/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rabbit;


import DominioDatos.Datos;
import com.mycompany.dao_sensores.DatosDAO;
import java.io.IOException;
import com.rabbitmq.client.*;
import java.time.LocalDateTime;

/**
 *
 * @author oscar
 */
public class Receptor {
     private static final String EXCHANGE_NAME="colaDatos";
     private static final String ROUTING_KEY="key1";
     private static final String RABBITMQ_HOST = "rabbitmq";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    public static void main(String[] args) throws IOException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost(RABBITMQ_HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        try{
            Connection connection= factory.newConnection();
            Channel channel=connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String prueba = channel.queueDeclare().getQueue();
            channel.queueBind(prueba, EXCHANGE_NAME, ROUTING_KEY);
            System.out.println(" [*] Esperando mensajes en"+ EXCHANGE_NAME +"Para salir, presion CRTL+C");
            
            DeliverCallback deliverCallback= (consumerTag, delivery) ->{
                
                String message= new String(delivery.getBody(), "UTF-8");
                System.out.println("Llego Mensaje "+message);
                DatosDAO datosDAO = new DatosDAO("localhost", "3306", "DatosSensores", "root", "12345");
                Datos datos = new Datos();
                String[] atributos=message.split(":");
                datos.setIdSensor(atributos[0]);
                datos.setTipoSensor("Sensor");
                datos.setMedidaHumedad(Double.parseDouble(atributos[2]));
                datos.setMedidaTemperatura(Double.parseDouble(atributos[3]));
                datos.setFechaHora(LocalDateTime.now());
                datos.setMarcaSensor(atributos[1]);
                datosDAO.agregarDatos(datos);
                
            };
            channel.basicConsume(prueba, true, deliverCallback, consumerTag -> { });
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
