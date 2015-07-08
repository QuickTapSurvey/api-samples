#!/usr/bin/python

# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
# INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
# PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL QUICKTAPSURVEY OR TABBLEDABBLE INC. BE 
# LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
# TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
# USE OR OTHER DEALINGS IN THE SOFTWARE. THE SOFTWARE MAY BE USED FOR ANY PURPOSE, 
# INCLUDING PAID-SERVICES, WITHOUT ANY ROYALTIES. USE AT YOUR OWN RISK.
# 
# Date: July 3, 2015
# Author: Tishan Mills

import QTSAPIHelper, json

# Change the following to your own username, password and API key
username = "tmapi"
password = "Passw0rd"
apiKey = "D262ZK77Q2OTRQBMYKQCBXKXSL6Q7JHU"

# Constants
CODE_LOGIN_SUCCESS = 10
CODE_LIST_SURVEYS_SUCCESS = 20
CODE_GET_SURVEY_RESPONSES_SUCCESS = 30
ENDPOINT_URL = "https://www.quicktapsurvey.com/api-v1/"

# instantiate api helper class
apiHelper = QTSAPIHelper.QTSAPIHelper(ENDPOINT_URL)

# call login method
loginJson = apiHelper.login(username, password, apiKey)
loginResult = json.loads(loginJson.getvalue())
resultCode = int(loginResult["resultCode"])

if resultCode == CODE_LOGIN_SUCCESS:
	print "Login Successful.";
	pageSize = 25
	pageNumber = 1
	listSurveysJson = apiHelper.listSurveys(pageSize, pageNumber)
	listSurveysResult = json.loads(listSurveysJson.getvalue())
	resultCode = int(listSurveysResult["resultCode"])
	
	if resultCode == CODE_LIST_SURVEYS_SUCCESS:
		print "List Surveys Successful.";
		surveyId = listSurveysResult["surveyList"][0]["surveyId"]
		pageSize = 25
		pageNumber = 1
		# sample date format: 2014-09-09 17:25:34 -0400
		fromDate = ""
		toDate = ""
		getSurveyResponsesJson = apiHelper.getSurveyResponses(surveyId, pageSize, pageNumber, fromDate, toDate)
		getSurveyResponsesResult = json.loads(getSurveyResponsesJson.getvalue())
		resultCode = int(getSurveyResponsesResult["resultCode"])
		
		if resultCode == CODE_GET_SURVEY_RESPONSES_SUCCESS:
			print "Get Survey Responses Successful.";
			print "Responses: " + str(getSurveyResponsesResult)
		else:
			print "Get Survey Responses Failed with Code: " + str(resultCode);
		
	else:
		print "List Surveys Failed with Code: " + str(resultCode);
	
else:
	print "Login Failed with Code: " + str(resultCode);