
package pruebasbomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static pruebasbomberman.PruebasBomberman.clevels;
import static pruebasbomberman.PruebasBomberman.levels;

class Listener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("El codigo de la tecla es: " + e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("El codigo de la tecla es: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("El codigo de la tecla es: " + e.getKeyCode());
    }

}

public class Principal extends javax.swing.JFrame {

    private String name;
    public int PosX, PosY;
    
    public int[]PosXEnemies = new int[8];
    public int[] PosYEnemies = new int[8];
    
    public Principal(String name) {        
        
        /* KeyListener */
        Listener listener = new Listener();
        addKeyListener(listener);
        
        initComponents();        
        
        /* Player Name */
        this.name = name;
        
        /* Fill the levels */
        int x = 0, y = 0, cEnemies = 0;
        for(int i = 0; i<12; i++){
            matriz.setValueAt(levels[clevels][y][x], y, x);
            switch (levels[clevels][y][x]) {
                case "J":
                    this.PosX = x;
                    this.PosY = y;
                    System.out.println("La posicion del Jugador es: " + this.PosY + " " + this.PosX);
                    break;
                case "E":
                    PosXEnemies[cEnemies] = x;
                    PosYEnemies[cEnemies] = y;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        matriz = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Pasar Nivel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        matriz.setRowHeight(40);
        jScrollPane1.setViewportView(matriz);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 490, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clevels += 1;
        RefreshLevels();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Movement(){
        
    }
    
    private void RefreshLevels(){
        int x = 0, y = 0;
        for(int i = 0; i<12; i++){
            matriz.setValueAt(levels[clevels][y][x], y, x);
            
            switch (levels[clevels][y][x]) {
                case "L":
                    break;
                case "J":
                    this.PosX = x;
                    this.PosY = y;
                    System.out.println("La posicion del Jugador es: " + this.PosY + " " + this.PosX);
                    break;
                case "B":
                    break;
                case "E":
                    break;
                case "F":
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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable matriz;
    // End of variables declaration//GEN-END:variables
}
