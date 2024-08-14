
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Cool Abit
 */
public class adminforgot_password extends javax.swing.JFrame {

    /**
     * Creates new form forgot_password
    */
    public adminforgot_password() 
    {
        initComponents();
       setSize(599, 323);
        
        ImageIcon ic = new ImageIcon("src/Downloaded_photos/signup2.jpg");       // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;
        Image im = ic.getImage().getScaledInstance(adminforgotpassword_background.getWidth(), adminforgotpassword_background.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
        adminforgotpassword_background.setIcon(new ImageIcon(im)); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailaddress = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        adminforgotpassword_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reset your admin password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 0, 490, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email Address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 170, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter the email address associated with your admin account");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 70, 530, 30);

        emailaddress.setBackground(new java.awt.Color(153, 153, 153));
        emailaddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        emailaddress.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(emailaddress);
        emailaddress.setBounds(210, 110, 270, 40);

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 170, 270, 40);
        getContentPane().add(adminforgotpassword_background);
        adminforgotpassword_background.setBounds(0, -4, 620, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        






 String  email = emailaddress.getText();
       if(email.equals(""))
      {
       JOptionPane.showMessageDialog(rootPane, "Enter Your Email");  
      }
      else
      { 
            String ans = myClient.verify_email_for_adminpassword_reset(email);
           
           if(!ans.equals("email_does_not_exist"))
           {
                adminverification_otp object= new adminverification_otp(email,ans);
                object.setVisible(true);
                
               //String Otp2= JOptionPane.showInputDialog(rootPane,"Enter the OTP that we've sent to the email "+email);
      
            
//                if(Otp2.trim().equals(ans.trim()))
//               {
//                JOptionPane.showMessageDialog(rootPane,"OTP Verified");
//                change_adminpassword obj4 = new change_adminpassword(email);   // pass the email that you want to send to another frame; send
//                                                                  // changepassword(email) karke humne us class ko call kiya
//                 the new keyword in new changepassword(email)is used to create an instance of the class and call the constructor of changepassword class
//                                                                  
//                obj4.setVisible(true);
//               }
            
           
                }
            else if (ans.equals("email_does_not_exist"))
           {
                 JOptionPane.showMessageDialog(rootPane, "No Account found for this Admin Email address.");
           }
           
           
        
           }
      
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(adminforgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminforgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminforgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminforgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminforgot_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminforgotpassword_background;
    private javax.swing.JTextField emailaddress;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
