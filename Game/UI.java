package Game;

import java.awt.Graphics;
import java.awt.Color;

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
        g.drawRect(0,0,300,300);
        //g.fillRect(0,0,300,300);
    }

    public UI(String gameState){
        this.gameState = gameState;
    }
}
