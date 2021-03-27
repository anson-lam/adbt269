package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class HealthPoint extends DynamicBody {
    /** The shape of the health point */
    private static final Shape HPShape = new CircleShape(1);

    /** The sound for the collision with health point */
    private static SoundClip HPSound;
    static {
        try {
            HPSound = new SoundClip("data/sound_health_point.wav");
            System.out.println("Loading HP sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The image of the health point.
     */
    private static final BodyImage image =
            new BodyImage("data/health_point.png", 2);

    /**
     * Add the health point to the world.
     *
     * @param world The world to which the health point is added.
     */
    public HealthPoint(World world) {
        super(world, HPShape);
        addImage(image);
    }

    /**
     * Destroy the health point when it falls to hit the ground.
     */
    @Override
    public void destroy()
    {
        HPSound.play();
        super.destroy();
    }

    /**
     * Get the sound of the health point.
     * <p>
     * Triggered when the jet collects the health point.
     *
     * @return The sound of the health point of SoundClip type.
     */
    public static SoundClip getHPSound() {
        return HPSound;
    }
}