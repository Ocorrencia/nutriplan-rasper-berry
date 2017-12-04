/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import tela.TelaApontamentoParada;
import tela.TelaOP;
import static tela.TelaOP.tela;

/**
 *
 * @author diogo.melo
 */
public class Servidor {

    public static ServerSocket servidor;
    public static Socket cliente;

    public Servidor() {
        try {
            InetAddress addr = InetAddress.getByName("10.1.1.234");
            servidor = new ServerSocket(12000, 1000, addr);
            System.out.println("SERVIDOR RASPERBERRY INICIADO...");
            iniciarServidor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviar() {
        try {
            Socket cliente = new Socket("paulo", 12345);
            try (ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream())) {
                Date data_atual = (Date) entrada.readObject();
                JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
            }
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
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
                            try (Scanner entrada = new Scanner(cliente.getInputStream())) {
                                while (entrada.hasNextLine()) {
                                    String dados = entrada.nextLine();
                                    System.out.println(dados);
                                    if (!dados.equals("")) {
                                        switch (dados) {
                                            case "1":
                                                DadosRaspberry.QUANTIDADEPRODUZIDA = DadosRaspberry.QUANTIDADEPRODUZIDA + 1;
                                                TelaOP.getTela().controleProducao();
                                                break;
                                            case "2":
                                                Modal.getTela(tela).setVisible(true);
                                                TelaApontamentoParada.getTela();
                                                break;
                                            case "3":
                                                break;
                                            case "4":
                                                break;
                                            case "5":
                                                break;
                                            case "6":
                                                break;
                                            case "7":
                                                break;
                                        }

                                    }
                                }
                            }
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
        Servidor.servidor = servidor;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        Servidor.cliente = cliente;
    }

}
