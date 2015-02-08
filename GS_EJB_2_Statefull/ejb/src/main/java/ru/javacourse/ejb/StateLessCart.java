package ru.javacourse.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StateLessCart implements ShopCart{

    List<String> items;

    @PostConstruct
    public void init() {
        System.out.println("StateLess post construct");
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
