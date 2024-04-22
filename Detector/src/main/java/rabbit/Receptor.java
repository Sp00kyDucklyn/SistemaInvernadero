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

    private static final String QUEUE_NAME="colaDatos";
    private static final String ROUTING_KEY="key2"; // Clave de enrutamiento para esta cola

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        try{
            Connection connection= factory.newConnection();
            Channel channel=connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.queueBind(QUEUE_NAME, "colaDatos", ROUTING_KEY); // Vincular la cola al exchange con la clave de enrutamiento

            System.out.println(" [*] Esperando mensajes en "+ QUEUE_NAME +". Para salir, presiona CTRL+C");

            DeliverCallback deliverCallback= (consumerTag, delivery) ->{
                String message= new String(delivery.getBody(), "UTF-8");
                System.out.println("Llego Mensaje "+message);
                EnviarColaMensajeria colita = new EnviarColaMensajeria();
                colita.construirMensaje(message);
            };

            // Consumir mensajes de la cola
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

        } catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
}
