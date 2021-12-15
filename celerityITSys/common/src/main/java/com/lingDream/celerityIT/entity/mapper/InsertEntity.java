package com.lingDream.celerityIT.entity.mapper;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.*;

/**
 * 新增时用这个类,代替原本的实体类
 */
@Data
@Accessors(chain = true)
public class InsertEntity {
    private String tableName;
    private final Set<String> fieldNames = new HashSet<>();
    private final String fieldStr;
    private List<Map<String, Object>> valueMapList = new ArrayList<>();

    public InsertEntity(String tableName, String... fieldNames) {
        this.tableName = tableName;

        this.fieldNames.addAll(Arrays.asList(fieldNames));

        String fies = String.valueOf(this.fieldNames);
        this.fieldStr = fies.substring(1, fies.length() - 1);
    }

    /**
     * 针对xml文件的出口
     */
    public List<Object[]> getValueSqlList() {
        List<Object[]> valSqlList = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : valueMapList) {
            valSqlList.add(getItemValueSql(stringObjectMap));
        }
        return valSqlList;
    }

    private Object[] getItemValueSql(Map<String, Object> valueMap) {
        String[] split = this.fieldStr.split(",");
        Object[] valueSql = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            valueSql[i] = valueMap.get(split[i].trim());
        }
        return valueSql;
    }
}
