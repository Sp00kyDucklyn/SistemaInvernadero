/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.itson.socketsensores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author hoshi
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Socket socket = new Socket("localhost", 1542);
         
            // El string que quieres enviar en binario
            String mensaje = "pitito:tilina";

            // Convertir el string a bytes en formato UTF-8
            byte[] bytesMensaje = mensaje.getBytes("UTF-8");

            // Obtener el flujo de salida del socket
            OutputStream outputStream = socket.getOutputStream();

            // Enviar los bytes al socket
            outputStream.write(bytesMensaje);

            // Flush y cerrar el flujo
            outputStream.flush();
            outputStream.close();

            // Cerrar el socket
            socket.close();

            System.out.println("Mensaje enviado correctamente en binario.");

    }
    
}
