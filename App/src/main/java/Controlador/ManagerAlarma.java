/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import dominio.Alarma;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diego
 */
public class ManagerAlarma {
    private Connection connection;

    public ManagerAlarma() {
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

    public void agregarAlarmaYActualizarSensor(Alarma alarma, long idSensor) {
    String callProcedure = "{CALL agregar_alarma_y_actualizar_sensor(?, ?, ?)}";
    try (CallableStatement callStmt = connection.prepareCall(callProcedure)) {
        // Establecer los parámetros del procedimiento almacenado
        callStmt.setDouble(1, alarma.getLimiteHumedad());
        callStmt.setDouble(2, alarma.getLimiteTemperatura());
        callStmt.setLong(3, idSensor);

        // Ejecutar el procedimiento almacenado
        callStmt.execute();
        
        System.out.println("Se agregó la alarma y se actualizó el sensor correctamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
//    public void actualizarAlarma(Alarma alarma) {
//        String query = "UPDATE alarma SET limite_humedad = ?, limite_temperatura = ?, id_sensor = ? WHERE id_alarma = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setDouble(1, alarma.getLimiteHumedad());
//            preparedStatement.setDouble(2, alarma.getLimiteTemperatura());
//            preparedStatement.setLong(3, alarma.getSensor());
//            preparedStatement.setLong(4, alarma.getIdAlarma());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void eliminarAlarma(Long id) {
        String query = "DELETE FROM alarma WHERE id_alarma = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Alarma obtenerAlarmaPorId(Long id) {
        String query = "SELECT * FROM alarma WHERE id_alarma = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Alarma alarma = new Alarma();
                alarma.setIdAlarma(resultSet.getLong("id_alarma"));
                alarma.setLimiteHumedad(resultSet.getDouble("limite_humedad"));
                alarma.setLimiteTemperatura(resultSet.getDouble("limite_temperatura"));
                
                // Aquí deberías obtener el sensor asociado a la alarma desde la base de datos
                // y configurarlo en el objeto alarma antes de devolverlo.
                
                return alarma;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Alarma> obtenerTodasLasAlarmas() {
        List<Alarma> alarmas = new ArrayList<>();
        String query = "SELECT * FROM alarma";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alarma alarma = new Alarma();
                alarma.setIdAlarma(resultSet.getLong("id_alarma"));
                alarma.setLimiteHumedad(resultSet.getDouble("limite_humedad"));
                alarma.setLimiteTemperatura(resultSet.getDouble("limite_temperatura"));
                
                // Aquí deberías obtener el sensor asociado a cada alarma desde la base de datos
                // y configurarlo en cada objeto alarma antes de añadirlo a la lista.
                
                alarmas.add(alarma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alarmas;
    }
}
