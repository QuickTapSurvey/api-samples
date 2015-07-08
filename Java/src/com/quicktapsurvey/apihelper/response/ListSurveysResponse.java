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
import com.quicktapsurvey.apihelper.data.ApiSurveyDO;

/**
 * @author tishanmills
 * 
 */
public class ListSurveysResponse extends BaseResponse {

	int pageNumber;
	ApiSurveyDO[] surveyList;

	/**
	 * @param resultCode
	 */
	public ListSurveysResponse(ResultCode resultCode, int pageNumber, ApiSurveyDO[] surveyList) {
		super(resultCode);
		this.pageNumber = pageNumber;
		this.surveyList = surveyList;
	}

	public ApiSurveyDO[] getSurveyList() {
		return this.surveyList;
	}

	public int getPageNumber() {
		return pageNumber;
	}

}
