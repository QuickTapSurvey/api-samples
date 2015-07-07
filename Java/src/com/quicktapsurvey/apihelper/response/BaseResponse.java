/**
 * Project: DC-ServerAPI
 * File: BaseResponse.java
 * Created by tishanmills on Sep 17, 2014 at 12:46:36 PM
 *
 * Copyright 2014 TabbleDabble Inc. All rights reserved.
 */
package com.tabbledabble.dcclientforapi.response.json;

import com.tabbledabble.dcclientforapi.enums.ResultCode;

/**
 * @author tishanmills
 *
 */
public class BaseResponse {
	ResultCode resultCode = ResultCode.REQUEST_FAIL;
	
	public BaseResponse(ResultCode resultCode) {
		this.resultCode=resultCode;
	}
	public ResultCode getResultCode() { return this.resultCode; }
}
