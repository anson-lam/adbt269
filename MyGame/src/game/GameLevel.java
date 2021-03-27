package game;

import city.cs.engine.World;

public abstract class GameLevel extends World {
    /**
     * The jet in the level.
     */
    private Jet jet;

    /**
     * The ground in the level.
     */
    private Ground ground;

    /**
     * Set up static bodies and their collision listeners which are common among all game levels.
     *
     * @param game The game which runs the level.
     */
    public GameLevel(Game game) {

        //create the jet and black hole
        //jet = new Jet(this);
        ground = new Ground(this);

        /*
        //encounters of black hole and floating black hole
        BlackHoleEncounter encounter1 = new BlackHoleEncounter(this, game);
        jet.addCollisionListener(encounter1);
        BlackHoleFloatingEncounter encounter2 = new BlackHoleFloatingEncounter(this, game);
        jet.addCollisionListener(encounter2);

        //jet's collision listener of infection
        InfectedWithVirus infected = new InfectedWithVirus(jet);
        jet.addCollisionListener(infected);

        //jet's collision listener of collection
        CollectHealthPoint collect = new CollectHealthPoint(jet);
        jet.addCollisionListener(collect);
        */

        //ground's collision listener of destroying health points
        GroundDestroysHealthPoint destroy1 = new GroundDestroysHealthPoint(ground);
        ground.addCollisionListener(destroy1);

        //ground's collision listener of destroying viruses
        GroundDestroysVirus destroy2 = new GroundDestroysVirus(ground);
        ground.addCollisionListener(destroy2);
    }

    /**
     * Populate dynamic bodies and their collision listeners which are common among all game levels.
     *
     * @param game The game which runs the level.
     */
    public void populate(Game game) {
        //create the jet and black hole
        jet = new Jet(this);
        //ground = new Ground(this);

        //encounters of black hole and floating black hole
        BlackHoleEncounter encounter1 = new BlackHoleEncounter(this, game);
        jet.addCollisionListener(encounter1);
        BlackHoleFloatingEncounter encounter2 = new BlackHoleFloatingEncounter(this, game);
        jet.addCollisionListener(encounter2);

        //jet's collision listener of infection
        InfectedWithVirus infected = new InfectedWithVirus(jet);
        jet.addCollisionListener(infected);

        //jet's collision listener of collection
        CollectHealthPoint collect = new CollectHealthPoint(jet);
        jet.addCollisionListener(collect);
    }

    /**
     * Get the jet of a specific level.
     *
     * @return A jet of Jet class.
     */
    public Jet getJet() {
        return jet;
    }

    /**
     * Set the jet of a specific level.
     *
     * @param j The jet to be set.
     */
    public void setJet(Jet j) {
        jet = j;
    }

    /**
     * Get the ground of a specific level.
     *
     * @return The ground of Ground class.
     */
    public Ground getGround() {
        return ground;
    }

    //method of completing a level
    /**
     * An abstract method to test whether a specific level is has been completed.
     *
     * @return True if the level has been completed; false otherwise.
     */
    public abstract boolean isComplete();

    /**
     * An abstract method to get the level name.
     *
     * @return The level name of string type.
     */
    public abstract String getLevelName();
}
