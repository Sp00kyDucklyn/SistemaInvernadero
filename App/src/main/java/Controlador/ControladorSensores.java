/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import dominio.Sensor;
import java.util.List;

/**
 *
 * @author diego
 */
public class ControladorSensores {
    public String getOpcionesSensores() {
        ManagerSensores manager = new ManagerSensores();
        List<Sensor> sensor = manager.obtenerTodosLosSensores();
        manager.close();
        
        StringBuilder opciones = new StringBuilder();
        for (Sensor sensorito : sensor) {
            opciones.append("<option value=\"").append(sensorito.getIdSensor()).append("\">")
                    .append(sensorito.getClaveSensor()).append("</option>");
        }
        
        return opciones.toString();
    }
}
