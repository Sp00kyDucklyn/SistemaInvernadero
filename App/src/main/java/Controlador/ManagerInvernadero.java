/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import dominio.Invernadero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class ManagerInvernadero {
    private Connection connection;

    public ManagerInvernadero() {
        try {
            // Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/invernadero";
            String user = "root";
            String password = "12345";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarInvernadero(Invernadero invernadero) {
        String query = "INSERT INTO invernadero (direccion, nombre) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, invernadero.getDireccion());
            preparedStatement.setString(2, invernadero.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarInvernadero(Invernadero invernadero) {
        String query = "UPDATE invernadero SET direccion = ?, nombre = ? WHERE id_invernadero = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, invernadero.getDireccion());
            preparedStatement.setString(2, invernadero.getNombre());
            preparedStatement.setLong(3, invernadero.getIdInvernadero());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarInvernadero(int id) {
        String query = "DELETE FROM invernadero WHERE id_invernadero = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Invernadero obtenerInvernaderoPorId(int id) {
        String query = "SELECT * FROM invernadero WHERE id_invernadero = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Invernadero invernadero = new Invernadero();
                invernadero.setIdInvernadero(resultSet.getLong("id_invernadero"));
                invernadero.setDireccion(resultSet.getString("direccion"));
                invernadero.setNombre(resultSet.getString("nombre"));
                return invernadero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Invernadero> obtenerTodosLosInvernaderos() {
        List<Invernadero> invernaderos = new ArrayList<>();
        String query = "SELECT * FROM invernadero";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Invernadero invernadero = new Invernadero();
                invernadero.setIdInvernadero(resultSet.getLong("id_invernadero"));
                invernadero.setDireccion(resultSet.getString("direccion"));
                invernadero.setNombre(resultSet.getString("nombre"));
                invernaderos.add(invernadero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invernaderos;
    }
}
