/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "sensores")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSensor;

    @Column(name = "clave_sensor", nullable = false)
    private String claveSensor;

    @Column(nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "id_invernadero")
    private Invernadero invernadero;

    @OneToOne
    @JoinColumn(name = "id_alarma")
    private Alarma alarma;

    // Constructores, getters y setters

    public Sensor() {
        
    }
    
    public Sensor(String claveSensor, String marca) {
        this.claveSensor = claveSensor;
        this.marca = marca;   
    }

    public Sensor(String claveSensor, String marca, Invernadero invernadero, Alarma alarma) {
        this.claveSensor = claveSensor;
        this.marca = marca;
        this.invernadero = invernadero;
        this.alarma = alarma;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public String getClaveSensor() {
        return claveSensor;
    }

    public void setClaveSensor(String claveSensor) {
        this.claveSensor = claveSensor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Invernadero getInvernadero() {
        return invernadero;
    }

    public void setInvernadero(Invernadero invernadero) {
        this.invernadero = invernadero;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
}