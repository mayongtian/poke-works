package Game;

import Game.staticData.AllCharacters.Species;
import Game.staticData.AllCharacters.Pokemon;
import Game.staticData.AllCharacters.Player;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.time.Duration;

public class App extends JFrame {

    public static final Random random = new Random();
    
    public static void main(String[] args) throws Exception {
        App window = new App();
        window.run();
    }

    class Canvas extends JPanel {
        UI ui;
        Player player;

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));
            this.ui = new UI("Overworld");
        }

        public void drawBackround(Graphics g){
            g.setColor(Color.WHITE);
            g.drawRect(0,0,1280,720);
            g.fillRect(0,0,1280,720);
        }

        @Override
        public void paint(Graphics g) {
            try{
                drawBackround(g);
                File file = new File("Drawings/sinistea.jpg"); //load image into a File object
                Image image = ImageIO.read(file); //create Image object from File object
                Pokemon p = new Pokemon(new Species(854, "sinistea", image, 0, 0, 0, 0, 0, 0), 0, true);
                p.paint(g, p.getSprite(), this.getWidth()/2 - 125, this.getHeight()/2 - 125);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            this.ui.paint(g, this.ui.getGameState());
        }  
    }
    

    private App() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }

    public void run() {
        while (true) {
            Instant startTime = Instant.now();
            repaint();
            Instant endTime = Instant.now();
            long howLong = Duration.between(startTime, endTime).toMillis();
            try {
            Thread.sleep(33l - howLong);
            } catch(InterruptedException e) {
            System.out.println("thread was interrupted, but who cares?");
            } catch(IllegalArgumentException e) {
            System.out.println("application can't keep up with framerate");
            }
        }
    }
}