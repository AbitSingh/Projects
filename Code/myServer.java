
import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import com.vmm.JHTTPServer;
import java.util.Properties;

import java.sql.*;

//import java.util.logging.Logger;

public class myServer extends JHTTPServer
{

//    private Object parms;
 public myServer(int port) throws Exception
  {
   super(port); 
  }  

    
    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
     {
       Response res = null;  
       // YEAH SARA STATIC ENTRY DAAL KAI SERVER PAI STORE KIYA HAI;
       // JAB CLIENT ES URL KI REQUEST MAREGA TO YAHA STATIC DATA SAI CONDITION CHECK HOKE CLIENT PAI ANSWER JAYEGA; 
     
      if(uri.equals("/"))   // AGAR contains LIKH DAI TO BAS Url ki uri mai sai ekela yeah dekhega ki yeah "/" hai to  yeah vala if chalado;
       {
       String ans = Math.random()+ "";
       res = new Response (HTTP_OK,"text/plain",ans);
       return res;         
       
      }
       
       else if(uri.equals("/one"))
       {
       String ans = Math.random()+ "";
       res = new Response (HTTP_OK,"text/plain",ans);
       return res;         
       }
       
       
       else if (uri.equals("/userlogin"))
       {
        // CLIENT SAI PARAMETER LEKE YAHA PAI GET KARO;
        String username = parms.getProperty("username");     // PICHE SAI JIS NAAM SAI BHEJE HAI US NAAM SAI YAHA GET KARENGE WITH HELP OF PARMS;
        String password = parms.getProperty("password");     // password naam ka parameter jo client sai aaya hai, vo yaha pai get karo; SO NAME MUST BE SAME;
        try 
        {
   
        
        ResultSet rs = DBLoader.executeQuery("  select * from users where useremail ='"+ username +"' and password = '" +password+"'");
          
                // AB YEAH SQL COMMAND LIKHNE KAI BAAD CHECK KARO KI ROW RETUEN HUI, agar hui hai to print karo success, or else fail;
                if(rs.next())
                {
                    res =   new Response(HTTP_OK,"text/plain","Success");
                   //  return res; yeah kyo nahi likha ?
                }
                else
                {
                    res = new Response(HTTP_OK,"text/plain", "Failed");
                  //  return res; Yeah likh kai bhi chal jata hai;
                }   
                
          }
        catch(Exception e)
         {
          e.printStackTrace();
         }
       } 
       
       else if (uri.equals("/usersignup"))
       {
        String email = parms.getProperty("email");
        String password= parms.getProperty("pass");
        String mobile = parms.getProperty("mobile");
        String address = parms.getProperty("address");
        
        String name= saveFileOnServerWithRandomName(files, parms,"f1","src/uploads");
         try
         { 
        // files, parms ese hi ayega , f1 means kis name sai file aa rahi hai, abspath = kaha save karni hai;
        // database mai photo ka column nahi banaya, pehle vo banayo varna exception aa jayege;    
        // 2 WAYS TO CHANGE TABLE - table kai name kai right side center vala button
        // or choose right click to alter table;
           
           ResultSet rs1 = DBLoader.executeQuery("select * from users"); 
         
               // IF WANT TO APPLY CHECK ON EXISTING MOBILE NUMBER;
            
//              ResultSet rs1 = DBLoader.executeQuery("select * from users where mobile= '"+mobile+"'");
//                if(rs1.next())
//                { 
//             
//                res = new Response (HTTP_OK,"text/plain", "mobile");   
//                }
//                else
//               {
             
                
                
                   rs1.moveToInsertRow();
           
                   // JIS ORDER MAI DATABASE KAI COLUMNS HAI US ORDER MAI YAHA PAR LIKHO,
                   // NAHI TO PHIR KISE COLUMN KI VALUE KISE COLUMN MAI JAYEGI;
           
                rs1.updateString("useremail", email); // YAHA PAI DATABASE KI ENTRY DAAL TAI HAI,
                rs1.updateString("password", password);// AGAR GALAT DATABASE KA COLUMN FILL KAR DIYA, TO VO YAHA ERROR SHOW
                rs1.updateString("mobile",mobile);    // TO VO YAHA ERROR SHOW netbeans MAI NAHI KAREGA;
                rs1.updateString("address",address);
                rs1.updateString("photo","src/uploads/"+name); // agar photo database mai sai nikalni hai preview kai liye , so eseliye path do,
                                                                // agar path nahi diya, name sai photo nahi milegi use;
                rs1.insertRow();
           
                res = new Response(HTTP_OK, "text/plain", "success");
           
               
               
          } 
         
         
         catch(Exception e) 
         {
          e.printStackTrace();
         }
    
       } 
       
       // if otp is not sending,  than please check the app password;
       else if (uri.equals("/verifyEmail"))
       {
       String email = parms.getProperty("email");   // email get karo
       String mobile = parms.getProperty("mobile");   
              try 
           {
           ResultSet rs = DBLoader.executeQuery("select * from users where useremail='"+email+"'");
           
                if(rs.next())
               {
               res = new Response(HTTP_OK, "text/plain" ,"exist") ;    // check karo email database mai padi hai, agar padi to exist return karo;
               }
                else
               { 
           
               // IF WANT TO APPLY CHECK ON EXISTING MOBILE NUMBER;
            
                   ResultSet rs1 = DBLoader.executeQuery("select * from users where mobile= '"+mobile+"'");
                   if(rs1.next())
                   { 
             
                   res = new Response (HTTP_OK,"text/plain", "mobile");   
                   }
                   
                   
                   
                   
                 else
                   {
                // Email Bhejne Ka Code Hai yeah;                                           // agar email nahi padi to otp send karo;
                 String otp =  (int) (1000+(9999-1000)*Math.random())+"";    // yeah otp merepass agee hai, esko verify karna hai;        
                 System.out.println("--->"+otp);
           
            sendemail obj = new sendemail( email,"hello","Your Otp is: "+otp);    // email generate hogi tab eska response bhejo;
            res = new Response(HTTP_OK, "text/plain" ,otp) ;        
               }
           } 
        }
           
            catch (Exception e) 
           {
            e.printStackTrace();  // Yeah Exception Print karvane kai liye, yeah nahi likhe gai code tab bhi chal jayega, but exception nahi ayegi phir;
              
           }
      
    }
    
    else if (uri.equals("/fetchcat")) 
   {
          String ans = " ";
          
        try
        {
          ResultSet rs = DBLoader.executeQuery("select * from category");
             while(rs.next())
            {
             String name = rs.getString("name");
             String photo = rs.getString("photo");
             
             String row = name+ "$" +photo;
              ans =  ans+row + ";;";
             
              // Ab Jo ans Banaya Use return Karo ese:-
              res = new Response(HTTP_OK, "text/plain", ans);   // ans ese vapas bej do
             
            }
          
        }
          catch(Exception e)
          {
           e.printStackTrace();
          }
          
    }
       
       
    
    else if (uri.equals("/AdminLogin"))
    {
       String name = parms.getProperty("name");                    //yeah same vahi client vale hai name aur pass 
       String pass = parms.getProperty("pass"); // name , pass jo client sai aaye uhne String naam ki name aur pass mai store kar liya;
      
       System.out.println("name :" + name + "password :" + pass);    // CHECK KARNE KAI LIYE KI PARAMETERS SAHI AARAHE HAI;
       
       try 
       {
       ResultSet rs = DBLoader.executeQuery("select * from admin where username ='"+name+"'  and password ='"+pass+"'" );  //  jo upar sai name pass get kiye vo database kai username or password mai sai lekar aayo
       
       if(rs.next())
       {
       res = new Response(HTTP_OK, "text/plain", "success");
       }
       else
       {
        res = new Response(HTTP_OK, "text/plain", " Failed");   
       }
    
       }
     
       catch(Exception e)
       {
        e.printStackTrace();
       }
   }       
       
    
      
    else if (uri.equals("/addcat"))  // see it 
    {
      String category = parms.getProperty("category");
      
      // File ph ko save karvane ka code:-
      String name = saveFileOnServerWithRandomName(files, parms, "f1", "src/uploads");         //  "src/uploads" ka matlab "f1" ko esmai save karvana hai
      
        try 
        {
         ResultSet rs = DBLoader.executeQuery("select * from category where name ='"+category+"'");    
        // VERY IMPORTANT
        // NAME, PASSWORD MATCH KARVANE MAI SPACES EXTRA MAT DAALNA VO KYOKI VO SPACES BHI BEECH MAI COUNT KAREGA AUR PHIR MATCH NA HONE PAR LOGIN FAILED AYEGA;
        // ese spaces( = ' " + category+ " ' ");  daalne sai category to add ho jayegi but doobara same category ka name daalne par vo "Category Already Exist" kabhi print nahi karega , kyoki spaces kai karan phir vo "Failed" print hoga 
        // SO, SQL QUERY LIKHTE SPACES KABHI MAT DALO;
        // System.out.println("category: " + category);
        
       if(rs.next())
           {
            res = new Response(HTTP_OK, "text/plain", "exist");
            
           }
        else
           {
           rs.moveToInsertRow();
           rs.updateString("name", category);
           rs.updateString("photo", "src/uploads/"+name);
           rs.insertRow(); 
               System.out.println("category: " + category);
               System.out.println("photopath: " +"src/uploads/"+ name );
           
           res = new Response(HTTP_OK, "text/plain", "success");
           } 
        }
        catch (Exception e) 
        {
            
            
        }
      
      
    } 
      
    
    else if(uri.equals("/fetchcategories"))
    {
     String ans = "";
     
       try 
       {
        ResultSet rs = DBLoader.executeQuery("select name from category");
     
           while (rs.next())                                   // while eseliye kyoki miltiple name hai; and us category table kai name tak pahunche; 
           {
           String name = rs.getString("name");            //name(database mai hai) ki value java kai variable row mai store karvali 
           String row = name;
           ans = ans + row+";;";                               // phir us row ki har ek value ans mai store karvate gaye;
           } 
           
           res = new Response(HTTP_OK,"text/plain", ans);    // jab while khatam hui, phir ans, res mai daal kai myClient ko res return kar diya; 
        } 
        
        catch(Exception e)
        {
            
        }
    }
       
       
    else if(uri.equals("/addmovie"))
    {
        String category  =  parms.getProperty("category");
        String movie     =  parms.getProperty("movie");
        String director  =  parms.getProperty("director");
        String cast      =  parms.getProperty("cast");
        String moviePlot =  parms.getProperty("plot");
        String Imdb      =  parms.getProperty("imdb");
        String id        =  parms.getProperty("id");
       
        String name      = saveFileOnServerWithRandomName(files, parms, "f2", "src/uploads");
        
        // Ab movie Save Karvani Hai ese:-
        // piche sai hame movie_link mil raha hai, yeah line use save kardegi;
        String movie_name = saveFileOnServerWithRandomName(files, parms, "movie_link", "src/uploads/movies/");  // piche sai movie_link naam ki file aa rahi hai jise humnai Random Number kai saath src mai uploads kai andar movies naam kai folder mai save karvaya hai;                                                           
        
        try 
        {
        ResultSet rs = DBLoader.executeQuery("select * from movies");
        
        rs.moveToInsertRow();
        rs.updateString("movie_name", movie);                     // id will Automatically increment; 
        rs.updateString("director", director);                    // upar vale Stirngs ki value ko database ki values sai sath change kardo; 
        rs.updateString("cast", cast);
        rs.updateString("movie_link", "src/uploads/movies/"+movie_name);              // ab movie_link ka path database mai bhi save karo;
        rs.updateString("movieplot",moviePlot);
        rs.updateString("imdb",Imdb );
        rs.updateString("trailer", id);
        rs.updateString("photo", "src/uploads/" + name);
        rs.updateString("category", category);
        rs.insertRow();
        
        res = new Response(HTTP_OK,"text/plain", "success");
        
        } 
        
        catch (Exception e) 
        { 
         res = new Response(HTTP_OK,"text/plain", e.toString());
        }
    } 
      
      
    else if (uri.equals("/fetchmovies"))
    {   
        String ans ="";
        String category = parms.getProperty("category");   //category sai beja tha sai, category kai naam sai store kiya;
        
        try                                           // try catch is used so aql instruction na aaye;
        {
           //ResultSet rs = DBLoader.executeQuery("select * from movies where category='"+category.trim()+"'");
            ResultSet rs = DBLoader.executeQuery("select * from movies where category='"+category+"'");
           while(rs.next())
           {
               
              // ("select * from movies where category='"+category+"'");
            int id = rs.getInt("id");                 // database ki value java kai id int variable mai store karvali;                          
            String name = rs.getString("movie_name");
            String photo =rs.getString("photo"); 
            
            String row = id+"$"+name+"$"+photo; 
            ans = ans+row+";;"; 
             
           }
           res = new Response(HTTP_OK, "text/plain", ans);
           
           
           // System.out.println(ans); 
        } 
        
        catch (Exception e) 
        {
         e.printStackTrace();
         res = new Response(HTTP_INTERNALERROR, "text/plain", "Internal Server Error");
            
        }
    }
       
       
    else if (uri.equals("/moviedetails"))
    {
     int id = Integer.parseInt(parms.getProperty("id"));    // id as string aayi hai to use integer mai convert karo kyoki database mai sai yeah integer hi search karna hai;
        try 
        {
            
        ResultSet rs = DBLoader.executeQuery("select * from movies where id="+id);    // id integer hai to uske liye Single quotes nahi chaiye;
        if(rs.next())
           {
            String name =     rs.getString("movie_name");
            String cast =     rs.getString("cast");
            String director=  rs.getString("director");
            String movieplot = rs.getString("movieplot");
            String imdb    = rs.getString("imdb");
            String youtube_id = rs.getString("trailer");                 // yeah sari green color strings es naam sai database mai store hai, ese naam sai get honge;
            String photo = rs.getString("photo");
            String movie_link= rs.getString("movie_link");    // jis order mai daal rahe hai use order mai tokenizer nai get karna hai;
            
            
            
            String ans =name+"$"+cast+"$"+director+"$"+ movieplot+"$"+imdb+"$"+youtube_id+"$"+photo+"$"+movie_link;
                    
            res = new Response(HTTP_OK, "text/plain", ans);
           }
//        else 
//           {
//           res = new Response(HTTP_OK, "text/plain", "Failed");
//           }
        } 
        
        catch (Exception e) 
        {
        e.printStackTrace();
        }
 
     
     
     
     
     
     
     
    }
     
      
      
    else if (uri.equals("/search"))
    {   
        String ans = "";
        String name = parms.getProperty("name");
        
        try 
        { 
         ResultSet rs = DBLoader.executeQuery("select * from movies where movie_name like '"+name+ "%'");                        // read like query from w3schools
         
         while(rs.next())
           {
            int id = rs.getInt("id");                 // database ki value java kai id int variable mai store karvali;                          
            String name1 = rs.getString("movie_name");
            String photo =rs.getString("photo"); 
            
            String row = id+"$"+name1+"$"+photo; 
            ans = ans+row+";;"; 
             
           }
           res = new Response(HTTP_OK, "text/plain", ans);
           
           
           // System.out.println(ans); 
        } 
        
        
        catch (Exception e) 
        {
       
        }
    }
      
    else if (uri.equals("/otp_for_reset"))
    {
    String useremail1 = parms.getProperty("email");
    
    try
    {
    ResultSet rs = DBLoader.executeQuery("select * from users where useremail='"+useremail1+"'");
     
        if(rs.next())
        {
            String otp =  (int) (1000+(9999-1000)*Math.random())+"";    // yeah otp merepass agee hai, esko verify karna hai;        
            System.out.println("--->"+otp);
           
            sendemail obj = new sendemail( useremail1,"Reset your Password", "To authenticate, please use the following One Time Password(OTP):"+otp + "   Don't share this OTP with anyone. Our customer service team will never ask you for your password, OTP, credit card, or banking info.\n" +
"\n" + "We hope to see you again soon " );    // email generate hogi tab eska response bhejo;
            
            res = new Response(HTTP_OK, "text/plain" ,otp) ;        
        }
        
                                                                        //  "hello","Your Otp is: "+otp);
        else
        {
        res = new Response(HTTP_OK, "text/plain" ,"email_does_not_exist");    
        }
            
    }   
    catch (Exception e) 
    {
       
    e.printStackTrace();
    }
   
   }
      
      else if (uri.equals("/change_password"))
      {
       String change_password = parms.getProperty("newpassword"); 
       String user_email      = parms.getProperty("useremail");
          try 
          {
          ResultSet rs = DBLoader.executeQuery("select * from users where useremail='"+user_email+"'");
             if (rs.next())                             // jab vo row found ho gayi;
             {  
                String previous_password= rs.getString("password");
                if(previous_password.equals(change_password))     // agar purana aur new password same hai
                {
                res = new Response(HTTP_OK, "text/plain", "same_previous_password");   
                }
                else
                {                                                 // change karo password
                 rs.updateString("password",change_password); 
                 rs.updateRow();
             
                res = new Response(HTTP_OK, "text/plain","updated");
                }
             }
             else                                    
             {
             res = new Response(HTTP_OK, "text/plain" ,"password_not_updated");    
             }  
              
              
          } 
          catch (Exception e) 
          { 
          e.printStackTrace();
          }
          }
      
      
       else if (uri.equals("/otp_for_adminpassword_reset"))
    {
    String useremail1 = parms.getProperty("email");
    
    try
    {
    ResultSet rs = DBLoader.executeQuery("select * from admin where useremail='"+useremail1+"'");
     
        if(rs.next())
        {
            String otp =  (int) (1000+(9999-1000)*Math.random())+"";    // yeah otp merepass agee hai, esko verify karna hai;        
            System.out.println("--->"+otp);
           
            sendemail obj = new sendemail( useremail1,"Reset your Password", "To authenticate, please use the following One Time Password(OTP):/n"+otp + "/n Don't share this OTP with anyone. Our customer service team will never ask you for your password, OTP, credit card, or banking info.\n" +
            "\n" + "We hope to see you again soon " );    // email generate hogi tab eska response bhejo;
            
            res = new Response(HTTP_OK, "text/plain" ,otp) ;        
        }
        
                                                                        //  "hello","Your Otp is: "+otp);
        else
        {
        res = new Response(HTTP_OK, "text/plain" ,"email_does_not_exist");    
        }
            
    }   
    catch (Exception e) 
    {
       
    e.printStackTrace();
    }
   
   }
      
      
      else if (uri.equals("/changeadmin_password"))
      {
          String admin_user_email      = parms.getProperty("useremail");
          String admin_change_password = parms.getProperty("newpassword"); 
       
          try 
          {
          ResultSet rs = DBLoader.executeQuery("select * from admin where useremail='"+admin_user_email+"'");
             if (rs.next())                             // jab vo row found ho gayi;
             {  
                String previous_password= rs.getString("password");
                if(previous_password.equals(admin_change_password))     // agar purana aur new password same hai
                {
                res = new Response(HTTP_OK, "text/plain", "same_previous_password");   
                }
                else
                {                                                 // change karo password
                 rs.updateString("password",admin_change_password); 
                 rs.updateRow();
             
                res = new Response(HTTP_OK, "text/plain","updated");
                }
             }
             else                                    
             {
             res = new Response(HTTP_OK, "text/plain" ,"password_not_updated");    
             }  
              
              
          } 
          catch (Exception e) 
          { 
          e.printStackTrace();
          }
          }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
       
       return res;
       } 
    
}
 

 /*  
    public static void main(String[] args) 
    {
    
    
       try
       {
       myServer obj = new myServer(9000);
       Thread.sleep(10000000);    // HUM NAHI CHAHTE KI SERVER CHALTE HI BAND HO JAYE;
                                     // 1000 milli Seconds == 1 Second
                                     
       
       }
       catch (Exception e)
       {
        e.printStackTrace();
       }
          
    }
 
}
   
   public static void main(String[] args) 
    {
       try
       {
       myServer obj = new myServer(9000);
       Thread.sleep(10000000);    // HUM NAHI CHAHTE KI SERVER CHALTE HI BAND HO JAYE;
                                     // 1000 milli Seconds == 1 Second
       }
       catch (Exception e)
       {
        e.printStackTrace();
       }
          
    }
 */

