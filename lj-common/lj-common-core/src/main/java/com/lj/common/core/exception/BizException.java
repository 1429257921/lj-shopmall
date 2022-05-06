package com.lj.common.core.exception;


import com.lj.common.core.enums.ErrorEnum;

/**
 * @author: gzc
 * @createTime: 2021-11-13 14:12
 * @description: 自定义运行时异常
 **/
public class BizException extends RuntimeException {

	/**
	 * 错误码
	 */
	protected String errCode;
	/**
	 * 错误信息
	 */
	protected String errMsg;

	public BizException() {
		super();
	}

	public BizException(ErrorEnum errorEnum) {
		this.errCode = errorEnum.getCode();
		this.errMsg = errorEnum.getMsg();
	}

	public BizException(String errMsg) {
		this.errCode = ErrorEnum.ERROR.getCode();
		this.errMsg = errMsg;
	}

	public BizException(String errMsg, Throwable cause) {
		super(errMsg, cause);
		this.errCode = ErrorEnum.ERROR.getCode();
		this.errMsg = errMsg;
	}

	public BizException(ErrorEnum errorEnum, Throwable cause) {
		super(errorEnum.getMsg(), cause);
		this.errCode = errorEnum.getCode();
		this.errMsg = errorEnum.getMsg();
	}

	public BizException(String errorCode, String errorMsg) {
		super(errorCode);
		this.errCode = errorCode;
		this.errMsg = errorMsg;
	}

	public static String getLineInfo() {
		StackTraceElement ste = new Throwable().getStackTrace()[1];
		String s = ste.getFileName() + ": Line " + ste.getLineNumber();
		System.out.println(s);
		return s;
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	@Override
	public String getMessage() {
		return errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
