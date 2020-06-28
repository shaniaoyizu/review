package com.sunbc.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestMP {

    /**
     * 代码生成  示例代码
     */
    @Test
    public void test(){
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//支持AR模式
                .setAuthor("sunbc")
                .setOutputDir("E:\\review\\mybatis\\mybatis_plus_generator\\src\\main\\java") //生成路径
                .setFileOverride(true) //文件覆盖
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")  //设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)  //设置数据库类型
                        .setDriverName("com.mysql.cj.jdbc.Driver")
                        .setUrl("jdbc:mysql://localhost:3306/test_mybatis?serverTimezone=UTC&useSSL=false")
                        .setUsername("root")
                        .setPassword("xiaoBAO22");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  //全局大写命名
                        .setNaming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略
                        .setTablePrefix("tbl_")
                        .setInclude("tbl_employee");  //需要生成的表

        //4.包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.sunbc")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }
}
