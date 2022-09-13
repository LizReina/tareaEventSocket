/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;

/**
 *
 * @author bismart
 */
public class Listener extends Thread {

    int puerto;
    ServerSocket serverSocket;
    Socket clientSocket;

    private List<ListenCliente> listaDeConexiones = new ArrayList<ListenCliente>();

    protected EventListenerList listenerList = new EventListenerList();
     private List<ImyEvent> listeners = new ArrayList<ImyEvent>();

    public Listener(int puerto) throws IOException {
        this.puerto = puerto;
        serverSocket = new ServerSocket(puerto); //Creamos el socket servidor.
        System.out.println("Esperando conexiones...");
    }

  

    void fireMyEvent() {
          System.out.println("Hello!");
    
        // Notify everybody that may be interested.
        for (ImyEvent hl : listeners)
            hl.onConnect();
    
    }

    @Override
    public void run() {
        try {
            while (true) {

                Socket socket = serverSocket.accept();

                ListenCliente cs = new ListenCliente(socket);
                cs.start();

                listaDeConexiones.add(cs);
                System.out.println(listaDeConexiones.size());
                
                this.listeners.add(new MyEvent(socket));
                
                 
                 fireMyEvent();
            }

        } catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void myEventOccurred(MyEvent evt) {
        System.out.println("fired");
    }

  /*  public void avisoConectados() {

        // Notify everybody that may be interested.
        for (ImyEvent hl : listaDeConexiones) {
            hl.onConnect();
        }
    }*/

}
