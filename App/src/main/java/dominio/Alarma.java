/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author diego
 */
public class Alarma {
    private long idAlarma;
    private double limiteHumedad;
    private double limiteTemperatura;

    public Alarma() {
    }

    public Alarma(double limiteHumedad, double limiteTemperatura) {
        this.limiteHumedad = limiteHumedad;
        this.limiteTemperatura = limiteTemperatura;
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

   
}
