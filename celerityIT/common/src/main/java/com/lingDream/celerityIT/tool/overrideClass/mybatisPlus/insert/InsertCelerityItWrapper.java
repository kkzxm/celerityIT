package com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.insert;

import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.AbstractCelerityItWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class InsertCelerityItWrapper extends AbstractCelerityItWrapper {
    private List<Map<String, Object>> valueList;

    public InsertCelerityItWrapper(List<Map<String, Object>> valueList) {
        this.valueList = valueList;
    }

    @Override
    public String getOperationSql() {
        String fieldString = getFieldString();
        String values = getValues(fieldString);
        String tableName = getTableName();
        operationSql.append(String.format(
                "insert into %s (%s) values %s ",
                tableName, fieldString, values));
        return String.valueOf(operationSql);
    }

    private String getFieldString() {
        String value = String.valueOf(columnSet);
        if ("[]".equals(value)) {
            throw new RuntimeException("保证规范，新增数据时，请必须填写新增的字段");
        }
        return value.substring(1, value.length() - 1);
    }

    private String getValues(String fieldString) {
        for (Map<String, Object> valueMap : valueList) {
            valueMap.forEach((k, v) -> {
                System.out.printf("k:%s,v:%s%n", k, v);
            });
        }
        return "";
    }

    public static void main(String[] args) {
        InsertCelerityItWrapper wrapper = new InsertCelerityItWrapper(new ArrayList<Map<String, Object>>() {{
            add(new Hashtable<String, Object>() {{
                put("chinese_info", "测试");
            }});
            add(new Hashtable<String, Object>() {{
                put("chinese_info", "一下");
            }});
        }}).setTableName("chinese")
                .addColumns("chinese_info");
        System.out.println(wrapper.getOperationSql());
    }
}
