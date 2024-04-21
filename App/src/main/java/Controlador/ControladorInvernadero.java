/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import entidades.Invernadero;
import java.util.List;

/**
 *
 * @author diego
 */
public class ControladorInvernadero {
    public String getOpcionesInvernaderos() {
        ManagerInvernadero manager = new ManagerInvernadero();
        List<Invernadero> invernaderos = manager.obtenerTodosLosInvernaderos();
        manager.close();
        
        StringBuilder opciones = new StringBuilder();
        for (Invernadero invernadero : invernaderos) {
            opciones.append("<option value=\"").append(invernadero.getId_invernadero()).append("\">")
                    .append(invernadero.getNombre()).append("</option>");
        }
        
        return opciones.toString();
    }
}
