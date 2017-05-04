package com.youzi.yuchou.core.exception;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExceptionStaticEnum  {

    NOPERMISSIONS(401, "没有权限访问"),
    
    ERRORSERVICE(500, "系统异常"),

    ERROR(1000, "错误"),
    

    
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
