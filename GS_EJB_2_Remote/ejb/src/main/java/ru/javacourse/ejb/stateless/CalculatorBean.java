package ru.javacourse.ejb.stateless;

/**
 * Created by Georgy Gobozov on 06.02.2015.
 */
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
//@Remote(RemoteCalculator.class)
@Local(RemoteCalculator.class)
public class CalculatorBean implements RemoteCalculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}