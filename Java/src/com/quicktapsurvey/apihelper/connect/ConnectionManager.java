import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.tabbledabble.dcclientforapi.enums.ResultCode;
import com.tabbledabble.dcclientforapi.request.json.LoginRequest;
import com.tabbledabble.dcclientforapi.response.json.LoginResponse;

/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL QUICKTAPSURVEY OR TABBLEDABBLE INC. BE 
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
USE OR OTHER DEALINGS IN THE SOFTWARE. USE AT YOUR OWN RISK.

Date: July 5, 2015
Author: Tishan Mills
*/
public class ConnectionManager {
	
	String endpointUrl;
	public ConnectionManager(String endpointUrl) {
		this.endpointUrl=endpointUrl;
	}
	
	public LoginResponse login(String username, String password, String apiKey) {
		LoginResponse response = null;
		// get login endpoint url
		String url = this.endpointUrl + "login";
		// construct login request object
		LoginRequest request = new LoginRequest(username, password, apiKey);
		// serialize login request to json string
		String data = this.gson.toJson(request, LoginRequest.class);
		System.out.println("Logging in at "+endPoint);
		try {
			// do post request
			String responseData = doPost(endPoint, data);
			System.out.println("responseData:"+responseData);
			
			//Deserialize json object
			response = this.gson.fromJson(responseData, LoginResponse.class);
			if (response.getResultCode()==ResultCode.LOGIN_SUCCESS) {
				System.out.println(response.getResultCode().getDescription());
			} else {
				System.out.println(response.getResultCode().getDescription());
			}
			
		} catch (Exception e) {
			log.error("Unable to post request data "+data+" to "+endPoint+". "+e.getMessage(), e);
		}
		return response;
	}
	
	/**
	 * Submits a post request to the given url endpoint 
	 * and submits the given data as the post data
	 * and sends the given cookie string in the header
	 * and returns the response
	 * @param endPoint
	 * @param data
	 * @param cookies
	 * @return
	 * @throws IOException
	 * Created by tishanmills on Sep 18, 2014 at 1:29:27 PM
	 */
	protected String doPost(String endPoint, String data) throws IOException {
		System.out.println("Connecting to: "+endPoint);
		System.out.println("Post Data: "+data);
		
		// Do HTTP Post
		
		URL url = new URL(endPoint);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("POST");
		httpCon.setRequestProperty("Content-Type", "application/json");
		
		OutputStreamWriter wr = new OutputStreamWriter(httpCon.getOutputStream());
	    wr.write(data);
	    wr.flush();
	    
		// read response data
		BufferedReader reader = null;
		StringBuffer res = new StringBuffer();
	    try {
	    	InputStreamReader is = new InputStreamReader(httpCon.getInputStream(), "UTF-8");
	        reader = new BufferedReader(is);
	        for (String line; (line = reader.readLine()) != null;) {
	            res.append(line);
	            res.append("\n");
	        }
	    } finally {
	        if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
	    }
	    // return response data
	    return res.toString();
	}
}