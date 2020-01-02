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
                }else if(map.getValueAt(posBombY - 1, posBombX).equals("L")){
                    map.setValueAt("O", posBombY - 1, posBombX);
                    r = 0;
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
                }else if(map.getValueAt(posBombY + 1, posBombX).equals("L")){
                    map.setValueAt("O", posBombY + 1, posBombX);
                    r = 0;
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
                }else if(map.getValueAt(posBombY, posBombX + 1).equals("L")){
                    map.setValueAt("O", posBombY, posBombX + 1);
                    r = 0;
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
                }else if(map.getValueAt(posBombY, posBombX - 1).equals("L")){
                    map.setValueAt("O", posBombY, posBombX - 1);
                    r = 0;
                }else{
                    map.setValueAt("O", posBombY, posBombX - r);
                }
                r--;
            }
        }catch(Exception e){}
        
        try{sleep(2000);}catch(Exception e){}
        r = this.range;
        // Regreso a N de lo que no es jugador o bonus
        map.setValueAt("", posBombY, posBombX);
        
        
        while(r > 0){
            try{
                if(map.getValueAt(posBombY - r, posBombX).equals("O")){                    
                    map.setValueAt("", posBombY - r, posBombX);                    
                }
            }catch(Exception e){}
            r--;
        }        
        r = this.range;
        // Down
        while(r > 0){
            try{
                if(map.getValueAt(posBombY + r, posBombX).equals("O")){                    
                    map.setValueAt("", posBombY + r, posBombX);                    
                }
            }catch(Exception e){}
            r--;
        }        
        r = this.range;
        // Right
        while(r > 0){
            try{
                if(map.getValueAt(posBombY, posBombX + r).equals("O")){                    
                    map.setValueAt("", posBombY, posBombX + r);                    
                }
            }catch(Exception e){}
            r--;
        }        
        r = this.range;
        // Left
        while(r > 0){
            try{
                if(map.getValueAt(posBombY, posBombX - r).equals("O")){                    
                    map.setValueAt("", posBombY, posBombX - r);                    
                }
            }catch(Exception e){}
            r--;
        }        
    }
    
}
