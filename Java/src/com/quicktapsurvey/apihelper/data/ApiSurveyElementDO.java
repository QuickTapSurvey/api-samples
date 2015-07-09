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
public class ApiSurveyElementDO {
	private int questionNumber;
	private String questionTitle;

	/**
	 * @param questionNumber
	 * @param questionTitle
	 */
	public ApiSurveyElementDO(int questionNumber, String questionTitle) {
		this.questionNumber = questionNumber;
		this.questionTitle = questionTitle;
	}

	/**
	 * @return the questionNumber
	 */
	public int getQuestionNumber() {
		return questionNumber;
	}

	/**
	 * @param questionNumber
	 *            the questionNumber to set
	 */
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	/**
	 * @return the questionTitle
	 */
	public String getQuestionTitle() {
		return questionTitle;
	}

	/**
	 * @param questionTitle
	 *            the questionTitle to set
	 */
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
}
