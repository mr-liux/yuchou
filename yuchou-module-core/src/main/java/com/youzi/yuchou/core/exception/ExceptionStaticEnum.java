package com.youzi.yuchou.core.exception;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExceptionStaticEnum  {
    
	ERROR_NO_RIGHT(401, "对不起，你没有权限进行此项操作。"),
    ERROR_SERVICE(500, "系统异常"),
    ERROR_PARAMS(501, "参数错误"),
    ERROR(1000, "未知错误"),
    ERROR_DB(100010, "数据库执行失败。"),
    ERROR_NO_INVALID_USER(100011, "用户名或者密码错误，请重新输入。"),
    ERROR_NO_NO_INVALID_TOKEN(100013, "登录无效，或者已经过期，请重新登录。"),
    ERROR_MAX_INVALID_INPUT(100014, "“<@1>”输入不合法，请重新输入。"),
    ERROR_INVALID_SID(100015, "系统鉴权失败，请重新登陆系统。"),   
    ERROR_NOT_EXISTS(100016, "查询的数据不存在。"),
    ERROR_OLDPASSWORD_NO_INVALID(100017, "原密码输入有误。"),
    ERROR_TIMEOUT(100018, "系统连接超时，请重新登陆系统。"),
    ERROR_SIGN(100019, "系统连接证书错误，请更新正确的证书。"),
    ERROR_DATA_USED(100020, "该数据正在被其他配置使用，无法删除。"),
    ERROR_USER_IS_UNABLE(100027, "此用户已经被禁用。 "),
    USER_LOGIN_LOCKED(100028, "连续输入错误密码次数过多，用户登录被锁定，请稍后再试！"),
    ;

    private final Integer                            code;

    private final String                            message;

    private static Map<Integer, ExceptionStaticEnum> codeLookup = new HashMap<Integer, ExceptionStaticEnum>();

    static {
        for (ExceptionStaticEnum type : ExceptionStaticEnum.values()) {
            codeLookup.put(type.code, type);
        }
    }

    ExceptionStaticEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    @JsonCreator
    public static ExceptionStaticEnum getByCode(String code) {
        return codeLookup.get(code);
    }
    
    @JsonValue
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.code + "-" + this.message;
    }
    public String getMessageByCode(String code){
        return  codeLookup.get(code).getMessage();
    }

    public boolean equals(String code){
        return  this.code.equals(code);
    }
}
