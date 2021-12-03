package com.lingDream.celerityIT.entity.dataBase;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 数据库的库
 */
@Data
public class DataBase {
    /**
     * 库名
     */
    private String name;
    /**
     * 表集合
     */
    private final Set<TableOrView> tableSet = new HashSet<>();
}
