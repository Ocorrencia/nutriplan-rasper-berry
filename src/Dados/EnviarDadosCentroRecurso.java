/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pojo.CentroRecurso;
import util.ConexaoMysql;

/**
 *
 * @author diogo.melo
 */
public class EnviarDadosCentroRecurso {

    private final String INCLUIRSQL = "INSERT INTO NUTRI_OP_SINC.OP725CRE VALUES(?,?,?)";
    private final String ATUALIZARTABELAPADRAO = "INSERT IGNORE INTO NUTRI_OP.op725cre SELECT * FROM NUTRI_OP_SINC.op725cre";
    private final String LIMPARTABELA = "DELETE FROM NUTRI_OP_SINC.OP725CRE";
    List<CentroRecurso> centroRecursoObj = new ArrayList<CentroRecurso>();

    public void EnviarDadosCentroRecurso(List<CentroRecurso> centroRecursoObj) {
        this.centroRecursoObj = centroRecursoObj;
        enviarDados();
    }

    public void enviarDados() {
        limparDados();
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(INCLUIRSQL);
            for (CentroRecurso centroRecurso : centroRecursoObj) {

                ps.setString(1, centroRecurso.getCodCre());
                ps.setString(2, centroRecurso.getDescCre());
                ps.setInt(3, centroRecurso.getCodEtg());
                ps.executeUpdate();
            }
            ConexaoMysql.FecharConexao();
            atualizarTabelaPadrao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarTabelaPadrao() {
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(ATUALIZARTABELAPADRAO);
            ps.executeUpdate();
            ConexaoMysql.FecharConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limparDados() {
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(LIMPARTABELA);
            ps.executeUpdate();
            ConexaoMysql.FecharConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
