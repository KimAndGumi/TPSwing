package fr.istic.gli.tp.model;

import java.util.List;

/**
 * Created by nirina on 16/09/16.
 */
public interface IEnsemble {
    public String getName();

    public void setName(String name);

    public List<Item> getItems();

    public void setItems(List<Item> items);

    public void addItem(Item item);

    public Item getItemAt(int ind);
}
