package edu.javacourse.ejb;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Author: Georgy Gobozov
 * Date: 08.07.13
 */
@Stateless
@LocalBean // http://piotrnowicki.com/2013/03/defining-ejb-3-1-views-local-remote-no-interface/
public class AsynchTestBean {



    @Asynchronous
    public java.util.concurrent.Future<String> sayHello(int duration) {
        try {
            System.out.println("Long process started....");
            Thread.sleep(duration);
            System.out.println("Long process finished....");

        } catch (InterruptedException ex) {
        }
        return new AsyncResult<String>("Long process result string");
    }


    @Asynchronous
    public java.util.concurrent.Future<Integer> longCalculation(int a, int b) {
        try {
            System.out.println("Long calculation started....");
            Thread.sleep(3000);
            System.out.println("Long calculation finished....");

        } catch (InterruptedException ex) {
        }
        return new AsyncResult<Integer>(a * b);
    }

}
