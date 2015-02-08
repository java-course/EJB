package ru.javacourse.ejb;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgy Gobozov on 05.02.2015.
 */
public class NoEjbCart implements ShopCart {

    List<String> items = new ArrayList<String>();

    @PostConstruct
    public void init() {
        System.out.println("No Ejb cart post construct");
        items = new ArrayList<String>();
    }

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public void removeItem(String item) {
        items.remove(item);
    }
}
