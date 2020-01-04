
package pruebasbomberman;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pruebasbomberman.PruebasBomberman.playing;
import javax.swing.*;

public class ShowingLives extends Thread{
    // Agregar cronometro en este lugar
    private JLabel txt;
    private Player player;
    private JFrame principal;
    public static int time;
    
    public ShowingLives(JLabel txt, Player player, JFrame principal){
        this.txt = txt;
        this.player = player;
        this.principal = principal;
    }
    
    @Override
    public void run(){
        time = 0;
        while(player.CheckLifes()){
            this.txt.setText(String.valueOf(player.getLifes()));
            try {
                sleep(1000);
                time++;
            } catch (InterruptedException ex) {
                Logger.getLogger(ShowingLives.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!player.CheckLifes()){
            player.Lose();
            principal.hide();
            playing = false;
        }
        
    }
    
}