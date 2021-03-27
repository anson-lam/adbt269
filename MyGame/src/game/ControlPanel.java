package game;

import city.cs.engine.SoundClip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

public class ControlPanel {
    /**
     * The main panel.
     */
    private JPanel mainPanel;

    /**
     * The pause button.
     */
    private JButton pauseButton;

    /**
     * The resume button.
     */
    private JButton resumeButton;

    /**
     * The quit button.
     */
    private JButton quitButton;

    /**
     * The volume decrease button.
     */
    private JButton volumeDecreaseButton;

    /**
     * The volume increase button.
     */
    private JButton volumeIncreaseButton;

    /**
     * The mute button.
     */
    private JButton muteButton;

    /**
     * The unmute button.
     */
    private JButton unmuteButton;

    //private JButton restartButton;

    /**
     * The slow motion button, which can only be used when the game is paused.
     */
    private JButton slowMotionButton;

    /**
     * Functions of the control panel in which all buttons are located.
     *
     * @param level The current level..
     * @param gameMusic The background game music being played.
     */
    public ControlPanel(GameLevel level, SoundClip gameMusic) {
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMusic.pause();
                level.stop();
            }
        });

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.start();
                gameMusic.resume();
            }
        });

        volumeDecreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMusic.setVolume(0.5);
                HealthPoint.getHPSound().setVolume(0.5);
                Virus.getVirusSound().setVolume(0.5);
            }
        });

        volumeIncreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMusic.setVolume(1.5);
                HealthPoint.getHPSound().setVolume(1.5);
                Virus.getVirusSound().setVolume(1.5);
            }
        });

        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMusic.setVolume(0.0001);
                HealthPoint.getHPSound().setVolume(0.0001);
                Virus.getVirusSound().setVolume(0.0001);
            }
        });

        unmuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMusic.setVolume(1);
                HealthPoint.getHPSound().setVolume(1);
                Virus.getVirusSound().setVolume(1);
            }
        });

        /*
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        */

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        slowMotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.oneStep();
            }
        });
    }

    /**
     * Get the main panel.
     *
     * @return The main panel which is of JPanel type.
     */
    public JPanel getMainPanel() {
        return mainPanel;
    }
}