package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    /**
     * The game view of the player.
     */
    private MyView view;

    /**
     * The jet.
     */
    private Jet jet;

    /**
     * Track the jet in the view.
     *
     * @param view description of all the method's variables.
     * @param jet description of all the method's variables.
     */
    public Tracker(MyView view, Jet jet) {
        this.view = view;
        this.jet = jet;
    }

    /**
     * Step events before tracking.
     *
     * @param e description of all the method's variables.
     */
    public void preStep(StepEvent e) {}

    /**
     * Step events after tracking.
     *
     * @param e description of all the method's variables.
     */
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(jet.getPosition().x, 10));
    }
}
