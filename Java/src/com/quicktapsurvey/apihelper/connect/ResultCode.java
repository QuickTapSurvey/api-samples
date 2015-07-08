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
package com.quicktapsurvey.apihelper.connect;

import com.google.gson.annotations.SerializedName;

/**
 * @author tishanmills
 * 
 */
public enum ResultCode {
	@SerializedName("0")
	REQUEST_FAIL(0, "Invalid request."), @SerializedName("1")
	REQUEST_DAILY_LIMIT_EXCEEDED(1, "Request per day limit exceeded."), @SerializedName("2")
	REQUEST_PER_SECOND_LIMIT_EXCEEDED(2, "Request per second limit exceeded."), @SerializedName("10")
	LOGIN_SUCCESS(10, "Login succeeded."), @SerializedName("11")
	LOGIN_FAIL(11, "Login failed: bad password, bad username or locked out account."), @SerializedName("12")
	LOGIN_INVALID_API_KEY(12, "Login failed: invalid API key."), @SerializedName("20")
	LIST_SURVEYS_SUCCESS(20, "List surveys succeeded."), @SerializedName("21")
	LIST_SURVEYS_FAIL(21, "List surveys failed."), @SerializedName("22")
	LIST_SURVEYS_INVALID_PAGE_NUMBER(22, "List surveys: invalid page number or no more results."), @SerializedName("30")
	GET_SURVEY_RESPONSES_SUCCESS(30, "Get survey responses succeeded."), @SerializedName("31")
	GET_SURVEY_RESPONSES_FAIL(31, "Get survey responses failed."), @SerializedName("32")
	GET_SURVEY_RESPONSES_INVALID_PAGE_NUMBER(32, "Get survey responses: invalid page number or no more results."), @SerializedName("33")
	GET_SURVEY_RESPONSES_SURVEY_DOES_NOT_EXIST(33, "Unauthorized survey."), @SerializedName("34")
	GET_SURVEY_RESPONSES_SURVEY_NOT_OWNED(34, "Unauthorized survey."), @SerializedName("35")
	GET_SURVEY_RESPONSES_SURVEY_NOT_PUBLISHED(35, "Get survey responses: survey not published.");

	private int id;
	private String description;

	private ResultCode(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}
}
