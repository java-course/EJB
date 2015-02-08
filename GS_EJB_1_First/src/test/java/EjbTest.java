import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javacourse.ejb.TestBean;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
public class EjbTest {


    static EJBContainer ec = null;
    static Context ctx = null;

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(EJBContainer.MODULES, new File("target/classes"));
        // props.put("org.glassfish.ejb.embedded.glassfish.instance.root","./src/test/testing-domain");
        //props.put("org.glassfish.ejb.embedded.glassfish.web.http.port","");
        //props.put("org.glassfish.ejb.embedded.glassfish.installation.root","c:\\Java\\glassfish4\\glassfish\\domains\\domain1\\");
        ec = EJBContainer.createEJBContainer(props);
        ctx = ec.getContext();
    }


    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null)
            ctx.close();
        if (ec != null)
            ec.close();
    }

    @After
    public void printLine() {
        System.out.println("==========================================");
    }

    @Test
    public void test1() throws Exception {
        TestBean bean = (TestBean) ctx.lookup("java:global/classes/TestBean");
        bean.sayHello();

    }

    @Test
    public void test2() throws Exception {
        TestBean bean = (TestBean) ctx.lookup("java:global/classes/TestBean");
        int sum = bean.sum(1, 2);
        System.out.println("sum = " + sum);

    }


}
