/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author diogo.melo
 */
public class TelaRefugo extends JInternalFrame {

    JPanel painelGeral = new JPanel();
    private static TelaRefugo tela;
    JTextField campoQuantidade = new JTextField();
    JLabel lbQuantidade = new JLabel("Quantidade Refugo");
    JButton btnMotivosRefugo = new JButton("Motivos Refugo");

    public static TelaRefugo getTela() {
        if (tela == null) {
            tela = new TelaRefugo();
            tela.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(tela);
                    tela = null;
                }
            });
            TelaSistema.jdp.add(tela);
        }
        TelaSistema.jdp.setSelectedFrame(tela);
        TelaSistema.jdp.moveToFront(tela);
        TelaSistema.centraliza(tela);
        return tela;
    }

    public TelaRefugo() {
        super("Refugo", false, true, false, true);
        initiComponente();
    }

    private void initiComponente() {
        setSize(new Dimension(400, 400));
        setVisible(true);
        painelGeral.setLayout(new MigLayout());
        add(painelGeral);

        painelGeral.add(campoQuantidade);
        painelGeral.add(lbQuantidade, "wrap");
        painelGeral.add(btnMotivosRefugo);

        pack();
    }

}
