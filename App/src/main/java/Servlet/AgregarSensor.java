/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Controlador.ManagerInvernadero;
import Controlador.ManagerSensores;
import dominio.Invernadero;
import dominio.Sensor;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/agregarSensor")
public class AgregarSensor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerInvernadero manager = new ManagerInvernadero();
        System.out.println("gola");
        if (verificarConexionDB() && manager.existenInvernaderos()) {
            response.sendRedirect("agregar_sensor.jsp");
        } else {
             String mensajeError = "Condiciones previas no cumplidas. Verifique la conexión a la base de datos y que existan invernaderos.";
            response.sendRedirect("index.html?error=" + URLEncoder.encode(mensajeError, "UTF-8"));
      }
    }

    private boolean verificarConexionDB() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/invernadero", "root", "12345")) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String clave = request.getParameter("clave_sensor");
        String marca = request.getParameter("marca");
        long invernadero = Long.parseLong(request.getParameter("invernadero_id"));

        // Crear una nueva instancia de Invernadero con los datos recibidos
        Sensor sensor = new Sensor(clave, marca, invernadero);

        // Crear el EntityManagerFactory y EntityManager
        ManagerSensores manager = new ManagerSensores();
        manager.agregarSensor(sensor);

        // Redirigir de vuelta al menú principal
        response.sendRedirect("index.html");
    }
}
