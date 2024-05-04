/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DominioDatos.Datos;
import com.google.gson.Gson;
import com.invernadero.fachada.Fachada;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 *
 * @author Jorge
 */
@WebServlet(name = "ObtenerDatos", urlPatterns = {"/ObtenerDatos"})
public class ObtenerDatos extends HttpServlet {

    Gson gson = new Gson();
    Fachada fachada = new Fachada();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(fachada.obtenerDatos().size());
        List<Datos> sensores = fachada.obtenerDatos();
        String jsonSensores = gson.toJson(sensores);
        response.setContentType(jsonSensores);
        PrintWriter out = response.getWriter();
        out.print(jsonSensores);
        out.flush();
    }
    

}
