package com.lingDream.delerityIT.Flow.systemStart.root;

import com.lingDream.celerityIT.tool.cache.Cache;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;

public abstract class Abs_DataBaseStartFlow implements DataBaseStartFlow {
    protected static Connection connection;
    protected static Cache cache;


    @Override
    public void init(SqlSessionFactory sqlSessionFactory, Cache cache1) {
        connection = sqlSessionFactory.openSession().getConnection();
        cache = cache1;
        if (this.doStartDataBase() == null) {
            this.end();
        }
    }

    @SneakyThrows
    @Override
    public void end() {
        connection.close();
    }
}
