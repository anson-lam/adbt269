package game;

import city.cs.engine.*;

public class BlackHole extends StaticBody {
    /**
     * The shape of the black hole.
     */
    private static final Shape BlackHoleShape = new CircleShape(2);

    /**
     * The image of the black hole.
     */
    private static final BodyImage image =
            new BodyImage("data/black_hole.png", 10);

    /**
     * Link the black hole to the world.
     *
     * @param world The world to which the black hole is added.
     */
    public BlackHole(World world) {
        super(world, BlackHoleShape);
        addImage(image);
    }
}
