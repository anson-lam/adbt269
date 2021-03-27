package game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Virus extends DynamicBody{
    /** The shape of the virus */
    private static final Shape virusShape = new CircleShape(1);

    /** The sound for the collision with virus */
    private static SoundClip virusSound;
    static {
        try {
            virusSound = new SoundClip("data/sound_virus.wav");
            System.out.println("Loading virus sound");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /** The image of the virus */
    private static final BodyImage image =
            new BodyImage("data/virus.png", 2);

    /**
     * Add the virus to the world.
     *
     * @param world The world to which the virus is added.
     */
    public Virus(World world) {
        super(world, virusShape);
        addImage(image);
    }

    /**
     * Destroy the virus when it falls to hit the ground.
     */
    @Override
    public void destroy()
    {
        virusSound.play();
        super.destroy();
    }

    /**
     * Get the sound of the virus.
     * <p>
     * Triggered when the jet is infected with the virus.
     *
     * @return The sound of the virus of SoundClip type.
     */
    public static SoundClip getVirusSound() {
        return virusSound;
    }
}
