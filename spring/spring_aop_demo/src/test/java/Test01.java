import com.sunbc.spring.aop.ArithmeticCalculator;
import com.sunbc.spring.aop.ArithmeticCalculatorImpl;
import com.sunbc.spring.aop.ArithmeticCalculatorLoggingProxy;
import org.junit.Test;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test01 {

    @Test
    public void test01(){
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        int result = proxy.add(1,2);
        System.out.println("-->" + result);

        result = proxy.sub(1,2);
        System.out.println("-->" + result);
    }
}
