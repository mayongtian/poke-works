package Game;

//import Game.staticData.AllCharacters.Species;
//import Game.staticData.AllCharacters.Pokemon;
import Game.staticData.AllCharacters.CharacterType;
import Game.staticData.AllCharacters.Player;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

public class App extends JFrame {

    public static final Random random = new Random();
    
    public static void main(String[] args) throws Exception {
        App window = new App();
        window.run();
    }

    class Canvas extends JPanel implements KeyListener, MouseListener {
        UI ui;
        Player player;

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));
            this.addMouseListener(this);
            this.addKeyListener(this);
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
            if(player.getMovingUp()){
                if(player.getOverworldY() < -125){
                    player.setOverworldY(595);
                }
                player.moveUp();
            }
            if(player.getMovingLeft()){
                if(player.getOverworldX() < -125){
                    player.setOverworldX(1155);
                }
                player.moveLeft();
            }
            if(player.getMovingDown()){
                if(player.getOverworldY() > 595){
                    player.setOverworldY(-125);
                }
                player.moveDown();
            }
            if(player.getMovingRight()){
                if(player.getOverworldX() > 1155){
                    player.setOverworldX(-125);
                }
                player.moveRight();
            }
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
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_W){
                player.setMovingUp(true);
            }
            if(e.getKeyCode() == KeyEvent.VK_A){
                player.setMovingLeft(true);
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                player.setMovingDown(true);
            }
            if(e.getKeyCode() == KeyEvent.VK_D){
                player.setMovingRight(true);
            }
        }

        @Override
        public void keyTyped(KeyEvent e){

        }

        @Override
        public void keyReleased(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_W){
                player.setMovingUp(false);
            }
            if(e.getKeyCode() == KeyEvent.VK_A){
                player.setMovingLeft(false);
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                player.setMovingDown(false);
            }
            if(e.getKeyCode() == KeyEvent.VK_D){
                player.setMovingRight(false);
            }
        }
    }
    

    private App() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        
        this.pack();
        this.setVisible(true);
        this.getContentPane().setFocusable(true);
        this.getContentPane().requestFocus();
    }

    public void run() {
        while (true) {
            Instant startTime = Instant.now();
            repaint();
            Instant endTime = Instant.now();
            long howLong = Duration.between(startTime, endTime).toMillis();
            try {
            Thread.sleep(17l - howLong);
            } catch(InterruptedException e) {
            System.out.println("thread was interrupted, but who cares?");
            } catch(IllegalArgumentException e) {
            System.out.println("application can't keep up with framerate");
            }
        }
    }
}