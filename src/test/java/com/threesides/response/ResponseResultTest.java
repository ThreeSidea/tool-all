package com.threesides.response;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ResponseResultTest
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public class ResponseResultTest {

	@Test
	public void success() {
		ResponseResult<String> result = ResponseResult.success("我们", ResponseResultCodeEnum.INTER_ERROR);
		System.out.println("result = " + result);
	}
}