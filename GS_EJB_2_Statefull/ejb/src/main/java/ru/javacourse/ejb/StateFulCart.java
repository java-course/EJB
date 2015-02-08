package ru.javacourse.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;


@Stateful
public class StateFulCart implements ShopCart {

    List<String> items;

    @PostConstruct
    public void init() {
        System.out.println("StateFul post construct");
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
