package com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.query;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class QueryCelerityItWrapper extends QueryWrapper<Map<String, Object>> {
    private String tableName;
    private final Set<String> columnSet = new HashSet<>();
    private String querySql; //直接用sql查询

    public QueryCelerityItWrapper setColumns(String... columns) {
        columnSet.addAll(Arrays.asList(columns));
        return this;
    }

    public String getColumns() {
        if (columnSet.size() == 0) return "*";
        String valueOf = String.valueOf(this.columnSet);
        return valueOf.substring(1, valueOf.length() - 1);
    }

    /**
     * 指定列 模糊查询
     */
    public QueryCelerityItWrapper columnsLikeValue(Object value, String... columns) {
        for (String column : columns) {
            this.or().like(column, value);
        }
        return this;
    }
}
