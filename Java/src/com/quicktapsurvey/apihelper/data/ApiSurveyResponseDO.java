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

import java.sql.Timestamp;

/**
 * @author tishanmills
 * 
 */
public class ApiSurveyResponseDO {
	private String username;
	private Timestamp dateCollected;
	private Timestamp dateSent;
	private ApiSurveyMetaDataResponseDO[] responseFilterResponseValues;
	private ApiSurveyElementResponseDO[] responseValues;

	/**
	 * @param username
	 * @param dateCollected
	 * @param dateSent
	 * @param responseFilterResponseValues
	 * @param responseValues
	 */
	public ApiSurveyResponseDO(String username, Timestamp dateCollected, Timestamp dateSent,
			ApiSurveyMetaDataResponseDO[] responseFilterResponseValues, ApiSurveyElementResponseDO[] responseValues) {
		this.username = username;
		this.dateCollected = dateCollected;
		this.dateSent = dateSent;
		this.responseFilterResponseValues = responseFilterResponseValues;
		this.responseValues = responseValues;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the dateCollected
	 */
	public Timestamp getDateCollected() {
		return dateCollected;
	}

	/**
	 * @param dateCollected
	 *            the dateCollected to set
	 */
	public void setDateCollected(Timestamp dateCollected) {
		this.dateCollected = dateCollected;
	}

	/**
	 * @return the dateSent
	 */
	public Timestamp getDateSent() {
		return dateSent;
	}

	/**
	 * @param dateSent
	 *            the dateSent to set
	 */
	public void setDateSent(Timestamp dateSent) {
		this.dateSent = dateSent;
	}

	/**
	 * @return the responseFilterResponseValues
	 */
	public ApiSurveyMetaDataResponseDO[] getResponseFilterResponseValues() {
		return responseFilterResponseValues;
	}

	/**
	 * @param responseFilterResponseValues
	 *            the responseFilterResponseValues to set
	 */
	public void setResponseFilterResponseValues(ApiSurveyMetaDataResponseDO[] responseFilterResponseValues) {
		this.responseFilterResponseValues = responseFilterResponseValues;
	}

	/**
	 * @return the responseValues
	 */
	public ApiSurveyElementResponseDO[] getResponseValues() {
		return responseValues;
	}

	/**
	 * @param responseValues
	 *            the responseValues to set
	 */
	public void setResponseValues(ApiSurveyElementResponseDO[] responseValues) {
		this.responseValues = responseValues;
	}
}
