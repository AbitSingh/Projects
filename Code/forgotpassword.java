import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class forgotpassword extends javax.swing.JFrame {

    //JLabel obj4;
    public forgotpassword() 
    {
        
        initComponents(); 
        //obj4.setVerticalAlignment(SwingConstants.CENTER);      
       
        setSize(599, 323);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#000033")); 
        //emailaddress.setBackground(new Color(132,112,255));
        
         ImageIcon ic = new ImageIcon("src/Downloaded_photos/signup1.jpg");       // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;
        Image im = ic.getImage().getScaledInstance(forgotpassword_background.getWidth(), forgotpassword_background.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
        forgotpassword_background.setIcon(new ImageIcon(im));  
       
    }

  
   
                       

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailaddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        forgotpassword_background = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reset your password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 400, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter the email address associated with your account.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 410, 30);

        emailaddress.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        emailaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailaddressActionPerformed(evt);
            }
        });
        getContentPane().add(emailaddress);
        emailaddress.setBounds(210, 110, 274, 39);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email Address");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 110, 160, 39);

        submit.setBackground(new java.awt.Color(255, 153, 0));
        submit.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Continue");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(210, 170, 274, 40);
        getContentPane().add(forgotpassword_background);
        forgotpassword_background.setBounds(0, 0, 600, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailaddressActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
      String  email1 = emailaddress.getText();
      
//       obj4 = new JLabel();
//              
//       obj4.setText("To continue, complete the verification step. We've sent a One Time Password(OTP) to the email"+email+" ");
//       obj4.setFont(new Font("Arial",Font.PLAIN, 20));
//       obj4.setForeground(Color.BLUE);
//       
//       obj4.setBounds(180, 270, 160, 16);
//       add(obj4);
      
       
       
       
             if(email1.equals(""))
      {
       JOptionPane.showMessageDialog(rootPane, "Enter Your Email");  
      }
      else
      { 
            String ans1 = myClient.verify_email_for_reset(email1);
           
           if(!ans1.equals("email_does_not_exist"))
           {
               userverification_otp object = new  userverification_otp(email1,ans1);
               object.setVisible(true);
               //String Otp2= JOptionPane.showInputDialog(rootPane,"Enter the OTP that we've sent to the email "+email);
      
            
//                if(Otp2!=null && Otp2.trim().equals(ans.trim()))
//               {
//                JOptionPane.showMessageDialog(rootPane,"OTP Verified");
//                changepassword obj = new changepassword(email);   // pass the email that you want to send to another frame; send
//                                                                  // changepassword(email) karke humne us class ko call kiya
//                // the new keyword in new changepassword(email)is used to create an instance of the class and call the constructor of changepassword class
//                                                                  
//                obj.setVisible(true);
//               }
//            
           }
            else if (ans1.equals("email_does_not_exist"))
           {
                 JOptionPane.showMessageDialog(rootPane, "No account found for this Email address.");
            }
           
           
           }
             
             
            
            
          
          
          
          
          
          
          
      // verification obj = new verification();   
      
    }//GEN-LAST:event_submitActionPerformed
        
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
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotpassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailaddress;
    private javax.swing.JLabel forgotpassword_background;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
