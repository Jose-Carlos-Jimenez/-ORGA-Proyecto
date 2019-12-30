
package pruebasbomberman;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class Enemy extends Thread{
    
    JTable map;
    private String txt = "E";
    int posX, posY;
    boolean alive = true;
    
    public Enemy(JTable map, int posX, int posY){
        this.map = map;
        this.posX = posX;
        this.posY = posY;
    }
    
    // Movimiento
    @Override
    public void run(){
        while(checkAlive()){
            //
            if(posX == 0){
                if(map.getValueAt(posY - 1, posX).equals("N")){
                    map.setValueAt("E", posY - 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY--;
                }else if(map.getValueAt(posY + 1, posX).equals("N")){
                    map.setValueAt("E", posY + 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY++;
                }else if(map.getValueAt(posY, posX + 1).equals("N")){
                    map.setValueAt("E", posY, posX + 1);
                    map.setValueAt("N", posY, posX);
                    posX++;
                }
            }
            //
            else if(posX == 11){
                if(map.getValueAt(posY - 1, posX).equals("N")){
                    map.setValueAt("E", posY - 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY--;
                }else if(map.getValueAt(posY + 1, posX).equals("N")){
                    map.setValueAt("E", posY + 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY++;
                }else if(map.getValueAt(posY, posX - 1).equals("N")){
                    map.setValueAt("E", posY, posX + 1);
                    map.setValueAt("N", posY, posX);
                    posX--;
                }
            }
            //
            else if(posY == 0){
                System.out.println(posX);
                System.out.println(posY);
                if(map.getValueAt(posY + 1, posX).equals("N")){
                    map.setValueAt("E", posY + 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY++;
                }else if(map.getValueAt(posY, posX + 1).equals("N")){
                    map.setValueAt("E", posY, posX + 1);
                    map.setValueAt("N", posY, posX);
                    posX++;
                }else if(map.getValueAt(posY, posX - 1).equals("N")){
                    map.setValueAt("E", posY, posX - 1);
                    map.setValueAt("N", posY, posX);
                    posX--;
                }
            }
            //
            else if(posY == 11){
                if(map.getValueAt(posY - 1, posX).equals("N")){
                    map.setValueAt("E", posY - 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY--;
                }else if(map.getValueAt(posY, posX + 1).equals("N")){
                    map.setValueAt("E", posY, posX + 1);
                    map.setValueAt("N", posY, posX);
                    posX++;
                }else if(map.getValueAt(posY, posX - 1).equals("N")){
                    map.setValueAt("E", posY, posX - 1);
                    map.setValueAt("N", posY, posX);
                    posX--;
                }
            }else{
                if(map.getValueAt(posY - 1, posX).equals("N")){
                    map.setValueAt("E", posY - 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY--;
                }else if(map.getValueAt(posY + 1, posX).equals("N")){
                    map.setValueAt("E", posY + 1, posX);
                    map.setValueAt("N", posY, posX);
                    posY++;
                }else if(map.getValueAt(posY, posX + 1).equals("N")){
                    map.setValueAt("E", posY, posX + 1);
                    map.setValueAt("N", posY, posX);
                    posX++;
                }else if(map.getValueAt(posY, posX - 1).equals("N")){
                    map.setValueAt("E", posY, posX - 1);
                    map.setValueAt("N", posY, posX);
                    posX--;
                }
            }
            try {
                sleep(3000);
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
