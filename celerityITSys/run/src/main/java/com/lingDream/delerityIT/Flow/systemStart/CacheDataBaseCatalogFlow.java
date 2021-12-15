package com.lingDream.delerityIT.Flow.systemStart;

import com.lingDream.celerityIT.entity.dataBase.DataBaseCatalog;
import com.lingDream.celerityIT.mapper.DoDataBaseCatalogMapper;
import com.lingDream.delerityIT.Flow.systemStart.root.Abs_DataBaseStartFlow;
import lombok.SneakyThrows;

import static com.lingDream.celerityIT.tool.SpringUtil.getBean;

/**
 * 查询所有数据库,并装库放入缓存
 */
public class CacheDataBaseCatalogFlow extends Abs_DataBaseStartFlow {

    /**
     * 缓存数据库名称
     */
    @SneakyThrows
    @Override
    public Abs_DataBaseStartFlow doStartDataBase(Object... objects) {
        DoDataBaseCatalogMapper bean = getBean(DoDataBaseCatalogMapper.class);
        for (DataBaseCatalog catalog : bean.showAllDataBase(connection)) {
            cache.put(DataBaseCatalog.class, catalog.getName(), catalog);
        }
        //交给检查数据库
        return new CheckDataBaseExistsFlow().doStartDataBase(bean);
    }
}
