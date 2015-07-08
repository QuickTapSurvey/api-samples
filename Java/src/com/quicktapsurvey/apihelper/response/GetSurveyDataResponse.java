/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL QUICKTAPSURVEY OR TABBLEDABBLE INC. BE 
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
USE OR OTHER DEALINGS IN THE SOFTWARE. THE SOFTWARE MAY BE USED FOR ANY PURPOSE, 
INCLUDING PAID-SERVICES, WITHOUT ANY ROYALTIES. USE AT YOUR OWN RISK.

Date: July 5, 2015
Author: Tishan Mills
 */
package com.quicktapsurvey.apihelper.response;

import com.quicktapsurvey.apihelper.connect.ResultCode;
import com.quicktapsurvey.apihelper.data.ApiSurveyElementDO;
import com.quicktapsurvey.apihelper.data.ApiSurveyMetaDataDO;
import com.quicktapsurvey.apihelper.data.ApiSurveyResponseDO;

/**
 * @author tishanmills
 * 
 */
public class GetSurveyDataResponse extends BaseResponse {

	private int surveyId;
	private int pageNumber;
	private ApiSurveyElementDO[] questions;
	private ApiSurveyMetaDataDO[] responseFilters;
	private ApiSurveyResponseDO[] responses;

	/**
	 * @param resultCode
	 */
	public GetSurveyDataResponse(ResultCode resultCode) {
		super(resultCode);
	}

	/**
	 * @param resultCode
	 * @param surveyId
	 * @param pageNumber
	 * @param questions
	 * @param responseFilters
	 * @param responses
	 */
	public GetSurveyDataResponse(ResultCode resultCode, int surveyId, int pageNumber, ApiSurveyElementDO[] questions,
			ApiSurveyMetaDataDO[] responseFilters, ApiSurveyResponseDO[] responses) {
		super(resultCode);
		this.surveyId = surveyId;
		this.pageNumber = pageNumber;
		this.questions = questions;
		this.responseFilters = responseFilters;
		this.responses = responses;
	}

	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId
	 *            the surveyId to set
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the questions
	 */
	public ApiSurveyElementDO[] getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(ApiSurveyElementDO[] questions) {
		this.questions = questions;
	}

	/**
	 * @return the responseFilters
	 */
	public ApiSurveyMetaDataDO[] getResponseFilters() {
		return responseFilters;
	}

	/**
	 * @param responseFilters
	 *            the responseFilters to set
	 */
	public void setResponseFilters(ApiSurveyMetaDataDO[] responseFilters) {
		this.responseFilters = responseFilters;
	}

	/**
	 * @return the responses
	 */
	public ApiSurveyResponseDO[] getResponses() {
		return responses;
	}

	/**
	 * @param responses
	 *            the responses to set
	 */
	public void setResponses(ApiSurveyResponseDO[] responses) {
		this.responses = responses;
	}
}