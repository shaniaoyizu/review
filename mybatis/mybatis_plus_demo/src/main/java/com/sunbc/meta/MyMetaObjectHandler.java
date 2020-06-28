package com.sunbc.meta;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        if (name == null){
            System.out.println("*********满足填充条件**********");
            this.strictInsertFill(metaObject,"name",String.class,"小影");
//            setFieldValByName("name","小影",metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        if (name == null){
            System.out.println("*********满足填充条件**********");
//            setFieldValByName("name","小雪",metaObject);
            this.strictUpdateFill(metaObject,"name",String.class,"小雪");
        }
    }
}
