package edu.javacourse.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Author: Georgy Gobozov
 * Date: 08.07.13
 */
@Stateless(mappedName = "SayBeanMulti")
public class SayBeanMulti {

    @EJB(beanName = "SayBeanOne")
    private Say beanOne;

    @EJB(beanName = "SayBeanTwo")
    private Say beanTwo;

    public String sayOne(){
        return beanOne.sayHello() + " " + beanOne.sayBye();
    }


    public String sayTwo(){
        return  beanTwo.sayHello() + " " + beanTwo.sayBye();
    }

}
