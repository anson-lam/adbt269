package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import city.cs.engine.*;

public class JetController implements KeyListener {

    /**
     * The moving speed of the jet when it is being conteolled.
     */
    private static final float WALKING_SPEED = 10;

    /**
     * The game in which the jet controller is.
     */
    private Game game;

    /**
     * Link the jet controller to the game.
     *
     * @param game The game which runs the jet controller
     */
    public JetController(Game game) {
        this.game = game;
    }

    /**
     * Trigger events if a key is typed.
     *
     * @param e The typed key.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Trigger events if a key is pressed.
     *
     * @param e The pressed key.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            game.getJet().startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            game.getJet().startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_UP) {
            game.getJet().jump(WALKING_SPEED);
        }

        // keys for saving and loading
        else if (code == KeyEvent.VK_S) {
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (code == KeyEvent.VK_L) {
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * Trigger events if a key is released.
     *
     * @param e The released key.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            game.getJet().stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            game.getJet().stopWalking();
        }
    }
}
