package edu.javacourse.ejb;

import edu.javacourse.ejb.interceptor.ClassInterceptor;
import edu.javacourse.ejb.interceptor.MethodInterceptor;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@LocalBean
@Interceptors(ClassInterceptor.class)
public class InterceptorTestBean {


    @Interceptors(value = {MethodInterceptor.class})
    @ExcludeClassInterceptors
    public void withoutClassInterceptor() {
        System.out.println("EJB:withoutClassInterceptor");
    }

    @Interceptors(value = {MethodInterceptor.class})
    public void withClassInterceptor() {
        System.out.println("EJB:withClassinterceptor");
    }


}
