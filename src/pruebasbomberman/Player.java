
package pruebasbomberman;

import java.util.LinkedList;
import javax.swing.JTable;


public class Player {
    
    private int lifes, posX, posY, posOriginalX, posOriginalY, bonus, actualPoints;
    private LinkedList<Integer> times = new LinkedList<>();
    private LinkedList<Integer> points = new LinkedList<>();
    private LinkedList<Bomb> bombs = new LinkedList<>();
    private JTable map;
    private final String name;
    
    public Player(String name, JTable map){
        this.name = name;
        this.map = map;
        this.lifes = 3;        
        this.bonus = 1;
        this.actualPoints = 0;
    }
    
    public void setPosition(int x, int y){
        this.posX = x;
        this.posY = y;
        this.posOriginalX = x;
        this.posOriginalY = y;
    }
    
    public void killingAnEnemy(){
        actualPoints =+ 100;
    }
    
    public void gettingABonus(){
        actualPoints += 50;
    }
    
    public String getActualPoints(){
        addPoints();
        return String.valueOf(this.actualPoints);        
    }
    
    public void addPoints(){
        this.points.addLast(this.actualPoints);
    }
    
    public void addTime(int time){
        this.times.addLast(time);
    }
    
    // True if the player have lifes
    public boolean CheckLifes(){
        if(this.lifes <= 0){
            return false;
        }else if(this.lifes > 0){
            return true;
        }else{
            return true;
        }
    }
    
    public int getLifes(){
        return this.lifes;
    }
    
    public String getName(){
        return this.name;
    }
    
    // Take Life
    public void LoseLife(){
        this.lifes -= 1;
    }
    
    
    /* Movement */
    public void Up(){
        if(posY == 0){
            System.out.println("Esta hasta arriba");
        }else{
            // Moving Up
            if(map.getValueAt(posY - 1, posX).equals("N")){
                map.setValueAt("J", posY - 1, posX);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("N", posY, posX);
                }
                posY--;
            // Getting a bonus
            }else if(map.getValueAt(posY - 1, posX).equals("B")){
                this.bonus++;
                map.setValueAt("J", posY - 1, posX);
                map.setValueAt("N", posY, posX);
                posY--;
            // Touching an Enemy
            }else if(map.getValueAt(posY - 1, posX).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY - 1, posX).equals("F")){
                this.actualPoints += 200;
            }
        }
    }
    
    public void Down(){
        if(posY == 11){
            System.out.println("Esta hasta abajo");
        }else{
            // Moving Up
            if(map.getValueAt(posY + 1, posX).equals("N")){
                map.setValueAt("J", posY + 1, posX);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("N", posY, posX);
                }
                posY++;
            // Getting a bonus
            }else if(map.getValueAt(posY + 1, posX).equals("B")){
                this.bonus++;
                map.setValueAt("J", posY + 1, posX);
                map.setValueAt("N", posY, posX);
                posY++;
            // Touching an Enemy
            }else if(map.getValueAt(posY + 1, posX).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY + 1, posX).equals("F")){
                this.actualPoints += 200;
            }
        }
    }
    
    public void Left(){
        if(posX == 0){
            System.out.println("Esta hasta la izquierda");
        }else{
            // Moving Up
            if(map.getValueAt(posY, posX - 1).equals("N")){
                map.setValueAt("J", posY, posX - 1);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("N", posY, posX);
                }
                posX--;
            // Getting a bonus
            }else if(map.getValueAt(posY, posX - 1).equals("B")){
                this.bonus++;
                map.setValueAt("J", posY, posX - 1);
                map.setValueAt("N", posY, posX);
                posX--;
            // Touching an Enemy
            }else if(map.getValueAt(posY, posX - 1).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY, posX - 1).equals("F")){
                this.actualPoints += 200;
            }
        }
    }
    
    public void Right(){
        if(posX == 11){
            System.out.println("Esta hasta la derecha");
        }else{
            // Moving Up
            if(map.getValueAt(posY, posX + 1).equals("N")){
                map.setValueAt("J", posY, posX + 1);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("N", posY, posX);
                }
                posX++;
            // Getting a bonus
            }else if(map.getValueAt(posY, posX + 1).equals("B")){
                this.bonus++;
                map.setValueAt("J", posY, posX + 1);
                map.setValueAt("N", posY, posX);
                posX++;
            // Touching an Enemy
            }else if(map.getValueAt(posY, posX + 1).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY, posX + 1).equals("F")){
                this.actualPoints += 200;
            }
        }
    }
    
    
    public void PutBomb(){
        
        Bomb bomb = new Bomb(map, posY, posX, this.bonus, this);
        this.bombs.add(bomb);
        bomb.start();
        
    }
}
