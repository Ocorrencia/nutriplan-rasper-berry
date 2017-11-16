/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import pojo.ConfiguracaoBanco;
import util.Enums;

/**
 *
 * @author diogo.melo
 */
public class ControleOperacao {

    static String dados1 = "";

    public ControleOperacao() {

    }

    public static String consultar() {
        String dados = "";
        try {
            if (Enums.getTIPOSISTEMA().equals(Enums.RASPERBERRY)) {
                BufferedReader buffRead = new BufferedReader(new FileReader("/home/pi/Documentos/NutriplanRB/ControleOperacao"));
                while (true) {
                    if (dados != null) {
                    } else {
                        break;
                    }
                    dados1 += dados = buffRead.readLine();
                }
                buffRead.close();
            } else if (Enums.getTIPOSISTEMA().equals(Enums.WINDOWS)) {
                BufferedReader buffRead = new BufferedReader(new FileReader("C:/OP/arquivos/ControleOperacao"));
                while (true) {
                    if (dados != null) {
                    } else {
                        break;
                    }
                    dados1 += dados = buffRead.readLine();
                }
                buffRead.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados1.replace("null", "");
    }

    public static boolean alterar() {
        try {
            if (Enums.getTIPOSISTEMA().equals(Enums.RASPERBERRY)) {
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/home/pi/Documentos/NutriplanRB/configBanco"));
                buffWrite.append(capturarTexto() + "\n");
                buffWrite.close();
            } else if (Enums.getTIPOSISTEMA().equals(Enums.RASPERBERRY)) {
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter("C:/OP/arquivos/configBanco"));
                buffWrite.append(capturarTexto() + "\n");
                buffWrite.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String capturarTexto() {
        String dados = ":" + Enums.getSTATUSTELA() + "*\n";
        return dados;
    }
}
