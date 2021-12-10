package com.lingDream.celerityIT.entity.dataBase;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;
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
    private String comment; //备注
    private final Set<Field> fieldSet = new HashSet<>(); // 包含字段

    public <T extends TableOrView> T addFields(Field... fields) {
        fieldSet.addAll(Arrays.asList(fields));
        return (T) this;
    }

    public <T extends TableOrView> T setName(String name) {
        this.name = name;
        return (T) this;
    }
}
