package fr.istic.gli.tp.view;

import fr.istic.gli.tp.model.Item;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by nirina on 18/09/16.
 */
public class Quarter extends Arc2D.Double {
    Color color;
    Item item;
    boolean expanded;

    public Quarter(double start_angle,double angle,Item item,Color color){
        super(50,50,300,300,start_angle,angle,Arc2D.PIE);
        this.item = item;
        this.color = color;
        expanded = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void retract() {
        this.setArc(new Arc2D.Double(50,50,300,300,this.getAngleStart(),this.getAngleExtent(),Arc2D.PIE));
        expanded = false;
    }

    public void expand() {
        this.setArc(new Arc2D.Double(0,0,400,400,this.getAngleStart(),this.getAngleExtent(),Arc2D.PIE));
        expanded = true;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
