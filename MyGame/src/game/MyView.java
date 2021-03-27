package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {
    /**
     * The background image.
     */
    private Image background;

    /**
     * The jet.
     */
    private Jet jet;

    /**
     * Create the view of world with jet, and set its width and height.
     *
     * @param  w description of all the method's variables.
     * @param  jet description of all the method's variables.
     * @param  width description of all the method's variables.
     * @param  height description of all the method's variables.
     */
    public MyView(World w, Jet jet, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/space.png").getImage();
        this.jet = jet;
    }

    /**
     * Create the background with an image.
     *
     * @param b The 2D graphics of the background.
     */
    @Override
    protected void paintBackground(Graphics2D b) {
        b.drawImage(background, 0, 0, this);
    }

    /**
     * Create the foreground with the score display.
     *
     * @param f The 2D graphics of the foreground.
     */
    @Override
    protected void paintForeground(Graphics2D f) {
        f.setFont(new Font("Arial", Font.BOLD, 30));
        f.setColor(Color.orange);
        f.drawString("Score:" + jet.getScore(), 20, 40);
        f.drawString("Life:" + jet.getLife(), 20, 80);
    }
}