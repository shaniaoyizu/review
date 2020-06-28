package com.sunbc.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.sunbc.method.DeleteAll;

import java.util.List;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> list = super.getMethodList(mapperClass);
        list.add(new DeleteAll());
        return list;
    }
}
