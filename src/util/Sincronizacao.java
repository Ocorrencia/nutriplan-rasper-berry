/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import pojoWebService.FichaTecnicaWebService;
import pojoWebService.OperadorWebService;

/**
 *
 * @author diogo.melo
 */
public class Sincronizacao {

    public static void sincOperadores() {
        OperadorWebService operadorWebService = new OperadorWebService();
        operadorWebService.buscarOperadoresSapiens();
    }

    public static void sincFichaTecnica() {
        FichaTecnicaWebService fichaTecnicaWebService = new FichaTecnicaWebService();
        fichaTecnicaWebService.buscarFichaTenicaSapiens();
    }
}
