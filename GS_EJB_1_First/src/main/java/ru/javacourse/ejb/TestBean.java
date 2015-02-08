package ru.javacourse.ejb;

import javax.ejb.Stateless;

@Stateless
public class TestBean {

    public void sayHello() {
        System.out.println("Hello EJB");
    }

    public int sum(int a, int b) {
        return a + b;
    }

}
