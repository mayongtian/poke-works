package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

public class App extends JFrame {

    public static final Random random = new Random();
    
    public static void main(String[] args) throws Exception {
        App window = new App();
        window.run();
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(1280, 720));
        }

        @Override
        public void paint(Graphics g) {
            try{
                File file = new File("Drawings/sinistea.jpg"); //load image into a File object
                Image image = ImageIO.read(file); //create Image object from File object
                g.drawImage(image, 250, 350, rootPane); //draw Image object on screen at coordinates (250,350)
            } catch(IOException e){
                e.printStackTrace();
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
            repaint();
        }
    }
}