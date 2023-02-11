package Utils;

import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Darwin Solano
 */
public class EmailValidation {
    
    public static boolean isValid(String email){  
        String emailFormate ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."  
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";  
          
        Pattern p = Pattern.compile(emailFormate);  
        if(email == null){  
        return false;  
        }   
        return p.matcher(email).matches();  
    } 
    
}
