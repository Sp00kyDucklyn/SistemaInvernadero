/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.socketsensores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoshi
 */
public class SocketSensores {

    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = null;
        Socket sc = null;
        Executor service = Executors.newCachedThreadPool();
        final int PUERTO = 1544;
//        System.out.println("tamo activo papi");
        try {
//            System.out.println("tamo activo papi");
            socketServer = new ServerSocket(PUERTO);
            while(true){
                try {
                                    System.out.println("tamo activo papi");
                    //Que se quede esperando a ver qn llega
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SocketSensores.class.getName()).log(Level.SEVERE, null, ex);
                }
                sc = socketServer.accept();
                
                //puntacos
                service.execute(new Entrada (sc));                
                new Thread().start();  
                
            }
         
        }catch(IOException ex){
            
        }

        
    }
}
