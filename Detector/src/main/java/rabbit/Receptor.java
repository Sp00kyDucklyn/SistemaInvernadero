/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rabbit;

import com.rabbitmq.client.*;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;

/**
 *
 * @author diego
 */
public class Receptor {

   private static final String EXCHANGE_NAME="colaDatos";
    private static final String ROUTING_KEY="key2"; // Clave de enrutamiento para esta cola
     private static final String RABBITMQ_HOST = "rabbitmq";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
       
        try{
            Connection connection= factory.newConnection();
            Channel channel=connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            channel.queueDeclare(EXCHANGE_NAME, false, false, false, null);
            String prueba = channel.queueDeclare().getQueue();
            channel.queueBind(prueba, EXCHANGE_NAME, ROUTING_KEY);
            channel.queueBind(EXCHANGE_NAME, "colaDatos", ROUTING_KEY); // Vincular la cola al exchange con la clave de enrutamiento

            System.out.println(" [*] Esperando mensajes en "+ EXCHANGE_NAME +". Para salir, presiona CTRL+C");

            DeliverCallback deliverCallback= (consumerTag, delivery) ->{
                String message= new String(delivery.getBody(), "UTF-8");
                System.out.println("Llego Mensaje "+message);
                EnviarColaMensajeria colita = new EnviarColaMensajeria();
                colita.construirMensaje(message);
            };

            // Consumir mensajes de la cola
            channel.basicConsume(EXCHANGE_NAME, true, deliverCallback, consumerTag -> { });

        } catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    
}
