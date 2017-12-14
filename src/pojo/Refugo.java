/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author diogo.melo
 */
public class Refugo {

    static Double quantidade;
    static String expErp;
    static int codDft;

    public static Double getQuantidade() {
        return quantidade;
    }

    public static void setQuantidade(Double quantidade) {
        Refugo.quantidade = quantidade;
    }

    
    public static int getCodDft() {
        return codDft;
    }

    public static void setCodDft(int codDft) {
        Refugo.codDft = codDft;
    }

  
    public static String getExpErp() {
        return expErp;
    }

    public static void setExpErp(String expErp) {
        Refugo.expErp = expErp;
    }

}
