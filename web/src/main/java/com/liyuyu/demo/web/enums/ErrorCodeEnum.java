package com.liyuyu.demo.web.enums;

public enum ErrorCodeEnum {
	
	SYSTEM_EXCEPTION("03000001","System Exception"),
	ILLEGAL_PARAM("03000002","Illegal Param"),
	;

    private String code;
    private String message;

    private ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}