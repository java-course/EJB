package ru.javacourse.ejb.stateful;

import javax.ejb.Remote;

/**
 * Created by Georgy Gobozov on 06.02.2015.
 */
@Remote
public interface RemoteCounter {

    void increment();

    void decrement();

    int getCount();

}
