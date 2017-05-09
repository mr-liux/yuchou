package com.youzi.yuchou.module.redis.config;

/**
 * Created by LIUXUAN on 2017/5/9.
 */
public enum RedisKey {
    TEST_AAAA("com" , ValueType.MAP),
    TEST_BBBB("cccc" , ValueType.SINGLE);





    private String value;

    private ValueType type;

    RedisKey(String value, ValueType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }
}
