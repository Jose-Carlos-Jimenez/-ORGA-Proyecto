
package pruebasbomberman;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class Enemy extends Thread{
    
    JTable map;
    private String txt = "E";
    int posX, posY;
    boolean alive = true;
    Random dir = new Random();
    
    public Enemy(JTable map, int posX, int posY){
        this.map = map;
        this.posX = posX;
        this.posY = posY;
    }
    
    // Movimiento
    @Override
    public void run(){
        while(checkAlive()){
            int dir = this.dir.nextInt(4);
            System.out.println(dir);
            /* 
                0 UP
                1 DOWN
                2 RIGHT
                3 LEFT
            */
            
            if(dir == 0){
                if(posY != 0){
                    if(map.getValueAt(posY - 1, posX).equals("N")){
                        System.out.println("Arriba");
                        map.setValueAt("E", posY - 1, posX);
                        map.setValueAt("N", posY, posX);
                        posY--;
                    }                    
                }
            }else if(dir == 1){
                if(posY != 11){
                    if(map.getValueAt(posY + 1, posX).equals("N")){
                        System.out.println("Abajo");
                        map.setValueAt("E", posY + 1, posX);
                        map.setValueAt("N", posY, posX);
                        posY++;
                    }                    
                }
            }else if(dir == 2){
                if(posX != 11){
                    if(map.getValueAt(posY, posX + 1).equals("N")){
                        System.out.println("Derecha");
                        map.setValueAt("E", posY, posX + 1);
                        map.setValueAt("N", posY, posX);
                        posX++;
                    }                    
                }
            }else if(dir == 3){
                if(posX != 0){
                    if(map.getValueAt(posY, posX - 1).equals("N")){
                        System.out.println("Izquierda");
                        map.setValueAt("E", posY, posX - 1);
                        map.setValueAt("N", posY, posX);
                        posX--;
                    }                    
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean checkAlive(){
        return alive;
    }
    
    public void Die(){
        this.alive = false;
    }
    
}
