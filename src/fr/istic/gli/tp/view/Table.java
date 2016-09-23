package fr.istic.gli.tp.view;

import fr.istic.gli.tp.controller.Adapter;
import fr.istic.gli.tp.model.Item;

import javax.swing.table.AbstractTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by nirina on 19/09/16.
 */
public class Table extends AbstractTableModel implements KeyListener {

    Adapter model;

    public Table(Adapter e){
        super();
        model = e;
    }

    @Override
    public int getRowCount() {
        return model.getItems().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Object o;
        switch (i1){
            case 0 :
                o = model.getItems().get(i).getName();
                break;
            case 1 :
                o = model.getItems().get(i).getValue();
                break;
            case 2 :
                o = model.getItems().get(i).getDescription();
                break;
            default :
                o = null;
                break;
        }
        return o;
    }

    @Override
    public boolean isCellEditable(int i,int i1){
        return true;
    }

    @Override
    public void setValueAt(Object o, int i,int i1) {
        model.setValueAt(o,i,i1);
    }

    public void addRow(){
        model.addItem(new Item("",0,""));
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == ke.VK_ENTER){
            addRow();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
