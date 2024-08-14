
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;


public class Movie_details extends javax.swing.JFrame {

    int movie_id;
    public Movie_details(int id) 
    {   
        
        movie_id = id;
        initComponents(); 
        
     
        //yeah init sai pehle likh diya to null pointer exception
        
        // To set custom Foreground size in buttton
//        Font originalFont = imdbbutton.getFont();
//        Font boldFont = originalFont.deriveFont(Font.BOLD, originalFont.getSize() + 4);
//        imdbbutton.setFont(boldFont);
            
        ImageIcon ic6 = new ImageIcon("src/Downloaded_photos/yellow_hd.jpg");
        Image img = ic6.getImage().getScaledInstance(hd.getWidth(), hd.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic7 = new ImageIcon(img);
        hd.setIcon(ic7); 
        
        ImageIcon ic2 = new ImageIcon("src/Downloaded_photos/AD.jpg");
        Image img2 = ic2.getImage().getScaledInstance(ad.getWidth(), ad.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic3 = new ImageIcon(img2);
        ad.setIcon(ic3);
        
        ImageIcon ic4 = new ImageIcon("src/Downloaded_photos/CC2.png");
        Image img3 = ic4.getImage().getScaledInstance(cc.getWidth(), cc.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic5 = new ImageIcon(img3);
        cc.setIcon(ic5);
        setSize(710,600);
        
      
        repaint();
        // OR WE CAN USE .setBounds();
        
        loadmovie();
        
        moviename_lb.setEditable(false);
        cast_lb.setEditable(false);
        movie_id = id; 
       
        plot_lb.setEditable(false);              // yeah chahye loadmovie kai upar likho chal jayega;
        imdb_lb.setEditable(false);
        director_lb.setEditable(false);
        getContentPane().setBackground(Color.decode("#000033"));
            setSize(764, 530);
    }

    
   
    void loadmovie()
    {
        String ans = myClient.moviedetail(movie_id);
        
        StringTokenizer st = new StringTokenizer(ans,"$");
        
        // ek - ek karke Tokens get karlo();   
        
        //if (st.hasMoreTokens()){    
        
        String name        = st.nextToken();         // Very Imp :- serial order mai get karne hai    
        String cast        = st.nextToken();
        String director    = st.nextToken();
        String movieplot   = st.nextToken();
        String imdb        = st.nextToken();
        String youtube_id  = st.nextToken();
        String photo       = st.nextToken();
        String movie_link  = st.nextToken();
        
        
        ImageIcon ic = new ImageIcon(photo);
        Image img = ic.getImage().getScaledInstance(photolb2.getWidth(), photolb2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        
        photolb2.setIcon(ic1);               // upar sai jo photo ayi use photolb naam kai label pai set kar diya;
        
        moviename_lb.setText(name);         // upar sai jo name nikala use moviename naam kai label pai set kardo;
        
        
        
        cast_lb.setText(cast); 
        
        //String modifiedplot = addLineBreaksToText(movieplot, 5);
        plot_lb.setText(movieplot);
        
        
        
        imdb_lb.setText(imdb);
        director_lb.setText(director); 
        
//        
//        String addLineBreaksToText(String text, int wordsPerLine) {
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st2 = new StringTokenizer(text, " ");
//        int count = 0;
//
//        while (st.hasMoreTokens()) {
//            sb.append(st2.nextToken()).append(" ");
//            count++;
//
//            if (count >= wordsPerLine) {
//                sb.append("\n");
//                count = 0;
//            }
//        }
//
//        return sb.toString().trim();
//    }
        
       
        
        
        trailerbt.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)             // eseliye use kiya kyoki esemai youtube id aa rahi hai, vahi pai fix kardi
            {
                try
                {
                   // yeah URI class already defined hai java mai;
                   // agar extra space daal di string kai andar to vedio ka link open nahi hoga;
                   // yeah youtube_id database sai ayegi, baaki ka link sara same hai;
                    URI uri = new URI("https://www.youtube.com/watch?v="+youtube_id);                //Strings kai andar path dena hai us clicked hue button ka ;
                                                                                                    // equal to pehle tak har ek vedio ka link same hota hai, vaha tak yaha paste karke age clicked hui vali id attach kardenge ;
                    // AB BROWSER LAUNCH KARNA JAI JISPAI VEDIO CHALE, USKA CODE YEAH HAI:-         // Jab yeah dono attach hoti hai, phir es link pai click karne sai youtube pai ki vedio chal jati hai;
                                                                                                   // agar youtube_id ki scope ki problem pad jati to ese bahar rakh dena tha;
                   
                    
                    Desktop d = Desktop.getDesktop(); 
                    d.browse(uri);
                
                }
                catch(Exception ex)
                {
                    
                }
            }
            
        });
   
                     
        // Play Movie button ka alag action Listener, jab Play Movie vala  Button Click Hoga to yeah vala action ActionListener chal Jayega; 
        bt.addActionListener(new ActionListener() 
           {
                @Override
                public void actionPerformed(ActionEvent e) {
                // eske andar local movie chalane ka code ayega:-
                try                                    // files ki bhi exception aa jati hoti hai;
                {
                
            
                File f = new File(movie_link);  // movie_link mai vedio ka path aa raha hai;
            
                // yeah Desktop vali Story likho path ko run karne kai liye 
                Desktop d = Desktop.getDesktop();
                d.open(f);
            
                } 
                
                catch(Exception ex)
                {
                  ex.printStackTrace();  
                }
            
            }
        });
    
    
    
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photolb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        moviename_lb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();
        trailerbt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        imdb_lb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        director_lb = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        plot_lb = new javax.swing.JTextArea();
        photolb2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hd = new javax.swing.JLabel();
        ad = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        imdbbutton = new javax.swing.JButton();
        cast_lb = new javax.swing.JTextField();

        photolb.setText("Photo Preview");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Movie Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 10, 120, 50);

        moviename_lb.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        moviename_lb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moviename_lbActionPerformed(evt);
            }
        });
        getContentPane().add(moviename_lb);
        moviename_lb.setBounds(420, 20, 300, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Star Cast");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 80, 100, 30);

        bt.setBackground(new java.awt.Color(255, 153, 0));
        bt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt.setForeground(new java.awt.Color(255, 255, 255));
        bt.setText("Play Movie");
        getContentPane().add(bt);
        bt.setBounds(490, 430, 140, 40);

        trailerbt.setBackground(new java.awt.Color(255, 153, 0));
        trailerbt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        trailerbt.setForeground(new java.awt.Color(255, 255, 255));
        trailerbt.setText("Play Trailer ");
        trailerbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailerbtActionPerformed(evt);
            }
        });
        getContentPane().add(trailerbt);
        trailerbt.setBounds(490, 370, 140, 40);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Movie Plot");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, 140, 110, 40);

        imdb_lb.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        imdb_lb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imdb_lbActionPerformed(evt);
            }
        });
        getContentPane().add(imdb_lb);
        imdb_lb.setBounds(420, 320, 300, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("A Film By ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 420, 100, 30);

        director_lb.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        director_lb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                director_lbActionPerformed(evt);
            }
        });
        getContentPane().add(director_lb);
        director_lb.setBounds(100, 420, 150, 30);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        plot_lb.setEditable(false);
        plot_lb.setColumns(20);
        plot_lb.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        plot_lb.setLineWrap(true);
        plot_lb.setRows(5);
        plot_lb.setWrapStyleWord(true);
        plot_lb.setOpaque(false);
        jScrollPane1.setViewportView(plot_lb);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 140, 300, 150);
        getContentPane().add(photolb2);
        photolb2.setBounds(10, 30, 240, 320);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rating");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(350, 320, 70, 27);
        getContentPane().add(hd);
        hd.setBounds(10, 380, 30, 20);
        getContentPane().add(ad);
        ad.setBounds(50, 380, 30, 20);
        getContentPane().add(cc);
        cc.setBounds(90, 380, 30, 20);

        imdbbutton.setBackground(new java.awt.Color(255, 204, 0));
        imdbbutton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        imdbbutton.setText("IMDb");
        getContentPane().add(imdbbutton);
        imdbbutton.setBounds(270, 320, 80, 30);

        cast_lb.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        getContentPane().add(cast_lb);
        cast_lb.setBounds(420, 80, 300, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trailerbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailerbtActionPerformed
           
    }//GEN-LAST:event_trailerbtActionPerformed

    private void moviename_lbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moviename_lbActionPerformed
           // moviename.setForeground(Color.WHITE);
    }//GEN-LAST:event_moviename_lbActionPerformed

    private void director_lbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_director_lbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_director_lbActionPerformed

    private void imdb_lbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imdb_lbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imdb_lbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movie_details(0).setVisible(true);  // ab integer value pass ki hai to 0 yaha do;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ad;
    private javax.swing.JButton bt;
    private javax.swing.JTextField cast_lb;
    private javax.swing.JLabel cc;
    private javax.swing.JTextField director_lb;
    private javax.swing.JLabel hd;
    private javax.swing.JTextField imdb_lb;
    private javax.swing.JButton imdbbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField moviename_lb;
    private javax.swing.JLabel photolb;
    private javax.swing.JLabel photolb2;
    private javax.swing.JTextArea plot_lb;
    private javax.swing.JButton trailerbt;
    // End of variables declaration//GEN-END:variables


}
