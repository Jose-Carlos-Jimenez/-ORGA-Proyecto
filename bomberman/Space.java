/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import javax.swing.JButton;

/**
 *
 * @author Isaac Maldonado
 */
public class Space {
    public JButton square;
    public String type;
    public boolean bonus;
    
    public Space(JButton square, String type,boolean bonus){
    this.square=square;
    this.type=type;
    this.bonus=bonus;
    
    }
    
}
