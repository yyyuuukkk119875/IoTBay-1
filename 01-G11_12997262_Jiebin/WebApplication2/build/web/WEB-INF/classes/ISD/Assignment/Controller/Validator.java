  package ISD.Assignment.Controller;

   import java.io.Serializable;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
   import javax.servlet.http.HttpSession; 


   public class Validator implements Serializable{ 

 
   private String datePattern = "([0-9]{4})(-)([0-9]{2})(-)([0-9]{2})";      
   private String intPattern = "([0-9]*)";            
              
   public Validator(){    }       


   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       

   
   public boolean validateDate(String date){                       

      return validate(datePattern,date);   

   }

       
   public boolean validateInt(String ID){

      return validate(intPattern,ID); 

   }       
   
  
   
   public void clear(HttpSession session){
    
   }
}


