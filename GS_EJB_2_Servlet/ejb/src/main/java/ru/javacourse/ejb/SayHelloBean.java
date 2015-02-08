package ru.javacourse.ejb;

import javax.ejb.Stateless;

@Stateless
public class SayHelloBean{

    public String sayHello() {
        return "Hello from EJB";
    }
}
