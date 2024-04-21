/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;


import entidades.Invernadero;
import jakarta.servlet.ServletException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        Long rolId = Long.parseLong(request.getParameter("rol"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        Rol rol = em.find(Rol.class, rolId);
//        Usuario usuario = new Usuario(nombre, email, rol);

//        em.persist(usuario);

        tx.commit();

        em.close();
        emf.close();

        response.sendRedirect("index.html");
    }
}