/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pojo.OrdemProducao;
import util.ConexaoMysql;

/**
 *
 * @author diogo.melo
 */
public class EnviarDadosOrdemProducao {

    private final String INCLUIRSQL = "INSERT INTO nutri_op_sinc.op900qdo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String ATUALIZARTABELAPADRAO = "INSERT IGNORE\n"
            + "   INTO nutri_op.op900qdo\n"
            + " SELECT *\n"
            + "   FROM nutri_op_sinc.op900qdo\n"
            + "      ;\n"
            + "      \n"
            + "      ";
    private final String LIMPARTABELA = "DELETE FROM nutri_op_sinc.op900qdo";
    List<OrdemProducao> ordemProducao = new ArrayList<OrdemProducao>();

    public void EnviarDadosOperador(List<OrdemProducao> ordemProducaoObj) {
        this.ordemProducao = ordemProducaoObj;
        enviarDados();
    }

    public void enviarDados() {
        limparDados();
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(INCLUIRSQL);
            for (OrdemProducao op : ordemProducao) {
                ps.setInt(1, op.getCodEmp() + 1);
                ps.setString(2, op.getCodOri());
                ps.setInt(3, op.getNumOrp());
                ps.setString(4, op.getCodPro());
                ps.setString(5, op.getCodDer());
                ps.setInt(6, op.getCodEtg());
                ps.setInt(7, op.getSeqRot());
                ps.setInt(8, op.getSeqEtr());
                ps.setDouble(9, op.getQtdPrv());
                ps.setDouble(10, op.getQtdRe1() == null ? 0 : op.getQtdRe1());
                ps.setDouble(11, op.getQtdRfg());
                ps.setDouble(12, op.getQtdMax());
                ps.setDouble(13, op.getCicPad());
                ps.setString(14, op.getDesPro());
                ps.setString(15, op.getDesDer());
                ps.setString(16, op.getPrxPro());
                ps.setString(17, op.getPrxDer());
                ps.setString(18, op.getPrxPro());
                ps.setString(19, op.getPrxDer());
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
