/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.invernadero.fachada;

import DominioDatos.Datos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface IFachada {
    
    public Datos agregarDatos(Datos dato);
    
    public List<Datos> obtenerDatos();
    
    public List<Datos> obtenerDatosPorIdSensor(String idSensor);
    
    public List<Datos> obtenerDatosPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    
}
