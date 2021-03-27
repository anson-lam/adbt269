package game;

import city.cs.engine.*;

public class Jet extends Walker {
    /**
     * The shape of the jet.
     */
    private static final Shape jetShape = new PolygonShape(
            0.05f,2.47f,
            -1.71f,-0.32f,
            -1.89f,-5.27f,
            1.94f,-5.29f,
            1.77f,-0.32f);

    /**
     * The image of the jet.
     */
    private static final BodyImage image =
            new BodyImage("data/jet.png", 5f);

    /**
     * THr score of the jet.
     */
    private static int score;

    /**
     * The life of the jet.
     */
    private static int life;

    /**
     * Link the jet to a specific world or level
     *
     * @param world The world that the jet is added to.
     */
    public Jet(World world) {
        super(world, jetShape);
        addImage(image);

        //score = 0;
    }

    /**
     * Deduct the score of the jet.
     * <p>
     * Triggered by the collision between the jet and viruses.
     */
    public void deductScore() {
        score--;
        System.out.println("Score:" + score);
    }

    /**
     * Add the score of the jet.
     * <p>
     * Triggered by the collision between the jet and health points.
     */
    public void addScore() {
        score++;
        System.out.println("Score:" + score);
    }

    /**
     * Deduct the life of the jet.
     * <p>
     * Triggered by the collision between the jet and viruses.
     */
    public void deductLife() {
        life--;
    }

    /**
     * Get the score of the jet.
     *
     * @return The score of integer type.
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the score of the jet.
     *
     * @param score The score to be set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get the life of the jet.
     *
     * @return The life of integer type.
     */
    public static int getLife() {
        return life;
    }

    /**
     * Set the life of the jet.
     *
     * @param life The life to be set.
     */
    public static void setLife(int life) {
        Jet.life = life;
    }
}
