import com.sunbc.spring.tx.annotation.Cashier;
import com.sunbc.spring.tx.annotation.dao.BookShopDao;
import com.sunbc.spring.tx.annotation.service.BookShopService;
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
public class TestTransaction {

    ApplicationContext ctx = null;
    BookShopDao bookShopDao;
    BookShopService bookShopService;
    Cashier cashier;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void test(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

    @Test
    public void test02(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void test03(){
        bookShopDao.updateUserAccount("AA",200);
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
