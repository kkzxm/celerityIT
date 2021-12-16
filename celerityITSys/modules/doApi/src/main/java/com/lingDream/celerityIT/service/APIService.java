package com.lingDream.celerityIT.service;

import com.lingDream.celerityIT.entity.JSONAPI;
import com.lingDream.celerityIT.mapper.DoDataMapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.query.QueryCelerityItWrapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class APIService {
    final DoDataMapper doDataMapper;
    private static final String tableName = "api_info";

    public APIService(DoDataMapper doDataMapper) {
        this.doDataMapper = doDataMapper;
    }

    /**
     * 根据api的地址查询相关信息
     */
    public Map<String, Object> searchApiByAddress(JSONAPI jsonapi) {
        QueryCelerityItWrapper wrapper = new QueryCelerityItWrapper();
        wrapper.setTableName(tableName)
                .eq("address", jsonapi.getAddress());
        List<Map<String, Object>> query = doDataMapper.query(wrapper);
        return query.size() == 0 ? new HashMap<>() : query.get(0);//因为apiAddress不可重复,所以只取第一个
    }
}
