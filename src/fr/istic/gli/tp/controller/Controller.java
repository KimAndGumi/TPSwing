package fr.istic.gli.tp.controller;

import fr.istic.gli.tp.view.Quarter;
import fr.istic.gli.tp.view.Camembert;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by nirina on 16/09/16.
 */
public class Controller implements MouseListener,KeyListener {

    Camembert camembert;

    public Controller(Camembert c){
        super();
        camembert = c;
    }

    /**
     * catch mouseEvent and expand the right Quarter (and retract the others) if it's retracted (or retract it if expanded)
     * @param mouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        for (Quarter q: camembert.getQuarters()){
            if (q.contains(mouseEvent.getX(),mouseEvent.getY())){
                if (q.isExpanded()) {
                    q.retract();
                }else {
                    q.expand();
                }
            }else{
                q.retract();
            }
        }
        camembert.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * catch keyPressed event and show the infos of the next (or previous) one
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_LEFT){
            camembert.showPrevious();
        }
        if(e.getKeyCode() == e.VK_RIGHT){
            camembert.showNext();
        }
        camembert.repaint();

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
