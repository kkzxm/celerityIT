package com.lingDream.delerityIT.Flow.systemStart;

import com.lingDream.celerityIT.entity.dataBase.DataBaseCatalog;
import com.lingDream.celerityIT.mapper.DoDataBaseCatalogMapper;
import com.lingDream.delerityIT.Flow.systemStart.root.Abs_DataBaseStartFlow;

/**
 * 检查数据库是否存在,不存在则创建一下,再传给下一个
 */
public class CheckDataBaseExistsFlow extends Abs_DataBaseStartFlow {
    private static final String dataBaseName = "db_celerity_sys";

    @Override
    public Abs_DataBaseStartFlow doStartDataBase(Object... objects) {
        if (cache.checkKeyExists(DataBaseCatalog.class, dataBaseName) == null) {
            DoDataBaseCatalogMapper mapper = (DoDataBaseCatalogMapper) objects[0];
            mapper.createDataBase(dataBaseName);
        }
        return new CreateSysTableFlow().doStartDataBase(dataBaseName);
    }
}
