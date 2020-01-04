
package pruebasbomberman;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static pruebasbomberman.PruebasBomberman.playing;


public class Enemy extends Thread{
    
    private JTable map;
    private String txt = "E";
    private int posX, posY;
    private boolean alive = true;
    private Random dir = new Random();
    private Player player;
    
    public Enemy(JTable map, int posX, int posY, Player player){
        this.map = map;
        this.posX = posX;
        this.posY = posY;
        this.player = player;
    }
    
    // Movement
    @Override
    public void run(){
        if(!map.getValueAt(posY, posX).equals("E") || !playing){
            this.Die();
        }
        while(checkAlive()){
            int ran = this.dir.nextInt(4);
            /* 
                0 UP
                1 DOWN
                2 RIGHT
                3 LEFT
            */
            switch (ran) {
                case 0:
                    if(posY != 0){
                        switch (map.getValueAt(posY - 1, posX).toString()){
                            case "":
                                map.setValueAt("E", posY - 1, posX);
                                map.setValueAt("", posY, posX);
                                posY--;
                                break;
                            case "J":
                                this.player.LoseLife();
                                break;
                            case "O":
                                this.player.killingAnEnemy();
                                Die();
                                break;
                            default:
                                break;
                        }
                    }   
                    break;
                case 1:
                    if(posY != 11){
                        switch (map.getValueAt(posY + 1, posX).toString()){
                            case "":
                                map.setValueAt("E", posY + 1, posX);
                                map.setValueAt("", posY, posX);
                                posY++;
                                break;
                            case "J":
                                this.player.LoseLife();
                                break;
                            case "O":
                                this.player.killingAnEnemy();
                                Die();
                                break;
                            default:
                                break;
                        }
                    }   
                    break;
                case 2:
                    if(posX != 11){
                        switch (map.getValueAt(posY, posX + 1).toString()){
                            case "":
                                map.setValueAt("E", posY, posX + 1);
                                map.setValueAt("", posY, posX);
                                posX++;
                                break;
                            case "J":
                                this.player.LoseLife();
                                break;
                            case "O":
                                this.player.killingAnEnemy();
                                Die();
                                break;
                            default:
                                break;
                        }
                    }   
                    break;
                case 3:
                    if(posX != 0){
                        switch (map.getValueAt(posY, posX - 1).toString()){
                            case "":
                                map.setValueAt("E", posY, posX - 1);
                                map.setValueAt("", posY, posX);
                                posX--;
                                break;
                            case "J":
                                this.player.LoseLife();
                                break;
                            case "O":
                                this.player.killingAnEnemy();
                                Die();
                                break;
                            default:
                                break;
                        }
                    }   
                    break;
                default:
                    break;
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Check if enemy is Alive
    public boolean checkAlive(){
        return alive;
    }
    
    // Killing an enemy
    public void Die(){
        this.alive = false;
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
