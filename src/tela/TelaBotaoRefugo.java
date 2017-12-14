/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import util.DadosRaspberry;
import util.Enums;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class TelaBotaoRefugo extends JFrame {

    JButton botaoRefugo = new JButton("REFUGO");

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
            Enums.REFUGOSNAOIDENTIFICADOS = Enums.REFUGOSNAOIDENTIFICADOS + 1;
            if (TelaRefugo.tela != null) {
                TelaRefugo.tela.campoQuantidadeNaoJustificados.setText("0" + Enums.REFUGOSNAOIDENTIFICADOS);
            }
            TelaOP.tela.campoQuantidadeRefugo.setText(Enums.REFUGOSJUSTIFICADOS + Enums.REFUGOSNAOIDENTIFICADOS + " UN");
            if (Integer.parseInt(TelaOP.tela.campoQuantidadeRealizada.getText().replace("UN", "").trim()) != 0) {
                int total = Integer.parseInt(TelaOP.tela.campoQuantidadeRealizada.getText().replace("UN", "").trim()) - 1;
                DadosRaspberry.QUANTIDADEPRODUZIDA = DadosRaspberry.QUANTIDADEPRODUZIDA - 1;
                TelaOP.tela.campoQuantidadeRealizada.setText(total + " UN");
            }
            TelaOP.getTela().controleProducao();
        });
    }
}
