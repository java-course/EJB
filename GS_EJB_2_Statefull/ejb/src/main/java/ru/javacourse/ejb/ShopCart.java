package ru.javacourse.ejb;

import javax.ejb.Local;
import java.util.List;


@Local
public interface ShopCart {

    public List<String> getItems();
    public void addItem(String item);
    public void removeItem(String item);

}
