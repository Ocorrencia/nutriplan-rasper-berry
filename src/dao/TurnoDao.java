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
import pojo.TurnoTrabalho;
import util.ConexaoMysql;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class TurnoDao {

    private final String CONSULTARSQL = "SELECT DISTINCT tur.TURTRB, tur.destrb,\n"
            + "    REPLACE(CAST(LPAD(HORINI / 60, 2, '0') AS CHAR (50)),\n"
            + "        '.',\n"
            + "        '') AS HORINI,\n"
            + "    REPLACE(CAST(LPAD(HORFIM / 60, 2, '0') AS CHAR (50)),\n"
            + "        '.',\n"
            + "        '') AS HORAFIM\n"
            + "FROM\n"
            + "    nutri_op.op803trb as trb INNER JOIN nutri_op.op000tur as tur ON (tur.turtrb = trb.turtrb);\n"
            + "\n"
            + "    \n"
            + "    ";

    TurnoTrabalho turnoTrabalho = new TurnoTrabalho();
    EnviarEmail enviarEmail = new EnviarEmail();

    public TurnoDao(TurnoTrabalho obj) {
        this.turnoTrabalho = obj;
    }

    public List<TurnoTrabalho> consultar() {
        try {
            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(CONSULTARSQL);
            ResultSet rs = ps.executeQuery();
            List<TurnoTrabalho> itensTurnoTrabalho = new ArrayList<TurnoTrabalho>();
            while (rs.next()) {
                turnoTrabalho = new TurnoTrabalho();
                turnoTrabalho.setTurTrb(rs.getInt(1));
                turnoTrabalho.setDesTrb(rs.getString(2));
                turnoTrabalho.setHorIni(rs.getInt(3));
                turnoTrabalho.setHorFim(rs.getInt(4));
                itensTurnoTrabalho.add(turnoTrabalho);
            }
            turnoTrabalho.setItensTurnoTrabalho(itensTurnoTrabalho);
            return turnoTrabalho.getItensTurnoTrabalho();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Notificacao.infoBox("Ocorreu um Erro: ao consultar de turno de trabalho", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "Erro ao consultar o turno de trabalho");
            } catch (MessagingException ex) {
                Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
