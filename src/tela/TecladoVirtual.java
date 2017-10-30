/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;
import pojo.Operador;

public class TecladoVirtual extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    URL imagemVoltar = getClass().getResource("/imagens/icons8-exit-sign.png");
    URL imagemApagar = getClass().getResource("/imagens/icons8-backspace-filled.png");
    URL imagemOK = getClass().getResource("/imagens/icons8-enter-key.png");

    private ImageIcon icoOK = new ImageIcon(imagemOK);
    private ImageIcon icoBack = new ImageIcon(imagemVoltar);
    private ImageIcon icoApagar = new ImageIcon(imagemApagar);
    private ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JPanel painelTela = new JPanel();
    JPanel painelBotoesGrid = new JPanel();
    JPanel painelBotoesMig = new JPanel();
    JPanel painelSuperior = new JPanel();

    JTextField meuCampoValor = new JTextField();
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

    public static TecladoVirtual getTela() {
        if (tela == null) {
            tela = new TecladoVirtual();
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

    public void set(String labelInfo) {
        this.labelInfo.setText(labelInfo);
    }

    public TecladoVirtual() {
        super("Teclado Virtual", false, false, false, false);
        montarTela();
        adicionarListener();
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
        um.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "1");
            }
        });
        dois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "2");
            }
        });
        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "3");
            }
        });
        quatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "4");
            }
        });
        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "5");
            }
        });
        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "6");
            }
        });
        sete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "7");
            }
        });
        oito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "8");
            }
        });
        nove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "9");
            }
        });
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuCampoValor.setText(meuCampoValor.getText() + "0");
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operador op = new Operador();
                op.getOperador();
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTela().dispose();
            }
        });
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (meuCampoValor.getText().length() > 0) {
                    meuCampoValor.setText(meuCampoValor.getText().substring(0, meuCampoValor.getText().length() - 1));
                }
            }
        });
    }
}
