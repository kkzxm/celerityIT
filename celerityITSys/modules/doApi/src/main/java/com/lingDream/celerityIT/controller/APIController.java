package com.lingDream.celerityIT.controller;

import com.lingDream.celerityIT.entity.JSONAPI;
import com.lingDream.celerityIT.service.APIService;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.lingDream.celerityIT.util.StringUtils.isEmptyByTrim;

@Component
public class APIController {
    final APIService apiService;

    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    /**
     * 操作控制层
     * 先向数据库中查询该api的信息
     * 再根据查询到的api信息,再次查询
     *
     * @param jsonapi api实体类
     */
    public JSONObject doController(JSONAPI jsonapi) {
        Map<String, Object> map = apiService.searchApiByAddress(jsonapi);
        Map<String, Object> resultMap = new HashMap<>();
        String dbMethod = String.valueOf(map.get("method"));//数据库里存储的方法
        if (isEmptyByTrim(dbMethod) || (!Objects.equals(dbMethod, jsonapi.getMethod().toString()))) {
            resultMap.put("code", 400);
        } else {
            resultMap.put("code", 200);
        }
        return new JSONObject(resultMap);
    }
}
