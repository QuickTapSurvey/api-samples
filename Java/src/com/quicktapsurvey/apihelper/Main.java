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

import org.apache.log4j.Logger;

import com.quicktapsurvey.apihelper.connect.ConnectionManager;
import com.quicktapsurvey.apihelper.connect.ResultCode;
import com.quicktapsurvey.apihelper.data.ApiSurveyDO;
import com.quicktapsurvey.apihelper.data.ApiSurveyResponseDO;
import com.quicktapsurvey.apihelper.response.GetSurveyDataResponse;
import com.quicktapsurvey.apihelper.response.ListSurveysResponse;
import com.quicktapsurvey.apihelper.response.LoginResponse;

public class Main {

	// final static String endpointUrl =
	// "https://www.quicktapsurvey.com/api-v1/";
	final static String endpointUrl = "https://tm-macbook-pro.local/api-v1/";
	static Logger log;

	public static void main(String[] args) {

		log = Logger.getLogger(Main.class);

		String username = "tmapi";
		String password = "Passw0rd";
		String apiKey = "D262ZK77Q2OTRQBMYKQCBXKXSL6Q7JHU";

		ConnectionManager conn = new ConnectionManager(endpointUrl);

		log.debug("Sending login request.");
		LoginResponse loginResponse = conn.login(username, password, apiKey);
		if (loginResponse.getResultCode() == ResultCode.LOGIN_SUCCESS) {

			int pageSize = 1;
			int pageNumber = 1;
			ListSurveysResponse listSurveysResponse = conn.listSurveys(pageSize, pageNumber);
			if (listSurveysResponse.getResultCode() == ResultCode.LIST_SURVEYS_SUCCESS) {

				ApiSurveyDO[] surveyList = listSurveysResponse.getSurveyList();
				if (surveyList != null && surveyList.length > 0) {
					int surveyId = surveyList[0].getSurveyId();
					log.debug("Fetching data for survey with ID: " + surveyList[0].getSurveyId() + ", name: "
							+ surveyList[0].getSurveyName());
					GetSurveyDataResponse getSurveyResponse = conn.getSurveyResponses(surveyId, null, null,
							pageNumber, pageSize);

					if (getSurveyResponse.getResultCode() == ResultCode.GET_SURVEY_RESPONSES_SUCCESS) {
						ApiSurveyResponseDO[] responses = getSurveyResponse.getResponses();
						for (ApiSurveyResponseDO res : responses) {
							log.debug("Response username: " + res.getUsername());
						}
					} else {
						log.debug("Getting survey responses failed. Code:"
								+ getSurveyResponse.getResultCode().getId() + ", "
								+ getSurveyResponse.getResultCode().getDescription());
					}
				} else {
					log.debug("Survey list empty.");
				}

			} else {
				log.debug("ListSurveys failed with result code: " + listSurveysResponse.getResultCode().getId()
						+ ", " + listSurveysResponse.getResultCode().getDescription());
			}

		} else {
			log.debug("Login failed with result code: " + loginResponse.getResultCode().getId() + ", "
					+ loginResponse.getResultCode().getDescription());
		}

	}
}