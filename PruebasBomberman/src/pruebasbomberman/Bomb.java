package pruebasbomberman;

import static java.lang.Thread.sleep;
import javax.swing.JTable;

public class Bomb extends Thread{
    
    private JTable map;
    private int posBombY, posBombX;
    
    public Bomb(JTable map, int posBombY, int posBombX){
        this.map = map;
        this.posBombY = posBombY;
        this.posBombX = posBombX;
    }
    
    @Override
    public void run(){
        try{
            map.setValueAt("M", posBombY, posBombX);
            sleep(2000);
            map.setValueAt("N", posBombY, posBombX);
        }catch(Exception e){
            
        }
    }
    
}
