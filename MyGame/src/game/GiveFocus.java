package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiveFocus implements MouseListener{
    /**
     * The view in the game.
     */
    private MyView view;

    /**
     * Give focus to the view.
     *
     * @param v The view of the player in the game.
     */
    public GiveFocus(MyView v){
        this.view = v;
    }


    /**
     * Events triggered by clicking the mouse.
     *
     * @param e The event of clicking the mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Events triggered by pressing the mouse.
     *
     * @param e The event of pressing the mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Events triggered by releasing the mouse.
     *
     * @param e The event of releasing the mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Events triggered by entering the mouse.
     *
     * @param e The event of entering the mouse.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    /**
     * Events triggered by exiting the mouse.
     *
     * @param e The event of exiting the mouse.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}