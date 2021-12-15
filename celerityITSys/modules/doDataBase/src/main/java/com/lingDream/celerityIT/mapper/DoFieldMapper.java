package com.lingDream.celerityIT.mapper;

import com.lingDream.celerityIT.entity.dataBase.Table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 操作数据库字段
 */
@Mapper
public interface DoFieldMapper {
    //region 数据库表字段

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
    //endregion
}
