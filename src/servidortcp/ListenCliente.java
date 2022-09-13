/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 *
 * @author bismart
 */
public class ListenCliente extends Thread  {

    Socket socket;
    DataInputStream entrada;
    PrintStream salida;

    public ListenCliente(Socket s) {
        this.socket = s;
        // TODO Auto-generated constructor stub
    }

    // Devuelve al cliente una información que se ha conectado al servidor al cliente
    public void out(String out) {
        try {
            socket.getOutputStream().write((out + "\n").getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Se ha desconectado una conexión de servicio al cliente");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        out ("Conectado"); // al cliente
		try {
			//from   client
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			String line = null;
			while((line = br.readLine())!=null) {  
				System.out.println(line);
			}
			br.close();
 
		} catch (UnsupportedEncodingException e) {
 e.printStackTrace();
		} catch (IOException e) {
			 System.out.println ("Un enlace de cliente está desconectado");
			e.printStackTrace();
		}

    }

   

    }
