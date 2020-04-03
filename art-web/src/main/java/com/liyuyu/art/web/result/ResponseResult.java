package com.liyuyu.art.web.result;

/**
 * @Description:
 * @author Lyle
 * @date 2019-06-11
 * @param <T>
 */
public class ResponseResult<T> {

	public static final String SUCCESS_STATUS = "1";
	public static final String ERROR_STATUS = "0";
	public static final String SUCCESS_CODE = "00000000";

	/**
	 * 1 success, 0 failure
	 */
	private String status;

	/**
	 * 00000000 success, esle failure
	 */
	private String error;

	private String msg;

	private T data;

	public ResponseResult() {
	}

	public ResponseResult(String status, String error, String msg, T data) {
		this.status = status;
		this.error = error;
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
		return build(SUCCESS_STATUS, SUCCESS_CODE, msg, data);
	}

	public static <T> ResponseResult<T> error(String error) {
		return error(error, null);
	}

	public static <T> ResponseResult<T> error(String error, String msg) {
		return build(ERROR_STATUS, error, msg, null);
	}

	public static <T> ResponseResult<T> error(String error, String msg, T data) {
		return build(ERROR_STATUS, error, msg, data);
	}

	private static <T> ResponseResult<T> build(String status, String error, String msg, T data) {
		return new ResponseResult<T>(status, error, msg, data);
	}

	public static <T> Boolean isSuccess(ResponseResult<T> result) {
		if (result == null || result.getStatus() == null || result.getError() == null) {
			return false;
		}
		return result.getStatus().equals(SUCCESS_STATUS) && result.getError().equals(SUCCESS_CODE);
	}

	public static <T> Boolean isSuccessWithData(ResponseResult<T> result) {
		return isSuccess(result) && result.getData() != null;
	}

	public String getStatus() {
		return status;
	}

	public ResponseResult<T> setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getError() {
		return error;
	}

	public ResponseResult<T> setError(String error) {
		this.error = error;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResponseResult<T> setData(T data) {
		this.data = data;
		return this;
	}
}
