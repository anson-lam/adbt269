package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import java.awt.*;

/**
 * @author      Anson Lam
 * @version     1.0 (Milestone 3)
 * @since       Mar 2021
 * A world with some bodies.
 */
public class Game {
    /**
     * The game level in which the bodies move and interact.
     */
    private GameLevel level;

    /**
     * The background music.
     */
    private SoundClip gameMusic;

    /**
     * The graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    /**
     * The jet controller.
     */
    private JetController jc;

    /**
     * The score saver of level 1.
     */
    private int score_lv1;

    /**
     * The score saver of level 2.
     */
    private int score_lv2;

    /**
     * The life saver of level 1.
     */
    private int life_lv1;

    /**
     * The life saver of level 2.
     */
    private int life_lv2;

    /**
     * Initialise a new Game.
     */
    public Game() {
        // initialize level to Level1
        level = new Level1(this);
        level.populate(this);

        //set the initial score and life of level 1
        this.level.getJet().setScore(0);
        this.level.getJet().setLife(5);

        // make the background music
        try {
            gameMusic = new SoundClip("data/music_level_1.wav"); // Open an audio input stream
            gameMusic.loop(); //Set it to continuous playback(looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        // make a view
        view = new MyView(level, level.getJet(), 500, 700);
        view.setZoom(19);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add the jet controller
        jc = new JetController(this);
        view.addKeyListener(jc);

        // tracking the jet
        Tracker tracker = new Tracker(view, level.getJet());
        level.addStepListener(tracker);

        // give focus to the view
        view.addMouseListener(new GiveFocus(view));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Level 1");
        frame.add(view);

        //add the control panel
        ControlPanel controlPanel = new ControlPanel(level, gameMusic);
        frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 500, 1000);

        // start our game world simulation!
        level.start();
    }

    /**
     * Proceed to the next level.
     * <p>
     * Either proceed to level 2 or level 3.
     */
    public void goToNextLevel() {
        if (level instanceof Level1){
            //save the final score and life of level 1
            score_lv1 = this.level.getJet().getScore();
            life_lv1 = this.level.getJet().getLife();

            //stop the current level and music
            gameMusic.stop();
            level.stop();

            //create and refer to the next level
            level = new Level2(this);
            level.populate(this);

            //set the initial score and life of level 2
            this.level.getJet().setScore(score_lv1);
            this.level.getJet().setLife(life_lv1);

            // make the background music
            try {
                gameMusic = new SoundClip("data/music_level_2.wav"); // Open an audio input stream
                gameMusic.loop(); //Set it to continuous playback(looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

            //set the view and zoom to to the next level
            view.setWorld(level);
            view.setZoom(19);

            //change the score to the next level
            //jet.getScore() = level_1_score;
            //jet.setScore() level_1_score;

            // tracking the jet
            Tracker tracker = new Tracker(view, level.getJet());
            level.addStepListener(tracker);

            // give focus to the view
            view.addMouseListener(new GiveFocus(view));

            // add the view to a frame (Java top level window)
            final JFrame frame = new JFrame("Level 2");
            frame.add(view);

            //add the control panel
            ControlPanel controlPanel = new ControlPanel(level, gameMusic);
            frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);

            // enable the frame to quit the application
            // when the x button is pressed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true);
            // don't let the frame be resized
            frame.setResizable(false);
            // size the frame to fit the world view
            frame.pack();
            // finally, make the frame visible
            frame.setVisible(true);

            // uncomment this to make a debugging view
            //JFrame debugView = new DebugViewer(level, 500, 1000);

            //start the simulation in the new level
            level.start();

        } else if (level instanceof Level2) {
            //save the final score and life of level 2
            score_lv2 = this.level.getJet().getScore();
            life_lv2 = this.level.getJet().getLife();

            //stop the current level and music
            gameMusic.stop();
            level.stop();

            //create and refer to the next level
            level = new Level3(this);
            level.populate(this);

            //set the initial score and life of level 3
            this.level.getJet().setScore(score_lv2);
            this.level.getJet().setLife(life_lv2);

            // make the background music
            try {
                gameMusic = new SoundClip("data/music_level_3.wav"); // Open an audio input stream
                gameMusic.loop(); //Set it to continuous playback(looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

            //set the view and zoom to to the next level
            view.setWorld(level);
            view.setZoom(19);

            // tracking the jet
            Tracker tracker = new Tracker(view, level.getJet());
            level.addStepListener(tracker);

            // give focus to the view
            view.addMouseListener(new GiveFocus(view));

            // add the view to a frame (Java top level window)
            final JFrame frame = new JFrame("Level 3");
            frame.add(view);

            //add the control panel
            ControlPanel controlPanel = new ControlPanel(level, gameMusic);
            frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);

            // enable the frame to quit the application
            // when the x button is pressed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true);
            // don't let the frame be resized
            frame.setResizable(false);
            // size the frame to fit the world view
            frame.pack();
            // finally, make the frame visible
            frame.setVisible(true);

            // uncomment this to make a debugging view
            //JFrame debugView = new DebugViewer(level, 500, 1000);

            //start the simulation in the new level
            level.start();

        } else {
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }

    /**
     * Set the level to be loaded.
     * <p>
     * Can only be used after saving the game previously.
     *
     * @param level The level that has been saved previously.
     */
    public void setLevel(GameLevel level) {
        //save the final score and life of level 1
        score_lv1 = this.level.getJet().getScore();
        life_lv1 = this.level.getJet().getLife();

        //stop the current level and music
        this.gameMusic.stop();
        this.level.stop();

        //create and refer to the next level
        //level = new Level2(this);
        this.level = level;

        //set the initial score and life of level 2
        this.level.getJet().setScore(score_lv1);
        this.level.getJet().setLife(life_lv1);

        // make the background music
        try {
            //gameMusic = new SoundClip("data/music_level_2.wav"); // Open an audio input stream
            //gameMusic.loop(); //Set it to continuous playback(looping)
            if (level instanceof Level1) {
                gameMusic = new SoundClip("data/music_level_1.wav"); // Open an audio input stream
                gameMusic.loop(); //Set it to continuous playback(looping)
            } else if (level instanceof Level2) {
                gameMusic = new SoundClip("data/music_level_2.wav"); // Open an audio input stream
                gameMusic.loop(); //Set it to continuous playback(looping)
            } else {
                gameMusic = new SoundClip("data/music_level_3.wav"); // Open an audio input stream
                gameMusic.loop(); //Set it to continuous playback(looping)
            }
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        //set the view and zoom to to the next level
        view.setWorld(this.level);
        view.setZoom(19);

        //change the score to the next level
        //jet.getScore() = level_1_score;
        //jet.setScore() level_1_score;

        // tracking the jet
        Tracker tracker = new Tracker(view, this.level.getJet());
        level.addStepListener(tracker);

        // give focus to the view
        view.addMouseListener(new GiveFocus(view));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Developing");
        frame.add(view);

        //add the control panel
        ControlPanel controlPanel = new ControlPanel(this.level, gameMusic);
        frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 500, 1000);

        //start the simulation in the new level
        this.level.start();
    }

    /**
     * Get a specific level.
     *
     * @return The level of GameLevel class.
     */
    public GameLevel getLevel() {
        return level;
    }

    /**
     * Get the jet.
     *
     * @return A jet of Jet class.
     */
    public Jet getJet() {
        return level.getJet();
    }

    /**
     * Run the game.
     *
     * @param args Java command line arguments.
     */
    public static void main(String[] args) {
        new Game();
    }
}
