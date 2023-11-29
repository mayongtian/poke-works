package Game;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Color;

public class UI {
    private String gameState;


    public void setGameState(String gameState){
        this.gameState = gameState;
    }

    public String getGameState(){
        return this.gameState;
    }

    public void paint(Graphics g, String gameState){
        g.setColor(Color.BLUE);
        g.drawRect(0,0,150,150);
    }

    public UI(String gameState){
        this.gameState = gameState;
    }
}
