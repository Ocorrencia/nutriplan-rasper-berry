/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import pojo.Motivo;
import util.ConexaoMysql;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class MotivoDao {

    private final String CONSULTARSQL = "SELECT concat(codmtv, ' - ', desmtv) as motivo from nutri_op.op018mtv";

    Motivo motivo = new Motivo();
    EnviarEmail enviarEmail = new EnviarEmail();
    List<String> motivos = new ArrayList<String>();

    public MotivoDao() {
    }

    public List<String> consultar() {
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(CONSULTARSQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                motivos.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Notificacao.infoBox("Ocorreu um Erro: ao consultar os motivos de parada", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "Erro ao consultar os motivos de parada");
            } catch (MessagingException ex) {
                Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return motivos;
    }
}
