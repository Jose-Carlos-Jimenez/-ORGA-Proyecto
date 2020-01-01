
package pruebasbomberman;

import java.util.LinkedList;
import javax.swing.JTable;


public class Player {
    
    private int lifes, points, time, posX, posY, posOriginalX, posOriginalY, id;
    private JTable map;
    private String name, password;
    private LinkedList<Integer> timeList;
    private LinkedList<Integer> pointsList;
    
    
    public Player(String name, JTable map){
        this.name = name;
        this.map = map;
        this.lifes = 3;
        this.points = 0;
        this.time = 0;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.timeList = new LinkedList();
        this.pointsList = new LinkedList();        
    }         

    public LinkedList getTimeList() {
        return timeList;
    }

    public void setTimeList(LinkedList timeList) {
        this.timeList = timeList;
    }

    public LinkedList getPointsList() {
        return pointsList;
    }

    public void setPointsList(LinkedList pointsList) {
        this.pointsList = pointsList;
    }
        
    public void addTime(int time){
        this.timeList.add(time);
    }
    
    public void addPoint(int point){
        this.pointsList.add(point);
    }
    
    public void setPosition(int x, int y){
        this.posX = x;
        this.posY = y;
        this.posOriginalX = x;
        this.posOriginalY = y;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    
    public void setTime(int time){
        this.time = time;
    }
    
    // True if the player doesnt have lifes
    public boolean CheckLifes(){
        if(this.lifes == 0){
            return true;
        }else if(this.lifes > 0){
            return false;
        }else{
            return false;
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
                map.setValueAt("J", posY - 1, posX);
                map.setValueAt("N", posY, posX);
                posY--;
            // Touching an Enemy
            }else if(map.getValueAt(posY - 1, posX).equals("E")){
                
            // Next Level
            }else if(map.getValueAt(posY - 1, posX).equals("F")){
                
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
                map.setValueAt("J", posY + 1, posX);
                map.setValueAt("N", posY, posX);
                posY++;
            // Touching an Enemy
            }else if(map.getValueAt(posY + 1, posX).equals("E")){
                
            // Next Level
            }else if(map.getValueAt(posY + 1, posX).equals("F")){
                
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
                map.setValueAt("J", posY, posX - 1);
                map.setValueAt("N", posY, posX);
                posX--;
            // Touching an Enemy
            }else if(map.getValueAt(posY, posX - 1).equals("E")){
                
            // Next Level
            }else if(map.getValueAt(posY, posX - 1).equals("F")){
                
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
                map.setValueAt("J", posY, posX + 1);
                map.setValueAt("N", posY, posX);
                posX++;
            // Touching an Enemy
            }else if(map.getValueAt(posY, posX + 1).equals("E")){
                
            // Next Level
            }else if(map.getValueAt(posY, posX + 1).equals("F")){
                
            }
        }
    }
    
    public void PutBomb(){
        
        Bomb bomb = new Bomb(map, posY, posX);
        bomb.start();
        
    }
}
