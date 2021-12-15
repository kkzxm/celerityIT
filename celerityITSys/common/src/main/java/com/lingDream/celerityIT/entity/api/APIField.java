package com.lingDream.celerityIT.entity.api;

import lombok.Data;

/**
 * API字段
 */
@Data
public class APIField {
    private String name; //名称
    private Object value; //值
    private String type = "String"; // 类型,默认为String,其它情况如:Object,Date time 等
    private APIField parent; // 父字段
    private APIField children; // 子字段
}
