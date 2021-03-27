package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class InfectedWithVirus implements CollisionListener {
    /**
     * The jet.
     */
    private Jet jet;

    /**
     * Synchronise the jet in the game and the jet being infected with the virus.
     *
     * @param j The jet to be infected with the virus.
     */
    public InfectedWithVirus(Jet j) {
        this.jet = j;
    }

    /**
     * Other events triggered by the collision event (being infected with the virus).
     *
     * @param a The collision event.
     */
    @Override
    public void collide(CollisionEvent a) {
        if (a.getOtherBody() instanceof Virus) {
            jet.deductScore();
            jet.deductLife();
            a.getOtherBody().destroy();
        }
    }
}
