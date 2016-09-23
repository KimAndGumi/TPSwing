package fr.istic.gli.tp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nirina on 16/09/16.
 */
public class Ensemble implements IEnsemble{
    String name;
    List<Item> items;
    String description;

    public Ensemble(String name, String description){
        super();
        this.name = name;
        this.description = description;
        items = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public Item getItemAt(int ind) {
        return items.get(ind);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
