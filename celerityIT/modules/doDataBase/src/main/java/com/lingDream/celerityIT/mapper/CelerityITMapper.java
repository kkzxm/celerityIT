package com.lingDream.celerityIT.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingDream.celerityIT.entity.dataBase.Table;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.query.QueryCelerityItWrapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update.UpdateCelerityItWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CelerityITMapper extends BaseMapper<Map<String, Object>> {
    /**
     * 根据自定义的wrapper查询数据库数据
     */
    List<Map<String, Object>> query(@Param("ew") QueryCelerityItWrapper wrapper);

    Page<Map<String, Object>> queryPage(Page<Map<String, Object>> page, @Param("ew") QueryCelerityItWrapper wrapper);

    Integer insertData(@Param("ew") UpdateWrapper<Table> wrapper, @Param("tableSet") List<Table> tableList);

    /**
     * 根据自定义的wrapper修改数据库数据
     */
    Integer updateData(@Param("ew") UpdateCelerityItWrapper wrapper);

    /**
     * 新增数据
     */
    Integer insertData(@Param("ew") UpdateCelerityItWrapper wrapper, @Param("tableList") Table... tables);
}
