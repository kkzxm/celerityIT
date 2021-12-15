package com.lingDream.celerityIT.mapper;

import com.lingDream.celerityIT.entity.dataBase.DataBaseCatalog;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据库
 */
@Mapper
public interface DoDataBaseCatalogMapper {
    //region 关于数据库

    /**
     * 查询所有数据库,
     * 注该方法并没有关闭连接,只将结果集关闭
     */
    @SneakyThrows
    default List<DataBaseCatalog> showAllDataBase(Connection connection) {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getCatalogs();
        List<DataBaseCatalog> catalogs = new ArrayList<>();
        while (resultSet.next()) {
            String catalogName = resultSet.getString(1);
            catalogs.add(new DataBaseCatalog().setName(catalogName));
        }
        resultSet.close();
        return catalogs;
    }

    /**
     * 创建数据库
     */
    Integer createDataBase(@Param("name") String databaseName);
    //endregion
}
