/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.EventosDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author diogo.melo
 */
public class Consulta {

    static EnviarEmail enviarEmail = new EnviarEmail();

    public static String CONSULTASTRING(String tabela, String coluna, String where) {
        String sql = "SELECT " + coluna + " FROM " + tabela + " WHERE " + where + "";
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }else{
                return "VAZIO";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Notificacao.infoBox("Ocorreu um Erro ao Incluir o Evento", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "Erro ao incluir o evento");
            } catch (MessagingException ex) {
                Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "VAZIO";
    }

    public static int CONSULTAINT() {
        return 0;
    }
}
