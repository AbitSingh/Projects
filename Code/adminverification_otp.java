
import com.vmm.NanoHTTPD;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class adminverification_otp extends javax.swing.JFrame 
{
      String email, ans;
      private boolean isResendClicked = false;
      private String resend5_new_otp;
      
    public adminverification_otp(String Email,String Ans) {
        initComponents(); 
        setSize(530, 316);
        this.email = Email;
        this.ans   = Ans; 
        getContentPane().setBackground( Color.decode ("#000000"));
        
        
        // " To continue, complete this verification step. We've sent a  \n One Time Password (OTP) to the email "+email+ " Please enter it below."
                                         
        JLabel object2 = new JLabel("<html> To continue, complete this verification step.We've sent a One Time Password (OTP) to the email " + email+ " Please enter it below.</html>"
        );
                
        
            object2.setBounds(20, 30, 460, 100);
            object2.setForeground(new Color(255,255,255));
            object2.setFont(new Font("Segoe UI",Font.ITALIC,14));
            //object2.setVerticalAlignment(SwingConstants.TOP);
               
            add(object2);
            repaint();
            //getContentPane().setBackground(new Color(0,0,0));
                
//            ImageIcon ic = new ImageIcon("src/Downloaded_photos/signup2.jpg");                                                         // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;            
//            Image im = ic.getImage().getScaledInstance(admin_verification.getWidth(), admin_verification.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
//            admin_verification.setIcon(new ImageIcon(im));
//        

}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();
        CONTINUE = new javax.swing.JButton();
        resend_otp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Verification required");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 0, 400, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter OTP");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 130, 110, 30);

        otp.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        getContentPane().add(otp);
        otp.setBounds(180, 130, 260, 40);

        CONTINUE.setBackground(new java.awt.Color(255, 153, 0));
        CONTINUE.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        CONTINUE.setForeground(new java.awt.Color(255, 255, 255));
        CONTINUE.setText("Continue");
        CONTINUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTINUEActionPerformed(evt);
            }
        });
        getContentPane().add(CONTINUE);
        CONTINUE.setBounds(180, 200, 260, 40);

        resend_otp.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        resend_otp.setForeground(new java.awt.Color(102, 204, 255));
        resend_otp.setText("Resend OTP");
        resend_otp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resend_otpMouseClicked(evt);
            }
        });
        getContentPane().add(resend_otp);
        resend_otp.setBounds(270, 240, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CONTINUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTINUEActionPerformed
       
    String enter_otp = otp.getText();
    if(enter_otp.equals(""))
    { 
       JOptionPane.showMessageDialog(rootPane,"Enter OTP!");
    }
    
    
    else if(isResendClicked) 
    {
   
    
        //if(enter_otp.equals(""))
        //JOptionPane.showMessageDialog(rootPane,"Please fill in this field");
    
        if(enter_otp.trim().equals(resend5_new_otp))
        {
            JOptionPane.showMessageDialog(rootPane,"OTP Verified");
            change_adminpassword obj5 = new change_adminpassword(email);   // pass the email that you want to send to another frame; send
                                                                               // changepassword(email) karke humne us class ko call kiya
            // the new keyword in new changepassword(email)is used to create an instance of the class and call the constructor of changepassword class
            obj5.setVisible(true);
                  
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
                change_adminpassword obj4 = new change_adminpassword(email);   // pass the email that you want to send to another frame; send
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











    }//GEN-LAST:event_CONTINUEActionPerformed

    private void resend_otpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resend_otpMouseClicked
    //String enter_otp2 = otp.getText();
        
    
    
        JLabel label3  = new  JLabel( "A new code has been sent to your email.");
        //label.setBounds(180,40,600,169);
        label3.setBounds(180, 167, 300, 40);
        label3.setForeground(new Color(102,204,255));
        label3.setFont(new Font("Segoe UI",Font.ITALIC,14));
        add(label3);
                
        repaint();
            
    String new_otp =  (int) (1000+(9999-1000)*Math.random())+"";    // yeah otp merepass agee hai, esko verify karna hai;        
    System.out.println("--->"+new_otp);
           
    sendemail obj = new sendemail( email,"Reset your Password", "To authenticate, please use the following One Time Password(OTP):  " +new_otp + "   Don't share this OTP with anyone. Our customer service team will never ask you for your password, OTP, credit card, or banking info." +
    "\n" + "We hope to see you again soon " );    
   
     resend5_new_otp = new_otp; 
    isResendClicked = true;
    /*
    if(enter_otp2.equals(""))
        JOptionPane.showMessageDialog(rootPane,"Please fill in this field");
    
        else if(enter_otp2.equals(otp))
        {
            JOptionPane.showMessageDialog(rootPane,"OTP Verified");
            change_adminpassword obj4 = new change_adminpassword(email);   // pass the email that you want to send to another frame; send
                                                                               // changepassword(email) karke humne us class ko call kiya
            // the new keyword in new changepassword(email)is used to create an instance of the class and call the constructor of changepassword class
            obj4.setVisible(true);
                  
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Invalid OTP. Please check your code and try again.");
        }
      */  
       
    }//GEN-LAST:event_resend_otpMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminverification_otp("","").setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CONTINUE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField otp;
    private javax.swing.JLabel resend_otp;
    // End of variables declaration//GEN-END:variables
}
