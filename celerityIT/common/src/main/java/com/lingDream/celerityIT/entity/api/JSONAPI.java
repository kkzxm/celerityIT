package com.lingDream.celerityIT.entity.api;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Data
public class JSONAPI {
    private String APIName; // 名称
    private RequestMethod method; //方法
    private String address; //请求地址
    private List<APIField> reqField;//请求字段
    private List<APIField> resField;//返回字段
}
