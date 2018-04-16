package com.zhaojm.enums;

public enum UserTypeEnum {
    
    USER_TYPE_ADMIN(1,"管理员"),
    USER_TYPE_DOCTOR(2,"医生"),
    USER_TYPR_PATIENT(3,"病人"),
    USER_TYPE_GUEST(4,"游客");
    ;
    
    private int typeCode;
    private String message;
    UserTypeEnum(int code,String msg){
        this.typeCode=code;
        this.message=msg;
    }
    public int getTypeCode() {
        return typeCode;
    }
    public String getMessage() {
        return message;
    }

}
