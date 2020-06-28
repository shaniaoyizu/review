import com.sunbc.spring.aop.impl.ArithmeticCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test02 {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test02(){
        ArithmeticCalculator calculator = ctx.getBean(ArithmeticCalculator.class);
        int add = calculator.add(1, 2);
        System.out.println(add);

        int sub = calculator.sub(1, 2);
        System.out.println(sub);

        int div = calculator.div(1, 1);
        System.out.println(div);
    }
}
