/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "invernaderos")
public class Invernadero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_invernadero;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL)
    private List<Sensor> sensores;

    // Constructores, getters y setters

    public Invernadero(){
        
    }
    public Invernadero(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.sensores= new ArrayList<>();
    }

    public Long getId_invernadero() {
        return id_invernadero;
    }

    public void setId_invernadero(Long id_invernadero) {
        this.id_invernadero = id_invernadero;
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

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }
}
