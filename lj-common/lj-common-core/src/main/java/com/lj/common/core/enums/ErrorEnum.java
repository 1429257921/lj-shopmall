package com.lj.common.core.enums;

/**
 * @author: gzc
 * @createTime: 2021-11-13 13:48
 * @description: 响应vo错误信息枚举
 **/
public enum ErrorEnum {
	/*
	 * 默认成功信息
	 */
	SUCCESS("0", "成功"),
	/*
	 * 默认错误信息
	 */
	ERROR("-1", "失败"),

	SERVICE_REMOTE_FAIL("300", "Dubbo服务调用超时, 请稍后重试! "),
	TOKEN_EXPIRE("3", "时间戳验证不通过"),
	TOKEN_INCORRECTNESS("9", "登录令牌不正确"),
	TOKEN_INVALID("10", "登录令牌过期，请重新获取"),


	UNIONPAY_API_ERROR("50", "调用银联项目接口失败,原因:"),

	SQL_EXECUTE_ERROR("400", "sql执行异常"),
	SIGN_INFO_NULL("401", "签名信息为空"),
	SIGN_INFO_ERROR("402", "签名信息校验不正确"),
	REQUEST_PARAM_NULL("410", "请求参数为空"),
	REQUEST_METHOD_NOT_SUPPORT("415", "请求方法类型不支持"),
	HTTP_PARAM_NOT_READ("416", "请求参数不是标准JSON字符串或参数没有JSON序列化"),
	HTTP_PARAM_FORMAT_ERROR("417", "请求参数不符合入参规范"),
	READ_KEY_ERROR("420", "系统内部错误, 错误原因: 程序启动时加载秘钥文件失败"),
	REMOTE_NOT_SERVICE("421", "远程调用时找不到服务错误"),
	JSON_CONVERT_ERROR("422", "JSON转换错误"),
	FILES_ERR("9", "上传文件失败"),
	FILES_NO_FILEE("9", "文件不存在"),
	/**
	 * 数据库异常
	 */
	DATABASE_LINE_TIME_OUT("499", "数据库连接超时"),
	/**
	 * 网络连接异常信息
	 */
	NETWORK_ERROR("408", "网络繁忙,请稍后重试"),
	/**
	 * 未知异常信息
	 */
	INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
	/**
	 * 认证系统成功
	 */
	AUTH_SUCCESS("100", "成功"),
	;

	private String code;
	private String msg;

	ErrorEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
