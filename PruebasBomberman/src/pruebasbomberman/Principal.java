
package pruebasbomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTable;
import static pruebasbomberman.PruebasBomberman.clevels;
import static pruebasbomberman.PruebasBomberman.levels;

class Listener implements KeyListener{
    
    private JTable mapa = new JTable();
    private Player player;
    public Listener(JTable mapa, Player p){
        this.mapa = mapa;
        this.player = p;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {                
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            
            System.out.println("Arriba");
            this.player.Up();
            
        }else if(code == KeyEvent.VK_S){
            
            System.out.println("Abajo");
            this.player.Down();
            
        }else if(code == KeyEvent.VK_A){
            
            System.out.println("Izquierda");
            this.player.Left();
            
        }else if(code == KeyEvent.VK_D){
            
            System.out.println("Derecha");
            this.player.Right();
        
        }else if(code == KeyEvent.VK_P){
            
            System.out.println("Pausa");
        
        }else if(code == KeyEvent.VK_O){
            
            System.out.println("Bomba");
            this.player.PutBomb();
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

public class Principal extends javax.swing.JFrame {

    private JPanel contentPane;
    
    public Player player;
    public int PosX, PosY;
    
    public Principal(String name) {                
        
        initComponents();        
        
        /* Player */
        this.player = new Player(name, this.matriz);
        
        /* Contenedor de todo */
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        contentPane.setFocusable(true);
        contentPane.add(matriz);
        
        /* KeyListener */
        Listener listener = new Listener(matriz, this.player);
        contentPane.addKeyListener(listener);
        
        /* Fill the levels */
        int x = 0, y = 0, cEnemies = 0;
        for(int i = 0; i<12; i++){
            matriz.setValueAt(levels[clevels][y][x], y, x);
            switch (levels[clevels][y][x]) {
                case "J":
                    this.player.setPosition(x, y);
                    break;
                case "E":
                    Enemy enemy = new Enemy(x, y);
                    enemy.start();
                    System.out.println("La posicion del enemigo " + cEnemies + " es " + y + " " + x);
                    cEnemies++;
                    break;
                default:
                    break;
            }
            x++;
            if(i==11 && y != 11){
                i = -1;
                x = 0;
                y++;
            }else{}
        }
    }

    Principal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        matriz = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        matriz.setEnabled(false);
        matriz.setFocusable(false);
        matriz.setRowHeight(40);
        jScrollPane1.setViewportView(matriz);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable matriz;
    // End of variables declaration//GEN-END:variables
    }
