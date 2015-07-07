<?php
/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL QUICKTAPSURVEY OR TABBLEDABBLE INC. BE 
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
USE OR OTHER DEALINGS IN THE SOFTWARE. USE AT YOUR OWN RISK.

Date: July 1, 2015
Author: Tishan Mills
*/

include "QTSAPIHelper.inc";

define(ENDPOINT, "https://www.quicktapsurvey.com/api-v1/");
define(CODE_LOGIN_SUCCESS, 10);
define(CODE_LIST_SURVEYS_SUCCESS, 20);
define(CODE_GET_SURVEY_RESPONSES_SUCCESS, 30);

// Change the following to your own username, password and API key
$username = 'myusername';
$password = 'mypassword';
$apiKey = 'myapikey';

$apiHelper = new QTSAPIHelper(ENDPOINT);
$jsonResult = $apiHelper->login($username, $password, $apiKey);

$resultArray = json_decode($jsonResult, true);
$resultCode = $resultArray["resultCode"];

if ($resultCode == CODE_LOGIN_SUCCESS) {
    echo "\nLogin Successful.";

    $jsonResult = $apiHelper->listSurveys($pageSize, $pageNumber);
    $resultArray = json_decode($jsonResult, true);
    $resultCode = $resultArray["resultCode"];
    if ($resultCode == CODE_LIST_SURVEYS_SUCCESS) {
        echo "\nList Surveys Successful.";

        $surveyList = $resultArray["surveyList"];
        if (count($surveyList) > 0) {
            $surveyId = $surveyList[0]["surveyId"];
            echo "\nSurvey found with ID: " . $surveyId;

            $jsonResult = $apiHelper->getSurveyResponses($surveyId, $pageSize, $pageNumber);
            $resultArray = json_decode($jsonResult, true);
            $resultCode = $resultArray["resultCode"];
            if ($resultCode == CODE_GET_SURVEY_RESPONSES_SUCCESS) {
                echo "\nGet Survey Responses Successful.";
            }
        } else {
        	echo "\nList Surveys Failed with Result Code: " . resultCode;
        }
    } else {
    	echo "\Get Survey Responses Failed with Result Code: " . resultCode;
    }
}

echo "\n";


