/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.miginfocom.swing.MigLayout;
import util.Enums;
import util.Modal;

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
        travarTela();
        setTitle("Aviso travamento operacional");
        pack();
    }

    public void travarTela() {
        BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI();
        Component cp = ui.getNorthPane();
        MouseMotionListener[] actions
                = (MouseMotionListener[]) cp.getListeners(MouseMotionListener.class);
        for (int i = 0; i < actions.length; i++) {
            cp.removeMouseMotionListener(actions[i]);
        }
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
        if (Modal.telaPai == null) {
            Modal.getTela(telaAviso).moveToFront();
        } else {
            Modal.telaPai = telaAviso;
        }
        Enums.setSTATUSTELA(Enums.AVISOTRAVAMENTO);
        return telaAviso;
    }

    public void listener() {
        btnIniciar.addActionListener((ActionEvent e) -> {
            dispose();
            Modal.getTela(telaAviso).dispose();
            TecladoVirtual tela = TecladoVirtual.getTela("Digite o Operador", "");
            tela.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    if (!tela.meuCampoValor.getText().isEmpty()) {
                        int options;
                        options = JOptionPane.showConfirmDialog(null, "          2807 - MATÍLIA APARECIDA DA SILVA GIRARDI\".\n"
                                + "                       Deseja Continuar?                            ", "OPERADOR SELECIONADO", JOptionPane.YES_NO_OPTION);
                        if (options == JOptionPane.YES_OPTION) {
                            TelaOP.getTela().labelOperador.setText("2807 - MATÍLIA APARECIDA DA SILVA GIRARDI");
                            TelaAvisoInicioProducao.getTela();
                        } else {
                            TelaAvisoTravamento.getTela();
                        }
                    } else {
                        TelaAvisoTravamento.getTela();
                    }
                }
            });
        });
    }
}
