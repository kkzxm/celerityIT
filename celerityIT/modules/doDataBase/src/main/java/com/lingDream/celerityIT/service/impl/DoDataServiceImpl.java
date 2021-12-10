package com.lingDream.celerityIT.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lingDream.celerityIT.entity.mapper.InsertEntity;
import com.lingDream.celerityIT.mapper.DoDataMapper;
import com.lingDream.celerityIT.service.DoDataService;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.query.QueryCelerityItWrapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update.UpdateCelerityItWrapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoDataServiceImpl implements DoDataService {
    final DoDataMapper mapper;

    public DoDataServiceImpl(DoDataMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Map<String, Object>> query(JSONPObject jsonpObject) {
        QueryCelerityItWrapper queryCelerityItWrapper = new QueryCelerityItWrapper();
        return mapper.query(queryCelerityItWrapper);
    }

    @Override
    public Page<Map<String, Object>> queryPage(Page<Map<String, Object>> page, JSONPObject jsonpObject) {
        QueryCelerityItWrapper queryCelerityItWrapper = new QueryCelerityItWrapper();
        return mapper.queryPage(page, queryCelerityItWrapper);
    }

    @Override
    public Integer insertData(InsertEntity insertEntity) {
        return mapper.insertData(insertEntity);
    }

    @Override
    public Integer deleteData(UpdateCelerityItWrapper wrapper) {
        return mapper.deleteData(wrapper);
    }

    @Override
    public Integer updateData(UpdateCelerityItWrapper wrapper) {
        return mapper.updateData(wrapper);
    }
}
