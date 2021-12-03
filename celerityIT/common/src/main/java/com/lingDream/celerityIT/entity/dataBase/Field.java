package com.lingDream.celerityIT.entity.dataBase;

import lombok.Data;
import org.apache.ibatis.type.JdbcType;

/**
 * 表或视图的字段
 */
@Data
public class Field {
    private String name; // 名称
    private String commit; // 备注
    private JdbcType type; // 类型
    private Boolean primary; // 是否是主键
    private Object value; // 存储的值
    private TableOrView tableOrView; //所属表或视图
    private Object otherInfo;// 其它信息
}
