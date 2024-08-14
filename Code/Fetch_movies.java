import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Fetch_movies extends javax.swing.JFrame {

    String catname;
    public Fetch_movies(String category)      // CONSTRUCTOR;
    {   
        System.out.println("---->"+category);
        initComponents();
        setSize(862, 669);
        
        
        
        
        catname =category;               //catname mai category;
//        mainpanel = new JPanel();
//        mainpanel.setLayout(null); // Set the layout manager to null or any desired layout
//        // getContentPane().
//        getContentPane().add(mainpanel);
        getContentPane().setBackground(Color.decode("#000033"));
        //mainPanel.setLayout(new GridLayout(n / 2, 2, 10, 10));
        loadmovies(); 
        
        
       
       //openSearchDialog();
        
        
    }

    void loadmovies()
    {  
        
       
        String ans = myClient.fetchmovies(catname);     // catname is global; 
        System.out.println(ans);      
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n = st.countTokens();
//    
//        JPanel mainPanel = new JPanel();
//        mainPanel.setBackground(Color.decode("#00033"));
//        mainPanel.setLayout(new GridLayout(n / 2, 2, 10, 10)); // 2 columns grid


        
        JButton arr[] = new JButton[n];
       
        int x=20, y=20;
       
       
        for(int i = 0; i<n; i++)
        {
        String row = st.nextToken();
        StringTokenizer st1 = new StringTokenizer(row,"$");
        
        int id =Integer.parseInt(st1.nextToken());
        String name = st1.nextToken();
        String photo = st1.nextToken();
        
        //JItne button hai ab unko memory do;
        arr[i]= new JButton(name); 
        arr[i].setLayout(null);
        //  arr[i].setLayout(new BoxLayout(arr[i], BoxLayout.Y_AXIS)); 
        //        arr[i].setOpaque(false); // Make the button transparent
        //        arr[i].setContentAreaFilled(false); // Make the content area transparent
        //        arr[i].setBorderPainted(false); // Remove the borde
        
        arr[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
        arr[i].setBackground(new Color(153,204,255));
        arr[i].setForeground(new Color(0,0,0));

        
        
        
        // memory dene kai baad hamesha bounds hi dete hai
        arr[i].setBounds(x,y,150,180);
        
        int topMargin = 155;
        Insets insets = arr[i].getInsets();
        arr[i].setMargin(new Insets(topMargin,0,0,0));
        
        int margin = 5;
        // JLabel movieLabel = new JLabel();
        ImageIcon ic = new ImageIcon(photo);
        Image img = ic.getImage().getScaledInstance(148,160 ,Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        JLabel movieLabel = new JLabel(ic1);
        
        
        movieLabel.setBounds(0, 0, 148, 160);
        //movieLabel.setBounds(0, 0, ic.getIconWidth(), ic.getIconHeight());
        // movieLabel.setIcon(ic1);
        // movieLabel.setBounds(0, 0, 150, 160);
        arr[i].add(movieLabel);        
        
       
        //arr[i].setIcon(ic1);
        
        // JLabel movieLabel = new JLabel(ic1);
//         JPanel moviePanel = new JPanel();
//            moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
//            moviePanel.add(movieLabel);
//           // moviePanel.add(nameLabel);
//            moviePanel.setAlignmentY(TOP_ALIGNMENT);
//        
//         arr[i].add(moviePanel);
//        
        
        
        
        
        
        
        arr[i].addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent e)
            {
            Movie_details obj = new Movie_details(id);  
            obj.setVisible(true);
            }
        
        }
        );
        
        
        mainpanel.add(arr[i]);
        mainpanel.repaint();
        if(x<=410)
        {
           x= x+180;          
        }
        else
        {
        x=  20;
        y = y+200;
        }
       }
    
       mainpanel.setPreferredSize(new Dimension(520,n*50));    // jab movies jayda hogi tab n*50 ka drawback pata lagega;
         
    
    
    }
    
//     public void openSearchDialog() {
//        // Create an instance of the search_demo dialog
//        search_demo obj = new search_demo(this );
//        obj.setVisible(true);
//    }
//    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainpanel.setBackground(Color.decode("#00033"));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 828, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 150, 760, 440);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("For You");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 10, 160, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trending Now");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 60, 250, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fetch_movies("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
