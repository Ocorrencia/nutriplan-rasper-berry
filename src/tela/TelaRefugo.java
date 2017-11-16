/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import componente.MeuComboBox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;
import util.Enums;
import util.Modal;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class TelaRefugo extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JPanel painelGeral = new JPanel();
    private static TelaRefugo tela;

    JPanel panelRefugoJustificado = new JPanel();
    JLabel lbQuantidadeNaoJustificados = new JLabel("REFUGOS NÃO JUSTIFICADOS");
    JLabel campoQuantidadeNaoJustificados = new JLabel();

    JPanel panelRefugoNaoJustificado = new JPanel();
    JLabel lbQuantidadeInformado = new JLabel("REFUGOS JUSTIFICADOS");
    JLabel campoQuantidadeInformado = new JLabel();

    JPanel panelMotivoRefugo = new JPanel();
    MeuComboBox comboMotivoRefugo = new MeuComboBox(null, false, "Motivo Refugo");
    JLabel lbMotivoRefugo = new JLabel(comboMotivoRefugo.getDica());
    static JButton btnMotivosRefugo = new JButton("JUSTIFICAR");

    JPanel panelJustificativaRefugo = new JPanel();
    JLabel lbJustificativaRefugo = new JLabel("QUANTIDADE");
    public JTextField campoJustificativaRefugo = new JTextField();

    //TODO REMOVER BOTAO DEPOIS DE FINALIZADO O APP
    TelaBotaoRefugo botaoRefugo = new TelaBotaoRefugo();

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
        if (Modal.telaPai == null) {
            Modal.getTela(tela).moveToFront();
        } else {
            Modal.getTela(tela).setVisible(true);
            Modal.telaPai = tela;
            tela.moveToFront();
        }
        return tela;
    }

    public TelaRefugo() {
        super("Refugo", false, true, false, false);
        setSize(new Dimension(700, 400));
        panelRefugoNaoJustificado.setPreferredSize(new Dimension(350, 133));
        panelRefugoJustificado.setPreferredSize(new Dimension(700, 133));
        panelJustificativaRefugo.setPreferredSize(new Dimension(350, 133));
        panelMotivoRefugo.setPreferredSize(new Dimension(700, 133));
        setVisible(true);
        this.setFrameIcon(iconeprincipal);
        panelRefugoJustificado.setBorder(BorderFactory.createTitledBorder(""));
        panelJustificativaRefugo.setBorder(BorderFactory.createTitledBorder(""));
        panelRefugoNaoJustificado.setBorder(BorderFactory.createTitledBorder(""));
        panelMotivoRefugo.setBorder(BorderFactory.createTitledBorder("Justificar Motivos do Refugo"));

        initiComponente();
        tamanhoFontes();

        comboMotivoRefugo.addItem("1000 - PEÇAS NÃO PREENCHIDAS");
        listener();
        botaoRefugo.setVisible(true);

        campoQuantidadeNaoJustificados.setText("0" + Enums.REFUGOSNAOIDENTIFICADOS);
        campoQuantidadeInformado.setText("0" + Enums.REFUGOSJUSTIFICADOS);

        comboMotivoRefugo.setSelectedIndex(-1);
    }

    private void initiComponente() {
        //   panelJustificados.setLayout(new GridLayout(2,0));
        setLayout(new MigLayout());
        panelRefugoNaoJustificado.setLayout(new BoxLayout(panelRefugoNaoJustificado, BoxLayout.Y_AXIS));
        panelJustificativaRefugo.setLayout(new BoxLayout(panelJustificativaRefugo, BoxLayout.Y_AXIS));
        panelRefugoJustificado.setLayout(new BoxLayout(panelRefugoJustificado, BoxLayout.Y_AXIS));
        panelMotivoRefugo.setLayout(new BoxLayout(panelMotivoRefugo, BoxLayout.Y_AXIS));
        //  panelJustificados.setLayout(new MigLayout());
        //  panelJustificados.setLayout(new MigLayout());

        panelJustificativaRefugo.add(lbJustificativaRefugo);
        panelJustificativaRefugo.add(campoJustificativaRefugo);

        panelRefugoNaoJustificado.add(lbQuantidadeNaoJustificados);
        panelRefugoNaoJustificado.add(campoQuantidadeNaoJustificados);

        lbQuantidadeNaoJustificados.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        campoQuantidadeNaoJustificados.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        lbQuantidadeInformado.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        campoQuantidadeInformado.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        btnMotivosRefugo.setAlignmentX(JButton.CENTER_ALIGNMENT);

        lbMotivoRefugo.setAlignmentX(JButton.CENTER_ALIGNMENT);

        panelRefugoJustificado.add(lbQuantidadeInformado);
        panelRefugoJustificado.add(campoQuantidadeInformado);

        panelMotivoRefugo.add(lbMotivoRefugo);
        panelMotivoRefugo.add(comboMotivoRefugo);
        panelMotivoRefugo.add(btnMotivosRefugo);

        add(panelMotivoRefugo, "span, wrap");
        add(panelRefugoNaoJustificado);
        add(panelJustificativaRefugo, "wrap");
        add(panelRefugoJustificado, "span");
    }

    public void tamanhoFontes() {
        lbQuantidadeInformado.setFont(new Font("Arial", Font.BOLD, 20));
        campoQuantidadeInformado.setFont(new Font("Arial", Font.BOLD, 60));
        lbQuantidadeNaoJustificados.setFont(new Font("Arial", Font.BOLD, 20));
        campoQuantidadeNaoJustificados.setFont(new Font("Arial", Font.BOLD, 60));
        lbJustificativaRefugo.setFont(new Font("Arial", Font.BOLD, 20));
        campoJustificativaRefugo.setFont(new Font("Arial", Font.BOLD, 60));
        campoJustificativaRefugo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    }

    private void listener() {
        btnMotivosRefugo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String quantidadeNaoJustificada = campoQuantidadeNaoJustificados.getText() == "" ? "0" : campoQuantidadeNaoJustificados.getText();
                String quantidadeJustificativaRefugo = campoJustificativaRefugo.getText() == "" ? "0" : campoJustificativaRefugo.getText();

                if ("".equals(campoJustificativaRefugo.getText())) {
                    Notificacao.infoBox("Quantidade de Refugo não informada", false);
                } else if (comboMotivoRefugo.getSelectedIndex() == -1) {
                    Notificacao.infoBox("Selecione um Motivo de Refugo!", false);
                } else if (Enums.REFUGOSNAOIDENTIFICADOS == 0) {
                    Notificacao.infoBox("Não existem Refugos para Justificar!", false);
                } else if ("".equals(campoJustificativaRefugo.getText())) {
                    Notificacao.infoBox("Valor Inválido", false);
                } else if ("0".equals(campoJustificativaRefugo.getText())) {
                    Notificacao.infoBox("Valor Inválido", false);
                } else if (Integer.parseInt(quantidadeNaoJustificada) < Integer.parseInt(quantidadeJustificativaRefugo)) {
                    Notificacao.infoBox("Quantidade Inválida!", false);
                } else {
                    calcular();
                }
            }
        }
        );
        campoJustificativaRefugo.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                if (comboMotivoRefugo.getSelectedIndex() == -1) {
                    Notificacao.infoBox("Selecione um Motivo de Refugo!", false);
                } else if (Enums.REFUGOSNAOIDENTIFICADOS == 0) {
                    Notificacao.infoBox("Não existem Refugos para Justificar!", false);
                } else {
                    TecladoVirtual teclado = TecladoVirtual.getTela("Digite a Quantidade", null);
                    teclado.addInternalFrameListener(new InternalFrameAdapter() {
                        @Override
                        public void internalFrameClosed(InternalFrameEvent e) {
                            campoJustificativaRefugo.setText(teclado.meuCampoValor.getText());
                            Modal.getTela(tela).setVisible(false);
                        }
                    });
                }
            }
        }
        );
    }

    public void calcular() {

        int resto = Integer.parseInt(campoJustificativaRefugo.getText()) - Integer.parseInt(campoQuantidadeNaoJustificados.getText());
        resto = resto < 0 ? resto * -1 : resto;
        int justificado = Enums.REFUGOSJUSTIFICADOS + Integer.parseInt(campoJustificativaRefugo.getText());

        Enums.REFUGOSJUSTIFICADOS = justificado;
        Enums.REFUGOSNAOIDENTIFICADOS = resto;

        campoQuantidadeInformado.setText("0" + justificado);
        campoQuantidadeNaoJustificados.setText("0" + resto);

        campoJustificativaRefugo.setText("");

        /*int calculo = Enums.REFUGOSJUSTIFICADOS + Enums.REFUGOSNAOIDENTIFICADOS - Integer.parseInt(campoJustificativaRefugo.getText());
        Enums.REFUGOSNAOIDENTIFICADOS = calculo;
        Enums.REFUGOSJUSTIFICADOS = Enums.REFUGOSJUSTIFICADOS + Integer.parseInt(campoJustificativaRefugo.getText());
        campoQuantidadeNaoJustificados.setText("0");
        campoQuantidadeInformado.setText("0" + calculo);*/
    }
}
