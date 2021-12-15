package com.lingDream.celerityIT.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lingDream.celerityIT.entity.dataBase.Table;
import org.apache.ibatis.annotations.Param;

/**
 * 操作数据表的业务层
 */

public interface DoTableService {
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
     * 修改表名/表备注
     */
    JSONPObject changeTable(@Param("oldTable") Table oldTable, @Param("newTable") Table newTable);
    //endregion
}
