import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.awt.Image;
import java.util.*;
//import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JTextField;


public class user_home extends javax.swing.JFrame 
{
    //public javax.swing.JTextField tf;
                                          // agar mai sidha userhome ko run kardunga to welcome kai saath email nahi ayegi;
    public user_home(String email)       // piche sai yeah email user name sai aa rahi hai, jo yaha pass ki hai;
    {
        
        initComponents(); 
        
        
        setSize(975, 812);
        lb.setText("WELCOME : " + email);
        
        ImageIcon ic = new ImageIcon("src/Downloaded_photos/search.png");       // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;
        Image im = ic.getImage().getScaledInstance(searchicon.getWidth(), searchicon.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
        searchicon.setIcon(new ImageIcon(im));  
        
        loadcategory();
        getContentPane().setBackground(Color.decode("#000033"));
        mainpanel.setOpaque(true);
        //mainpanel.setBackground(Color.decode());
        //mainpanel2.setOpaque(true);
        mainpanel2.setBackground(Color.GRAY); 
          mainpanel2.setBackground(Color.decode("#000033"));
          
        
          // public javax.swing.JTextField tf; This Method is not allowed inside the constructor in java;
          
         /* 
          tf2 = new javax.swing.JTextField();
          tf2.setText("Search for movies...");   // Set the initial placeholder text
          tf2.setForeground(Color.ORANGE);
          
          tf2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Focus Gained");
                  // Clear the text when the search bar gains focus
                if (tf2.getText().equals("Search for movies...")) {
                    tf2.setText("");
                    tf2.setForeground(Color.ORANGE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Focus Lost");
               
// Restore the placeholder text if the search bar is empty
                if (tf2.getText().trim().isEmpty()) {
                    tf2.setText("Search for movies...");
                    tf2.setForeground(Color.ORANGE);
                }
            }
        });
        */
    }        
        
        
        
       
    
    
     void loadcategory()                                                     // can add private here ?
    {
     String ans = myClient.fetchcat();
    // System.out.println(ans);
      
     StringTokenizer st = new StringTokenizer (ans,";;");  
     int  n = st.countTokens(); 
     
     JButton arr[] = new JButton [n];  
     
     int x = 49, y = 40;
     for(int i = 0; i<n; i++)                                                                 // jitna count kiya use String row mai store karo with help of st.nextToken();  
     {
        String row = st.nextToken();  
        StringTokenizer st1 = new StringTokenizer(row,"$");                            // Phir us row ko tod do "$" par
     
        String name = st1.nextToken();
        String photo = st1.nextToken();
     
        arr[i] = new JButton(name);                                                             // ek- ek karke us array mai value daalte gaye;
        arr[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
        //System.out.println("Setting font for button: " + name); 
        
        arr[i].setBackground(new Color(153,204,255));
        arr[i].setForeground(new Color(0,0,0));

        //arr[i].setIcon(new ImageIcon(photo));   WHY THIS SIR'S CODE IS NOT WORKING IN MY LAPTOP ?
        
        
        ImageIcon ic = new ImageIcon(photo);            // By Chatgpt
        Image im = ic.getImage();
        Image scaledImage = im.getScaledInstance(80,64, Image.SCALE_SMOOTH);
        arr[i].setIcon(new ImageIcon(scaledImage));
        
        
       
        arr[i].setBounds(x,y,185,70);          // ab buttons kai bound set karo
        
        
        //  anonymous Listener tab lagta hai jab hume nahi pata kitne button aane vale hai, To yaha hume nahi pata So use anonymous listener; ;
        // yeah chalega hi tab agar user home mai koi category pai click hui hai;
        // JAB YEAH BUTTON CLICK HOGA TAB US BUTTON VALA FRAME i.e Fetch_movies ka constructor call hoga;
       
        arr[i].addActionListener(new ActionListener(){   // HAR EK BUTTON KA APNA ACTION LISTENER HAI USE, ANONYMOUS LISTENER KEHTE HAI;
             @Override
            public void actionPerformed(ActionEvent e){   // beech mai function override kiya;
           //  JOptionPane.showMessageDialog(rootPane, name +"clicked");
             

           Fetch_movies obj = new Fetch_movies(name);
            obj.setVisible(true);
            }
});                                                 // bahar vali body band kar di;
        
        
        
        mainpanel.add(arr[i]);                                                        // yeah manually array declare kiya hai , to ese manually add bhi karna padega;
        mainpanel.repaint();                                                            //  refresh karne kai kam ata hai;
        
        
        if( x<= 480)                                                                      // Ab hum chahte hai ki grid bane , ek line mai bas 3 aaye so if ki condition tak bas 3 button add honge , baad mai y increment karega ,  
          {                                                                              // 120 * 3 = 360 + 30( 3 button kai beech ka gap) = 390;
          
            x= x+200;           // ek button 120 width ka hai, to usmai 10 add karke baaki button lagayenge
         
          }
        else 
          { 
            x= 50;
            y= y +85;                                                                         // button ki height 40 hai, to 10 hum add karke 50 lenge
          }
     }
     
     mainpanel.setPreferredSize(new Dimension(470, n*5));  // used to set mainpanel size;  scroll pane works on panel;
    
   } 
    
   
         void loadmovies()
    {  
        
        mainpanel2.removeAll();   // jab textfield khali tab movies show nahi hogi;
        mainpanel2.repaint();
        
        if(!tf2.getText().equals(""))
        {
        String ans = myClient.search(tf2.getText());          // jo textField mai type karenge vo hi jayega;
        
        
//        tf.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                // Clear the text when the search bar gains focus
//                if (tf.getText().equals("Search for movies...")) {
//                    tf.setText("");
//                    tf.setForeground(Color.BLACK);
//                }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                // Restore the placeholder text if the search bar is empty
//                if (tf.getText().trim().isEmpty()) {
//                    tf.setText("Search for movies...");
//                    tf.setForeground(Color.GRAY);
//                }
//            }
//        });
        
        
        
        
        
        
        
        
        System.out.println(ans);      
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n = st.countTokens();
    
        JButton arr[] = new JButton[n];
       
        int x=10,y = 10;
       
       
        for(int i = 0; i<n; i++)
        { 
         System.out.println("Loop iteration: " + i);    
        String row = st.nextToken();
        StringTokenizer st1 = new StringTokenizer(row,"$");
        
        int id =Integer.parseInt(st1.nextToken());
        String name = st1.nextToken();
        String photo = st1.nextToken();
        
       // System.out.println("Button name: " + name);                                                       //JItne button hai ab unko memory do;
        arr[i]= new JButton(name); 
        
       // arr[i].setFont(new Font("Segoe UI", Font.BOLD, 14)); // Customize the font as needed
       // System.out.println("Setting font for button: " + name);

        
        // memory dene kai baad hamesha bounds hi dete hai
        arr[i].setBounds(x,y,220,55);
        arr[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
        arr[i].setBackground(new Color(153,204,255));
        arr[i].setForeground(new Color(0,0,0));
        
        
        
        ImageIcon ic = new ImageIcon(photo);
        Image img = ic.getImage().getScaledInstance(80, 41, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        
        arr[i].setIcon(ic1);
        
        arr[i].addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent e)
            {
            Movie_details obj = new Movie_details(id);  
            obj.setVisible(true);
            }
        
        }
        );
        
        
        mainpanel2.add(arr[i]);
        mainpanel2.repaint();
        if(x<=520)
        {
           x= x+227;          
        }
        else
        {
        x=  10;
        y = y+ 65;
        }
        }
       
    
       mainpanel2.setPreferredSize(new Dimension(530,n*50));   // jab movies jayda hogi tab n*50 ka drawback pata lagega;
      }
      
//        else if(tf2.getText().equals(""))
//        {
//         mainpanel2.removeAll();
//         mainpanel2.repaint();
//        } 
//        else
//        {
//        System.out.println("No Movies Found");
//        } 
//        
       
        
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        tf2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        mainpanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchicon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("windowText"));
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("WELCOME");
        getContentPane().add(lb);
        lb.setBounds(0, 0, 970, 60);

        mainpanel.setBackground(Color.decode("#00033"));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(mainpanel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 370, 880, 410);

        tf2.setBackground(new java.awt.Color(153, 204, 255));
        tf2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        tf2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tf2CaretUpdate(evt);
            }
        });
        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        getContentPane().add(tf2);
        tf2.setBounds(90, 110, 840, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Popular on VOD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 70, 280, 30);

        jScrollPane3.setForeground(new java.awt.Color(51, 51, 51));

        mainpanel2.setBackground(new java.awt.Color(102, 204, 255));
        mainpanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainpanel2.setForeground(new java.awt.Color(102, 102, 102));
        mainpanel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout mainpanel2Layout = new javax.swing.GroupLayout(mainpanel2);
        mainpanel2.setLayout(mainpanel2Layout);
        mainpanel2Layout.setHorizontalGroup(
            mainpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
        );
        mainpanel2Layout.setVerticalGroup(
            mainpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(mainpanel2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(50, 170, 880, 130);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("All Categories");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 320, 270, 50);
        getContentPane().add(searchicon);
        searchicon.setBounds(50, 110, 40, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tf2CaretUpdate
       // if(/*!tf2.getText().equals("") && */!tf2.getText().equals("Search for movies")) 
       // {
        loadmovies();
        //} 
       /* else if (tf2.getText().equals(""))
        
         { 
          mainpanel2.removeAll();
          mainpanel2.repaint();
             
             
          //tf2 = new javax.swing.JTextField();
          tf2.setText("Search for movies");   // Set the initial placeholder text
          tf2.setForeground(Color.ORANGE);
          
          tf2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("Focus Gained");
                  // Clear the text when the search bar gains focus
                if (tf2.getText().equals("Search for movies")) {
                    tf2.setText("");
                    //tf2.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Focus Lost");
               
                // Restore the placeholder text if the search bar is empty
                if (tf2.getText().trim().isEmpty()) {
                    tf2.setText("Search for movies");
                    tf2.setForeground(Color.WHITE);
                }
            }
        }); 
          
      } 
        
        else 
        {
            
        }
       */ 
    }//GEN-LAST:event_tf2CaretUpdate

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

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
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_home("").setVisible(true);  // parameter puch raha hai, khali pass kardo(" ") kyoki string hai; int hai to 0 pass karo; Agar nahi likhenge to obj.setvisible khud likhna padega; 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel mainpanel2;
    private javax.swing.JLabel searchicon;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
