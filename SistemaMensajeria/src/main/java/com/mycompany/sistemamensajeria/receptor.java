package com.mycompany.sistemamensajeria;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Marcos T.
 */
public class receptor {

    /**
     * @param args the command line arguments
     */
    static String QUEUE_NAME = "ListaCompra";
    private static final String USERNAME = "admin";
    private static final String RABBITMQ_HOST = "rabbitmq";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        try {

            ConnectionFactory factory = new ConnectionFactory();

            factory.setUsername(USERNAME);
            factory.setPassword(PASSWORD);
            factory.setHost(RABBITMQ_HOST);

            Connection connection = factory.newConnection();

            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            System.out.println(" [*] Waiting for messages.");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {

                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

                String[] datos = message.split(":");

                String idSensor = datos[0];
                String tipoSensor = datos[1];
                String medidaHumedad = datos[2];
                String medidaTemperatura = datos[3];
                String nombreInvernadero = datos[4];
                String direccionInvernadero = datos[5];

                String mensajeFormatedado = "Id Sensor: " + idSensor + "\n"
                        + "Tipo del sensor: " + tipoSensor + "\n"
                        + "Medida de Humedad: " + medidaHumedad + "\n"
                        + "Medida Temperatura: " + medidaTemperatura + "\n"
                        + "Nombre del Invernadero: " + nombreInvernadero + "\n"
                        + "Direccion del Invernadero: " + direccionInvernadero;

                EmailSender.sendEmail("carmen.hernandez240210@potros.itson.edu.mx", "APP INVERNADERO", mensajeFormatedado);
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        } catch (IOException ex) {
            Logger.getLogger(receptor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(receptor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
