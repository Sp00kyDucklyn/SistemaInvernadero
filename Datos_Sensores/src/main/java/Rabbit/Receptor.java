/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rabbit;


import DominioDatos.Datos;
import com.mycompany.dao_sensores.DatosDAO;
import java.io.IOException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.CancelCallback;
import java.time.LocalDateTime;

/**
 *
 * @author oscar
 */
public class Receptor {
     private static final String QUEUE_NAME="colaDatos";
    public static void main(String[] args) throws IOException {
        ConnectionFactory factory=new ConnectionFactory();
         LocalDateTime fechaHoraActual = LocalDateTime.now();
        factory.setHost("Localhost");
        try{
            Connection connection= factory.newConnection();
            Channel channel=connection.createChannel();
            
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Esperando mensajes en"+ QUEUE_NAME +"Para salir, presion CRTL+C");
            
            DeliverCallback deliverCallback= (consumerTag, delivery) ->{
                String message= new String(delivery.getBody(), "UTF-8");
                DatosDAO datosDAO = new DatosDAO("localhost", "3306", "Invernadero", "root", "1234");
                Datos datos = new Datos("2", "Sensor de Humedad", 75.5, 25.3, fechaHoraActual, "MarcaXYZ");
                String[] atributos=message.split(":");
                datos.setIdSensor(atributos[0]);
                datos.setTipoSensor(message);
                datos.setMedidaHumedad(Double.parseDouble(atributos[1]));
                datosDAO.agregarDatos(datos);
                
            };
        }catch(Exception e){
            
        }
    }
}
