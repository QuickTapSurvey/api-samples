/**
 * Project: DC-ServerAPI
 * File: GetSurveyDataResponse.java
 * Created by tishanmills on Sep 17, 2014 at 1:41:50 PM
 *
 * Copyright 2014 TabbleDabble Inc. All rights reserved.
 */
package com.tabbledabble.dcclientforapi.response.json;

import com.tabbledabble.dcclientforapi.dataobjects.ApiSurveyElementDO;
import com.tabbledabble.dcclientforapi.dataobjects.ApiSurveyMetaDataDO;
import com.tabbledabble.dcclientforapi.dataobjects.ApiSurveyResponseDO;
import com.tabbledabble.dcclientforapi.enums.ResultCode;

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
	public GetSurveyDataResponse(ResultCode resultCode, int surveyId,
			int pageNumber, ApiSurveyElementDO[] questions,
			ApiSurveyMetaDataDO[] responseFilters,
			ApiSurveyResponseDO[] responses) {
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
	 * @param surveyId the surveyId to set
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
	 * @param pageNumber the pageNumber to set
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
	 * @param questions the questions to set
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
	 * @param responseFilters the responseFilters to set
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
	 * @param responses the responses to set
	 */
	public void setResponses(ApiSurveyResponseDO[] responses) {
		this.responses = responses;
	}
}	