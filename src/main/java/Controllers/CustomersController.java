/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.customers;
import Utils.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darwin Solano
 */
public class CustomersController {
    
    ConexionDB con = null;

    public CustomersController() {
        
        con = new ConexionDB();
    }
    
    public List<customers> getClientes(){
        
        List<customers> clientes = new ArrayList<>();  
        
        Statement statement;
        try {
            statement = con.getConexion().createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, numero_identificacion, nombre, telefono, email, profesion FROM customers");
        
            while (rs.next()) {
                int id = rs.getInt("id");
                String numero_identificacion = rs.getString("numero_identificacion");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String cargo = rs.getString("profesion");
                clientes.add(new customers(numero_identificacion, nombre, telefono, email, cargo));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public customers getCliente(String idCliente){
        
        customers cliente = new customers();  
       
        PreparedStatement statement;
        try {
            statement = con.getConexion().prepareStatement("SELECT id, numero_identificacion, nombre, telefono, email, profesion FROM customers WHERE numero_identificacion = ? ");
            statement.setString(1, idCliente);    
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
 
                cliente.setId(rs.getInt("id"));
                cliente.setNumero_identificacion(rs.getString("numero_identificacion"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCargo(rs.getString("profesion"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
    public int insertCliente(customers cliente){
        int row = 0;
        PreparedStatement statement;
        try {
            statement = con.getConexion().prepareStatement("INSERT INTO customers (numero_identificacion, nombre, telefono, email, profesion) VALUES (?,?,?,?,?)");
            statement.setString(1, cliente.getNumero_identificacion());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getTelefono());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getCargo());
            row = statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    public int editCliente(customers cliente){
        int row = 0;
        PreparedStatement statement;
        try {
            statement = con.getConexion().prepareStatement("UPDATE  customers SET nombre = ?, telefono = ?, email = ?, profesion = ? WHERE numero_identificacion = ?");
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getTelefono());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getCargo());
            statement.setString(5, cliente.getNumero_identificacion());
            row = statement.executeUpdate();
            statement.close();  
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    public int deleteCliente(String idCliente){
        int row = 0;
        PreparedStatement statement;
        try {
            statement = con.getConexion().prepareStatement("DELETE FROM customers WHERE numero_identificacion = ?");
            statement.setString(1, idCliente);
            row = statement.executeUpdate();
            statement.close();  
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
