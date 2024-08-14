
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class userverification_otp extends javax.swing.JFrame {

      String email, ans;
      public boolean is_otp_resendclicked = false;
      public String resend_user2_otp;
    
    public userverification_otp(String Email1, String Ans1) {
        initComponents(); 
        setSize(554, 319);
        this.email = Email1;
        this.ans   = Ans1;
        getContentPane().setBackground( Color.decode ("#000033"));
        
//        ImageIcon ic = new ImageIcon("src/Downloaded_photos/signup1.jpg");       // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;
//        Image im = ic.getImage().getScaledInstance(userverification_background.getWidth(),userverification_background.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
//        userverification_background.setIcon(new ImageIcon(im));
//        
        
        // " To continue, complete this verification step. We've sent a  \n One Time Password (OTP) to the email "+email+ " Please enter it below."
                                         
        JLabel object2 = new JLabel("<html> To continue, complete this verification step We've sent a One Time Password (OTP)"+ "to the email " + email + " Please enter it below.</html>"
        );
                
        
                object2.setBounds(20, 30, 460, 100);
                object2.setForeground(new Color(255,255,255));
                object2.setFont(new Font("Segoe UI",Font.ITALIC,14));
                //object2.setVerticalAlignment(SwingConstants.TOP);
               
                add(object2);
                repaint();
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user_resend_otp = new javax.swing.JLabel();
        user_otp = new javax.swing.JTextField();
        user_continue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Verification required");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 380, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter OTP");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 120, 100, 30);

        user_resend_otp.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        user_resend_otp.setForeground(new java.awt.Color(102, 204, 255));
        user_resend_otp.setText("Resend OTP");
        user_resend_otp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_resend_otpMouseClicked(evt);
            }
        });
        getContentPane().add(user_resend_otp);
        user_resend_otp.setBounds(270, 230, 110, 30);

        user_otp.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        getContentPane().add(user_otp);
        user_otp.setBounds(180, 112, 260, 40);

        user_continue.setBackground(new java.awt.Color(255, 153, 0));
        user_continue.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        user_continue.setForeground(new java.awt.Color(255, 255, 255));
        user_continue.setText("continue");
        user_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_continueActionPerformed(evt);
            }
        });
        getContentPane().add(user_continue);
        user_continue.setBounds(180, 180, 260, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_resend_otpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_resend_otpMouseClicked
        String enter_otp2 = user_otp.getText();
        
    
    
        JLabel label  = new  JLabel( "A new code has been sent to your email.");
        label.setBounds(180, 150, 300, 40);

        label.setForeground(new Color(153,204,255));
        label.setFont(new Font("Segoe UI",Font.ITALIC,14));
        add(label);
                
        repaint();
        revalidate();
            
    String otp =  (int) (1000+(9999-1000)*Math.random())+"";    // yeah otp merepass agee hai, esko verify karna hai;        
    System.out.println("--->"+otp);
           
    sendemail obj = new sendemail( email,"Reset your Password", "To authenticate, please use the following One Time Password(OTP):"+ 
            otp + 
            "   Don't share this OTP with anyone. Our customer service team will never ask you for your password, OTP, credit card, or banking info." +
      "We hope to see you again soon " );    
    
    resend_user2_otp = otp; 
    is_otp_resendclicked = true;   
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_user_resend_otpMouseClicked

    private void user_continueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_continueActionPerformed
        
     String enter_otp = user_otp.getText();
    if(enter_otp.equals(""))
    { 
       JOptionPane.showMessageDialog(rootPane,"Enter OTP!");
    }
    
    
    else if(is_otp_resendclicked) 
    {
   
    
        //if(enter_otp.equals(""))
        //JOptionPane.showMessageDialog(rootPane,"Please fill in this field");
    
        if(enter_otp.trim().equals(resend_user2_otp))
        {
            JOptionPane.showMessageDialog(rootPane,"OTP Verified");
            //changepassword obj4 = new changepassword(email);   // pass the email that you want to send to another frame; send
              changepassword obj4 =new changepassword(email);                                                                 // changepassword(email) karke humne us class ko call kiya
            // the new keyword in new changepassword(email)is used to create an instance of the class and call the constructor of changepassword class
            obj4.setVisible(true);
                  
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Invalid OTP. Please check your code and try again.");
        }
    }
    else  // Check here when Resend OTP was not clicked;
    {
       //   String ans = myClient.verify_email_for_adminpassword_reset(email);
       if(!ans.equals("email_does_not_exist"))
           {
               //String Otp2= JOptionPane.showInputDialog(rootPane,"Enter the OTP that we've sent to the email "+email);
      
            
                if(enter_otp!= null && enter_otp.trim().equals(ans.trim()))
               {
               // JOptionPane.showMessageDialog(rootPane,"OTP Verified");
                changepassword obj4 = new changepassword(email);   // pass the email that you want to send to another frame; send
                                                                  // changepassword(email) karke humne us class ko call kiya
                // the new keyword in new changepassword(email)is used to create an instance of the class and call the constructor of changepassword class
                                                                  
                obj4.setVisible(true);
                  
               }
                else
                {
                JOptionPane.showMessageDialog(rootPane, "The OTP you entered is not valid. Please try again");
                }
            
           }
            else if (ans.equals("email_does_not_exist"))
           {
                 JOptionPane.showMessageDialog(rootPane, "No Account found for this Admin Email address.");
           }
    }   
        
        
        
        
    }//GEN-LAST:event_user_continueActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userverification_otp("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton user_continue;
    private javax.swing.JTextField user_otp;
    private javax.swing.JLabel user_resend_otp;
    // End of variables declaration//GEN-END:variables
}
