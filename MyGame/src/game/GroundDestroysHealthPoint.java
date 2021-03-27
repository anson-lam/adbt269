package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GroundDestroysHealthPoint implements CollisionListener {

    private Ground ground;

    /**
     * Synchronise the ground in the level with the ground destroying the health point.
     *
     * @param ground The ground in the specific level.
     */
    public GroundDestroysHealthPoint(Ground ground) {
        this.ground = ground;
    }

    /**
     * Events triggered by the ground destroying the health point.
     *
     * @param c The collision event.
     */
    @Override
    public void collide(CollisionEvent c) {
        if (c.getOtherBody() instanceof HealthPoint) {
            c.getOtherBody().destroy();

            //remove the health point collision sound
            HealthPoint.getHPSound().stop();
        }
    }
}
