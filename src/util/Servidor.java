/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author diogo.melo
 */
public class Servidor {

    public Servidor() {
        iniciarServidor();
    }

    public void iniciarServidor() {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("SERVIDOR RASPERBERRY INICIADO...");
            new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Socket cliente = servidor.accept();
                            Scanner entrada = new Scanner(cliente.getInputStream());
                            while (entrada.hasNextLine()) {
                                System.out.println(entrada.nextLine());
                            }
                            entrada.close();
                            cliente.close();
                            iniciarServidor();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
        }
    }
}
