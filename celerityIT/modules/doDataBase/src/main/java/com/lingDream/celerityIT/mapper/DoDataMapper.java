package com.lingDream.celerityIT.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingDream.celerityIT.entity.mapper.InsertEntity;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.query.QueryCelerityItWrapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update.UpdateCelerityItWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 操作数据
 */
@Mapper
public interface DoDataMapper {
    //region 关于数据

    /**
     * 根据自定义的wrapper查询数据库数据
     */
    List<Map<String, Object>> query(@Param("ew") QueryCelerityItWrapper wrapper);

    /**
     * 分页查询
     */
    Page<Map<String, Object>> queryPage(Page<Map<String, Object>> page, @Param("ew") QueryCelerityItWrapper wrapper);

    /**
     * 根据自定义的wrapper修改数据库数据
     */
    Integer updateData(@Param("ew") UpdateCelerityItWrapper wrapper);

    /**
     * 新增数据
     */
    Integer insertData(@Param("entity") InsertEntity entity);

    /**
     * 删除数据
     */
    Integer deleteData(@Param("ew") UpdateCelerityItWrapper wrapper);
    //endregion
}
