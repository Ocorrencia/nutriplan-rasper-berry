/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.miginfocom.swing.MigLayout;
import util.Enums;
import util.Modal;
import util.Notificacao;

public class TecladoVirtual extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    URL imagemVoltar = getClass().getResource("/imagens/icons8-exit-sign.png");
    URL imagemApagar = getClass().getResource("/imagens/icons8-backspace-filled.png");
    URL imagemOK = getClass().getResource("/imagens/icons8-enter-key.png");

    private final ImageIcon icoOK = new ImageIcon(imagemOK);
    private final ImageIcon icoBack = new ImageIcon(imagemVoltar);
    private final ImageIcon icoApagar = new ImageIcon(imagemApagar);
    private final ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JPanel painelTela = new JPanel();
    JPanel painelBotoesGrid = new JPanel();
    JPanel painelBotoesMig = new JPanel();
    JPanel painelSuperior = new JPanel();

    public JTextField meuCampoValor = new JTextField();
    JButton um = new JButton("1");
    JButton dois = new JButton("2");
    JButton tres = new JButton("3");
    JButton quatro = new JButton("4");
    JButton cinco = new JButton("5");
    JButton seis = new JButton("6");
    JButton sete = new JButton("7");
    JButton oito = new JButton("8");
    JButton nove = new JButton("9");
    JButton zero = new JButton("0");
    JButton ok = new JButton("", icoOK);
    JButton voltar = new JButton("", icoBack);
    JButton apagar = new JButton("", icoApagar);
    public JLabel labelInfo = new JLabel("");
    MigLayout migLayout = new MigLayout();
    private static TecladoVirtual tela;
    private static TelaOP telaOP;
    String abrirTela;

    static String STATUSTELA = "";

    public static TecladoVirtual getTela(String mensagem, String abrirTela) {
        if (tela == null) {
            tela = new TecladoVirtual(mensagem, abrirTela);
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
        if (Modal.telaPai == null) {
            Modal.getTela(tela).moveToFront();
        } else {
            Modal.telaPai = tela;
        }

        TelaSistema.jdp.moveToFront(tela);
        TelaSistema.centraliza(tela);
        return tela;
    }

    public TecladoVirtual(String mensagem, String abrirTela) {
        super("Teclado Virtual", false, false, false, false);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.labelInfo.setText(mensagem);
        this.abrirTela = abrirTela;
        montarTela();
        adicionarListener();
        listenerJInternal();
        Modal.getTela(this);
        travarTela();
    }

    public void travarTela() {
        BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI();
        Component cp = ui.getNorthPane();
        MouseMotionListener[] actions
                = (MouseMotionListener[]) cp.getListeners(MouseMotionListener.class);
        for (MouseMotionListener action : actions) {
            cp.removeMouseMotionListener(action);
        }
    }

    public void tamanhoBotao() {
        um.setPreferredSize(new Dimension(60, 60));
        dois.setPreferredSize(new Dimension(60, 40));
        tres.setPreferredSize(new Dimension(60, 40));
        quatro.setPreferredSize(new Dimension(60, 40));
        cinco.setPreferredSize(new Dimension(60, 40));
        seis.setPreferredSize(new Dimension(60, 40));
        sete.setPreferredSize(new Dimension(60, 40));
        oito.setPreferredSize(new Dimension(60, 40));
        nove.setPreferredSize(new Dimension(60, 40));
        voltar.setPreferredSize(new Dimension(60, 40));
        ok.setPreferredSize(new Dimension(60, 40));
        zero.setPreferredSize(new Dimension(60, 40));
        apagar.setPreferredSize(new Dimension(55, 60));
    }

    private void montarTela() {
        setVisible(true);
        setTitle("Teclado Virtual");
        this.setFrameIcon(iconeprincipal);
        tamanhoBotao();
        this.setSize(new Dimension(400, 290));
        this.setLayout(migLayout);

        meuCampoValor.setPreferredSize(new Dimension(300, 60));
        meuCampoValor.setFont(new Font("Arial", Font.BOLD, 30));
        add(painelSuperior, "span, grow");
        add(painelTela, "wrap");
        add(painelBotoesMig);

        painelSuperior.add(this.labelInfo);
        /*  painelSuperior.setBorder(BorderFactory.createLineBorder(Color.RED));/*
        painelBotoesGrid.setBorder(BorderFactory.createLineBorder(Color.GREEN));*/
        painelBotoesMig.add(painelBotoesGrid);
        painelBotoesGrid.setLayout(new GridLayout(2, 5));
        painelTela.add(meuCampoValor);
        painelTela.add(apagar);
        painelBotoesGrid.add(um);
        painelBotoesGrid.add(dois);
        painelBotoesGrid.add(tres, "wrap");
        painelBotoesGrid.add(quatro);
        painelBotoesGrid.add(cinco);
        painelBotoesGrid.add(seis, "wrap");
        painelBotoesGrid.add(sete);
        painelBotoesGrid.add(oito);
        painelBotoesGrid.add(nove, "wrap");
        painelBotoesGrid.add(zero);
        painelBotoesGrid.add(ok);

        painelBotoesGrid.add(voltar);
        //  pack();
    }

    public void adicionarListener() {
        um.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "1");
        });
        dois.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "2");
        });
        tres.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "3");
        });
        quatro.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "4");
        });
        cinco.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "5");
        });
        seis.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "6");
        });
        sete.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "7");
        });
        oito.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "8");
        });
        nove.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "9");
        });
        zero.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText(meuCampoValor.getText() + "0");
        });
        ok.addActionListener((ActionEvent e) -> {
            getTela("", "").dispose();
        });
        voltar.addActionListener((ActionEvent e) -> {
            meuCampoValor.setText("");
            getTela("", "").dispose();
        });
        apagar.addActionListener((ActionEvent e) -> {
            if (meuCampoValor.getText().length() > 0) {
                meuCampoValor.setText(meuCampoValor.getText().substring(0, meuCampoValor.getText().length() - 1));
            }
        });
    }

    private void listenerJInternal() {
        this.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                Modal.telaPai.moveToFront();

                if (!meuCampoValor.getText().isEmpty()) {
                    /* -------------------------------------- */
                    if (abrirTela.equals(Enums.TELAOP)) {
                        if ("".equals(meuCampoValor.getText())) {
                            TecladoVirtual.getTela("Digite o Operador", Enums.TELAOP);
                            return;
                        } else {
                            int options;
                            options = JOptionPane.showConfirmDialog(null, "          2807 - MATÍLIA APARECIDA DA SILVA GIRARDI\".\n"
                                    + "                       Deseja Continuar?                            ", "OPERADOR SELECIONADO", JOptionPane.YES_NO_OPTION);
                            if (options == JOptionPane.YES_OPTION) {
                                Enums.setSTATUSTELA(Enums.getSTATUSTELA() == Enums.PRODUCAO ? Enums.PRODUCAO : Enums.FINALIZADO);
                                Modal.getTela(tela).dispose();
                                TelaOP.getTela();
                                TelaOP.getTela().labelOperador.setText("2807 - MATÍLIA APARECIDA DA SILVA GIRARDI");
                            } else {
                                TecladoVirtual.getTela("Selecione o Operador", Enums.TELAOP);
                            }
                        }

                    }
                    /* -------------------------------------- */
                    if (abrirTela.equals(Enums.TELAMENU)) {
                        if (!meuCampoValor.getText().equals(Enums.SENHA)) {
                            Notificacao.infoBox("Código Incorreto", false);
                            TecladoVirtual.getTela("Digite o Código", Enums.TELAMENU);
                            Enums.setSTATUSTELA(Enums.MENU);
                        } else if (Enums.getSTATUSTELA() == Enums.MENU) {
                            TelaOP.getTela().dispose();
                            TelaMenu.getTela();
                            Enums.setSTATUSTELA(Enums.MENU);
                            return;
                        }
                    }
                    /* -------------------------------------- */
                    if (abrirTela == null ? Enums.TELAAP == null : abrirTela.equals(Enums.TELAAP)) {
                        int resp = JOptionPane.showConfirmDialog(null, "ESSE 1023 - FALTA DE INSUMOS. \n"
                                + "               Deseja Continuar?", "APONTAMENTO DE PARADA", JOptionPane.YES_OPTION);
                        if (resp == 0) {
                            TelaApontamentoParada.getTela().dispose();
                            Modal.getTela(telaOP).dispose();
                            TelaAvisoTravamento.getTela();
                        }
                    }
                    /* -------------------------------------- */
                } else {
                    TecladoVirtual.getTela("Selecione o Operador", Enums.TELAOP);
                }

            }
        }
        );
    }
}
