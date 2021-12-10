package com.lingDream.celerityIT.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lingDream.celerityIT.entity.mapper.InsertEntity;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update.UpdateCelerityItWrapper;

import java.util.List;
import java.util.Map;

/**
 * 操作数据的Service
 */
public interface DoDataService {
    /**
     * 查询
     */
    List<Map<String, Object>> query(JSONPObject jsonpObject);

    /**
     * 分页查询
     */
    Page<Map<String, Object>> queryPage(Page<Map<String, Object>> page, JSONPObject jsonpObject);

    /**
     * 新增
     */
    Integer insertData(InsertEntity insertEntity);

    /**
     * 删除
     */
    Integer deleteData(UpdateCelerityItWrapper wrapper);

    /**
     * 修改
     */
    Integer updateData(UpdateCelerityItWrapper wrapper);
}
