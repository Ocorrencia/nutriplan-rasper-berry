/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.laf.rootpane.WebDialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;
import static tela.TelaApontamentoParada.telaAP;

/**
 *
 * @author diogo.melo
 */
public class TelaAvisoTravamento extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JLabel lbParada = new JLabel("PARADA DE MÁQUINA");
    JLabel lbTempo = new JLabel("01:29:35");
    JLabel lbTipo = new JLabel("1023 - FALTA DE INSUMOS");

    URL urlTimeWarning = getClass().getResource("/imagens/icons8-expired_1.png");
    ImageIcon icoWarning = new ImageIcon(urlTimeWarning);

    JLabel iconeWarning = new JLabel(icoWarning);
    JButton btnIniciar = new JButton("INICIAR");
    public static TelaAvisoTravamento telaAviso;

    public TelaAvisoTravamento() {
        setTitle("Aviso travamento operacional");
        JPanel painelInfo = new JPanel();
        setVisible(true);
        setResizable(false);
        setTitle("AVISO");
        btnIniciar.setPreferredSize(new Dimension(80, 40));

        lbParada.setFont(new Font("Arial", Font.BOLD, 20));
        lbTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lbTipo.setFont(new Font("Arial", Font.BOLD, 16));

        painelInfo.setLayout(new MigLayout());
        this.setFrameIcon(iconeprincipal);
        painelInfo.add(iconeWarning, "align center,wrap");
        painelInfo.add(lbParada, "align center,wrap");
        painelInfo.add(lbTempo, "align center,wrap");
        painelInfo.add(lbTipo, "align center, wrap");
        painelInfo.add(btnIniciar, "align center");
        add(painelInfo);
        listener();
        pack();
    }

    public static TelaAvisoTravamento getTela() {
        if (telaAviso == null) {
            telaAviso = new TelaAvisoTravamento();
            telaAviso.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaAviso);
                    telaAviso = null;
                }
            });
            TelaSistema.jdp.add(telaAviso);
        }
        TelaSistema.jdp.setSelectedFrame(telaAviso);
        TelaSistema.jdp.moveToFront(telaAviso);
        TelaSistema.centraliza(telaAviso);
        return telaAviso;
    }

    public void listener() {
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
