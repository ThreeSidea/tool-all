package com.threesides.exception;

import com.threesides.beans.BeanEnum;
import com.threesides.lang.ObjectUtil;

/**
 * BusinessException
 *
 * @author Di Wu
 * @since 2023-04-09
 */
public class BusinessException extends RuntimeException{
	public BusinessException(String message){
		super(message);
	}

	public BusinessException(String message, Throwable cause){
		super(message,cause);
	}

	public BusinessException(Throwable cause){
		super(cause);
	}

	public BusinessException(BeanEnum beanEnum){
		super(ObjectUtil.objectToUFTF8String(beanEnum.getValue()));
	}
}
