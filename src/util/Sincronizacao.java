/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import pojoWebService.CentroRecursoWebService;
import pojoWebService.FichaTecnicaWebService;
import pojoWebService.MotivoParadaWebService;
import pojoWebService.OperadorWebService;
import pojoWebService.TurnoWebService;

/**
 *
 * @author diogo.melo
 */
public class Sincronizacao {

    public static boolean sincOperadores() {
        OperadorWebService operadorWebService = new OperadorWebService();
        return operadorWebService.buscarOperadoresSapiens();
    }

    public static boolean sincCentroRecurso() {
        CentroRecursoWebService centroRecursoWebService = new CentroRecursoWebService();
        return centroRecursoWebService.buscarCentroRecurso();
    }

    public static boolean sincFichaTecnica() {
        FichaTecnicaWebService fichaTecnicaWebService = new FichaTecnicaWebService();
        return fichaTecnicaWebService.buscarFichaTenicaSapiens();
    }

    public static boolean sincTurno() {
        TurnoWebService turnoWebService = new TurnoWebService();
        return turnoWebService.buscarTurnoSapiens();
    }

    public static boolean sincMotivoParada() {
        MotivoParadaWebService motivoParadaWebService = new MotivoParadaWebService();
        return motivoParadaWebService.buscarMotivoParadaSapiens();
    }
}
