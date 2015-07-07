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
package com.tabbledabble.dcclientforapi.request.json;

import java.sql.Timestamp;

/**
 * @author tishanmills
 *
 */
public class GetSurveysDataRequest extends PagedRequest {

	private int surveyId;
	private Timestamp fromDate;
	private Timestamp toDate;
	
	/**
	 * @param surveyId
	 * @param fromDate
	 * @param toDate
	 */
	public GetSurveysDataRequest(int surveyId, Timestamp fromDate,
			Timestamp toDate, int pageNumber, int pageSize) {
		this.surveyId = surveyId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}
	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	/**
	 * @return the fromDate
	 */
	public Timestamp getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public Timestamp getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}	
}