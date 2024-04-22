/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.detector;

/**
 *
 * @author hoshi
 */
public class Detector {

    public static void main(String[] args) {
        
        InvernaderoDAO pruebaInvernadero = new InvernaderoDAO();
        SensorDAO pruebaSensor = new SensorDAO();
        AlarmaDAO pruebaAlarma = new AlarmaDAO();
        
        System.out.println(pruebaInvernadero.colsultar());
        System.out.println(pruebaSensor.colsultar());
        System.out.println(pruebaAlarma.colsultar());
        
    }
}
