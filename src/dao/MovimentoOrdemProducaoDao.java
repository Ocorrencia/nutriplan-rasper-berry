/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import pojo.MovimentoOrdemProducao;
import util.ConexaoMysql;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class MovimentoOrdemProducaoDao {

    MovimentoOrdemProducao mp = new MovimentoOrdemProducao();
    EnviarEmail enviarEmail = new EnviarEmail();
    private final String INCLUIRSQL = "INSERT INTO nutri_op.op900eoq (CODEMP,CODORI,NUMORP,CODPRO,CODDER,CODETG,SEQROT,SEQETR,SEQMOV,DATMOV,HORMOV,NUMCAD,QTDRE1,QTDRFG,EXPERP,CODDFT,TURTRB) VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?)";

    public MovimentoOrdemProducaoDao(MovimentoOrdemProducao movimentoOrdemProducao) {
        this.mp = movimentoOrdemProducao;
    }

    public MovimentoOrdemProducao getMp() {
        return mp;
    }

    public void setMp(MovimentoOrdemProducao mp) {
        this.mp = mp;
    }
    

    public void INCLUIR() {
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(INCLUIRSQL);
            ps.setInt(1, 1);
            ps.setString(2, mp.getCodOri());
            ps.setInt(3, mp.getNumOrp());
            ps.setString(4, mp.getCodPro());
            ps.setString(5, mp.getCodDer());
            ps.setString(6, mp.getCodEtg());
            ps.setInt(7, mp.getSeqRot());
            ps.setInt(8, mp.getSeqEtr());
            ps.setInt(9, mp.getSeqMov());
            ps.setString(10, mp.getDatMov());
            ps.setString(11, mp.getHorMov());
            ps.setInt(12, mp.getNumCad());
            ps.setDouble(13, mp.getQtdRe1());
            ps.setDouble(14, mp.getQtdRfg());
            ps.setInt(15, mp.getExpErp());
            ps.setString(16, mp.getCodDdft());
            ps.setInt(17, mp.getTurTrb());
            ps.executeUpdate();
            ConexaoMysql.FecharConexao();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Notificacao.infoBox("Ocorreu um Erro ao Incluir a Máquina", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "Erro ao incluir a Máquina");
            } catch (MessagingException ex) {
                Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
