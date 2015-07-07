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

package com.quicktapsurvey.apihelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quicktapsurvey.apihelper.connect.ConnectionManager;
import com.quicktapsurvey.apihelper.response.LoginResponse;

public class Main {

	final static String endpointUrl = "https://www.quicktapsurvey.com/api-v1/";

	public static void main(String[] args) {

		String username = "tmapi";
		String password = "Passw0rd";
		String apiKey = "D262ZK77Q2OTRQBMYKQCBXKXSL6Q7JHU";

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss Z").setPrettyPrinting().create();
		ConnectionManager conn = new ConnectionManager(endpointUrl);

		System.out.println("Sending login request.");
		LoginResponse loginResponse = conn.login(username, password, apiKey);
	}

	/**
	 * Inner classes
	 */

	class loginRequest {
		String username, password, apiKey;

		loginRequest(String username, String password, String apiKey) {
			this.username = username;
			this.password = password;
			this.apiKey = apiKey;
		}
	}
}