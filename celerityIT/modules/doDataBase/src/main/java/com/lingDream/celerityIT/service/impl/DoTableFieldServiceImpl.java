package com.lingDream.celerityIT.service.impl;

import com.lingDream.celerityIT.entity.dataBase.Table;
import com.lingDream.celerityIT.mapper.DoFieldMapper;
import com.lingDream.celerityIT.service.DoTableFieldService;
import org.springframework.stereotype.Service;

@Service
public class DoTableFieldServiceImpl implements DoTableFieldService {
    final DoFieldMapper mapper;

    public DoTableFieldServiceImpl(DoFieldMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Integer addTableField(Table table) {
        return null;
    }

    @Override
    public Integer delTableField(Table table) {
        return null;
    }

    @Override
    public Integer changeTableField() {
        return null;
    }
}
