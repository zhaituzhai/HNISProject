package com.zhaojm.enums;

public enum ErrorCodeEnum {
	/*成功*/
	SUCESS(0,"成功"),
	/*安全错误代码10*/
	SEC_SES_EXPIRE(10001,"会话失效"),
	SEC_LACK_AUTH(10002,"缺乏授权"),
	SEC_LOGIN_FAILED(10003,"登录认证失败"),
	SEC_CODE_OTHER(10004,"验证码异常"),
	SEC_FORBIDDEN(10005,"权限不够拒绝访问"),
	SEC_ERROR_OTHER(10999,"安全未知异常"),
	
	/*业务异常11*/
	BSS_AUTH_FAILED(17000,"无数据操作权限"),
	BSS_UPDATE_FAILED(17001,"数据修改异常"),
	BSS_CREATE_FAILED(17002,"创建数据异常"),
	BSS_QUERY_FAILED(17003,"数据查询异常"),
	BSS_DELTE_FAILED(17004,"数据删除异常"),
	/****数据为空异常****/
	BSS_EMPTY_FAILED(11005,"数据为空异常"),
	BSS_PARAM_FAILED(11006,"业务参数异常"),
	BSS_RULE_FAILED(11007,"不符合业务规则"),
	BSS_INVID_FAILED(11008,"业务数据无效"),
	BSS_ERROR_OTHER(11999,"业务未知异常"),
	/*数据库异常代码12*/
	DB_CONNECTION_FAILED(12001,"数据库连接异常"),
	DB_ERROR_OTHER(12999,"数据库未知异常"),
	DB_ERROR_OP(12000,"数据库操作异常"),
	
	/*前端交互错误代码13*/	
	WEB_PARAM_FAILED(13001,"WEB参数校验失败"),
	WEB_ERROR_OTHER(13999,"WEB未知异常"),
	/*系统异常代码14*/
	SYS_SERV_NOT_EXSITED(14001,"服务不存在"),
	SYS_PORT_BINDING(14002,"端口绑定失败"),
	SYS_ERROR_OTHER(14999,"系统未知异常"),
	SYS_ERROR_REF(14003,"系统反射调用异常"),

	
	/*第三方服务(外部系统)异常代码15*/
	EXT_SERV_UNAVAILABLE(15001,"外部服务不可用"),
	EXT_SERV_REFUSE(15002,"外部服务拒绝访问"),
	EXT_SERV_ERROR(15003,"外部服务返回失败"),
	EXT_ERROR_OTHER(15999,"外部服务未知异常"),
	
	/*内部RPC请求异常16*/
	RPC_SERV_UNAVAILABLE(16001,"RPC服务不可用"),
	RPC_SERV_REFUSE(16002,"RPC服务拒绝访问"),
	RPC_SERV_ERROR(16003,"RPC服务返回失败"),
	RPC_ERROR_OTHER(16999,"RPC服务未知异常"),


	/*密码策略异常30*/
	SYS_PASSWORD_POLICY_DATA_ERROR(30001,"密码策略数据错误"),
	SYS_PASSWORD_IS_NULL(30002,"密码为空"),
	SYS_PASSWORD_IS_NOT_ENOUGH(30003,"密码长度不够"),
	SYS_PASSWORD_LONGER_THAN(30004,"密码长度超长"),
	SYS_PASSWORD_IS_ILLEGAL(30005,"密码违法"),

	UPDATE_SYS_PASSWORD_POLICY_ERROR(30006, "更新密码策略数据错误"),
	UPDATE_SYS_IMAGE_ERROR(30007, "更新图片信息数据错误"),
	UPDATE_SYS_OWNER_INFO_ERROR(30007, "更新企业信息数据错误"),

	IMPORT_CLIENT_LIC_ERROR(30011, "导入授权错误:授权文件错误"),
	CLIENT_LIC_EXPIRE_ERROR(30012, "授权错误:试用期到期"),
	CLIENT_LIC_IS_INVALID_ERROR(30013, "授权错误:授权文件无效"),
	CLIENT_LIC_NOT_EXISTS(30014, "您的系统试用已到期，请联系深圳航天信息有限公司集团客户部！"),
	CLIENT_LIC_CREDIT_CODE_WRONG(30015, "授权错误:企业税号错误"),
	SYS_OWNER_INFO_IS_NULL(30016, "企业信息为空"),
	CLIENT_LIC_CREDIT_CODE_IS_NULL(30017, "企业税号为空"),
	LIC_SUCCESS(30018,"正常导入"),
	LIC_FALSIFICATION (30019,"系统启用的功能和License授权的不一致 "),
	
	/*****
	 * 公共组件错误
	 */
	COMMON_JAXB_PARSE_ERROR(40001,"xml 解析出错"),



	INVOICE_WAIT_NOT_EXISTS(50001, "待开发票不存在"),
	INVOICE_WAIT_INVALID_ORGID(50002, "待开发票机构不一致"),

	INVOICE_WAIT_ELECTRON_OPEN_INV_ERROR(50003, "待开发票开具电子发票错误"),
	INVOICE_OPEN_STATUS_ERROR(50004, "待开发票开具所在的发票已开或者不存在错误"),
	
	/***********工作流**********/
	WORK_FLOW_DEPLOY_FAILE(60000,"流程定义失败"),
	
	UNSUPPORTED_ENCODING(80000,"字符集转换异常"),
	
	/********************/
	MAILE_SEND_FAILE(70000,"发送邮件失败");
	;

	
	private int errCode;
	private String message;
	ErrorCodeEnum(int code,String msg){
		this.errCode=code;
		this.message=msg;
	}
	public int getErrCode() {
		return errCode;
	}
	public String getMessage() {
		return message;
	}

}
