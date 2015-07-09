/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL QUICKTAPSURVEY OR TABBLEDABBLE INC. BE 
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
USE OR OTHER DEALINGS IN THE SOFTWARE. THE SOFTWARE MAY BE USED FOR ANY PURPOSE, 
INCLUDING PAID-SERVICES, WITHOUT ANY ROYALTIES. USE AT YOUR OWN RISK.

Date: July 5, 2015

 */
package com.quicktapsurvey.apihelper.data;

/**
 * @author tishanmills
 * 
 */
public class ApiSurveyDO {

	int surveyId;
	String surveyName;
	long totalResponses;

	/**
	 * @param surveyId
	 * @param surveyName
	 * @param totalResponses
	 */
	public ApiSurveyDO(int surveyId, String surveyName, long totalResponses) {
		super();
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.totalResponses = totalResponses;
	}

	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * @return the surveyName
	 */
	public String getSurveyName() {
		return surveyName;
	}

	/**
	 * @return the totalResponses
	 */
	public long getTotalResponses() {
		return totalResponses;
	}

}
