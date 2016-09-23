package fr.istic.gli.tp.view;

import fr.istic.gli.tp.controller.Controller;
import fr.istic.gli.tp.model.Ensemble;
import fr.istic.gli.tp.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by nirina on 16/09/16.
 */
public class Camembert extends JComponent{

    Ensemble model;
    List<Quarter> quarters;
    String clabelnamecst;
    String clabelvaluecst;
    String clabeldescriptioncst;

    public Camembert(Ensemble model){
        this.model = model;
        quarters = new ArrayList<Quarter>();
        double total = getTotal(model);
        double start_angle = 0;
        double angle;
        Color c;
        Random rand = new Random();
        for (Item i:model.getItems()){
            angle = computeAngle(total,i.getValue());
            c = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
            quarters.add(new Quarter(start_angle,angle,i,c));
            start_angle += angle;
        }
        clabelnamecst = model.getName();
        clabelvaluecst = java.lang.Double.toString(total);
        clabeldescriptioncst = model.getDescription();

    }

    public void update(){
        double start_angle = 0;
        double angle;
        double total = getTotal(model);
        int ind = 0;
        for (Quarter q:quarters){
            q.setAngleStart(start_angle);
            angle = computeAngle(total,q.getItem().getValue());
            q.setAngleExtent(angle);
            start_angle+=angle;
            ind++;
        }
        Random rand = new Random();
        for (int i=ind;i<model.getItems().size();i++){
            angle = computeAngle(total,model.getItemAt(i).getValue());
            Color c = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            quarters.add(new Quarter(start_angle,angle,model.getItemAt(i),c));
            start_angle += angle;
        }
        setClabelvaluecst(java.lang.Double.toString(total));
    }

    public void setEnsemble(Ensemble e){
        model = e;
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (Quarter q:quarters){
            g2.setPaint(q.getColor());
            g2.fill(q);
            g2.setPaint(Color.WHITE);
            g2.draw(q);
        }
        //Dessiner le rond central
        drawInnerCircle(g2);
        //Ecrire le nom de l'ensemble
        this.drawEnsembleLabel(g2);
    }
    static double computeAngle(double total,double data){
        return 360*data/total;
    }
    static double getTotal(Ensemble e){
        double t = 0;
        for (Item i:e.getItems()){
            t += i.getValue();
        }
        return t;
    }
    static void drawInnerCircle(Graphics2D g){
        g.setPaint(Color.WHITE);
        g.fill(new Arc2D.Float(75,75,250,250,0,360,Arc2D.PIE));
        g.setPaint(Color.GREEN);
        g.fill(new Arc2D.Float(80,80,240,240,0,360,Arc2D.PIE));
    }
    public void drawEnsembleLabel(Graphics2D g){
        String label;
        String value;
        String description;
        int exp = this.getExpanded();
        if (exp<0){
            label = this.getClabelnamecst();
            value = this.getClabelvaluecst();
            description = this.getClabeldescriptioncst();
        }else{
            label = this.getQuarterAt(exp).getItem().getName();
            value = Double.toString(this.getQuarterAt(exp).getItem().getValue());
            description = this.getQuarterAt(exp).getItem().getDescription();
        }
        g.setPaint(Color.WHITE);
        g.drawString(label,200,190);
        g.drawString(value,200,210);
        g.drawString(description,200,230);
    }

    public List<Quarter> getQuarters() {
        return quarters;
    }

    public String getClabelnamecst() {
        return clabelnamecst;
    }

    public void setClabelnamecst(String clabelnamecst) {
        this.clabelnamecst = clabelnamecst;
    }

    public String getClabelvaluecst() {
        return clabelvaluecst;
    }

    public void setClabelvaluecst(String clabelvaluecst) {
        this.clabelvaluecst = clabelvaluecst;
    }

    public String getClabeldescriptioncst() {
        return clabeldescriptioncst;
    }

    public void setClabeldescriptioncst(String clabeldescriptioncst) {
        this.clabeldescriptioncst = clabeldescriptioncst;
    }

    public int getExpanded(){
        int i=0;
        for (Quarter q:quarters){
            if (q.isExpanded()){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void showNext(){
        int end = quarters.size()-1;
        int ind = getExpanded();
        if (ind>=0 && ind<end){
            getQuarterAt(ind).retract();
            getQuarterAt(ind+1).expand();
        }
        if (ind==end){
            getQuarterAt(end).retract();
            getQuarterAt(0).expand();
        }
    }

    public void showPrevious(){
        int end = quarters.size()-1;
        int ind = getExpanded();
        if (ind>0){
            getQuarterAt(ind).retract();
            getQuarterAt(ind-1).expand();
        }
        if (ind==0){
            getQuarterAt(0).retract();
            getQuarterAt(end).expand();
        }
    }

    public Quarter getQuarterAt(int ind){
        return quarters.get(ind);
    }

}
