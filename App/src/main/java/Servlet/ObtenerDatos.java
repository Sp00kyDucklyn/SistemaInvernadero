/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DominioDatos.Datos;
import com.invernadero.fachada.Fachada;
import jakarta.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "ObtenerDatos", urlPatterns = {"/ObtenerDatos"})
public class ObtenerDatos extends HttpServlet {

    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new TypeAdapter<LocalDateTime>() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

                @Override
                public void write(JsonWriter out, LocalDateTime value) throws IOException {
                    if (value == null) {
                        out.nullValue();
                    } else {
                        out.value(value.format(formatter));
                    }
                }

                @Override
                public LocalDateTime read(JsonReader in) throws IOException {
                    return LocalDateTime.parse(in.nextString(), formatter);
                }
            })
            .create();
    Fachada fachada = new Fachada();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Datos> sensores = fachada.obtenerDatos();
            if (sensores.isEmpty()) {
                String mensajeError = "Condiciones previas no cumplidas. Verifique la conexión a la base de datos y que existan DatosDeSensores.";
                response.sendRedirect("index.html?error=" + URLEncoder.encode(mensajeError, "UTF-8"));

            }
            String jsonSensores = gson.toJson(sensores);
            response.setContentType(jsonSensores);
            PrintWriter out = response.getWriter();
            out.print(jsonSensores);
            out.flush();
        } catch (Exception e) {
            String mensajeError = "Condiciones previas no cumplidas. Verifique la conexión a la base de datos y que existan DatosDeSensores.";
            response.sendRedirect("index.html?error=" + URLEncoder.encode(mensajeError, "UTF-8"));
        }

    }

}
