/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author diogo.melo
 */
public class Servidor {

    private PrintWriter out;

    public Servidor() {
        iniciarServidor();
    }

    public void iniciarServidor() {
        try {
            ServerSocket servidor = new ServerSocket(12000);
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

                            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true);
                            out.print("teste");
                            out.flush();
                            
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
