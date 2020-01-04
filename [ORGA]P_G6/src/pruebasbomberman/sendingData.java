
package pruebasbomberman;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static pruebasbomberman.PruebasBomberman.playing;

public class sendingData extends Thread{
    
    private JTable map;
    private pPort lpt;
    
    public sendingData(JTable map){
        this.map = map;
        this.lpt = new pPort();
        lpt.setAllDataBits((short)0);
    }
    
    @Override
    public void run(){
        int x = 0;
        //while(playing){
            
            for(int i = 0; i < 12; i++){
                if(map.getValueAt(11 - i, x).equals("")){
                    this.lpt.setPin((short)2, (short)0);                    
                }else{
                    this.lpt.setPin((short)2, (short)1);
                }
                if(i == 11 && x != 11){
                    i = -1;
                    x++;
                }else if(i == 11 && x == 11){
                    i = -1;
                    x = 0;
                }
            }  
        //}
        if(!playing){
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(sendingData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
