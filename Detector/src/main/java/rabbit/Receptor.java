/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author hoshi
 */
public class Receptor {

  private static final String QUEUE_NAME="colaDatos";
    public static void main(String[] args) throws IOException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("Localhost");
        try{
            Connection connection= factory.newConnection();
            Channel channel=connection.createChannel();
            
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Esperando mensajes en"+ QUEUE_NAME +"Para salir, presion CRTL+C");
            
            DeliverCallback deliverCallback= (consumerTag, delivery) ->{
                String message= new String(delivery.getBody(), "UTF-8");
                
                EnviarColaMensajeria colita = new EnviarColaMensajeria();
                colita.enviarMensajeAlerta(message);
                
            };
        }catch(Exception e){
            
        }
    }
    
}
