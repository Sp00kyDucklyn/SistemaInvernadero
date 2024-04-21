/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author diego
 */
public class Sensor {
    private long idSensor;
    private String claveSensor;
    private String marca;
    private long invernadero;
    private long alarma;

    public Sensor() {
    }

    public Sensor(String claveSensor, String marca) {
        this.claveSensor = claveSensor;
        this.marca = marca;
    }

    public Sensor(String claveSensor, String marca, long invernadero) {
        this.claveSensor = claveSensor;
        this.marca = marca;
        this.invernadero = invernadero;
    }

    public Sensor(String claveSensor, String marca, long invernadero, long alarma) {
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

    public long getInvernadero() {
        return invernadero;
    }

    public void setInvernadero(long invernadero) {
        this.invernadero = invernadero;
    }

    public long getAlarma() {
        return alarma;
    }

    public void setAlarma(long alarma) {
        this.alarma = alarma;
    }
}
