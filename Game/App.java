package Game;

//import Game.staticData.AllCharacters.Species;
//import Game.staticData.AllCharacters.Pokemon;
import Game.staticData.AllCharacters.CharacterType;
import Game.staticData.AllCharacters.Player;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.ListUI;

import java.util.Random;
//import java.io.File;
//import java.io.IOException;
import java.time.Instant;
//import java.awt.Image;
//import javax.imageio.ImageIO;
import java.awt.Color;
import java.time.Duration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class App extends JFrame {

    public static final Random random = new Random();
    
    public static void main(String[] args) throws Exception {
        App window = new App();
        window.run();
    }

    class Canvas extends JPanel implements ActionListener, MouseListener {
        UI ui;
        Player player;

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));
            this.addMouseListener(this);
            Listener l = new Listener();
            this.addKeyListener(l);
            this.ui = new UI("Overworld");
            this.player = new Player("name", CharacterType.PLAYER);
        }

        public void drawBackround(Graphics g){
            g.setColor(Color.GREEN);
            g.fillRect(0,0,1280,720);
        }

        @Override
        public void paint(Graphics g) {
            drawBackround(g);
            player.paint(g);
            this.ui.paint(g, this.ui.getGameState());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}


        @Override
        public void actionPerformed(ActionEvent e){

        }

        private class Listener extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {
        
                int key = e.getKeyCode() ;
                System.out.println(key);
        
                if (key == KeyEvent.VK_LEFT){

                }
        
                if (key == KeyEvent.VK_RIGHT) {
                }
        
                if (key == KeyEvent.VK_UP) {
                }
        
                if (key == KeyEvent.VK_DOWN) {
                }
            }
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