package fr.istic.gli.tp.model;

/**
 * Created by nirina on 16/09/16.
 */
public class Item {
    String name;
    double value;
    String description;

    public Item(String name, double value, String description){
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
