package com.zhaojm.enums;

public enum ErrorCodeEnum {
	/*成功*/
	SUCESS(0,"成功"),
	SYS_ERROR_OTHER(-1,"系统未知异常");
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
