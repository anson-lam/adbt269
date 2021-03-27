package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BlackHoleEncounter implements CollisionListener {
    /**
     * The current level.
     */
    private GameLevel level;

    /**
     * The game which runs the level.
     */
    private Game game;

    /**
     * Track the level and game in which the black hole encounter is.
     *
     * @param level The current level.
     * @param game The game which runs the level.
     */
    public BlackHoleEncounter(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }

    /**
     * Specify the condition of triggering the BlackHoleEncounter.
     *
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        //If the jet has enough score and touch the black hole,
        //go to the next level
        if (e.getOtherBody() instanceof BlackHole
                && level.isComplete()) {
            game.goToNextLevel();
        }
    }
}
