package com.zhaojm.util;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhaojm.enums.ErrorCodeEnum;


public class ResultDTO <T>  implements Serializable {
  
  private static final long serialVersionUID = -4214236501903574966L;
  protected String message;
  protected T value;
  protected boolean success;
  protected int msgCode;

  private ResultDTO() {
  }
  
  public static <T> ResultDTO<T> valueOfSuccess(T value ) {
    ResultDTO<T> vo = new ResultDTO<T>();
    vo.value = value;
    vo.success = true;
    vo.msgCode = ErrorCodeEnum.SUCESS.getErrCode();
    return vo;
  }

  public static <T> ResultDTO<T> valueOfSuccess() {
    return valueOfSuccess(null);
  }

  public static <T> ResultDTO<T> valueOfError(String msg, T value) {
    return valueOfError(msg, ErrorCodeEnum.SYS_ERROR_OTHER.getErrCode(), null, value);
  }

  public static <T> ResultDTO<T> valueOfError(String msg, int msgCode, Class source, T value) {
    if (source != null) {
    	 Logger log = LoggerFactory.getLogger(ResultDTO.class);;
         log.warn(msg);
    }
    ResultDTO<T> vo = new ResultDTO<T>();
    vo.value = value;
    vo.message = msg;
    vo.success = false;
    vo.msgCode = msgCode;
    return vo;
  }

  public static <T> ResultDTO<T> valueOfError(String msg) {
    return valueOfError(msg, ErrorCodeEnum.SYS_ERROR_OTHER.getErrCode(), null, null);
  }

  public static <T> ResultDTO<T> valueOfError(String msg, int msgCode) {
    return valueOfError(msg, msgCode, null, null);
  }

  public String getMessage(){
      return message;
  }

  public ResultDTO<T> setMessage(String message) {
    this.message = message;
    return this;
  }

  public boolean isSuccess() {
    return success;
  }

  public ResultDTO<T> setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public int getMsgCode() {
    return msgCode;
  }

  public  void setMsgCode(int msgCode) {
    this.msgCode = msgCode;
  }

}
