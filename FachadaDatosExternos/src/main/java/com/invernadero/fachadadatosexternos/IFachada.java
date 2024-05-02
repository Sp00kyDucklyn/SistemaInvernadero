package com.invernadero.fachadadatosexternos;

import DominioDatos.Datos;
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
