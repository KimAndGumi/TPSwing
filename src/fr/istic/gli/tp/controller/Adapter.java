package fr.istic.gli.tp.controller;

import fr.istic.gli.tp.model.Ensemble;
import fr.istic.gli.tp.model.IEnsemble;
import fr.istic.gli.tp.model.Item;
import fr.istic.gli.tp.view.Camembert;

import java.util.List;

/**
 * Created by nirina on 16/09/16.
 */
public class Adapter implements IAdapter, IEnsemble{
    Ensemble ensemble;
    Camembert camembert;

    public Adapter(Ensemble e,Camembert c){
        ensemble = e;
        camembert = c;
    }

    public void setEnsemble(Ensemble e){
        ensemble = e;
    }
    public void setCamembert(Camembert c){
        camembert = c;
    }
    @Override
    public void notifyView() {
        camembert.update();
        camembert.repaint();
    }

    @Override
    public String getName() {
        return ensemble.getName();
    }

    @Override
    public void setName(String name) {
        ensemble.setName(name);
        notifyView();
    }

    @Override
    public List<Item> getItems() {
        return ensemble.getItems();
    }

    @Override
    public void setItems(List<Item> items) {
        ensemble.setItems(items);
        notifyView();
    }

    @Override
    public void addItem(Item item) {
        ensemble.addItem(item);
        //System.out.println("item ajouté");
        notifyView();
    }

    @Override
    public Item getItemAt(int ind) {
        return ensemble.getItemAt(ind);
    }

    public void setValueAt(Object o, int i,int i1) {
        switch (i1){
            case 0:
                ensemble.getItems().get(i).setName((String)o);
                break;
            case 1:
                ensemble.getItems().get(i).setValue(Double.parseDouble((String)o));
                break;
            case 2:
                ensemble.getItems().get(i).setDescription((String)o);
                break;
        }
        notifyView();
    }
}
