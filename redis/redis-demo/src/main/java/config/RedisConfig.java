package config;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RedisConfig {
    public static final String REDIS_STAND_ALONE_HOST = "120.24.170.213";
    public static final int REDIS_STAND_ALONE_PORT = 6381;
    public static final String REDIS_CLUSTER = "120.24.170.213:7001," +
            "120.24.170.213:7002,120.24.170.213:7003,120.24.170.213:7004," +
            "120.24.170.213:7005,120.24.170.213:7006";
}
