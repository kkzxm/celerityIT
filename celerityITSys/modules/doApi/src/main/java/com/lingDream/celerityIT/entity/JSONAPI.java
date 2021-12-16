package com.lingDream.celerityIT.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Accessors(chain = true)
public class JSONAPI {
    private Integer Id; // 编号
    private String APIName; // 名称
    private RequestMethod method; //方法
    private String address; //请求地址
    private final List<APIField> reqField = new ArrayList<>();//请求字段
    private final List<APIField> resField = new ArrayList<>();//返回字段

    public JSONAPI addRequestField(APIField... apiField) {
        reqField.addAll(Arrays.asList(apiField));
        return this;
    }
}
