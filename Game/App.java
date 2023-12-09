package Game;

//import Game.StaticData.AllCharacters.Species;
//import Game.StaticData.AllCharacters.Pokemon;
import Game.StaticData.AllCharacters.CharacterType;
import Game.StaticData.AllCharacters.Player;
import Game.StaticData.Overworld.Building;
import Game.StaticData.WorldMap;
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
            this.player = new Player("name", CharacterType.PLAYER, 0, 0, 0, 0);
            this.map = new WorldMap(0, 0);
            Building b = new Building(640, 360, 0, 0,0,0,"Drawings\\ash_valley_diagonal_lab.png");
            map.getCurrentLocation().addBuilding(b);
            
            
        }

        @Override
        public void paint(Graphics g) {
            this.map.paint(g);
            if(player.getMovingUp()){
                player.moveUp(map);
            }
            if(player.getMovingLeft()){
                player.moveLeft(map);
            }
            if(player.getMovingDown()){
                player.moveDown(map);
            }
            if(player.getMovingRight()){
                player.moveRight(map);
            }

            player.paint(g);
            //this.ui.paint(g, this.gameState);
            this.mouseX = this.getMousePosition().getX();
            this.mouseY = this.getMousePosition().getY();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getX() <= 1270 && e.getX() >= 1170 && e.getY() <= 710 && e.getY() >= 690){
            }
               
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

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