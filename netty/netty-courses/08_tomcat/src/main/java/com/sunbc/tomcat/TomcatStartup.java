package com.sunbc.tomcat;

/**
 * Created on 2020-07-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TomcatStartup {
    public static void main(String[] args) throws Exception {
        TomcatServer server = new TomcatServer("com.sunbc.webapp");
        server.start();
    }
}
