/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import componente.MensagensSistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import util.Consulta;
import util.Enums;
import util.Modal;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class TelaAvisoTravamento extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JLabel lbParada = new JLabel("PARADA DE MÁQUINA");
    JLabel lbTempo = new JLabel("00:00:00");
    public JLabel lbTipo = new JLabel("");

    URL urlTimeWarning = getClass().getResource("/imagens/icons8-expired_1.png");
    ImageIcon icoWarning = new ImageIcon(urlTimeWarning);

    JLabel iconeWarning = new JLabel(icoWarning);
    JButton btnIniciar = new JButton("INICIAR");
    JButton btnVoltar = new JButton("VOLTAR");
    public static TelaAvisoTravamento telaAviso;

    public TelaAvisoTravamento() {

        JPanel painelInfo = new JPanel();
        setVisible(true);
        setResizable(false);
        setTitle("AVISO");

        btnIniciar.setPreferredSize(new Dimension(700, 60));
        btnVoltar.setPreferredSize(new Dimension(700, 60));
        lbParada.setFont(new Font("Arial", Font.BOLD, 42));
        lbTempo.setFont(new Font("Arial", Font.BOLD, 30));
        lbTipo.setFont(new Font("Arial", Font.BOLD, 30));
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 40));
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 40));
        painelInfo.setLayout(new MigLayout());
        this.setFrameIcon(iconeprincipal);
        painelInfo.add(iconeWarning, "align center,wrap");
        painelInfo.add(lbParada, "align center,wrap");
        painelInfo.add(lbTempo, "align center,wrap");
        painelInfo.add(lbTipo, "align center, wrap");
        painelInfo.add(btnIniciar, "align center, wrap");
        painelInfo.add(btnVoltar, "align center");
        add(painelInfo);
        listener();
        travarTela();
        setTitle("Aviso travamento operacional");
        setPreferredSize(new Dimension(700, 400));
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
        Enums.setSTATUSTELA(Enums.APONTAMENTODEPARADA);
        return telaAviso;
    }

    public void listener() {
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TelaApontamentoParada.getTela();
            }
        });

        btnIniciar.addActionListener((ActionEvent e) -> {
            dispose();
            Modal.getTela(telaAviso).dispose();
            TecladoVirtual tela = TecladoVirtual.getTela("DIGITE O OPERADOR", "");
            tela.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    if (!tela.meuCampoValor.getText().isEmpty()) {

                        String nomeOperador = Consulta.CONSULTASTRING("nutri_op.op906ope", "NOMOPE", "" + tela.meuCampoValor.getText() + " = NUMCAD");
                        String codigoOperador = Consulta.CONSULTASTRING("nutri_op.op906ope", "NUMCAD", "" + tela.meuCampoValor.getText() + " = NUMCAD");

                        if (codigoOperador.equals("VAZIO")) {
                            Notificacao.infoBox("Operador não encontrado!", false);
                            TecladoVirtual.getTela("DIGITE O OPERADOR", Enums.TELAOP);
                            return;
                        }
                        int options;

                        String operador = "" + codigoOperador + " - " + "" + nomeOperador + "";
                        if (MensagensSistema.MensagemConfirmarOperacao1(operador).equals("SIM")) {
                            TelaOP.getTela().labelOperador.setText("" + codigoOperador + " - " + "" + nomeOperador + "");
                            TelaOP.getTela().operadorPOJO.setNumCad(Integer.parseInt(codigoOperador));
                            TelaAvisoInicioProducao.getTela();
                        } else {
                            TelaAvisoTravamento.getTela();
                        }
                    } else {
                        TelaApontamentoParada.getTela();
                    }
                }
            }
            );
        });
    }
}
