package com.lingDream.celerityIT.service;

import com.lingDream.celerityIT.entity.dataBase.Table;
import org.apache.ibatis.annotations.Param;

/**
 * 操作数据表字段的Service
 */

public interface DoTableFieldService {
    /**
     * 新增表字段
     */
    Integer addTableField(@Param("table") Table table);

    /**
     * 删除表字段
     */
    Integer delTableField(@Param("table") Table table);

    /**
     * 修改表字段
     */
    Integer changeTableField();
}
