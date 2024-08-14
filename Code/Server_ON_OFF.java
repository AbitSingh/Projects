
import java.awt.Image;
import javax.swing.ImageIcon;


public class Server_ON_OFF extends javax.swing.JFrame 
{

    myServer obj; 
     
    public Server_ON_OFF() 
    {
       
    initComponents();
    setSize(505, 499);      //BUUTON BANNE KAI BAAD HI SIZE SET HOGA
                                       //BANNE SAI PEHLE SIZE SET KAR DIYA TO CALL NAHI HOGA
        stopbt.setEnabled(false);
        ImageIcon ic = new ImageIcon("src/Downloaded_photos/gradient.jpg");                        
        Image im = ic.getImage().getScaledInstance(server_background.getWidth(), server_background.getHeight(),Image.SCALE_SMOOTH);
        server_background.setIcon(new ImageIcon(im));  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startbt = new javax.swing.JButton();
        stopbt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        server_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        startbt.setBackground(new java.awt.Color(0, 153, 255));
        startbt.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        startbt.setForeground(new java.awt.Color(255, 255, 255));
        startbt.setText("Start Server ");
        startbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startbtActionPerformed(evt);
            }
        });
        getContentPane().add(startbt);
        startbt.setBounds(70, 70, 152, 82);

        stopbt.setBackground(new java.awt.Color(0, 153, 255));
        stopbt.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        stopbt.setForeground(new java.awt.Color(255, 255, 255));
        stopbt.setText("Stop Server");
        stopbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopbtActionPerformed(evt);
            }
        });
        getContentPane().add(stopbt);
        stopbt.setBounds(280, 70, 152, 81);

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Launch VOD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 230, 230, 70);
        getContentPane().add(server_background);
        server_background.setBounds(0, 0, 510, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startbtActionPerformed
     // AB HUM CHAHTE HAI ES BUTTON KAI CLICK PAI SERVER ON JAYE, SERVER ON KARNE KA CODE TO myServer CLASS MAI LIKHA HUA HAI,
     //TO US CLASS KO YAHA PAR CALL KARLO ESE :- US CLASS KA SABSE UPAR OBJECT BANAO,
     // PHIR JAHA CHAHIYE VAHA USKO MEMORY DEKE CALL KARLO, 
     // BUS HUMNE myServer CLASS KA OBJECT HI BANA KAI RUN KARNA HAI, VO CLASS YAHA CALL HO JAYEGI;
     // obj = new myServer();  
     //humne parameter vala constructor pass kiya  tha yaha pai bhi vohi parameter pass karo;
        
        
        try
        {
            obj = new myServer(9000);
            // AB AGAR BAAR- BAAR START SERVER BUTTON CLICK KARTE RAHENGE TO PORT NUMBER KHARAB HO JAYEGA,
            // SO EK BAAR ON KARNE PAI JAB TAK STOP NAHI KARENGE SERVER KO TAB TAK START SERVER VALA BUTTON OF RAHE;
            startbt.setEnabled(false);
            stopbt.setEnabled(true);
            
        } 
        catch(Exception e)
        {
        
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_startbtActionPerformed

    private void stopbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopbtActionPerformed
    // stop KAI CLICK PAI SERVER BAND HONA CHAIHE SO,
    // us call hui class class ka object + dot shutdown kar dena use class band ho jayegi,
    // aur saath mai us class mai likha server on ka code bhi band ho jayega;
    obj.shutdown();
    startbt.setEnabled(true);
    stopbt.setEnabled(false);
    
    }//GEN-LAST:event_stopbtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        welcome obj = new welcome();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
         
    /*
     * @param args the command line arguments
     */
    public static void main(String argsa[]) {
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
            java.util.logging.Logger.getLogger(Server_ON_OFF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_ON_OFF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_ON_OFF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_ON_OFF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_ON_OFF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel server_background;
    private javax.swing.JButton startbt;
    private javax.swing.JButton stopbt;
    // End of variables declaration//GEN-END:variables
}
