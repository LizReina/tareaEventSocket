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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bismart
 */
public class ServidorMain {

    
    // método principal main de la clase
 public static void main(String argv[]) throws IOException {
    ServidorTCP server=new ServidorTCP(6000);
    server.initServer();

 }
}
