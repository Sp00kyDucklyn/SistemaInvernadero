/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoshi
 */
public class EnviarColaMensajeria {
    static String QUEUE_NAME = "mensaje";
    private Channel channel;
    
    public EnviarColaMensajeria() {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        
         try {
             Connection connection = (Connection) factory.newConnection();
              channel = connection.createChannel();
         } catch (IOException ex) {
             Logger.getLogger(EnviarColaMensajeria.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TimeoutException ex) {
             Logger.getLogger(EnviarColaMensajeria.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void enviarMensajeAlerta(String mensaje) {
        
        try {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes());
            System.out.println("[x] Sent '" + mensaje + "'");

        } catch (Exception ex) {
            
            System.out.println(ex);
            
        } 
    }
}
