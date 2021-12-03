package com.lingDream.celerityIT.tool.overrideClass.mybatisPlus;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public abstract class AbstractCelerityItWrapper extends UpdateWrapper<Map<String, Object>> {
    protected String tableName;
    protected final StringBuffer operationSql = new StringBuffer();
    protected final Set<String> columnSet = new HashSet<>();

    public abstract String getOperationSql();

    public <T extends AbstractCelerityItWrapper> T setTableName(String tableName){
        this.tableName = tableName;
        return (T)this;
    }

    public <T extends AbstractCelerityItWrapper> T addColumns(String... columns) {
        columnSet.addAll(Arrays.asList(columns));
        return (T)this;
    }
}
