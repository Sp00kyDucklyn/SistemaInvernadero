/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import entidades.Invernadero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 *
 * @author diego
 */
public class ManagerInvernadero {
     private EntityManagerFactory emf;

    public ManagerInvernadero() {
        emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void close() {
        emf.close();
    }

    public void agregarInvernadero(Invernadero invernadero) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(invernadero);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarInvernadero(Invernadero invernadero) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(invernadero);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarInvernadero(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Invernadero invernadero = em.find(Invernadero.class, id);
        if (invernadero != null) {
            em.remove(invernadero);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Invernadero obtenerInvernaderoPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Invernadero invernadero = em.find(Invernadero.class, id);
        em.close();
        return invernadero;
    }

    public List<Invernadero> obtenerTodosLosInvernaderos() {
        EntityManager em = emf.createEntityManager();
        List<Invernadero> invernaderos = em.createQuery("SELECT i FROM Invernadero i", Invernadero.class).getResultList();
        em.close();
        return invernaderos;
    }
}
