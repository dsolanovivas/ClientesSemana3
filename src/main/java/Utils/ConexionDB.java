/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Darwin Solano
 */
public class ConexionDB {
    
    	public static final String URL = "jdbc:mysql://localhost:3306/market";
        public static final String USER = "root";
        public static final String CLAVE = "Root2022mysql";
        
        public Connection getConexion(){
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
                System.out.println("Connected database successfully!!!");
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Error: " + e.getMessage());
            }   
        return con;
    }

}
