package com.lingDream.celerityIT.entity.dataBase;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * 数据库表或视图
 */
@Data
@Accessors(chain = true)
public abstract class TableOrView {
    private String name;//表名
    private DataBase dataBase;//所属数据库
    private String commit; //备注
    private final Set<Field> fieldSet = new HashSet<>(); // 包含字段
}
