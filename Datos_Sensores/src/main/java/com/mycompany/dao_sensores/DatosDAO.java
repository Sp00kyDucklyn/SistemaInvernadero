/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao_sensores;

import DominioDatos.Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class DatosDAO implements IDatos {

    private String url;
    private String usuario;
    private String contraseña;

    public DatosDAO() {
    }

    public DatosDAO(String host, String puerto, String bd, String usuario, String contraseña) {
        this.url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    private Connection conexion() throws SQLException {
        System.out.println(url);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
        }
        return DriverManager.getConnection(url, usuario, contraseña);
    }

    @Override
    public Datos agregarDatos(Datos datos) {
        try (Connection connection = conexion()) {
            String query = """
                        INSERT INTO datos (idSensor, tipo_sensor, medida_humedad, medida_temperatura, fecha_hora, marca_sensor) 
                        VALUES (?, ?, ?, ?, ?, ?);""";
            try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, datos.getIdSensor());
                ps.setString(2, datos.getTipoSensor());
                ps.setDouble(3, datos.getMedidaHumedad());
                ps.setDouble(4, datos.getMedidaTemperatura());
                ps.setTimestamp(5, Timestamp.valueOf(datos.getFechaHora()));
                ps.setString(6, datos.getMarcaSensor());
                ps.executeUpdate();

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        datos.setId(generatedKeys.getLong(1));
                    } else {
                        throw new SQLException("ID no reconocido");
                    }
                }
            }
            return datos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Datos> obtenerDatos() {
        List<Datos> datosList = new ArrayList<>();
        try (Connection connection = conexion()) {
            String query = "SELECT * FROM datos";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Datos datos = new Datos();
                        datos.setId(rs.getLong("id"));
                        datos.setIdSensor(rs.getString("idSensor"));
                        datos.setTipoSensor(rs.getString("tipo_sensor"));
                        datos.setMedidaHumedad(rs.getDouble("medida_humedad"));
                        datos.setMedidaTemperatura(rs.getDouble("medida_temperatura"));
                        datos.setFechaHora(rs.getObject("fecha_hora", LocalDateTime.class));
                        datos.setMarcaSensor(rs.getString("marca_sensor"));
                        datosList.add(datos);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datosList;
    }

    @Override
    public List<Datos> obtenerDatosPorIdSensor(String idSensor) {
        List<Datos> datosList = new ArrayList<>();
        try (Connection connection = conexion()) {
            String query = "SELECT * FROM datos WHERE idSensor = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, idSensor);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Datos datos = mapearResultSetADatos(rs);
                        datosList.add(datos);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datosList;
    }

    @Override
    public List<Datos> obtenerDatosPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Datos> datosList = new ArrayList<>();
        try (Connection connection = conexion()) {
            String query = "SELECT * FROM datos WHERE fecha_hora BETWEEN ? AND ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setObject(1, fechaInicio);
                ps.setObject(2, fechaFin);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Datos datos = mapearResultSetADatos(rs);
                        datosList.add(datos);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datosList;
    }

    private Datos mapearResultSetADatos(ResultSet rs) throws SQLException {
        Datos datos = new Datos();
        datos.setId(rs.getLong("id"));
        datos.setIdSensor(rs.getString("idSensor"));
        datos.setTipoSensor(rs.getString("tipo_sensor"));
        datos.setMedidaHumedad(rs.getDouble("medida_humedad"));
        datos.setMedidaTemperatura(rs.getDouble("medida_temperatura"));
        datos.setFechaHora(rs.getObject("fecha_hora", LocalDateTime.class));
        datos.setMarcaSensor(rs.getString("marca_sensor"));
        return datos;
    }

}
