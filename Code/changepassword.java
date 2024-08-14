
//import javax.swing.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class changepassword extends javax.swing.JFrame {

  
    public changepassword(String email) {
        
        initComponents();
        setSize(650,650);
        currentemail.setText(email);   // currentemail ki jagah agar email likh diya, to yeah upar vali email hi samjega aur error dega;
        currentemail.setEditable(false);
    
        
          ImageIcon ic = new ImageIcon("src/Downloaded_photos/signup1.jpg");       // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;
        Image im = ic.getImage().getScaledInstance(changepassword_background.getWidth(),changepassword_background.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
        changepassword_background.setIcon(new ImageIcon(im));
        
        
    }

   //you can create a function in the changepassword class and pass the email as an argument to that function.
   // forgotpassword class, call the setEmail function to pass the email to the changepassword frame:
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        save_changes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currentemail = new javax.swing.JTextField();
        newpassword = new javax.swing.JPasswordField();
        reenterpassword = new javax.swing.JPasswordField();
        changepassword_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Change Your password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 0, 410, 60);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter new password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 160, 220, 37);

        save_changes.setBackground(new java.awt.Color(255, 153, 0));
        save_changes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        save_changes.setForeground(new java.awt.Color(255, 255, 255));
        save_changes.setText("Save changes");
        save_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_changesActionPerformed(evt);
            }
        });
        getContentPane().add(save_changes);
        save_changes.setBounds(240, 310, 170, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("We'll ask for this password whenever you Log-in ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 80, 381, 26);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Re-enter new password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 230, 270, 29);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("password must be at least 4 characters");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 190, 250, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Secure password tips:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 390, 260, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("• Do not use the same password you have used with us previously. ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 450, 460, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("• Use at least 8 characters, a combination of numbers and letters is best. ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 420, 500, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("• Do not use dictionary words, your name, e-mail address, mobile phone ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 480, 500, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("number or other personal information that can be easily obtained. ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 500, 470, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("• Do not use the same password for multiple online accounts.");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(60, 530, 430, 20);

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Current Email ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 100, 180, 40);

        currentemail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        currentemail.setForeground(new java.awt.Color(51, 51, 51));
        currentemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentemailActionPerformed(evt);
            }
        });
        getContentPane().add(currentemail);
        currentemail.setBounds(360, 110, 260, 40);

        newpassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        newpassword.setForeground(new java.awt.Color(51, 51, 51));
        newpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(newpassword);
        newpassword.setBounds(360, 170, 260, 40);

        reenterpassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        reenterpassword.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(reenterpassword);
        reenterpassword.setBounds(360, 230, 260, 40);
        getContentPane().add(changepassword_background);
        changepassword_background.setBounds(0, 0, 670, 1110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_changesActionPerformed
        String new_password = newpassword.getText();
        String re_enter_password= reenterpassword.getText();
        String user_email= currentemail.getText(); // same variable mai store kiya to error
        
        if(new_password.equals("")|| re_enter_password.equals("")) 
        {
         JOptionPane.showMessageDialog(rootPane, "Please enter your password");
        }
        
        else if(!new_password.equals(re_enter_password))
        {
        JOptionPane.showMessageDialog(rootPane,"Must match your new password");
        }
        else
        {
         String ans = myClient.changepassword(user_email,new_password); 
         
           if(ans.equals("updated"))         
           {
             JOptionPane.showMessageDialog(rootPane,"Password Changed!");
             userlogin obj = new userlogin();
           }
           else if(ans.equals("same_previous_password"))
           {
             JOptionPane.showMessageDialog(rootPane," You cannot use a previous password");
           }
           else    //if (ans.equals("password_not_updated"))
           {
             JOptionPane.showMessageDialog(rootPane,"Password not Changed!"); 
           }
        }
        
        
        
        
    }//GEN-LAST:event_save_changesActionPerformed

    private void currentemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentemailActionPerformed

    private void newpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpasswordActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepassword("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changepassword_background;
    private javax.swing.JTextField currentemail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField newpassword;
    private javax.swing.JPasswordField reenterpassword;
    private javax.swing.JButton save_changes;
    // End of variables declaration//GEN-END:variables
}
