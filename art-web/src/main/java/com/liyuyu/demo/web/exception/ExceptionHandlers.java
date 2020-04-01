package com.liyuyu.demo.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liyuyu.demo.web.enums.ErrorCodeEnum;
import com.liyuyu.demo.web.result.ResponseResult;

@ControllerAdvice
public class ExceptionHandlers {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ResponseResult<String> serverExceptionHandler(final Exception e) {
		LOGGER.error(e.getMessage(), e);
		return ResponseResult.error(ErrorCodeEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage());
	}
}
