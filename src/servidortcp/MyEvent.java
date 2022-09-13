/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidortcp;

import java.net.Socket;
import java.util.EventObject;

/**
 *
 * @author bismart
 */
public class MyEvent implements ImyEvent {

    private Socket cliente;

    public MyEvent(Socket cliente) {
        // super(source);
        this.cliente = cliente;

    }

    @Override
    public void onConnect() {
        System.out.println("Connectado!!!!");
    }

    @Override
    public void onDesconnect() {
        System.out.println("Desconnectado!!!!");
    }

}
