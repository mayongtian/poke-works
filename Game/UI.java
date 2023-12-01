package Game;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Color;

public class UI {
    public boolean optionsHovered;

    public void paint(Graphics g, GameState gameState){
        if(gameState == GameState.OVERWORLD){
            if(optionsHovered){
            g.setColor(Color.GRAY);
        }
        else{
            g.setColor(Color.DARK_GRAY);
        }
        g.fillRect(1170, 690, 100, 20);
        g.setColor(Color.BLACK);
        g.drawRect(1170, 690, 100, 20);
        g.setColor(Color.WHITE);
        g.drawString("Options", 1197, 705);
        } 
    }

    public UI(){
    }
}
