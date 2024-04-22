/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.detector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hoshi
 */
public class Conexion {
    
    private String url;
    private String usuario;
    private String contraseña;

    public Conexion() {
    }

    public Conexion(String host, String puerto, String bd, String usuario, String contraseña) {
        this.url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Connection conexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexion");
        }
        return DriverManager.getConnection(url, usuario, contraseña);
    }
    
}
