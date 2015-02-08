package edu.javacourse.ejb;

import javax.ejb.Stateless;

/**
 * Author: Georgy Gobozov
 * Date: 08.07.13
 */
@Stateless(mappedName = "BeanTwo")
public class SayBeanTwo implements Say {

    @Override
    public String sayHello() {
        return "Say Hello from Two";
    }

    @Override
    public String sayBye() {
        return "Say Bye from Two";
    }
}
