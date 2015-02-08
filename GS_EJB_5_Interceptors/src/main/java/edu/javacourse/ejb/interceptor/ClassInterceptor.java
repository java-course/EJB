package edu.javacourse.ejb.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ClassInterceptor {

    @PostConstruct
    public void onCreate(InvocationContext ctx) throws Exception {
        System.out.println("Class interceptor created");
        ctx.proceed();
    }

    @PreDestroy
    public void onDestroy(InvocationContext ctx) throws Exception {
        System.out.println("Class interceptor destroyed");
        ctx.proceed();
    }

    @AroundInvoke
    public Object onInvoke(InvocationContext ctx) throws Exception {
        System.out.println("Class interceptor method invoked" + ctx.getMethod().getName());


        Object o = ctx.proceed();

        System.out.println("Class interceptor method finished");
        return o;
    }
}
