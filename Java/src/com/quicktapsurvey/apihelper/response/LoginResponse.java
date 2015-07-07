/**
 * Project: DC-ServerAPI
 * File: LoginResponse.java
 * Created by tishanmills on Sep 17, 2014 at 1:40:36 PM
 *
 * Copyright 2014 TabbleDabble Inc. All rights reserved.
 */
package com.tabbledabble.dcclientforapi.response.json;

import com.tabbledabble.dcclientforapi.enums.ResultCode;

/**
 * @author tishanmills
 *
 */
public class LoginResponse extends BaseResponse {
	
	/**
	 * 
	 * @param resultCode
	 */
	public LoginResponse(ResultCode resultCode) {
		super(resultCode);
	}

}
