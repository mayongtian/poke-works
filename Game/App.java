package Game;

import Game.StaticData.Overworld.Building;
import Game.StaticData.WorldMap;
import Game.StaticData.Characters.CharacterType;
import Game.StaticData.Characters.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.management.DescriptorKey;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
//import java.io.File;
//import java.io.IOException;
import java.time.Instant;
//import java.awt.Image;
//import javax.imageio.ImageIO;
//import java.awt.Color;
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
        public UI ui;
        public Player player;
        public WorldMap map;
        public GameState gameState;
        public double mouseX;
        public double mouseY;

        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));
            this.addMouseListener(this);
            this.addKeyListener(this);
            this.ui = new UI();
            
            this.gameState = GameState.OVERWORLD;
            this.player = new Player("name", CharacterType.PLAYER, 0, 0, 0, 0, "Drawings\\player\\player_sprite_basic (1).png");
            this.map = new WorldMap();
        }

        @Override
        public void paint(Graphics g) {
            paintTest(g);
        }

        /**
         * our old drawing function before we decided rectangles were better
         */
        @Deprecated
        public void paintGame(Graphics g){
            this.map.paint(g);
            if(player.getMovingUp()){
                player.moveUp(map.getCurrentLocation());
            }
            if(player.getMovingLeft()){
                player.moveLeft(map.getCurrentLocation());
            }
            if(player.getMovingDown()){
                player.moveDown(map.getCurrentLocation());
            }
            if(player.getMovingRight()){
                player.moveRight(map.getCurrentLocation());
            }
            player.paint(g);
            //this.ui.paint(g, this.gameState);
            this.mouseX = this.getMousePosition().getX();
            this.mouseY = this.getMousePosition().getY();
        }

        /**
         * draws only the hitbox for
         * @param g the graphics duh
         */
        @Deprecated
        public void paintTest(Graphics g){
            this.map.paintTest(g);
            if(player.getMovingUp()){
                player.moveUp(map.getCurrentLocation());
            }
            if(player.getMovingLeft()){
                player.moveLeft(map.getCurrentLocation());
            }
            if(player.getMovingDown()){
                player.moveDown(map.getCurrentLocation());
            }
            if(player.getMovingRight()){
                player.moveRight(map.getCurrentLocation());
            }
            player.paintTest(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getX() <= 1270 && e.getX() >= 1170 && e.getY() <= 710 && e.getY() >= 690){
            }
               
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
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE && this.gameState == GameState.MENU){
                //this.gameState = GameState.OVERWORLD;
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
        int frames = 0;
        long totalTime = 0;
        long limiter = 1000;
        while (true) {
            Instant startTime = Instant.now();
            repaint();
            frames++;
            Instant endTime = Instant.now();
            long howLong = Duration.between(startTime, endTime).toMillis();
            try {
                Thread.sleep(limiter - howLong);
                totalTime+=limiter - howLong;
                if(totalTime >= 1000){
                    System.out.println(frames);
                    totalTime = 0;
                    frames = 0;
                }
            } catch(InterruptedException e) {
                System.out.println("thread was interrupted, but who cares?");
            } catch(IllegalArgumentException e) {
                System.out.println("application can't keep up with framerate");
            }
        }
    }
}