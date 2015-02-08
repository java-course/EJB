import edu.javacourse.ejb.AsynchTestBean;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
public class EjbTest {


    private static EJBContainer ec=null;
    private static Context ctx=null;



    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> props=new HashMap<String, Object>();
        props.put(EJBContainer.MODULES, new File("target/classes"));
       // props.put("org.glassfish.ejb.embedded.glassfish.instance.root","./src/test/testing-domain");
       //props.put("org.glassfish.ejb.embedded.glassfish.web.http.port","");
        //props.put("org.glassfish.ejb.embedded.glassfish.installation.root","c:\\Java\\glassfish4\\glassfish\\domains\\domain1\\");
        ec = EJBContainer.createEJBContainer(props);
        ctx = ec.getContext();
    }


    @AfterClass
    public static void closeContainer() throws Exception {
        if(ctx!=null)
            ctx.close();
        if(ec!=null)
            ec.close();
    }

    @Test
    public void test() throws Exception {

        AsynchTestBean simpleBean = (AsynchTestBean) ctx.lookup("java:global/classes/AsynchTestBean");
        Future<String> answer = simpleBean.sayHello(5000);
        System.out.println("Answer = " + answer.get());

    }

    @Test
    public void test2() throws Exception {

        AsynchTestBean simpleBean = (AsynchTestBean) ctx.lookup("java:global/classes/AsynchTestBean");

        Future<String> answer = simpleBean.sayHello(5000);

        System.out.println("Between sync calls!");

        Future<Integer> answer2 = simpleBean.longCalculation(504, 872);


        System.out.println("Answer = " + answer.get());
        System.out.println("Answer = " + answer2.get());

    }





}
