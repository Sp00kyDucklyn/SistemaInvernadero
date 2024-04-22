/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabbit;

import DominioDetector.Alarma;
import DominioDetector.Invernadero;
import DominioDetector.Sensor;
import com.itson.detector.AlarmaDAO;
import com.itson.detector.InvernaderoDAO;
import com.itson.detector.SensorDAO;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoshi
 */
public class EnviarColaMensajeria {
    static String QUEUE_NAME = "ListaCompra";
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
    
    public void construirMensaje(String mensaje){
        
        SensorDAO datosS = new SensorDAO();
        InvernaderoDAO datosI = new InvernaderoDAO();
        AlarmaDAO datosA = new AlarmaDAO();
        
        String[] valores=mensaje.split(":");
        List<Sensor> sensores = new ArrayList<>();        
        List<Invernadero> invernaderos = new ArrayList<>();  
        List<Alarma> alarmas = new ArrayList<>();
        
        sensores = datosS.colsultar();
        invernaderos = datosI.colsultar();
        alarmas = datosA.colsultar();
        
        
        //Compara los datos que llegaron con los datos que están en la base de 
        //la alarma si sobrepasa se envía un message
        for (Sensor sensor : sensores) {
            if (sensor.getClave_sensor() .equalsIgnoreCase(valores[0]) ) {

                for (Alarma alarma : alarmas) {

                    if (alarma.getIdAlarma() == sensor.getId_alarma()) {
                          if(alarma.getLimite_humedad() <= 
                                  Double.parseDouble(valores[2])
                                  || alarma.getLimite_temperatura() <= 
                                  Double.parseDouble(valores[3])){
                                  System.out.println(alarma.getLimite_humedad()+":"+valores[2]);
                                  System.out.println(alarma.getLimite_temperatura()+":"+valores[3]);
                                for(Invernadero invernadero : invernaderos){
                                  
                                  if(sensor.getId_invernadero() == invernadero.getIdInvernadero()){
                                      
                                      mensaje = mensaje.concat(":" + invernadero.getNombre() + ":" + invernadero.getDireccion());
                                      this.enviarMensajeAlerta(mensaje);
                                      
                                  }
                                  
                              }
                              
                          }
                    }

                }

            }
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
