package fr.istic.gli.tp;

import fr.istic.gli.tp.controller.Adapter;
import fr.istic.gli.tp.controller.Controller;
import fr.istic.gli.tp.model.Ensemble;
import fr.istic.gli.tp.model.Item;
import fr.istic.gli.tp.view.Camembert;
import fr.istic.gli.tp.view.Table;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nirina on 16/09/16.
 */
public class Application {
    public static void main(String[] args){
        Ensemble e = new Ensemble("test","ensemble d'items");
        e.addItem(new Item("item1",154.f,"premier item"));
        e.addItem(new Item("item2",268.f,"second item"));
        e.addItem(new Item("item3",24.f,"troisième item"));
        //Item vierge pour pouvoir en ajouter
        e.addItem(new Item("",0,""));
        Camembert v = new Camembert(e);
        Controller c = new Controller(v);
        v.addMouseListener(c);
        Adapter a = new Adapter(e,v);
        Table table = new Table(a);
        JTable jt = new JTable(table);
        jt.addKeyListener(table);

        JFrame frame = new JFrame("Vue en camembert");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(v);
        frame.pack();
        frame.setSize(new Dimension(400, 400));
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.addKeyListener(c);

        JFrame frametab = new JFrame("Vue en table");
        JScrollPane scrollPane = new JScrollPane(jt);
        jt.setFillsViewportHeight(true);
        frametab.getContentPane().add(scrollPane);
        frametab.pack();
        frametab.setVisible(true);
    }
}
