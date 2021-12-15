package com.lingDream.celerityIT.mapper;

import com.lingDream.celerityIT.entity.dataBase.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 关于数据表的操作
 */
@Mapper
public interface DoTableMapper {
    //region 关于数据库表

    /**
     * 新增表
     */
    Integer createTable(@Param("table") Table table);

    /**
     * 删除表
     */
    Integer dropTable(@Param("table") Table table);

    /**
     * 截断表
     */
    Integer clearTable(@Param("table") Table table);

    /**
     * 表重命名
     */
    Integer renameTable(@Param("oldTable") Table oldTable, @Param("newTable") Table newTable);

    /**
     * 修改表备注
     */
    Integer changeTableComment(@Param("oldTable") Table oldTable, @Param("newTable") Table newTable);

    //endregion
}
