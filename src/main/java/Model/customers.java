/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Darwin Solano
 */
public class customers {
    
    //Variables
    private int id;
    private String numero_identificacion;
    private String nombre;
    private String telefono;
    private String email;
    private String cargo;

    public customers() {
    }

    public customers(String numero_identificacion, String nombre, String telefono, String email, String cargo) {
        this.numero_identificacion = numero_identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "customers{" + "numero_identificacion=" + numero_identificacion + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", cargo=" + cargo + '}';
    } 
    
}
