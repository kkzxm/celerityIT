package com.lingDream.delerityIT.Flow.systemStart.root;

import com.lingDream.celerityIT.tool.cache.Cache;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 当前系统的启动流程
 * <p>
 * 处理数据库,如果没有发现需要的数据库与表 则直接创建
 */
public interface DataBaseStartFlow {
    /**
     * 启动类
     */
    void init(SqlSessionFactory sqlSessionFactory, Cache cache);

    /**
     * 处理
     */
    Abs_DataBaseStartFlow doStartDataBase(Object... objects);

    /**
     * 最终结束类
     */
    void end();
}
