package com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update;

import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.AbstractCelerityItWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class UpdateCelerityItWrapper extends AbstractCelerityItWrapper {
    private String tableName; //操作的表名
    private final Set<String> columns = new HashSet<>(); //字段列表

    @Override
    public String getOperationSql() {
        return null;
    }
}
