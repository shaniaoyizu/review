import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestJDBC {

    ApplicationContext ctx = null;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
