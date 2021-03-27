package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level1 extends GameLevel implements ActionListener {
    /**
     * Specify what are in level 1.
     *
     * @param game The game which runs level 1.
     */
    public Level1(Game game){
        /** base class will create the jet and the black hole */
        super(game);

        /** set the positions of the ground */
        //getJet().setPosition(new Vec2(-2, -5));
        getGround().setPosition(new Vec2(0,-10));

        //optional to put collision listeners here, instead of in the abstract GameLevel
        //getJet().addCollisionListener(new InfectedWithVirus(getJet()));
        //getJet().addCollisionListener(new CollectHealthPoint(getJet()));

        /** create level specific platforms, enemies,
           pickups, collision listeners, etc.*/

        /** make walls */
        Shape wallShape = new BoxShape(15, 30);

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-30, 10));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(25, 10));

        /** make health points */
        /*
        HealthPoint healthPoint1 = new HealthPoint(this);
        healthPoint1.setPosition(new Vec2(-6, 30));

        HealthPoint healthPoint2 = new HealthPoint(this);
        healthPoint2.setPosition(new Vec2(2, 50));

        HealthPoint healthPoint3 = new HealthPoint(this);
        healthPoint3.setPosition(new Vec2(-6, 70));

        HealthPoint healthPoint4 = new HealthPoint(this);
        healthPoint4.setPosition(new Vec2(-10, 100));

        HealthPoint healthPoint5 = new HealthPoint(this);
        healthPoint5.setPosition(new Vec2(-6, 130));

        HealthPoint healthPoint6 = new HealthPoint(this);
        healthPoint6.setPosition(new Vec2(6, 170));

        HealthPoint healthPoint7 = new HealthPoint(this);
        healthPoint7.setPosition(new Vec2(2, 220));

        HealthPoint healthPoint8 = new HealthPoint(this);
        healthPoint8.setPosition(new Vec2(-10, 280));

        HealthPoint healthPoint9 = new HealthPoint(this);
        healthPoint9.setPosition(new Vec2(-6, 350));

        HealthPoint healthPoint10 = new HealthPoint(this);
        healthPoint10.setPosition(new Vec2(6, 430));

        */

        /** Timer for the black hole */
        Timer t = new Timer(13000, this);
        t.setRepeats(false);
        t.start();
    }

    @Override
    public void populate(Game game) {
        super.populate(game);

        /** set the positions of jet, black hole, and ground */
        getJet().setPosition(new Vec2(-2, -5));
        //getGround().setPosition(new Vec2(0,-10));

        /** make health points */

        HealthPoint healthPoint1 = new HealthPoint(this);
        healthPoint1.setPosition(new Vec2(-6, 30));

        HealthPoint healthPoint2 = new HealthPoint(this);
        healthPoint2.setPosition(new Vec2(2, 50));

        HealthPoint healthPoint3 = new HealthPoint(this);
        healthPoint3.setPosition(new Vec2(-6, 70));

        HealthPoint healthPoint4 = new HealthPoint(this);
        healthPoint4.setPosition(new Vec2(-10, 100));

        HealthPoint healthPoint5 = new HealthPoint(this);
        healthPoint5.setPosition(new Vec2(-6, 130));

        HealthPoint healthPoint6 = new HealthPoint(this);
        healthPoint6.setPosition(new Vec2(6, 170));

        HealthPoint healthPoint7 = new HealthPoint(this);
        healthPoint7.setPosition(new Vec2(2, 220));

        HealthPoint healthPoint8 = new HealthPoint(this);
        healthPoint8.setPosition(new Vec2(-10, 280));

        HealthPoint healthPoint9 = new HealthPoint(this);
        healthPoint9.setPosition(new Vec2(-6, 350));

        HealthPoint healthPoint10 = new HealthPoint(this);
        healthPoint10.setPosition(new Vec2(6, 430));


        ///** Timer for new and real black hole */
        //Timer t = new Timer(12000, this);
        //t.setRepeats(false);
        //t.start();

    }

    /** Required score for level 1*/
    @Override
    public boolean isComplete() {
        if ( (getJet().getScore() >= 4) && (getJet().getLife() > 0))
            return true;
        else return false;
    }

    /**
     * Set the black hole to appear according to the timer.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        BlackHole blackHole = new BlackHole(this);
        blackHole.setPosition(new Vec2(-2, 6.2f));
    }

    /**
     * Get the level name.
     *
     * @return The level name of string type.
     */
    @Override
    public String getLevelName() {
        return "Level1";
    }
}
