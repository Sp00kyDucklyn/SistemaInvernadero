/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.persistence.*;

@Entity
@Table(name = "alarmas")
public class Alarma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlarma;

    @Column(nullable = false)
    private double limiteHumedad;

    @Column(nullable = false)
    private double limiteTemperatura;

    @OneToOne(mappedBy = "alarma")
    private Sensor sensor;

    // Constructores, getters y setters

    public Alarma() {
        
    }

    public Alarma(double limiteHumedad, double limiteTemperatura, Sensor sensor) {
        this.limiteHumedad = limiteHumedad;
        this.limiteTemperatura = limiteTemperatura;
        this.sensor = sensor;
    }

    public Long getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(Long idAlarma) {
        this.idAlarma = idAlarma;
    }

    public double getLimiteHumedad() {
        return limiteHumedad;
    }

    public void setLimiteHumedad(double limiteHumedad) {
        this.limiteHumedad = limiteHumedad;
    }

    public double getLimiteTemperatura() {
        return limiteTemperatura;
    }

    public void setLimiteTemperatura(double limiteTemperatura) {
        this.limiteTemperatura = limiteTemperatura;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}