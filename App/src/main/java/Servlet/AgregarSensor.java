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
import java.util.List;

@WebServlet("/agregarSensor")
public class AgregarSensor extends HttpServlet {
     

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException { 
        
        String clave = request.getParameter("clave_sensor");
        String marca = request.getParameter("marca");
        long invernadero = Long.parseLong(request.getParameter("invernadero_id"));

        // Crear una nueva instancia de Invernadero con los datos recibidos
        Sensor sensor = new Sensor(clave, marca,invernadero);

        // Crear el EntityManagerFactory y EntityManager
        ManagerSensores manager = new ManagerSensores();
        manager.agregarSensor(sensor);
       

        // Redirigir de vuelta al menú principal
        response.sendRedirect("index.html");
    }
}