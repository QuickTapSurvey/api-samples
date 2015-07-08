<?php
/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL QUICKTAPSURVEY OR TABBLEDABBLE INC. BE 
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
USE OR OTHER DEALINGS IN THE SOFTWARE. THE SOFTWARE MAY BE USED FOR ANY PURPOSE, 
INCLUDING PAID-SERVICES, WITHOUT ANY ROYALTIES. USE AT YOUR OWN RISK.

Date: July 1, 2015
Author: Tishan Mills
 */

define(DEFAULT_PAGE_SIZE, 25);
define(DEFAULT_PAGE_NUMBER, 1);
define(DEFAULT_COOKIE_JAR, "/tmp/cookies.txt");

class QTSAPIHelper {

	var $endpoint;

    function QTSAPIHelper($endpoint) {
        $this->endpoint = $endpoint;
    }   

    function login($username, $password, $apiKey) {
        $url = $this->endpoint . "login";
        $data = array('username' => $username, 'password' => $password, 'apiKey' => $apiKey);
        $json = json_encode($data);
        $result = $this->CallAPI($url, $json, true);
        return $result;
    }

    function listSurveys($pageSize, $pageNumber) {
        $url = $this->endpoint . "listSurveys";
        if ($pageSize <= 0) {
            $pageSize = DEFAULT_PAGE_SIZE;
        }
        if ($pageNumber <= 0) {
            $pageNumber = DEFAULT_PAGE_NUMBER;
        }
        $data = array('pageSize' => $pageSize, 'pageNumber' => $pageNumber);
        $json = json_encode($data);
        $result = $this->CallAPI($url, $json);
        return $result;
    }

    function getSurveyResponses($surveyId, $pageSize, $pageNumber, $fromDate = false, $toDate = false) {
        $url = $this->endpoint . "getSurveyResponses";
        if ($pageSize <= 0) {
            $pageSize = DEFAULT_PAGE_SIZE;
        }
        if ($pageNumber <= 0) {
            $pageNumber = DEFAULT_PAGE_NUMBER;
        }
        $data = array('surveyId' => $surveyId, 'pageSize' => $pageSize, 'pageNumber' => $pageNumber);
        if ($fromDate) {
            $data["fromDate"] = $fromDate;
        }
        if ($toDate) {
            $data["toDate"] = $toDate;
        }
        $json = json_encode($data);
        $result = $this->CallAPI($url, $json);
        return $result;
    }

    // Method: POST, PUT, GET etc
    // Data: array("param" => "value") ==> index.php?param=value
    function CallAPI($url, $data = false, $isLogin = false) {
        $curl = curl_init();
 		echo "\nConnecting to: " . $url;
 		echo "\nPost Data: " . $data;
        if ($isLogin) {
            curl_setopt($curl, CURLOPT_COOKIEJAR, DEFAULT_COOKIE_JAR);
        } else {
            curl_setopt($curl, CURLOPT_COOKIEFILE, DEFAULT_COOKIE_JAR);
        }
        curl_setopt($curl, CURLOPT_POST, 1);

        if ($data) {
            curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
    	    curl_setopt($curl, CURLOPT_HTTPHEADER, array(                                                                          
	        'Content-Type: application/json',                                                                                
	        'Content-Length: ' . strlen($data))                                                                       
    	    );
        }

        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);

        $result = curl_exec($curl);
        curl_close($curl);

        return $result;
    }
}

?>
