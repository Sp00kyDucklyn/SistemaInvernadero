/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DominioDetector;

/**
 *
 * @author hoshi
 */
public class Invernadero {
    
    private long idInvernadero; 
    private String direccion;
    private String nombre;

    public Invernadero() {
    }

    public Invernadero(long idInvernadero, String direccion, String nombre) {
        this.idInvernadero = idInvernadero;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Invernadero(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public long getIdInvernadero() {
        return idInvernadero;
    }

    public void setIdInvernadero(long idInvernadero) {
        this.idInvernadero = idInvernadero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Invernadero{" + "idInvernadero=" + idInvernadero
                + ", direccion=" + direccion + ", nombre=" + nombre + '}';
    }
    
}
