/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author diogo.melo
 */
public class Servidor {

    private PrintWriter out;
    public static ServerSocket servidor;
    public static Socket cliente;

    public Servidor() {
        try {
            InetAddress addr = InetAddress.getByName("10.1.1.234");
            servidor = new ServerSocket(12000, 1000, addr);
            System.out.println("SERVIDOR RASPERBERRY INICIADO...");
            iniciarServidor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciarServidor() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Socket cliente;
                            cliente = servidor.accept();
                            Scanner entrada = new Scanner(cliente.getInputStream());
                            while (entrada.hasNextLine()) {
                                System.out.println(entrada.nextLine());
                            }
                            entrada.close();
                            cliente.close();
                            iniciarServidor();
                        }
                    } catch (IOException e) {
                    }
                }
            }.start();
        } catch (Exception e) {
        }
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

}
