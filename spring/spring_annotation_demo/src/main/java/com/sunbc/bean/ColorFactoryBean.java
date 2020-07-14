package com.sunbc.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Nullable
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
