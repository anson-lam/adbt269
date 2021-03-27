package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GroundDestroysVirus implements CollisionListener {

    private Ground ground;

    /**
     * Synchronise the ground in the level with the ground destroying the virus.
     *
     * @param ground The ground in the specific level.
     */
    public GroundDestroysVirus(Ground ground) {
        this.ground = ground;
    }

    /**
     * Events triggered by the ground destroying the virus.
     *
     * @param d The collision event.
     */
    @Override
    public void collide(CollisionEvent d) {
        if (d.getOtherBody() instanceof Virus) {
            d.getOtherBody().destroy();

            //remove the virus collision sound
            Virus.getVirusSound().stop();
        }
    }
}
