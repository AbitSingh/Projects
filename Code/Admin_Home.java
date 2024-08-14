
//import java.awt.*; 
import java.awt.Font;
import java.awt.Image; 
import java.io.File;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import javax.swing.*;



public class Admin_Home extends javax.swing.JFrame {

    File ph, ph1, movie;                          // ph or photo File hai
    JFileChooser jfc;
    public Admin_Home(String name)     // server on kai baad, jab admin login khola usne success kai baad admin home khud chala dena hai;
    {
        initComponents();
        setSize(1004,814); 
        lb.setText("Welcome: " + name );
        
        // To set custom Foreground size in buttton
        //Font originalFont = imdbbutton.getFont();
        //Font boldFont = originalFont.deriveFont(Font.BOLD, originalFont.getSize() + 4);
        //imdbbutton.setFont(boldFont);
            
        
        ImageIcon ic = new ImageIcon("src/Downloaded_photos/signup2.jpg");                                                         // if path wrong than photo will not paste ;                     // icon bana kai liye, label pai icon lagta hai , photo ka path bhi do;
        Image im = ic.getImage().getScaledInstance(adminhome_background.getWidth(), adminhome_background.getHeight(),Image.SCALE_SMOOTH); // image ko resize karne kai liye;
        adminhome_background.setIcon(new ImageIcon(im));
        
        
        
        
        loadCategories();  //  Jab Constructor Chala Tab loadCategories bhi sath mai chale ga;
    
    }
    
    
    void loadCategories()
    {
    String ans  = myClient.fetchcategories();  // String res jo my client sai aaya, uski value ans mai store karvali
    
    StringTokenizer st = new StringTokenizer(ans,";;");   // ans ko yaha pai ";;" toda; 
//        int n = st.countTokens();
//        for(int i=1; i<=n; i++)
//        {
//        } 
//                 OR 
          while (st.hasMoreTokens())     // jab tak token hai;
          {
          String name = st.nextToken(); 
          cb.addItem(name);
          }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        catname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        moviename = new javax.swing.JTextField();
        director = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cast = new javax.swing.JTextField();
        youtube_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        photo1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        plotlb = new javax.swing.JTextField();
        imdblb = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        imdbbutton = new javax.swing.JButton();
        adminhome_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setText("WELCOME");
        getContentPane().add(lb);
        lb.setBounds(40, 0, 850, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 70, 330, 70);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 180, 160, 30);

        catname.setBackground(new java.awt.Color(153, 153, 153));
        catname.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        catname.setForeground(new java.awt.Color(255, 255, 255));
        catname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catnameActionPerformed(evt);
            }
        });
        getContentPane().add(catname);
        catname.setBounds(230, 180, 190, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 270, 80, 20);

        photo.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        photo.setForeground(new java.awt.Color(255, 255, 255));
        photo.setText("Photo Preview");
        getContentPane().add(photo);
        photo.setBounds(230, 230, 190, 140);

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Choose ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 410, 100, 28);

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 21)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 570, 130, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Movies");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 80, 300, 60);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select Category ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(520, 170, 180, 40);

        cb.setBackground(new java.awt.Color(153, 153, 153));
        cb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cb.setForeground(new java.awt.Color(255, 255, 255));
        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select category" }));
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        getContentPane().add(cb);
        cb.setBounds(720, 170, 230, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Director");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 300, 90, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Movie Name");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(520, 240, 140, 40);

        moviename.setBackground(new java.awt.Color(153, 153, 153));
        moviename.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        moviename.setForeground(new java.awt.Color(255, 255, 255));
        moviename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movienameActionPerformed(evt);
            }
        });
        getContentPane().add(moviename);
        moviename.setBounds(720, 239, 230, 40);

        director.setBackground(new java.awt.Color(153, 153, 153));
        director.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        director.setForeground(new java.awt.Color(255, 255, 255));
        director.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directorActionPerformed(evt);
            }
        });
        getContentPane().add(director);
        director.setBounds(720, 299, 230, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("cast");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(520, 360, 80, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Trailer id");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 530, 110, 40);

        cast.setBackground(new java.awt.Color(153, 153, 153));
        cast.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        cast.setForeground(new java.awt.Color(255, 255, 255));
        cast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                castActionPerformed(evt);
            }
        });
        getContentPane().add(cast);
        cast.setBounds(720, 359, 230, 40);

        youtube_id.setBackground(new java.awt.Color(153, 153, 153));
        youtube_id.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        youtube_id.setForeground(new java.awt.Color(255, 255, 255));
        youtube_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtube_idActionPerformed(evt);
            }
        });
        getContentPane().add(youtube_id);
        youtube_id.setBounds(720, 539, 230, 40);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("photo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(520, 650, 70, 40);

        photo1.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        photo1.setForeground(new java.awt.Color(255, 255, 255));
        photo1.setText("Photo Preview");
        getContentPane().add(photo1);
        photo1.setBounds(720, 640, 120, 90);

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Choose ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(850, 670, 100, 30);

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 21)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(760, 750, 140, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Choose Movie");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(520, 590, 170, 60);

        jButton5.setBackground(new java.awt.Color(0, 102, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Choose Movie");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(810, 600, 140, 40);

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Movie Plot");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(520, 420, 130, 30);

        plotlb.setBackground(new java.awt.Color(153, 153, 153));
        plotlb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        plotlb.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(plotlb);
        plotlb.setBounds(720, 419, 230, 40);

        imdblb.setBackground(new java.awt.Color(153, 153, 153));
        imdblb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        imdblb.setForeground(new java.awt.Color(255, 255, 255));
        imdblb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imdblbActionPerformed(evt);
            }
        });
        getContentPane().add(imdblb);
        imdblb.setBounds(720, 479, 230, 40);

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Rating");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(610, 480, 80, 30);

        imdbbutton.setBackground(new java.awt.Color(255, 204, 51));
        imdbbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        imdbbutton.setText("IMDb");
        imdbbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imdbbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(imdbbutton);
        imdbbutton.setBounds(520, 480, 80, 30);
        getContentPane().add(adminhome_background);
        adminhome_background.setBounds(0, 0, 1000, 820);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void catnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catnameActionPerformed
       
    }//GEN-LAST:event_catnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         jfc = new JFileChooser();                          // es Step Sai Memory Mili Hai; yeah nahi denge to null pointer exception;
        int ans = jfc.showOpenDialog(this);          // use frame kai upar show karo; parent is frame;       
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            ph = jfc.getSelectedFile();
            
            // Image ko resize karo;
            ImageIcon ic = new ImageIcon (ph.getPath());
            Image img = ic.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);                                      // Phir doobara icon mai convert karo;
           
            photo.setIcon(ic1);                                                       // Resized photo paste kardo;
            
            
            // Yeah code sidha bhi chal jayega kyoki kise function ab tak request nahi ki
            
        }
        
        
        
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String category = catname.getText();
       
       if(catname.equals( " ") || ph == null)
       {
         JOptionPane.showMessageDialog(rootPane, " Enter All Fields");
       }
       else
       {
        String ans = myClient.addcat(category,ph); 
           System.out.println( ans);
        
           if(ans.equals("success"))
           {
            JOptionPane.showMessageDialog(rootPane, " Added Successfully");
           }
           else if( ans.equals("exist"))
           {
           JOptionPane.showMessageDialog(rootPane,  "Category Already Exist");
           }
           else
           {
            JOptionPane.showMessageDialog(rootPane, "Failed");
           }
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed

    private void movienameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movienameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movienameActionPerformed

    private void directorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_directorActionPerformed

    private void castActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_castActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_castActionPerformed

    private void youtube_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youtube_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_youtube_idActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      jfc = new JFileChooser();
      
      int ans = jfc.showOpenDialog(this);
      
      if(ans==JFileChooser.APPROVE_OPTION)
      {
          ph1 = jfc.getSelectedFile();
          
          ImageIcon ic = new ImageIcon(ph1.getPath());
          
          Image img = ic.getImage().getScaledInstance(photo1.getWidth(),photo1.getHeight(), Image.SCALE_SMOOTH);
          
          ImageIcon ic1 = new ImageIcon(img);
          
          photo1.setIcon(ic1);
      }
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
     String category   = (String) cb.getSelectedItem();  // combo box mai sai data lene ka method; 
     String movie_name = moviename.getText();
     String direct     = director.getText();
     String starcast   = cast.getText();
     String movie_plot  = plotlb.getText();
     String imdb       = imdblb.getText();
     String youtube    = youtube_id.getText();
        
     if(category.equals("") || movie_name.equals("") || direct.equals("")|| starcast.equals("") || youtube.equals("")|| movie_plot.equals("")||imdb.equals("")|| ph1==null|| movie ==null) 
     { 
       JOptionPane.showMessageDialog(rootPane, "Enter All Fields"); 
     }
     else
     {
      String ans = myClient.addmovie(category,movie_name,direct,starcast, movie_plot,imdb, youtube, ph1, movie);
         if(ans.equals("success"))
         {
          JOptionPane.showMessageDialog(rootPane, "Added Successfully");    
         }
         else
         {
           JOptionPane.showMessageDialog(rootPane, "Movie Added Failed"); 
         }
     
     
     
     }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       jfc = new JFileChooser();
       int ans = jfc.showOpenDialog(this);
       if (ans== JFileChooser.APPROVE_OPTION)
        {
          movie =jfc.getSelectedFile();                   // ab es movie mai path daal do;  
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void imdblbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imdblbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imdblbActionPerformed

    private void imdbbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imdbbuttonActionPerformed
       
    }//GEN-LAST:event_imdbbuttonActionPerformed

   
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
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin_Home( " ").setVisible(true);             // JAB CONSTRUCTOR PARAMETRISED HO GYA TO KHALI STRING PASS KARO;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminhome_background;
    private javax.swing.JTextField cast;
    private javax.swing.JTextField catname;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JTextField director;
    private javax.swing.JButton imdbbutton;
    private javax.swing.JTextField imdblb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb;
    private javax.swing.JTextField moviename;
    private javax.swing.JLabel photo;
    private javax.swing.JLabel photo1;
    private javax.swing.JTextField plotlb;
    private javax.swing.JTextField youtube_id;
    // End of variables declaration//GEN-END:variables
}
