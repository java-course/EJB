package edu.javacourse.ejb;

import javax.ejb.Stateless;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
@Stateless(name = "ByeBye")
public class SayByeBean implements SayBye{

    @Override
    public String sayBye() {
        return "Bye-Bye Ejb!";
    }

    @Override
    public void printBye() {
        System.out.println("Bye-Bye Ejb!");
    }
}
