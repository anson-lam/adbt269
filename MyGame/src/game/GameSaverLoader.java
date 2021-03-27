package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {
    /**
     * Save the state of the world or level.
     *
     * @param level The current level.
     * @param fileName The file name to be saved as.
     */
    public static void save(GameLevel level, String fileName) throws IOException {
        boolean append = false;
        FileWriter writer = null;

        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "\n");

            //save static bodies
            for (StaticBody body : level.getStaticBodies()) {
                //no need to save static bodies
            }

            //save dynamic bodies
            for (DynamicBody body : level.getDynamicBodies()) {
                //save the jet, health point, and virus
                if (body instanceof Jet) {
                    writer.write("Jet," +
                            body.getPosition().x + "," +
                            body.getPosition().y + "," +
                            ((Jet) body).getScore() + "," +
                            ((Jet) body).getLife() + "\n");
                } else if (body instanceof HealthPoint) {
                    writer.write("HealthPoint," +
                            body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                } else if (body instanceof Virus) {
                    writer.write("Virus," +
                            body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
            }

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Load the state of the world or level.
     *
     * @param game The game to be run.
     * @param fileName The file name saved before.
     */
    public static GameLevel load(Game game, String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;

        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            GameLevel level = null;
            if (line.equals("Level1")) {
                level = new Level1(game);
            } else if (line.equals("Level2")) {
                level = new Level2(game);
            } else if (line.equals("Level3")) {
                level = new Level3(game);
            }

            line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(",");

                if (tokens[0].equals("Jet")) {
                    Jet j = new Jet(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    j.setPosition(new Vec2(x, y));
                    int score = Integer.parseInt(tokens[3]);
                    j.setScore(score);
                    int life = Integer.parseInt(tokens[4]);
                    j.setLife(life);

                    level.setJet(j);

                    //encounters of black hole and floating black hole
                    BlackHoleEncounter encounter1 = new BlackHoleEncounter(level, game);
                    j.addCollisionListener(encounter1);
                    BlackHoleFloatingEncounter encounter2 = new BlackHoleFloatingEncounter(level, game);
                    j.addCollisionListener(encounter2);

                    //jet's collision listener of infection
                    InfectedWithVirus infected = new InfectedWithVirus(j);
                    j.addCollisionListener(infected);

                    //jet's collision listener of collection
                    CollectHealthPoint collect = new CollectHealthPoint(j);
                    j.addCollisionListener(collect);

                } else if (tokens[0].equals("HealthPoint")) {
                    HealthPoint hp = new HealthPoint(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    hp.setPosition(new Vec2(x, y));

                } else if (tokens[0].equals("Virus")) {
                    Virus v = new Virus(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    v.setPosition(new Vec2(x, y));
                }

                line = reader.readLine();
            }

            // NOT CORRECT!! life isn't updated!!!
            //game.getLevel().getJet().setScore(score);
            //game.getLevel().getJet().setLife(life);

            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
