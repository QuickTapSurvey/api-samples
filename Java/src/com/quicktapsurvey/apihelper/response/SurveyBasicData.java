/**
 * Project: DC-ServerAPI
 * File: SurveyBasicData.java
 * Created by tishanmills on Sep 17, 2014 at 3:46:08 PM
 *
 * Copyright 2014 TabbleDabble Inc. All rights reserved.
 */
package com.tabbledabble.dcclientforapi.response.json;

/**
 * @author tishanmills
 *
 */
public class SurveyBasicData {

	long surveyId;
	String surveyName;
	long totalResponses;
	/**
	 * @param surveyId
	 * @param surveyName
	 * @param totalResponses
	 */
	public SurveyBasicData(long surveyId, String surveyName, long totalResponses) {
		super();
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.totalResponses = totalResponses;
	}
	/**
	 * @return the surveyId
	 */
	public long getSurveyId() {
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
