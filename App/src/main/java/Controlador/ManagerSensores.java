/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author diego
 */
import dominio.Sensor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerSensores {
    private Connection connection;

    public ManagerSensores() {
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

    public void agregarSensor(Sensor sensor) {
        String query = "INSERT INTO sensor (clave_sensor, marca, id_invernadero) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sensor.getClaveSensor());
            preparedStatement.setString(2, sensor.getMarca());
            preparedStatement.setLong(3, sensor.getInvernadero());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarSensor(Sensor sensor) {
        String query = "UPDATE sensor SET clave_sensor = ?, marca = ?, id_invernadero = ?, id_alarma = ? WHERE id_sensor = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sensor.getClaveSensor());
            preparedStatement.setString(2, sensor.getMarca());
            preparedStatement.setLong(3, sensor.getInvernadero());
            preparedStatement.setLong(4, sensor.getAlarma());
            preparedStatement.setLong(5, sensor.getIdSensor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSensor(Long id) {
        String query = "DELETE FROM sensor WHERE id_sensor = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sensor obtenerSensorPorId(Long id) {
        String query = "SELECT * FROM sensor WHERE id_sensor = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Sensor sensor = new Sensor();
                sensor.setIdSensor(resultSet.getLong("id_sensor"));
                sensor.setClaveSensor(resultSet.getString("clave_sensor"));
                sensor.setMarca(resultSet.getString("marca"));
                
                // Aquí deberías obtener el invernadero y la alarma asociados al sensor desde la base de datos
                // y configurarlos en el objeto sensor antes de devolverlo.
                
                return sensor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sensor> obtenerTodosLosSensores() {
        List<Sensor> sensores = new ArrayList<>();
        String query = "SELECT * FROM sensor";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sensor sensor = new Sensor();
                sensor.setIdSensor(resultSet.getLong("id_sensor"));
                sensor.setClaveSensor(resultSet.getString("clave_sensor"));
                sensor.setMarca(resultSet.getString("marca"));
                
                // Aquí deberías obtener el invernadero y la alarma asociados al sensor desde la base de datos
                // y configurarlos en el objeto sensor antes de añadirlo a la lista.
                
                sensores.add(sensor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensores;
    }
}
