/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.extended.panel.GroupPanel;
import componente.MeuCampoFormatado;
import componente.MeuCampoTexto;
import componente.MeuComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;
import util.Enums;
import util.Modal;
import util.Notificacao;

public class TelaOP extends TelaCadastro {

    private static TelaOP tela;

    MeuComboBox comboOp = new MeuComboBox(null, true, "OPS");

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    URL urlTopoLogo = getClass().getResource("/imagem/logoSuperior.png");

    ImageIcon iconeprincipal = new ImageIcon(urlTopo);
    URL urlIconeInformacao = getClass().getResource("/imagem/iconeSobre.png");
    URL urlIconePlay = getClass().getResource("/imagens/icons8-circled-play.png");

    ImageIcon iconeInformacao = new ImageIcon(urlIconeInformacao);
    ImageIcon icoPlay = new ImageIcon(urlIconePlay);

    final JProgressBar progressBarPerformance = new JProgressBar(0, 100);
    final JProgressBar progressBarQualidade = new JProgressBar(0, 100);
    final JProgressBar progressBarEficiencia = new JProgressBar(0, 100);

    MeuCampoFormatado campoQuantidadeProgramada = new MeuCampoFormatado("Quantidade Programada:", false, 20);
    MeuCampoFormatado campoQuantidadeRefugo = new MeuCampoFormatado("Quantidade Refugos:", false, 20);
    MeuCampoFormatado campoQuantidadeRealizada = new MeuCampoFormatado("Quantidade Realizada:", false, 20);
    MeuCampoFormatado campoCicloPadraoAtual = new MeuCampoFormatado("Ciclo Padrão/Atual:", false, 20);
    MeuCampoFormatado campoPadraoUA = new MeuCampoFormatado("Padrão U.A:", false, 20);
    MeuCampoFormatado campoPesoPadrao = new MeuCampoFormatado("Peso Padrão:", false, 20);

    MeuCampoFormatado operador = new MeuCampoFormatado("Operador:", false, 20);

    // JButton btnIniciarProcesso = new JButton(icoPlay);
    JButton btnTrocaOperador = new JButton("OPERADOR");
    JButton btnQualidade = new JButton("QUALIDADE");
    JButton btnParadaMaquina = new JButton("PARADA");
    JButton btnMotivosRefugo = new JButton("REFUGO");
    JButton btnFichaTecnica = new JButton("FICHA TÉCNICA");
    JButton btnStatus = new JButton(iconeInformacao);

    GroupPanel gpPanel = new GroupPanel();

    public MeuCampoTexto campoHoras = new MeuCampoTexto(false, "");
    public MeuCampoTexto campoProximoProduto = new MeuCampoTexto(false, "");

    URL iconeOperador = getClass().getResource("/imagem/operador.gif");
    Icon iconeUser = new ImageIcon(iconeOperador);

    JLabel labelOperador = new JLabel("OPERADOR:", iconeUser, JLabel.HORIZONTAL);

    public static TecladoVirtual tecladoVirtual;
    public static TelaRefugo telaRefugo;
    public static TelaApontamentoParada telaParada;

    public static TelaOP getTela() {
        if (tela == null) {
            tela = new TelaOP();
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
        //  TelaSistema.jdp.moveToFront(tela);
        TelaSistema.centraliza(tela);
        Enums.setSTATUSTELA(Enums.PRODUCAO);
        return tela;
    }

    public TelaOP() {
        super("Inicar Apontamento de Produção");
        iniciarComponentes();
        painelStatus();
        painelComponente();
        painelBotoes();
        configBotoes();
        this.setFrameIcon(iconeprincipal);
        btnQualidade.setEnabled(false);
        campoNomeMaquina.setText("INJETORA 5531");
        campoTurno.setText("1º TURNO");
        campoData.setText("26/06/2017 08:48");
        tela = this;
        controleTelas();
    }

    public void controleTelas() {
        if (Enums.getSTATUSTELA() == Enums.PRODUCAO) {
            dados();
            TelaApontamentoParada.getTela().moveToFront();
        } else if (Enums.getSTATUSTELA() == Enums.MENU) {
        } else if (Enums.getSTATUSTELA() == Enums.FINALIZADO) {
            Modal.getTela(tela).setVisible(true);
            TelaAvisoInicioProducao.getTela();
        }
    }

    public void dados() {

        campoHoras.setText("HORAS RESTANTES: 03:16");
        campoProximoProduto.setText("PRÓXIMO PRODUTO: 68-734 - VASSOURA P/ GRAMA AZUL");
        campoHoras.setFocusable(false);
        campoProximoProduto.setFocusable(false);

        comboOp.addItem("68-735 - VASSOURA P/ GRAMA VERDE");
        comboOp.addItem("68-734 - VASSOURA P/ GRAMA AZUL");
        comboOp.addItem("61-14637 - VASO ROMANO 01 CERAMICA");
        comboOp.setSelectedIndex(0);

        campoQuantidadeProgramada.setText("960un");
        campoQuantidadeRefugo.setText("03un");
        campoQuantidadeRealizada.setText("480un");
        campoCicloPadraoAtual.setText("24.5s / 27s");
        campoPadraoUA.setText("240un");
        campoPesoPadrao.setText("0,483 KG");

        campoHoras.setFont(new Font("Arial", Font.BOLD, 15));
        campoProximoProduto.setFont(new Font("Arial", Font.BOLD, 15));
        comboOp.setFont(new Font("Arial", Font.BOLD, 15));

        //ProgressBar performance
        progressBarPerformance.setValue(70);
        progressBarPerformance.setString("70,79%");
        progressBarPerformance.setFont(new Font("Arial", Font.BOLD, 15));
        progressBarPerformance.setIndeterminate(false);
        progressBarPerformance.setStringPainted(true);
        iniciarPorcentagemPerformance();
        //FIM       

        //ProgressBar qualidade
        progressBarQualidade.setValue(98);
        progressBarQualidade.setString("98,17%");
        progressBarQualidade.setFont(new Font("Arial", Font.BOLD, 15));
        progressBarQualidade.setIndeterminate(false);
        progressBarQualidade.setStringPainted(true);
        iniciarPorcentagemPerformance();
        //FIM       

        //ProgressBar eficiencia
        progressBarEficiencia.setValue(29);
        progressBarEficiencia.setString("29,98%");
        progressBarEficiencia.setFont(new Font("Arial", Font.BOLD, 15));
        progressBarEficiencia.setIndeterminate(false);
        progressBarEficiencia.setStringPainted(true);

        //  setBorder(BorderFactory.createTitledBorder("Title"));
        iniciarPorcentagemPerformance();
        iniciarPorcentagemEficiencia();
        iniciarPorcentagemQualidade();
        //FIM     
    }

    public void iniciarPorcentagemPerformance() {
        new Thread() {
            @Override
            public void run() {
                if (progressBarPerformance.getValue() > 0 && progressBarPerformance.getValue() < 30) {
                    progressBarPerformance.setForeground(Color.red);
                } else if (progressBarPerformance.getValue() > 30 && progressBarPerformance.getValue() < 90) {
                    progressBarPerformance.setForeground(Color.ORANGE);
                } else if (progressBarPerformance.getValue() > 90 && progressBarPerformance.getValue() < 100) {
                    progressBarPerformance.setForeground(Color.green);
                }
            }
        }.start();
    }

    public void iniciarPorcentagemQualidade() {
        new Thread() {
            @Override
            public void run() {
                if (progressBarQualidade.getValue() > 0 && progressBarPerformance.getValue() < 30) {
                    progressBarQualidade.setForeground(Color.red);
                } else if (progressBarQualidade.getValue() > 30 && progressBarQualidade.getValue() < 90) {
                    progressBarPerformance.setForeground(Color.ORANGE);
                } else if (progressBarQualidade.getValue() > 90 && progressBarQualidade.getValue() < 100) {
                    progressBarQualidade.setForeground(Color.green);
                }
            }
        }.start();
    }

    public void iniciarPorcentagemEficiencia() {
        new Thread() {
            @Override
            public void run() {
                if (progressBarEficiencia.getValue() > 0 && progressBarEficiencia.getValue() < 30) {
                    progressBarEficiencia.setForeground(Color.red);
                } else if (progressBarEficiencia.getValue() > 30 && progressBarEficiencia.getValue() < 90) {
                    progressBarEficiencia.setForeground(Color.ORANGE);
                } else if (progressBarEficiencia.getValue() > 90 && progressBarEficiencia.getValue() < 100) {
                    progressBarEficiencia.setForeground(Color.green);
                }
            }
        }.start();
    }

    private void iniciarComponentes() {
        setVisible(true);
        this.setSize(800, 480);
        adicionaCampos();
        adicionaBotoes();
        adicionarListener();
    }

    private void adicionaCampos() {
        //  painelComponentes.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        painelComponentes.setLayout(new MigLayout());
        migLayout(0, 0, 12, 6, 1, 50, 40, comboOp, "", "");
        migLayout(0, 1, 12, 0, 1, 60, 40, campoQuantidadeProgramada, "", "");
        migLayout(2, 1, 12, 0, 1, 60, 40, campoQuantidadeRealizada, "", "");
        migLayout(4, 1, 12, 0, 1, 60, 40, campoPadraoUA, "", "");
        migLayout(0, 2, 12, 0, 1, 60, 40, campoQuantidadeRefugo, "", "");
        migLayout(2, 2, 12, 0, 1, 60, 40, campoCicloPadraoAtual, "", "");
        migLayout(4, 2, 12, 0, 1, 60, 40, campoPesoPadrao, "", "");
        migLayout(0, 5, 12, 0, 1, 40, 40, campoHoras, "", "");
        migLayout(1, 5, 12, 4, 1, 40, 40, campoProximoProduto, "", "");
        migLayout(0, 8, 0, 2, 1, 50, 40, progressBarPerformance, "Performance", "");
        migLayout(2, 8, 0, 2, 1, 50, 40, progressBarQualidade, "Qualidade", "");
        migLayout(4, 8, 0, 2, 1, 50, 40, progressBarEficiencia, "Eficiência", "");
        migLayout(0, 9, 0, 4, 0, 40, 40, labelOperador, "", "");

        comboOp.setPreferredSize(new Dimension(550, 30));

        campoQuantidadeProgramada.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoQuantidadeRealizada.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoPadraoUA.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoQuantidadeRefugo.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoCicloPadraoAtual.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoPesoPadrao.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));

        campoHoras.setPreferredSize(new Dimension(220, 20));
        campoProximoProduto.setPreferredSize(new Dimension(500, 20));

        campoHoras.setEditable(false);
        campoProximoProduto.setEditable(false);

        //campoHoras.setAlignmentX(CENTER_ALIGNMENT);
        //campoProximoProduto.setAlignmentX(CENTER_ALIGNMENT);
    }

    public void adicionaBotoes() {

        adicionarBotoes(painelBotoes, btnTrocaOperador);
        adicionarBotoes(painelBotoes, btnQualidade);
        adicionarBotoes(painelBotoes, btnParadaMaquina);
        adicionarBotoes(painelBotoes, btnMotivosRefugo);
        adicionarBotoes(painelBotoes, btnFichaTecnica);
        //adicionarBotoes(painelBotoes, btnIniciarProcesso);
        //adicionarBotoes(painelBotoes, btnStatus);

    }

    private void configBotoes() {
        //painelBotoes.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        btnTrocaOperador.setFont(new Font("Arial", Font.BOLD, 12));
        btnQualidade.setFont(new Font("Arial", Font.BOLD, 12));
        btnParadaMaquina.setFont(new Font("Arial", Font.BOLD, 12));
        btnMotivosRefugo.setFont(new Font("Arial", Font.BOLD, 12));
        btnFichaTecnica.setFont(new Font("Arial", Font.BOLD, 12));

        campoQuantidadeProgramada.setEditable(false);
        campoQuantidadeRealizada.setEditable(false);
        campoPadraoUA.setEditable(false);
        campoQuantidadeRefugo.setEditable(false);
        campoCicloPadraoAtual.setEditable(false);
        campoPesoPadrao.setEditable(false);
        campoHoras.setEditable(false);
    }

    private void painelStatus() {
        //  painelDescricaoMaquina.setBorder(BorderFactory.createLineBorder(Color.red));
    }

    private void painelComponente() {
        // painelComponentes.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
    }

    private void painelBotoes() {
        // painelBotoes.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void adicionarListener() {
        comboOp.addActionListener((ActionEvent e) -> {
            if (Enums.REFUGOSNAOIDENTIFICADOS > 0) {
                Notificacao.infoBox("Existem Refugos não Justificados!", false);
            }
        });
        btnTrocaOperador.addActionListener((ActionEvent e) -> {
            if (Enums.REFUGOSNAOIDENTIFICADOS > 0) {
                Notificacao.infoBox("Existem Refugos não Justificados!", false);

            } else {
                TecladoVirtual tela1 = TecladoVirtual.getTela("Digite o Operador", null);
                tela1.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        if (!tela1.meuCampoValor.getText().isEmpty()) {
                            int options;
                            options = JOptionPane.showConfirmDialog(null, "          2807 - MATÍLIA APARECIDA DA SILVA GIRARDI\".\n"
                                    + "                       Deseja Continuar?                            ", "OPERADOR SELECIONADO", JOptionPane.YES_NO_OPTION);
                            if (options == JOptionPane.YES_OPTION) {
                                labelOperador.setText("2807 - MATÍLIA APARECIDA DA SILVA GIRARDI");
                                Modal.getTela(tela1).dispose();
                            } else {
                                Modal.getTela(tela1).dispose();
                            }
                        } else {
                            Notificacao.infoBox("Nenhum operador Selecionado!", false);
                            Modal.getTela(tela1).dispose();
                        }
                    }
                });
            }
        });

        btnFichaTecnica.addActionListener((ActionEvent e) -> {
            TelaFichaTecnica.getTela();
        });

        btnMotivosRefugo.addActionListener((ActionEvent e) -> {
            TelaRefugo telaRef = telaRefugo.getTela();
            telaRef.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    Modal.getTela(null).dispose();
                    Enums.setSTATUSTELA(Enums.LIBERADOPRODUCAO);
                }
            });
            /* TecladoVirtual tela = tecladoVirtual.getTela();
            tela.set("Digite o código de parada");
            tela.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
            telaRef.dispose();
            JOptionPane.showConfirmDialog(null, "187 - FALTA DE INSUMOS. \n"
            + "               Deseja Continuar?", "Operador Selecionado", JOptionPane.YES_OPTION);
            
            }
            });*/
        });
        btnCancelar.addActionListener((ActionEvent e) -> {
        });
        btnParadaMaquina.addActionListener((ActionEvent e) -> {
            Modal.getTela(tela).setVisible(true);
            TelaApontamentoParada.getTela();
        });
    }
}
