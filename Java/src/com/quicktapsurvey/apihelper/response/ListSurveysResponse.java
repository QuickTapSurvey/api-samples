/**
 * Project: DC-ServerAPI
 * File: ListSurveysResponse.java
 * Created by tishanmills on Sep 17, 2014 at 1:41:36 PM
 *
 * Copyright 2014 TabbleDabble Inc. All rights reserved.
 */
package com.tabbledabble.dcclientforapi.response.json;

import com.tabbledabble.dcclientforapi.enums.ResultCode;

/**
 * @author tishanmills
 *
 */
public class ListSurveysResponse extends BaseResponse {

	int pageNumber;
	SurveyBasicData[] surveyList;
	
	/**
	 * @param resultCode
	 */
	public ListSurveysResponse(ResultCode resultCode, int pageNumber, SurveyBasicData[] surveyList) {
		super(resultCode);
		this.pageNumber=pageNumber;
		this.surveyList=surveyList;
	}

	public SurveyBasicData[] getSurveyList() { return this.surveyList; }

	public int getPageNumber() {
		return pageNumber;
	}
	
}
