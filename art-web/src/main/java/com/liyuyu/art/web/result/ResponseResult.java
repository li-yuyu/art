package com.liyuyu.art.web.result;

/**
 * @Description:
 * @author Lyle
 * @date 2019-06-11
 * @param <T>
 */
public class ResponseResult<T> {

	private boolean success;
	
	private int code;

	private String msg;

	private T data;

	public ResponseResult() {
	}

	public ResponseResult(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> ResponseResult<T> success() {
		return success("", null);
	}

	public static <T> ResponseResult<T> success(T data) {
		return success("", data);
	}

	public static <T> ResponseResult<T> success(String msg, T data) {
		return build(ResultCode.SUCCESS.code, msg, data);
	}

	public static <T> ResponseResult<T> error(int code) {
		return error(code, null);
	}

	public static <T> ResponseResult<T> error(int code, String msg) {
		return build(code, msg, null);
	}

	public static <T> ResponseResult<T> error(int code, String msg, T data) {
		return build(code, msg, data);
	}

	private static <T> ResponseResult<T> build(int code, String msg, T data) {
		return new ResponseResult<T>(code, msg, data);
	}

	public static <T> Boolean isSuccess(ResponseResult<T> result) {
		if (result == null) {
			return false;
		}
		return result.getCode() == ResultCode.SUCCESS.code;
	}

	public static <T> Boolean isSuccessWithData(ResponseResult<T> result) {
		return isSuccess(result) && result.getData() != null;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
