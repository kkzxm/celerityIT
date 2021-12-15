package com.lingDream.celerityIT.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 关于数据视图的操作
 */
@Mapper
public interface DoViewMapper {
    /**
     * 新增视图
     */
    Integer createView();

    /**
     * 删除视图
     */
    Integer dropView();

    /**
     * 查看视图的创建sql
     */
    Integer showViewSql();

    /**
     * 修改视图
     */
    Integer changeView();
}
