package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BlackHoleFloating extends DynamicBody implements StepListener{
    /**
     * The shape of the floating black hole.
     */
    private static final Shape BlackHoleShape = new CircleShape(2);

    /**
     * The image of the floating black hole.
     */
    private static final BodyImage image =
            new BodyImage("data/black_hole.png", 10);

    /**
     * The possible states of the floating black hole, floating left or right.
     */
    private enum State {
        FLOAT_LEFT, FLOAT_RIGHT
    }

    /**
     * The current level.
     */
    private GameLevel level;

    /**
     * The current state of the floating black hole.
     */
    private State state;

    /**
     * Synchronise the floating black hole with the level.
     *
     * @param level description of all the method's variables.
     */
    public BlackHoleFloating(GameLevel level) {
        super(level, BlackHoleShape);
        this.level = level;
        addImage(image);
        state = State.FLOAT_LEFT;
        getWorld().addStepListener(this);
    }

    /**
     * Track if the flaoting black role has reached the specified leftmost position.
     *
     * @return The boolean value of whether the condition is met, true or false.
     */
    public boolean reachLeft() {
        if (getPosition().x <= -8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Track if the flaoting black role has reached the specified rightmost position.
     *
     * @return The boolean value of whether the condition is met, true or false.
     */
    public boolean reachRight() {
        if (getPosition().x >= 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update the state of the floating black hole.
     *
     * @param e The step event.
     */
    public void preStep(StepEvent e) {
        if (reachLeft()) {
            if (state != State.FLOAT_RIGHT) {
                state = State.FLOAT_RIGHT;
            }
        } else if (reachRight()) {
            if (state != State.FLOAT_LEFT) {
                state = State.FLOAT_LEFT;
            }
        }
        refreshFloat();
    }

    /**
     * Refresh the state of the floating black hole.
     */
    private void refreshFloat() {
        switch (state) {
            case FLOAT_LEFT:
                setLinearVelocity(new Vec2(-5,0));
                //setAngularVelocity(-2);
                break;
            case FLOAT_RIGHT:
                setLinearVelocity(new Vec2(5, 0));
                //setAngularVelocity(2);
                break;
            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) {
    }
}
