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
package com.quicktapsurvey.apihelper.data;

/**
 * 
 *
 */
public class ApiSurveyMetaDataResponseDO {
	private int filterNumber;
	private String responseValue;

	/**
	 * @param filterNumber
	 * @param responseValue
	 */
	public ApiSurveyMetaDataResponseDO(int filterNumber, String responseValue) {
		this.filterNumber = filterNumber;
		this.responseValue = responseValue;
	}

	/**
	 * @return the filterNumber
	 */
	public int getFilterNumber() {
		return filterNumber;
	}

	/**
	 * @param filterNumber
	 *            the filterNumber to set
	 */
	public void setFilterNumber(int filterNumber) {
		this.filterNumber = filterNumber;
	}

	/**
	 * @return the responseValue
	 */
	public String getResponseValue() {
		return responseValue;
	}

	/**
	 * @param responseValue
	 *            the responseValue to set
	 */
	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}
}
