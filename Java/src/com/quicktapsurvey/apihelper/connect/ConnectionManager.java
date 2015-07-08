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

package com.quicktapsurvey.apihelper.connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quicktapsurvey.apihelper.request.ListSurveysRequest;
import com.quicktapsurvey.apihelper.request.LoginRequest;
import com.quicktapsurvey.apihelper.response.GetSurveyDataResponse;
import com.quicktapsurvey.apihelper.response.ListSurveysResponse;
import com.quicktapsurvey.apihelper.response.LoginResponse;

public class ConnectionManager {

	String endpointUrl;
	Gson gson;
	Logger log;

	public ConnectionManager(String endpointUrl) {
		this.endpointUrl = endpointUrl;
		this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss Z").setPrettyPrinting().create();
		this.log = Logger.getLogger(this.getClass());
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		trustAllCerts();
	}

	public LoginResponse login(String username, String password, String apiKey) {
		LoginResponse response = null;
		// get login endpoint url
		String url = this.endpointUrl + "login";
		// construct login request object
		LoginRequest request = new LoginRequest(username, password, apiKey);
		// serialize login request to json string
		String data = this.gson.toJson(request, LoginRequest.class);
		try {
			// do post request
			String responseData = doPost(url, data);
			log.debug("responseData:" + responseData);

			// Deserialize json object
			response = this.gson.fromJson(responseData, LoginResponse.class);
			if (response.getResultCode() == ResultCode.LOGIN_SUCCESS) {
				log.debug(response.getResultCode().getDescription());
			} else {
				log.debug(response.getResultCode().getDescription());
			}

		} catch (Exception e) {
			log.error("Unable to post request data " + data + " to " + url + ". " + e.getMessage(), e);
		}
		return response;
	}

	/**
	 * Sends a request to get a list of surveys to server through API
	 * 
	 * Created by tishanmills on Sep 18, 2014 at 12:00:10 PM
	 */
	public ListSurveysResponse listSurveys(Integer pageSize, Integer pageNumber) {
		ListSurveysResponse response = null;

		// get listSurveys endpoint url
		String url = this.endpointUrl + "listSurveys";

		ListSurveysRequest request = new ListSurveysRequest(pageSize, pageNumber);

		String data = this.gson.toJson(request, ListSurveysRequest.class);

		try {
			// do post request
			String responseData = doPost(url, data);
			log.debug("responseData:" + responseData);

			// Deserialize json object
			response = this.gson.fromJson(responseData, ListSurveysResponse.class);

			if (response.getResultCode() == ResultCode.LIST_SURVEYS_SUCCESS) {
				log.debug(response.getResultCode().getDescription());
			} else {
				log.debug(response.getResultCode().getDescription());
			}

		} catch (Exception e) {
			log.error("Unable to post request data " + data + " to " + url + ". " + e.getMessage(), e);
		}
		return response;
	}

	/**
	 * Send a request to get the survey data
	 * 
	 * @param surveyId
	 * @param fromDate
	 * @param toDate
	 * @param pageNumber
	 * @param pageSize
	 */
	public GetSurveyDataResponse getSurveyResponses(int surveyId, String fromDate, String toDate, Integer pageNumber,
			Integer pageSize) {

		// construct getSurveysData request object
		HashMap<String, String> request = new HashMap<String, String>();
		request.put("surveyId", String.valueOf(surveyId));
		if (pageNumber != null)
			request.put("pageNumber", String.valueOf(pageNumber));
		if (pageSize != null)
			request.put("pageSize", String.valueOf(pageSize));
		if (fromDate != null)
			request.put("fromDate", fromDate);
		if (toDate != null)
			request.put("toDate", toDate);

		// serialize getSurveyData request to json string
		String data = this.gson.toJson(request, HashMap.class);

		GetSurveyDataResponse response = null;

		// get get survey data endpoint url
		String url = this.endpointUrl + "getSurveyResponses";
		log.debug("Sending getSurveyData request to " + url);

		try {
			// do post request
			String responseData = doPost(url, data);
			log.debug("responseData:" + responseData);

			// Deserialize json object
			response = this.gson.fromJson(responseData, GetSurveyDataResponse.class);
			log.debug(response.getResultCode().getDescription());

		} catch (Exception e) {
			log.error("Unable to post request data " + data + " to " + url + ". " + e.getMessage(), e);
		}
		return response;
	}

	/**
	 * Submits a post request to the given url endpoint and submits the given
	 * data as the post data and sends the given cookie string in the header and
	 * returns the response
	 * 
	 * @param endPoint
	 * @param data
	 * @param cookies
	 * @return
	 * @throws IOException
	 *             Created by tishanmills on Sep 18, 2014 at 1:29:27 PM
	 */
	protected String doPost(String endPoint, String data) throws IOException {
		log.debug("Connecting to: " + endPoint);
		log.debug("Post Data: " + data);

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
			if (reader != null)
				try {
					reader.close();
				} catch (IOException logOrIgnore) {
				}
		}
		// return response data
		return res.toString();
	}

	/**
	 * For DEBUG purposes and local test, this method forces connections to
	 * trust all certs
	 * 
	 * Created by tishanmills on Sep 18, 2014 at 2:00:40 PM
	 */
	private void trustAllCerts() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (GeneralSecurityException e) {
		}
	}
}