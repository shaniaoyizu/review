package org.apache.dubbo.demo;


/**
 * 服务降级类
 */
public class DemoServiceMock implements DemoService {
    @Override
    public String sayHello(String name) {
        return "this is Mock Result : " + name;
    }
}
