import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class JDBCTest {

    ApplicationContext ctx = null;

    JdbcTemplate jdbcTemplate = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void test01() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test02() {
        String sql = "UPDATE tb_employee SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "晓忍者", 13);
    }

    @Test
    public void test03() {
        String sql = "INSERT INTO tb_employee(last_name,email,gender,d_id) VALUES(?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA", "aa@xx.com", "0", 1});
        batchArgs.add(new Object[]{"BB", "bb@xx.com", "1", 2});
        batchArgs.add(new Object[]{"CC", "cc@xx.com", "0", 3});
        batchArgs.add(new Object[]{"DD", "dd@xx.com", "1", 4});
        batchArgs.add(new Object[]{"EE", "ee@xx.com", "0", 1});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
