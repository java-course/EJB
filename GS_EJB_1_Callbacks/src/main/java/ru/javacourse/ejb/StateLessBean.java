package ru.javacourse.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class StateLessBean {

    @PostConstruct
    public void init() {
        System.out.println("Init sateless bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy sateless bean");
    }

    public void sayHello() {
        System.out.println("Hello EJB");
    }

    public int sum(int a, int b) {
        return a + b;
    }

}
