/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DominioDatos;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author oscar
 */
public class Datos {

    public long id; // Identificador único del sensor
    private String idSensor;
    private String tipoSensor; // Tipo de sensor (por ejemplo, sensor de humedad o sensor de temperatura)
    private double medidaHumedad; // Medida de humedad capturada por el sensor
    private double medidaTemperatura; // Medida de temperatura capturada por el sensor
    private LocalDateTime fechaHora; // Fecha y hora en que se capturaron los datos
    private String marcaSensor; // Marca del sensor que capturó los datos

    public Datos() {
    }

    public Datos(long id, String idSensor, String tipoSensor, double medidaHumedad, double medidaTemperatura, LocalDateTime fechaHora, String marcaSensor) {
        this.id = id;
        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.medidaHumedad = medidaHumedad;
        this.medidaTemperatura = medidaTemperatura;
        this.fechaHora = fechaHora;
        this.marcaSensor = marcaSensor;
    }

    public Datos(String idSensor, String tipoSensor, double medidaHumedad, double medidaTemperatura, LocalDateTime fechaHora, String marcaSensor) {
        this.idSensor = idSensor;
        this.tipoSensor = tipoSensor;
        this.medidaHumedad = medidaHumedad;
        this.medidaTemperatura = medidaTemperatura;
        this.fechaHora = fechaHora;
        this.marcaSensor = marcaSensor;
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

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public double getMedidaHumedad() {
        return medidaHumedad;
    }

    public void setMedidaHumedad(double medidaHumedad) {
        this.medidaHumedad = medidaHumedad;
    }

    public double getMedidaTemperatura() {
        return medidaTemperatura;
    }

    public void setMedidaTemperatura(double medidaTemperatura) {
        this.medidaTemperatura = medidaTemperatura;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMarcaSensor() {
        return marcaSensor;
    }

    public void setMarcaSensor(String marcaSensor) {
        this.marcaSensor = marcaSensor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Datos{" + "id=" + id + ", idSensor=" + idSensor
                + ", tipoSensor=" + tipoSensor + ", medidaHumedad="
                + medidaHumedad + ", medidaTemperatura=" + medidaTemperatura
                + ", fechaHora=" + fechaHora + ", marcaSensor=" + marcaSensor + '}';
    }
}
