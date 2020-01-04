
package pruebasbomberman;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import static pruebasbomberman.PruebasBomberman.playing;
import static pruebasbomberman.ShowingLives.time;


public class Player {
    
    private int lifes, posX, posY, posOriginalX, posOriginalY, bonus, actualPoints;
    private LinkedList<Integer> times = new LinkedList<>();
    private LinkedList<Integer> points = new LinkedList<>();
    private LinkedList<Bomb> bombs = new LinkedList<>();
    private JTable map;
    private JFrame principal;
    private final String name;
    private String password;
    private LinkedList<Integer> timeList;
    private LinkedList<Integer> pointsList;
    private boolean registro;
    
    public Player(String name, JTable map, JFrame frame){
        this.name = name;
        this.map = map;
        this.lifes = 3;        
        this.bonus = 1;
        this.actualPoints = 0;
        this.principal = frame;
    }
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistro() {
        return registro;
    }

    public void setRegistro(boolean registro) {
        this.registro = registro;
    }

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        this.timeList = new LinkedList();
        this.pointsList = new LinkedList();
        this.registro = false;
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
            if(map.getValueAt(posY - 1, posX).equals("")){
                map.setValueAt("J", posY - 1, posX);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("", posY, posX);
                }
                posY--;
            // Getting a bonus
            }else if(map.getValueAt(posY - 1, posX).equals("B")){
                this.gettingABonus();
                this.bonus++;
                map.setValueAt("J", posY - 1, posX);
                map.setValueAt("", posY, posX);
                posY--;
            // Touching an Enemy
            }else if(map.getValueAt(posY - 1, posX).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY - 1, posX).equals("F")){
                this.actualPoints += 200;
                Win();
            }else if(map.getValueAt(posY - 1, posX).equals("O")){
                this.LoseLife();
            }
        }
    }
    
    public void Down(){
        if(posY == 11){
            System.out.println("Esta hasta abajo");
        }else{
            // Moving Up
            if(map.getValueAt(posY + 1, posX).equals("")){
                map.setValueAt("J", posY + 1, posX);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("", posY, posX);
                }
                posY++;
            // Getting a bonus
            }else if(map.getValueAt(posY + 1, posX).equals("B")){
                this.gettingABonus();
                this.bonus++;
                map.setValueAt("J", posY + 1, posX);
                map.setValueAt("", posY, posX);
                posY++;
            // Touching an Enemy
            }else if(map.getValueAt(posY + 1, posX).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY + 1, posX).equals("F")){
                this.actualPoints += 200;
                Win();
            }else if(map.getValueAt(posY + 1, posX).equals("O")){
                this.LoseLife();
            }
        }
    }
    
    public void Left(){
        if(posX == 0){
            System.out.println("Esta hasta la izquierda");
        }else{
            // Moving Up
            if(map.getValueAt(posY, posX - 1).equals("")){
                map.setValueAt("J", posY, posX - 1);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("", posY, posX);
                }
                posX--;
            // Getting a bonus
            }else if(map.getValueAt(posY, posX - 1).equals("B")){
                this.gettingABonus();
                this.bonus++;
                map.setValueAt("J", posY, posX - 1);
                map.setValueAt("", posY, posX);
                posX--;
            // Touching an Enemy
            }else if(map.getValueAt(posY, posX - 1).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY, posX - 1).equals("F")){
                this.actualPoints += 200;
                Win();
            }else if(map.getValueAt(posY, posX - 1).equals("O")){
                this.LoseLife();
            }
        }
    }
    
    public void Right(){
        if(posX == 11){
            System.out.println("Esta hasta la derecha");
        }else{
            // Moving Up
            if(map.getValueAt(posY, posX + 1).equals("")){
                map.setValueAt("J", posY, posX + 1);
                if(map.getValueAt(posY, posX) != "M"){
                    map.setValueAt("", posY, posX);
                }
                posX++;
            // Getting a bonus
            }else if(map.getValueAt(posY, posX + 1).equals("B")){
                this.gettingABonus();
                this.bonus++;
                map.setValueAt("J", posY, posX + 1);
                map.setValueAt("", posY, posX);
                posX++;
            // Touching an Enemy
            }else if(map.getValueAt(posY, posX + 1).equals("E")){
                this.LoseLife();
            // End the game
            }else if(map.getValueAt(posY, posX + 1).equals("F")){
                this.actualPoints += 200;
                Win();
            }else if(map.getValueAt(posY, posX + 1).equals("O")){
                this.LoseLife();
            }
        }
    }
    
    public void Win(){
        playing = false;
        this.principal.hide();
        FinalJFrame("Felicidades Ganaste!!!");
        
    }
    
    public void Lose(){
        playing = false;
        FinalJFrame("Perdiste :c F");
    }
    
    public void FinalJFrame(String finalTitle){
        JFrame finalFrame = new JFrame();
        finalFrame.setSize(300, 300);
        finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finalFrame.setLocationRelativeTo(null);
        
        Container cp = finalFrame.getContentPane();
        GridLayout gl = new GridLayout(5, 1);
        gl.setHgap(5); gl.setVgap(5);
        cp.setLayout(gl);
        
        JLabel title = new JLabel("Se acabo el juego, " + finalTitle);
        
        JLabel name = new JLabel("Nombre: " + this.getName());
        JLabel points = new JLabel("Puntos: " + this.getActualPoints());
        JLabel Jtime = new JLabel("Tiempo: " + time);
        this.addTime(time);
        
        JButton accept = new JButton("Regresar a menu");
        accept.addActionListener(new actionListener(finalFrame));
        
        cp.add(title);
        cp.add(name);
        cp.add(points);
        cp.add(Jtime);
        cp.add(accept);
        
        finalFrame.show();
        
    }
    
    public void PutBomb(){
        
        Bomb bomb = new Bomb(map, posY, posX, this.bonus, this);
        this.bombs.add(bomb);
        bomb.start();
        
    }
}

class actionListener implements ActionListener{
    
    JFrame frame;
    
    public actionListener(JFrame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        this.frame.hide();
        Menu menu = new Menu();
        menu.show();
    }
    
}