/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author bismart
 */
public class ServidorTCP {
   
 private ServerSocket server;
 private final int port;

    
    public ServidorTCP(int puerto) {
        this.port = puerto;
    }
    
    public void initServer() throws IOException{
        new Listener(port).start();
    }
    
}
