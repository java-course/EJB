package edu.javacourse.ejb.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MethodInterceptor {

    @PostConstruct
    public void onCreate(InvocationContext ctx) throws Exception {
        System.out.println("Method Interceptor created");
        ctx.proceed();
    }

    @PreDestroy
    public void onDestroy(InvocationContext ctx) throws Exception {
        System.out.println("Method Interceptor destroyed");
        ctx.proceed();
    }

    @AroundInvoke
    public Object onInvoke(InvocationContext ctx) throws Exception {
        System.out.println("Method invoked " + ctx.getMethod().getName());
        Object o = ctx.proceed();
        System.out.println("Method invoked finished");
        return o;
    }
}
