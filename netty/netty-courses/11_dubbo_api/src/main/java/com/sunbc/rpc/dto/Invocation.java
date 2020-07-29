package com.sunbc.rpc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Data
public class Invocation implements Serializable {
    /**
     * 业务接口名
     */
    private String className;
    /**
     * 远程调用方法名
     */
    private String methodName;
    /**
     * 参数类型
     */
    private Class<?>[] paramTypes;
    /**
     * 参数值
     */
    private Object[] paramValue;
    /**
     * 要调用的接口实现类名前缀
     */
    private String prefix;
}
