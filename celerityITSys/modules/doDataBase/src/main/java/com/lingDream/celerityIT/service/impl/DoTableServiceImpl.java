package com.lingDream.celerityIT.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lingDream.celerityIT.entity.dataBase.Table;
import com.lingDream.celerityIT.mapper.DoTableMapper;
import com.lingDream.celerityIT.service.DoTableService;
import org.springframework.stereotype.Service;

import static com.lingDream.celerityIT.util.StringUtils.isEmptyByTrim;


@Service
public class DoTableServiceImpl implements DoTableService {
    final DoTableMapper mapper;

    public DoTableServiceImpl(DoTableMapper doTableMapper) {
        this.mapper = doTableMapper;
    }

    @Override
    public Integer createTable(Table table) {
        return mapper.createTable(table);
    }

    @Override
    public Integer dropTable(Table table) {
        return mapper.dropTable(table);
    }

    @Override
    public Integer clearTable(Table table) {
        return mapper.clearTable(table);
    }

    @Override
    public JSONPObject changeTable(Table oldTable, Table newTable) {
        //检查表名 无效直接返回false
        if (isEmptyByTrim(oldTable.getName())) {
            return null;
        }

        String newTableName = newTable.getName();
        //先执行修改备注
        if (!isEmptyByTrim(newTable.getComment())) {
            System.out.println(mapper.changeTableComment(oldTable, newTable));
        }
        //当新表名有效时,再执行修改表名
        if (!isEmptyByTrim(newTableName)) {
            System.out.println(mapper.renameTable(oldTable, newTable));
        }
        return new JSONPObject("", "");
    }
}
