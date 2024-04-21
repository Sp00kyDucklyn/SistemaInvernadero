/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author diego
 */
public class Invernadero {
    private long idInvernadero;
    private String direccion;
    private String nombre;

    public Invernadero() {
    }

    public Invernadero(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Long getIdInvernadero() {
        return idInvernadero;
    }

    public void setIdInvernadero(Long idInvernadero) {
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

    
}

