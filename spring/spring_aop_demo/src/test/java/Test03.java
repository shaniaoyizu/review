import com.sunbc.spring.aop.xml.ArithmeticCalculator;
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
public class Test03 {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");

    @Test
    public void test01(){
        ArithmeticCalculator calculator = ctx.getBean(ArithmeticCalculator.class);
        int add = calculator.add(1, 2);
        System.out.println(add);

        int sub = calculator.sub(1, 2);
        System.out.println(sub);

        int mul = calculator.mul(1, 2);
        System.out.println(mul);

        int div = calculator.div(1, 1);
        System.out.println(div);
    }
}
