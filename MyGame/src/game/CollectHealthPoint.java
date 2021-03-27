package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CollectHealthPoint implements CollisionListener {
    /**
     * The jet.
     */
    private Jet jet;

    /**
     * Synchronise the jet in the game and the jet collecting the health point.
     *
     * @param j The jet to collect the health point.
     */
    public CollectHealthPoint(Jet j) {
        this.jet = j;
    }

    /**
     * Other events triggered by the collision event (collecting the health point).
     *
     * @param b The collision event.
     */
    @Override
    public void collide(CollisionEvent b) {
        if (b.getOtherBody() instanceof HealthPoint) {
            jet.addScore();
            b.getOtherBody().destroy();
        }
    }
}
