package edu.javacourse.ejb;

import javax.ejb.Stateless;

/**
 * Author: Georgy Gobozov
 * Date: 08.07.13
 */
@Stateless(mappedName = "BeanOne")
public class SayBeanOne implements Say {

    @Override
    public String sayHello() {
        return "Hello from One!";
    }

    @Override
    public String sayBye() {
        return "Bye from One";
    }
}
