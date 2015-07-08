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

import StringIO, pycurl, json

class QTSAPIHelper:

	# Constructor to set endpoint for reuse
    def __init__(self, endpoint):
		self.endpoint = endpoint
		
	# Returns the result of a login attept with the given parameters.
    def login(self, username, password, apiKey):
		url = self.endpoint + "login"
		json_array = {'username':username, 'password':password, 'apiKey':apiKey}
		result = self.callAPI(url, json_array)
		return result
		
	# Returns a list of surveys
    def listSurveys(self, pageSize, pageNumber):
		url = self.endpoint + "listSurveys"
		json_array = {'pageSize':pageSize, 'pageNumber':pageNumber}
		result = self.callAPI(url, json_array)
		return result		
		
	# Returns survey reponses for the given survey
    def getSurveyResponses(self, surveyId, pageSize, pageNumber, fromDate, toDate):
		url = self.endpoint + "getSurveyResponses"
		json_array = {'surveyId':surveyId, 'pageSize':pageSize, 'pageNumber':pageNumber}
		if fromDate and toDate:
			json_array['fromDate'] = fromDate
			json_array['toDate'] = toDate
		result = self.callAPI(url, json_array)
		return result		
				
	# Function to call API with given data
    def callAPI(self, url, json_array):
		data = json.dumps(json_array, encoding="utf-8")
		length = str(len(data))
		headers = ['Content-Type: application/json', 'Content-Length: '+length]
		
		cookies_file = "/tmp/cookies.txt"
		
		print "Connecting to: " + url
		print "Post Data: " + data
		
		result = StringIO.StringIO()
		c = pycurl.Curl()
		c.setopt(pycurl.URL, url)
		c.setopt(pycurl.POST, 1)
		c.setopt(pycurl.POSTFIELDS, data)
		c.setopt(pycurl.HTTPHEADER, headers)
		c.setopt(pycurl.COOKIEFILE, cookies_file)
		c.setopt(pycurl.COOKIEJAR, cookies_file)
		c.setopt(pycurl.WRITEFUNCTION, result.write)
		#c.setopt(pycurl.SSL_VERIFYPEER, 0)
		#c.setopt(pycurl.SSL_VERIFYHOST, 0)
		c.perform()
		c.close()
		
		return result
