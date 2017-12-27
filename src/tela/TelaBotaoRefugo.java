/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.RefugoDao;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import pojo.Refugo;
import util.Consulta;
import util.Enums;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class TelaBotaoRefugo extends JFrame {

    JButton botaoRefugo = new JButton("REFUGO");
    Refugo refugo;
    RefugoDao refugoDao = new RefugoDao();

    public TelaBotaoRefugo() {
        setSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(botaoRefugo);
        botaoRefugo.addActionListener((ActionEvent e) -> {
            if (Integer.parseInt(TelaOP.tela.campoQuantidadeProgramada.getText().replace("UN", "").trim()) <= Enums.REFUGOSJUSTIFICADOS + Enums.REFUGOSNAOIDENTIFICADOS) {
                Notificacao.infoBox("Quantidade Excede a quantidade programada", false);
                return;
            }
            if (Integer.parseInt(TelaOP.tela.campoQuantidadeRealizada.getText().replace("UN", "").trim()) == 0) {
                Notificacao.infoBox("Quantidade Realizada ainda é 0", false);
                return;
            }
            if (Enums.REFUGOSNAOIDENTIFICADOS > Consulta.CONSULTAINT("nutri_op.op900eoq", "SUM(QTDRE1)", "EXPERP = 0 AND QTDRE1 = 1")) {
                 Notificacao.infoBox("Não há saldo para refugos", false);
                return;
            }
            Enums.REFUGOSNAOIDENTIFICADOS = Enums.REFUGOSNAOIDENTIFICADOS + 1;
            if (TelaRefugo.tela != null) {
                TelaRefugo.tela.campoQuantidadeNaoJustificados.setText("0" + Enums.REFUGOSNAOIDENTIFICADOS);
            }
            TelaOP.tela.campoQuantidadeRefugo.setText(Enums.REFUGOSJUSTIFICADOS + Enums.REFUGOSNAOIDENTIFICADOS + " UN");
            TelaOP.tela.adicionarRefugo(1);
            Refugo.setQuantidade(1);
            refugoDao.atualizar();
        });
    }
}
