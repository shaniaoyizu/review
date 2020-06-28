package com.sunbc.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class DeleteAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = " DELETE FROM " + tableInfo.getTableName();
        String methodName = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass,methodName,sqlSource);
    }
}
