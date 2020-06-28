import com.sunbc.spring.tx.xml.service.Cashier;
import com.sunbc.spring.tx.xml.service.BookShopDao;
import com.sunbc.spring.tx.xml.service.BookShopService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TestTransactionXml {

    ApplicationContext ctx = null;
    BookShopDao bookShopDao;
    BookShopService bookShopService;
    Cashier cashier;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("applicationContext-tx.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void test04(){
        bookShopService.purchase("AA","1001");
    }

    @Test
    public void test05(){
        cashier.checkOut("AA", Arrays.asList("1001","1002"));
    }

}
