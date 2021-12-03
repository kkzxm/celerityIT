package com.lingDream.celerityIT.entity.dataBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class View extends TableOrView {
    private String sql; //创建视图的sql
}
