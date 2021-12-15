package com.lingDream.delerityIT.Flow.systemStart;

import com.lingDream.celerityIT.entity.dataBase.Field;
import com.lingDream.celerityIT.entity.dataBase.Table;
import com.lingDream.celerityIT.mapper.DoTableMapper;
import com.lingDream.delerityIT.Flow.systemStart.root.Abs_DataBaseStartFlow;

import java.util.ArrayList;
import java.util.List;

import static com.lingDream.celerityIT.tool.SpringUtil.getBean;

public class CreateSysTableFlow extends Abs_DataBaseStartFlow {
    List<Table> tableList = new ArrayList<Table>() {{
        add(new Table().setName("manager").setComment("测试一下")
                .addFields(
                        new Field().setName("id").setComment("编号").setPrimary(true),
                        new Field().setName("name").setComment("姓名"),
                        new Field().setName("password").setComment("密码"),
                        new Field().setName("phone").setComment("手机号码")
                )
        );
    }};

    @Override
    public Abs_DataBaseStartFlow doStartDataBase(Object... objects) {
        for (Table table : tableList) {
            table.setName(objects[0] + "." + table.getName());
            getBean(DoTableMapper.class).createTable(table);
        }
        return null;
    }
}
