/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.TimerTask;
import tela.TelaApontamentoParada;

/**
 *
 * @author diogo.melo
 */
public class Enums {

    public static int STATUSTELA;
    public static int PRODUCAO = 1;
    public static int PADRAO = 0;
    public static int FINALIZADO = 3;
    public static int MENU = 2;
    public static String SENHA = "00";
    public static String TELAOP = "TELAOP";
    public static String TELAMENU = "TELAMENU";
    public static String TELAAP = "TELAMENU";
    public static String TIPOSISTEMA;
    public static String RASPERBERRY = "RASPERBERRY";
    public static String WINDOWS = "WINDOWS";
    public static int REFUGOSNAOIDENTIFICADOS = 0;
    public static int REFUGOSJUSTIFICADOS = 0;

    public static String getTIPOSISTEMA() {
        return TIPOSISTEMA;
    }

    public static void setTIPOSISTEMA(String TIPOSISTEMA) {
        Enums.TIPOSISTEMA = TIPOSISTEMA;
    }

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
