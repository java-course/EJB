package edu.javacourse.ejb;

import javax.ejb.Local;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
@Local
public interface SayBye {

    public String sayBye();
    public void printBye();


}
