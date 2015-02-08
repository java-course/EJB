package edu.javacourse.ejb;

import javax.ejb.Local;

/**
 * Author: Georgy Gobozov
 * Date: 08.07.13
 */
@Local
public interface Say {

    public String sayHello();
    public String sayBye();

}
