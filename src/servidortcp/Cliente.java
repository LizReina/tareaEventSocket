/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
// importar la libreria java.net
import java.io.*;
// importar la libreria java.io

/**
 *
 * @author bismart
 */
public class Cliente extends Thread {
 Socket client;
    int port;
    String host;

    public Cliente(int port, String host) {
        this.port = port;
        this.host = host;
    }

    @Override
    public void run() {

       
        try {

            client = new Socket(host,port);
            System.out.println("Dirección del host remoto:" + client.getRemoteSocketAddress()); 
            // Salida del contenido del servidor
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {

                System.out.println(line);

            }

          

            br.close();
            

        } catch (Exception e) {

            System.err.println(e.getMessage());
            System.exit(1);
        }

    }

    public void send(String outString) throws IOException {
        System.out.println("escribiendo en el servidor........");
		client.getOutputStream().write((outString+"\n").getBytes("UTF-8"));
		
	}

    public static void main(String argv[]) throws IOException {
        try {
                Cliente cli= new Cliente(6000,"127.0.0.2");
        cli.start();
            
        } catch (Exception e) {
        }
 

    }
}
