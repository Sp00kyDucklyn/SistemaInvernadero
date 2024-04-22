/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DominioDetector;

import java.time.LocalDateTime;

/**
 *
 * @author hoshi
 */
public class Sensor {
    
    private long id; // Identificador único del sensor
    private String idSensor;
    private String clave_sensor;
    private String marca;
    private long id_invernadero;
    private long id_alarma;

    public Sensor() {
    }

    public Sensor(long id, String idSensor, String clave_sensor, String marca, long id_invernadero, long id_alarma) {
        this.id = id;
        this.idSensor = idSensor;
        this.clave_sensor = clave_sensor;
        this.marca = marca;
        this.id_invernadero = id_invernadero;
        this.id_alarma = id_alarma;
    }
    
    public Sensor(String idSensor, String clave_sensor, String marca, long id_invernadero, long id_alarma) {
        this.idSensor = idSensor;
        this.clave_sensor = clave_sensor;
        this.marca = marca;
        this.id_invernadero = id_invernadero;
        this.id_alarma = id_alarma;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    public String getClave_sensor() {
        return clave_sensor;
    }

    public void setClave_sensor(String clave_sensor) {
        this.clave_sensor = clave_sensor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getId_invernadero() {
        return id_invernadero;
    }

    public void setId_invernadero(long id_invernadero) {
        this.id_invernadero = id_invernadero;
    }

    public long getId_alarma() {
        return id_alarma;
    }

    public void setId_alarma(long id_alarma) {
        this.id_alarma = id_alarma;
    }

    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", idSensor=" + idSensor + 
                ", clave_sensor=" + clave_sensor + ", marca=" + marca 
                + ", id_invernadero=" + id_invernadero + ", id_alarma=" 
                + id_alarma + '}';
    }

}
