package ru.javacourse.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

/**
 * Created by Georgy Gobozov on 06.02.2015.
 */
@Stateful
public class StateFulBean {

    @PostConstruct
    public void init() {
        System.out.println("Init sateful bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy sateful bean");
    }

    @PostActivate
    public void activate() {
        System.out.println("Activate stateful bean");
    }

    @PrePassivate
    public void passivate() {
        System.out.println("Passivate stateful bean");
    }

    public int sum(int a, int b) {
        return a + b;
    }

}
