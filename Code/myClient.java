
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.File;

//AB  ES CLASS MAI SARE FUNCTIONS LIKHTE YAHA SAI CALL KARTE JAYENGE;
// YEAH ESELIYE BANAYI HAI TAAKI YAHI SAI SARI REQUEST BHEJE SERVER PAR AUR RESPONSE MANGVAYE;
//J0 RESPONSE AYEGA USE PRINT KARE;
// import com.mashape.Unirest.http.*; YEAH IMPORT KYO NAHI CHAL RAHA ?

// SIDHA GUI SAI BHI BHI SERVER PAI REQUEST BEJ SAKTE THAI BUT VAISE KHLEDA BAHUT PAD JAYEGA,
// AUR CODE CLEAN RAKHNE KAI LIYE SARE FUNCTIONS YAHA PAI DEFINE KIYE,
// AGAR KAL KO KOI PROBLEM HUI TO YAHA SAI FUNCTIONS THIK KARLENGE;


public class myClient 
{
    public static String fetchIndex()
 {
     String url = "http://localhost:9000/one";
     try
     {
     HttpResponse<String> res = Unirest.get(url).asString(); 
     // .asstring esiliye laga kyoki jo url hai vo khud string hai to use sidha asString save karenge. 
     // .toString eseliye lagta agar url String na hota aur use String mai convert karna hota, vo response hai string mai convert hoga bhi nahi, kal ko parameter add karvaye to vo bhi .asString jaye;
     if (res.getStatus()==200)
     {
         String ans = res.getBody(); // String mai save karo kyoki response res khud string hai;
         return ans;
     }
     
     
     }
     catch(Exception e)
     {
      e.printStackTrace();
      // YEAH BINA LIKHE BHI CHAL JAYEGA :-
      //return e.toString();
     }
    return "error aaya bhai" ;
 }

    public static String userLogin(String username, String password) 
      // GUI MAI USERNAME OR PASSWORD PASS KARENGE AUR YAHA PAR GET KARENGE,
      // AB YEAH PARAMETER MAI ATTACH KARKE AAGE SERVER PAI BHEJNE HAI SO USE QUERY STRING,
      // SERVER EN KI VALUES KO CHECK KAREGA AGAR MATCH KI DATABASE KI VALUES KAI SAATH TO SUCCESS return hoga;
    { 
        
        try
     {
          String url = "http://localhost:9000/userlogin";
           HttpResponse<String> res = Unirest.get(url)
             .queryString("username",username) // name means kis name sai aage bhejne hai, value means unki value kya hogi;
             .queryString("password" , password)
             .asString(); 
     if(res.getStatus()==200) // this condition check server chal raha hai; VAISE ES CONDITION KAI BINA BHI CHAL JAYEGA;
     {
         String ans = res.getBody(); // String mai save karo kyoki response res khud string hai;
         return ans;
     }
     }
     catch(Exception e)
     {
      e.printStackTrace();
      
     }
            
 
 return "error aaya bhai";  //String return type upar declare ki hai to yaha bhi string return karenge;
 
 }      
         
     public static String usersignup_GUI(String email, String pass, String mobile, String address, File ph)
     {   
         // jab usersignup_GUI mai yeah function call hua uske sare parameters ki value yaha String aur File mai store hai;  
         try
         {
          String url = "http://localhost:9000/usersignup"; 
          HttpResponse<String> res = Unirest.post(url)
                  .queryString("email",email)    // ES name sai agge dusri class mai bhejo, aur yeah uski value hai jo upar usersignup_GUI sai aayi hai;
                  .queryString("pass",pass)
                  .queryString("mobile", mobile)
                  .queryString("address", address)
                  .field("f1", ph)
                  .asString();
          if(res.getStatus()==200)
           {
             return res.getBody();            // THIS RETURN VALUE TO usersignup_GUI which again stores in answer;
           
           }
         }
         catch(Exception e)
         {
             return e.toString();
             
         }
         return"error";
    }  
     
     
    public static String verifyEmail(String Email, String mobile)
    {
     String url = "http://localhost:9000/verifyEmail"; 
     // AGAR ESKO TRY KAI ANDAR DAAL DIYA TO YEAH GLOBAL NAHI RAHEGA , PHIR CATCH KAI LIYE DOOBARA LIJHNA PADEGA;
     try
     {
        HttpResponse<String> res = Unirest.get(url)
             .queryString("email", Email)
             .queryString("mobile", mobile)
             .asString();
     
     if( res.getStatus()==200)   // OK Status
     {
        return res.getBody(); //                       JO response aaya use return karna hai;
     }
       
     }
     
     catch (Exception e)
     {
       return e.toString();
     }
    
      // else likho ya phir sidha e return kardo;
      return null;
     }

public static String fetchcat()
{
    String url ="http://localhost:9000/fetchcat";
    try
    {
        
    
    HttpResponse<String> res = Unirest.get(url).asString();              // YEAH LINE SERVER PAI LEKE JAYEGI;
      if (res.getStatus()==200)
      {
       return res.getBody();
      }
      else
      {
      return "server error";   
      }
    }
  
      
    
    
    catch(Exception e) 
    {
      return e.toString();                                      // yeah return nahi likhenge to error hai; 
    }
    
}   
   

public static String AdminLogin(String name, String pass)
{
 String url = "http://localhost:9000/AdminLogin";
 
    try
    {
     HttpResponse<String> res = Unirest.get(url)
             .queryString("name", name)               // yeah name or pass AdminLogin gui sai aaye hai
             .queryString("pass", pass)
             .asString(); 
         System.out.println("name =" +name+ " password =" + pass  );
        if (res.getStatus()==200)
        {
           return res.getBody(); 
           
        }
        else 
        {
         return "Server Error";
        }
    }
         
  
    catch(Exception e)
    {
    return e.toString();
    
    }    
}
    
    
 
public static String addcat(String category, File ph)   // JO YAHA SAI category or ph aaya humnne use "f1" or "category" naam dai diya and hum ese naam sai myServer pai get karenge
{
  String url = "http://localhost:9000/addcat";
  try
   {
  HttpResponse <String> res = Unirest.post(url)
          .queryString("category", category)  
          .field("f1", ph)
          .asString();
    
    if( res.getStatus()==200)
       {
        return res.getBody();
       }
    else
       {
        return "Server Error in Adding Category";  // compiler bolega agar if nahi chali to kya return karoge;
       }
    
   }
  
  catch(Exception e) 
   {
    return e.toString();  
   }
}

   public static String fetchcategories()
   { 
    // YEAH FUNCTION COMBO BOX KAI ANDAR categories lekar ayega karvaega;
       
    String url = "http://localhost:9000/fetchcategories";   // es mai bhi space mat do;
    try
    {
    HttpResponse<String> res = Unirest.get(url).asString();  // es url ki value res mai jayegi;
    
       if( res.getStatus()== 200)
       {
       return res.getBody(); 
       }
       
       else 
       {
        return "Server Error in Fetching Categories";   
       }
    }
    
    catch(Exception e)
    {
     return e.toString();       
    }   
   
}     
        
   
public static String addmovie(String category, String movie, String director, String cast, String plot, String imdb, String id, File ph, File movie_link )
{
 String url = "http://localhost:9000/addmovie";
    try 
    {
    HttpResponse<String> res = Unirest.post(url)
            .queryString("category", category)        // ab yaha pai value upar value function ki same value ayegi na ki pichle gui kai function ki value;
            .queryString("movie", movie)
            .queryString(" director", director)
            .queryString("cast", cast)
            .queryString("plot",plot)
            .queryString("imdb",imdb)
            .queryString("id", id)
            .field("f2", ph)
            .field("movie_link", movie_link)
            .asString();
    
    
        if(res.getStatus()==200)
        {
          return res.getBody();
        }
        else
        {
            return " Server Error in Adding Movie";
        }
    
    } 
    
    catch (Exception e) 
    {
     return e.toString();   
    }
 
}        
    


public static String fetchmovies(String category)                                   // eska matlab agar action ki movies bola to vahi lai kai aayo aur koi category ki nahif;
   {
    String url = "http://localhost:9000/fetchmovies";
       try 
       {
            HttpResponse<String> res = Unirest.get(url)
                .queryString("category",category)
                .asString();
            if(res.getStatus()==200) 
            {
               return res.getBody();
            }
            else
            {
               return "Server Error in Fetching Movies From Particular Category";   
            }
          
            
            
//              public class MovieFetchException extends Exception {
//    public MovieFetchException(String message) {
//        super(message);
//    }
//}
//           else {
//            throw new MovieFetchException("Server Error in Fetching Movies From Particular Category");
//        }        
        }  
       
        catch (Exception e) 
       {
         return e.toString();      
       }
//       catch (UnirestException e) {
//        return "Error in HTTP request: " + e.getMessage();
//    } catch (Exception e) {
//        return "An unexpected error occurred: " + e.toString();
//    }
    }


   public static String moviedetail(int id)
   {
       String url = "http://localhost:9000/moviedetails";
       
       try 
       {
        HttpResponse<String> res = Unirest.get(url)
                .queryString("id", id)  
                .asString();
        
        if( res.getStatus()==200)
           {
            return res.getBody();
           }
        else
           {
            return "Server Error in Fetching Single Movie Detail";
           }
        
        
        
       } catch (Exception e) 
       {
        return e.toString();                  // esai exception return  hogi, e.printStackTrace(); sai exception return hogi,phir bahar aake null return kar sakte hai;
       } 

   }
       
     
   public static String search(String name) 
   {
    String url = "http://localhost:9000/search";   
    
     try 
       {
        HttpResponse<String> res = Unirest.get(url)
                .queryString("name", name)
                .asString();
        
        if( res.getStatus()==200)
           {
            return res.getBody();
           }
        else 
        {
            return " Server Search Bar Error";
        }
       }
        catch(Exception e)
        {
        e.printStackTrace();
        }
     return null;                         // String accepts null;
   }   
    
   public static String verify_email_for_reset(String Email)
   {
       
   
       String url ="http://localhost:9000/otp_for_reset";
   
   try
   {
    HttpResponse<String> res = Unirest.get(url)
                .queryString("email", Email)
                .asString();
   
        if(res.getStatus()==200)
        {
            return res.getBody();
        }
        else 
        {
            return "Password Reset Error";
        }
    }
    catch(Exception e )
   {
    return e.toString();
   }
   
 } 
   
    public static String changepassword(String user_email,String new_password)
    {
      
    String url ="http://localhost:9000/change_password";
   try
   {
    HttpResponse<String> res = Unirest.get(url)
                .queryString("newpassword", new_password)
                .queryString("useremail", user_email)  
                .asString();
   
        if( res.getStatus()==200)
        {
            return res.getBody();
        }
        else 
        {
            return "Change password error";
        }
    }
   catch(Exception e )
   {
    return e.toString();
   }    
        
   }
        
   
    
       public static String verify_email_for_adminpassword_reset(String Email)
   {
       
   
       String url ="http://localhost:9000/otp_for_adminpassword_reset";
   
   try
   {
    HttpResponse<String> res = Unirest.get(url)
                .queryString("email", Email)
                .asString();
   
        if(res.getStatus()==200)
        {
            return res.getBody();
        }
        else 
        {
            return "Password Reset Error";
        }
    }
    catch(Exception e )
   {
    return e.toString();
   }
   
 } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
   
      public static String changeadmin_password(String user_email,String new_password)
    {
      
    String url ="http://localhost:9000/changeadmin_password";
   try
   {
    HttpResponse<String> res = Unirest.get(url)
                
                .queryString("useremail", user_email)
                .queryString("newpassword", new_password)
                .asString();
   
        if( res.getStatus()==200)
        {
            return res.getBody();
        }
        else 
        {
            return "Change password error";
        }
    }
   catch(Exception e )
   {
    return e.toString();
   }    
        
   }
   
   
   
   
   
   
   
}        
        
        
//    public static void main(String[] args) {
//        
//    }




