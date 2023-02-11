/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.marketcustomers;
import View.Customers;

/**
 *
 * @author Darwin Solano
 */
public class MarketCustomers {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        try {
            Customers Client = new Customers();
            Client.setVisible(true);
        }
        catch(Exception e){
            System.out.println("Upss! Problemas : "+ e.getMessage());
        }
    }
}
