package pruebasbomberman;

import static java.lang.Thread.sleep;
import javax.swing.JTable;

public class Bomb extends Thread{
    
    private JTable map;
    private int posBombY, posBombX, range;
    private Player player;
    
    public Bomb(JTable map, int posBombY, int posBombX, int range, Player player){
        this.map = map;
        this.posBombY = posBombY;
        this.posBombX = posBombX;
        this.player = player;
        this.range = range;
    }
    
    @Override
    public void run(){
        int r = this.range;
        map.setValueAt("M", posBombY, posBombX);
        
        try{sleep(2000);}catch(Exception e){}
        
        // Codigo de explosión "O"
        map.setValueAt("O", posBombY, posBombX);
        
        // Up
        try{
            while(r > 0){
                if(map.getValueAt(posBombY - r, posBombX).equals("J")){
                    this.player.LoseLife();
                }else if(map.getValueAt(posBombY - r, posBombX).equals("E")){
                     // Muerte de enemigo
                }else{
                    map.setValueAt("O", posBombY - r, posBombX);
                }
                r--;
            }
        }catch(Exception e){}
        r = this.range;
        // Down
        try{
            while(r > 0){
                if(map.getValueAt(posBombY + r, posBombX).equals("J")){
                    this.player.LoseLife();
                }else if(map.getValueAt(posBombY + r, posBombX).equals("E")){
                     // Muerte de enemigo
                }else{
                    map.setValueAt("O", posBombY + r, posBombX);
                }
                r--;
            }
        }catch(Exception e){}
        r = this.range;
        // Right
        try{
            while(r > 0){
                if(map.getValueAt(posBombY, posBombX + r).equals("J")){
                    this.player.LoseLife();
                }else if(map.getValueAt(posBombY, posBombX + r).equals("E")){
                     // Muerte de enemigo
                }else{
                    map.setValueAt("O", posBombY, posBombX + r);
                }
                r--;
            }
        }catch(Exception e){}
        r = this.range;
        // Left
        try{
            while(r > 0){
                if(map.getValueAt(posBombY, posBombX - r).equals("J")){
                    this.player.LoseLife();
                }else if(map.getValueAt(posBombY, posBombX - r).equals("E")){
                     // Muerte de enemigo
                }else{
                    map.setValueAt("O", posBombY, posBombX - r);
                }
                r--;
            }
        }catch(Exception e){}
        
        try{sleep(2000);}catch(Exception e){}
        r = this.range;
        // Regreso a N de lo que no es jugador o bonus
        map.setValueAt("N", posBombY, posBombX);
        
        try{
            while(r > 0){
                map.setValueAt("N", posBombY - r, posBombX);
                r--;
            }
        }catch(Exception e){}
        r = this.range;
        // Down
        try{
            while(r > 0){
                map.setValueAt("N", posBombY + r, posBombX);
                r--;
            }
        }catch(Exception e){}
        r = this.range;
        // Right
        try{
            while(r > 0){
                map.setValueAt("N", posBombY, posBombX + r);
                r--;
            }
        }catch(Exception e){}
        r = this.range;
        // Left
        try{
            while(r > 0){
                map.setValueAt("N", posBombY, posBombX - r);
                r--;
            }
        }catch(Exception e){}
    }
    
}
