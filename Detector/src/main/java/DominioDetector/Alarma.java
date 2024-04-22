/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DominioDetector;

/**
 *
 * @author hoshi
 */
public class Alarma {
    
    private long id; // Identificador único del sensor
    private String idAlarma;
    private double limite_humedad;
    private double limite_temperatura;

    public Alarma() {
    }

    public Alarma(long id, String idAlarma, double limite_humedad, double limite_temperatura) {
        this.id = id;
        this.idAlarma = idAlarma;
        this.limite_humedad = limite_humedad;
        this.limite_temperatura = limite_temperatura;
    }

    public Alarma(String idAlarma, double limite_humedad, double limite_temperatura) {
        this.idAlarma = idAlarma;
        this.limite_humedad = limite_humedad;
        this.limite_temperatura = limite_temperatura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(String idAlarma) {
        this.idAlarma = idAlarma;
    }

    public double getLimite_humedad() {
        return limite_humedad;
    }

    public void setLimite_humedad(double limite_humedad) {
        this.limite_humedad = limite_humedad;
    }

    public double getLimite_temperatura() {
        return limite_temperatura;
    }

    public void setLimite_temperatura(double limite_temperatura) {
        this.limite_temperatura = limite_temperatura;
    }

    @Override
    public String toString() {
        return "Alarma{" + "id=" + id + ", idAlarma=" + idAlarma + 
                ", limite_humedad=" + limite_humedad + ", limite_temperatura=" 
                + limite_temperatura + '}';
    }
    
    
    
}
