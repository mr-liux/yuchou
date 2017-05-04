package com.youzi.yuchou.core.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CommonStatusEnum  {

    NORMAL("1", "正常"),

    OPEN("2", "开启"),
    
    INVALID("3", "无效"),
    
    CLOSE("4", "关闭"),
    
    DELETE("0", "删除"),
    
    WQS("1", "未清算"),
    
    YQS("2", "已清算"),
    
    ;

    private final String                            code;

    private final String                            message;

    private static Map<String, CommonStatusEnum> codeLookup = new HashMap<String, CommonStatusEnum>();

    static {
        for (CommonStatusEnum type : CommonStatusEnum.values()) {
            codeLookup.put(type.code, type);
        }
    }

    CommonStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    @JsonCreator
    public static CommonStatusEnum getByCode(String code) {
        return codeLookup.get(code);
    }
    
    @JsonValue
    public String getCode() {
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
