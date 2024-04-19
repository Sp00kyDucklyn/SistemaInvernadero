/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao_sensores;

import DominioDatos.Datos;
import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * @author oscar
 */
public interface IDatos {
    public Datos agregarDatos(Datos datos);
    public List<Datos> obtenerDatos();
    public List<Datos> obtenerDatosPorIdSensor(String idSensor);
    public List<Datos> obtenerDatosPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
}
