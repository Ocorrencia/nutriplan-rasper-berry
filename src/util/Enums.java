/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author diogo.melo
 */
public class Enums {

    public static int STATUSTELA;
    public static int PRODUCAO = 1;
    public static int PADRAO = 0;
    public static int MENU = 2;
    public static String SENHA = "00";
    public static String TELAOP = "TELAOP";

    public static int getSTATUSTELA() {
        return STATUSTELA;
    }

    public static void setSTATUSTELA(int STATUSTELA) {
        Enums.STATUSTELA = STATUSTELA;
    }

    public static int getPRODUCAO() {
        return PRODUCAO;
    }

    public static void setPRODUCAO(int PRODUCAO) {
        Enums.PRODUCAO = PRODUCAO;
    }

    public static int getPADRAO() {
        return PADRAO;
    }

    public static void setPADRAO(int PADRAO) {
        Enums.PADRAO = PADRAO;
    }

}
