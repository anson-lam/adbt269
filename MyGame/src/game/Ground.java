package game;

import city.cs.engine.*;

public class Ground extends StaticBody{
    /**
     * The shape of the wall.
     */
    private static final Shape groundShape = new BoxShape(15, 2);

    /**
     * The image of the wall.
     */
    public Ground(World world) {
        super(world, groundShape);
    }

    /**
     * Destroy specific objects which fall to hit the ground.
     */
    @Override
    public void destroy()
    {
        super.destroy();
    }
}