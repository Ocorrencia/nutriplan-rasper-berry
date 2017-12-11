/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.extended.panel.GroupPanel;
import componente.MeuCampoFormatado;
import componente.MeuCampoGenerico;
import componente.MeuCampoTexto;
import dao.MovimentoOrdemProducaoDao;
import dao.OrdemProducaoDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;
import util.Consulta;
import util.Enums;
import util.Modal;
import util.Notificacao;
import pojo.TurnoTrabalho;
import dao.TurnoDao;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import org.joda.time.DateTime;
import pojo.MovimentoOrdemProducao;
import pojo.Operador;
import pojo.OrdemProducao;
import pojoWebService.MovimentoOrdemProducaoWebService;
import util.DadosRaspberry;

public class TelaOP extends TelaCadastro {

    public static TelaOP tela;

    MeuCampoFormatado campoOp = new MeuCampoFormatado("", false, 50);

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    URL urlTopoLogo = getClass().getResource("/imagem/logoSuperior.png");

    ImageIcon iconeprincipal = new ImageIcon(urlTopo);
    URL urlIconeInformacao = getClass().getResource("/imagem/iconeSobre.png");
    URL urlIconePlay = getClass().getResource("/imagens/icons8-circled-play.png");

    ImageIcon iconeInformacao = new ImageIcon(urlIconeInformacao);
    ImageIcon icoPlay = new ImageIcon(urlIconePlay);

    MeuCampoGenerico campoQuantidadeProgramada = new MeuCampoGenerico("Quantidade Programada:", false, 20);
    MeuCampoGenerico campoQuantidadeRefugo = new MeuCampoGenerico("Quantidade Refugos:", false, 20);
    MeuCampoGenerico campoQuantidadeRealizada = new MeuCampoGenerico("Quantidade Realizada:", false, 20);
    MeuCampoGenerico campoCicloPadraoAtual = new MeuCampoGenerico("Ciclo Padrão/Atual:", false, 20);
    MeuCampoGenerico campoPadraoUA = new MeuCampoGenerico("Padrão U.A:", false, 20);
    MeuCampoGenerico campoPesoPadrao = new MeuCampoGenerico("Peso Padrão:", false, 20);

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
    URL iconePrioridade = getClass().getResource("/imagens/icons8-high-priority-16.png");
    Icon iconPrioridade = new ImageIcon(iconePrioridade);

    JLabel labelOperador = new JLabel("OPERADOR:", iconeUser, JLabel.HORIZONTAL);
    JLabel labelPrioridade = new JLabel("PRIORIDADE: 1º", iconPrioridade, JLabel.HORIZONTAL);

    public static TecladoVirtual tecladoVirtual;
    public static TelaRefugo telaRefugo;
    public static TelaApontamentoParada telaParada;
    String codCre = "";

    TurnoTrabalho turnoTrabalho = new TurnoTrabalho();
    TurnoDao turnoDao = new TurnoDao(turnoTrabalho);

    OrdemProducao ordemProducao = new OrdemProducao();
    OrdemProducaoDao ordemProducaoDao = new OrdemProducaoDao(ordemProducao);

    MovimentoOrdemProducao mvp = new MovimentoOrdemProducao();
    MovimentoOrdemProducaoDao mvpDao = new MovimentoOrdemProducaoDao(mvp);

    public static Operador operadorPOJO = new Operador();

    boolean retorno = true;
    int codigoTurno = 0;
    String horaInicial = "";

    DateTime dt3 = new DateTime();
    DateTime dt4 = new DateTime();

    DateTime dt1 = new DateTime();
    DateTime dt2 = new DateTime();
    DateTime tempo = new DateTime();
    long cicloAtual = 0;
    long tempoProduzindo;

    MovimentoOrdemProducaoWebService mvWebService = new MovimentoOrdemProducaoWebService();

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
        super("Iniciar Apontamento de Produção");
        configBotoes();
        iniciarComponentes();
        this.setFrameIcon(iconeprincipal);
        btnQualidade.setEnabled(false);
        codCre = Consulta.CONSULTASTRING("nutri_op.op000maq", "CODCRE", "1 = 1");
        campoNomeMaquina.setText(Consulta.CONSULTASTRING("nutri_op.op725cre", "DESCRE", "CODCRE = " + codCre + ""));
        campoOp.setEditable(false);
        campoOp.setFocusable(false);
        new Thread(new Relogio()).start();
        tela = this;
        controleTelas();
        consultarTurno();
        enviarApontamentoProducao();
        iniciarVerificacaoTurno();
    }

    public MovimentoOrdemProducao getMvp() {
        return mvp;
    }

    public void setMvp(MovimentoOrdemProducao mvp) {
        this.mvp = mvp;
    }

    public OrdemProducao getOrdemProducao() {
        return ordemProducao;
    }

    public void setOrdemProducao(OrdemProducao ordemProducao) {
        this.ordemProducao = ordemProducao;
        setGUI();
    }

    public void iniciarVerificacaoTurno() {
        final long time = 60000; // a cada X ms
        Timer timer = new Timer();

        TimerTask tarefa = new TimerTask() {
            public void run() {
                try {
                    turnoTrabalho.setItensTurnoTrabalho(turnoDao.consultar());
                    for (TurnoTrabalho turnoTrabalho1 : turnoTrabalho.getItensTurnoTrabalho()) {

                        SimpleDateFormat datFormatAtual = new SimpleDateFormat("HH");
                        long timeInMillisAtual = System.currentTimeMillis();
                        Calendar dataAtual = Calendar.getInstance();
                        dataAtual.setTimeInMillis(timeInMillisAtual);

                        dt3 = new DateTime()
                                .withHourOfDay(Integer.parseInt(turnoTrabalho1.getHorIni().substring(0, 2)))
                                .withMinuteOfHour(Integer.parseInt(turnoTrabalho1.getHorIni().substring(3, 5)));

                        dt4 = new DateTime()
                                .withHourOfDay(Integer.parseInt(turnoTrabalho1.getHorFim().substring(0, 2)))
                                .withMinuteOfHour(Integer.parseInt(turnoTrabalho1.getHorFim().substring(3, 5)));

                        if (dataAtual.getTimeInMillis() >= dt3.getMillis() && dataAtual.getTimeInMillis() < dt4.getMillis()) {
                            campoTurno.setText(turnoTrabalho1.getDesTrb());
                            codigoTurno = turnoTrabalho1.getTurTrb();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(tarefa, time, time);
    }

    public void consultarTurno() {
        try {
            turnoTrabalho.setItensTurnoTrabalho(turnoDao.consultar());
            for (TurnoTrabalho turnoTrabalho1 : turnoTrabalho.getItensTurnoTrabalho()) {

                SimpleDateFormat datFormatAtual = new SimpleDateFormat("HH");
                long timeInMillisAtual = System.currentTimeMillis();
                Calendar dataAtual = Calendar.getInstance();
                dataAtual.setTimeInMillis(timeInMillisAtual);

                dt3 = new DateTime()
                        .withHourOfDay(Integer.parseInt(turnoTrabalho1.getHorIni().substring(0, 2)))
                        .withMinuteOfHour(Integer.parseInt(turnoTrabalho1.getHorIni().substring(3, 5)));

                dt4 = new DateTime()
                        .withHourOfDay(Integer.parseInt(turnoTrabalho1.getHorFim().substring(0, 2)))
                        .withMinuteOfHour(Integer.parseInt(turnoTrabalho1.getHorFim().substring(3, 5)));

                if (dataAtual.getTimeInMillis() >= dt3.getMillis() && dataAtual.getTimeInMillis() < dt4.getMillis()) {
                    campoTurno.setText(turnoTrabalho1.getDesTrb());
                    codigoTurno = turnoTrabalho1.getTurTrb();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String converterHoras(String horas) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(horas);
        return dateFormat.format(date);
    }

    public void controleTelas() {
        if (Enums.STATUSTELA == Enums.PRODUCAO || Enums.STATUSTELA == Enums.APONTAMENTODEPARADA) {
            TelaApontamentoParada.getTela().moveToFront();
        } else if (Enums.getSTATUSTELA() == Enums.MENU) {
        } else if (Enums.STATUSTELA == Enums.FINALIZADO) {
            Modal.getTela(tela).setVisible(true);
            TelaAvisoInicioProducao.getTela();
        }
    }

    private void setGUI() {
        campoProximoProduto.setText("PRÓXIMO PRODUTO: " + ordemProducao.getPrxDer() + " - " + ordemProducao.getPrxPro() + " - " + ordemProducao.getDesPrxDer() + " " + ordemProducao.getDesPrxPro());
        campoQuantidadeProgramada.setText(ordemProducao.getQtdPrv() + "UN");
        campoQuantidadeRefugo.setText(ordemProducao.getQtdRfg() + "UN");
        campoCicloPadraoAtual.setText(ordemProducao.getCicPad() + "S");
        campoQuantidadeProgramada.setText(((int) Math.round(ordemProducao.getQtdPrv())) + " UN");
        campoHoras.setFont(new Font("Arial", Font.BOLD, 15));
        campoProximoProduto.setFont(new Font("Arial", Font.BOLD, 15));
        campoOp.setFont(new Font("Arial", Font.BOLD, 30));
        campoPesoPadrao.setText(ordemProducao.getPesPad() + " KG");
        campoPadraoUA.setText(((int) Math.round(ordemProducao.getQtdMax())) + " UN");
        campoQuantidadeRealizada.setText(DadosRaspberry.QUANTIDADEPRODUZIDA + " UN");
        calcularHorasRestantes();
    }

    public void performance(double quantidadeRealizada) {

        // int calculo = (quantidadeRealizada / quantidadeTerica) * 100;
    }

    public void calcularHorasRestantes() {
        double calculo = ((ordemProducao.getQtdPrv() - Double.parseDouble(campoQuantidadeRealizada.getText().replace("UN", ""))) * 5);
        int segundos = (int) calculo;
        int segundo = segundos % 60;
        int minutos = segundos / 60;
        int minuto = minutos % 60;
        int hora = minutos / 60;
        String hms = String.format("%02d:%02d:%02d", hora, minuto, segundo);
        campoHoras.setText("HORAS RESTANTES: " + hms);
    }

    private String strzero(int n) {
        if (n < 10) {
            return "0" + String.valueOf(n);
        }
        return String.valueOf(n);
    }


    /*public void dados() {

        campoHoras.setText("HORAS RESTANTES: 03:16");
        campoProximoProduto.setText("PRÓXIMO PRODUTO: 68-734 - VASSOURA P/ GRAMA AZUL");
        campoHoras.setFocusable(false);
        campoProximoProduto.setFocusable(false);

        campoQuantidadeProgramada.setText("960un");
        campoQuantidadeRefugo.setText("03un");
        campoQuantidadeRealizada.setText("480un");
        campoCicloPadraoAtual.setText("24.5s / 27s");
        campoPadraoUA.setText("240un");
        campoPesoPadrao.setText("0,483 KG");

        campoHoras.setFont(new Font("Arial", Font.BOLD, 15));
        campoProximoProduto.setFont(new Font("Arial", Font.BOLD, 15));
        campoOp.setFont(new Font("Arial", Font.BOLD, 15));

        //ProgressBar performance
        progressBarPerformance.setFont(new Font("Arial", Font.BOLD, 15));
        progressBarPerformance.setIndeterminate(false);
        progressBarPerformance.setStringPainted(true);
        //FIM       

        //ProgressBar qualidade
        progressBarQualidade.setValue(98);
        progressBarQualidade.setString("98,17%");
        progressBarQualidade.setFont(new Font("Arial", Font.BOLD, 15));
        progressBarQualidade.setIndeterminate(false);
        progressBarQualidade.setStringPainted(true);
        //FIM       

        //ProgressBar eficiencia
        progressBarEficiencia.setValue(29);
        progressBarEficiencia.setString("29,98%");
        progressBarEficiencia.setFont(new Font("Arial", Font.BOLD, 15));
        progressBarEficiencia.setIndeterminate(false);
        progressBarEficiencia.setStringPainted(true);

        //  setBorder(BorderFactory.createTitledBorder("Title"));
        iniciarPorcentagemEficiencia();
        iniciarPorcentagemQualidade();
        //FIM     
    }*/
    public class Relogio implements Runnable {

        public void run() {
            while (true) {
                campoData.setText(getDateTime());
            }
        }
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
        painelComponentes.setLayout(new MigLayout(""));
        migLayout(0, 0, 12, 6, 1, 55, 25, campoOp, "Raised", "");
        migLayout(0, 1, 12, 0, 1, 80, 40, campoQuantidadeProgramada, "Raised", "");
        migLayout(2, 1, 12, 0, 1, 80, 40, campoQuantidadeRealizada, "Raised", "");
        migLayout(4, 1, 12, 0, 1, 80, 40, campoPadraoUA, "Raised", "");
        migLayout(0, 2, 12, 0, 1, 80, 40, campoQuantidadeRefugo, "Raised", "");
        migLayout(2, 2, 12, 0, 1, 80, 40, campoCicloPadraoAtual, "Raised", "");
        migLayout(4, 2, 12, 0, 1, 80, 40, campoPesoPadrao, "Raised", "");
        migLayout(0, 5, 12, 0, 1, 40, 40, campoHoras, "Raised", "");
        migLayout(1, 5, 12, 4, 1, 40, 40, campoProximoProduto, "Raised", "");
        migLayout(0, 9, 0, 4, 0, 40, 40, labelOperador, "Operador", "");
        migLayout(0, 9, 0, 4, 0, 40, 40, labelPrioridade, "Prioridade", "");

        campoOp.setPreferredSize(new Dimension(550, 30));

        /* campoQuantidadeProgramada.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoQuantidadeRealizada.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoPadraoUA.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoQuantidadeRefugo.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoCicloPadraoAtual.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));
        campoPesoPadrao.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 200, 28));*/
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
    }

    public void removerFundo(JTextField campo) {
        campo.setBackground(new Color(0, 0, 0, 0));
        campo.setBorder(null);
        campo.setOpaque(false);
        campo.setEditable(false);
        campo.setFocusable(false);
    }

    private void configBotoes() {
        //painelBotoes.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        btnTrocaOperador.setFont(new Font("Arial", Font.BOLD, 12));
        btnQualidade.setFont(new Font("Arial", Font.BOLD, 12));
        btnParadaMaquina.setFont(new Font("Arial", Font.BOLD, 12));
        btnMotivosRefugo.setFont(new Font("Arial", Font.BOLD, 12));
        btnFichaTecnica.setFont(new Font("Arial", Font.BOLD, 12));
        
        btnTrocaOperador.setFont(new Font("Arial", Font.BOLD, 17));
        btnQualidade.setFont(new Font("Arial", Font.BOLD, 17));
        btnParadaMaquina.setFont(new Font("Arial", Font.BOLD, 17));
        btnMotivosRefugo.setFont(new Font("Arial", Font.BOLD, 17));
        btnFichaTecnica.setFont(new Font("Arial", Font.BOLD, 17));

        campoOp.setFont(new Font("Arial", Font.BOLD, 45));
        labelPrioridade.setFont(new Font("Arial", Font.BOLD, 20));
        labelOperador.setFont(new Font("Arial", Font.BOLD, 20));
        campoQuantidadeProgramada.setFont(new Font("Arial", Font.BOLD, 45));
        campoQuantidadeRealizada.setFont(new Font("Arial", Font.BOLD, 45));
        campoPadraoUA.setFont(new Font("Arial", Font.BOLD, 45));
        campoQuantidadeRefugo.setFont(new Font("Arial", Font.BOLD, 45));
        campoCicloPadraoAtual.setFont(new Font("Arial", Font.BOLD, 45));
        campoPesoPadrao.setFont(new Font("Arial", Font.BOLD, 45));

        
        
        removerFundo(campoQuantidadeProgramada);
        removerFundo(campoQuantidadeRealizada);
        removerFundo(campoPadraoUA);
        removerFundo(campoQuantidadeRefugo);
        removerFundo(campoCicloPadraoAtual);
        removerFundo(campoPesoPadrao);
    }

    public void adicionarListener() {
        campoOp.addActionListener((ActionEvent e) -> {
            if (Enums.REFUGOSNAOIDENTIFICADOS > 0) {
                Notificacao.infoBox("Existem Refugos não Justificados!", false);
            }
        });
        btnTrocaOperador.addActionListener((ActionEvent e) -> {
            if (Enums.REFUGOSNAOIDENTIFICADOS > 0) {
                Notificacao.infoBox("Existem Refugos não Justificados!", false);

            } else {
                TecladoVirtual tela1 = TecladoVirtual.getTela("DIGITE O OPERADOR", null);
                tela1.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        if (!tela1.meuCampoValor.getText().isEmpty()) {
                            String nomeOperador = Consulta.CONSULTASTRING("nutri_op.op906ope", "NOMOPE", "" + tela1.meuCampoValor.getText() + " = NUMCAD");
                            String codigoOperador = Consulta.CONSULTASTRING("nutri_op.op906ope", "NUMCAD", "" + tela1.meuCampoValor.getText() + " = NUMCAD");

                            if (codigoOperador.equals("VAZIO")) {
                                Notificacao.infoBox("Operador não encontrado!", false);
                                TecladoVirtual.getTela("DIGITE O OPERADOR", Enums.TELAOP);
                                return;
                            }

                            int options;
                            options = JOptionPane.showConfirmDialog(null, "" + codigoOperador + " - " + "" + nomeOperador + "", "OPERADOR SELECIONADO", JOptionPane.YES_NO_OPTION);
                            if (options == JOptionPane.YES_OPTION) {
                                TelaOP.getTela().labelOperador.setText("" + codigoOperador + " - " + "" + nomeOperador + "");
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

    public void controleProducao() {
        mvp = new MovimentoOrdemProducao();
        mvp.setCodDer(ordemProducao.getCodDer());
        mvp.setCodEmp(1);
        mvp.setCodEtg(ordemProducao.getCodEtg() + "");
        mvp.setCodOri(ordemProducao.getCodOri());
        mvp.setCodPro(ordemProducao.getCodPro());
        mvp.setDatMov(getDate());
        mvp.setExpErp(0);
        mvp.setHorMov(getTime());
        mvp.setNumCad(operadorPOJO.getNumCad());
        mvp.setNumOrp(ordemProducao.getNumOrp());
        campoQuantidadeRealizada.setText(DadosRaspberry.QUANTIDADEPRODUZIDA + " UN");
        DadosRaspberry.SEQUENCIA = DadosRaspberry.SEQUENCIA + 1;
        mvp.setQtdRe1(Float.parseFloat(campoQuantidadeRealizada.getText().replace("UN", "")));
        mvp.setQtdRfg(Float.parseFloat(campoQuantidadeRefugo.getText().replace("UN", "")));
        mvp.setSeqEtr(ordemProducao.getSeqEtr());
        mvp.setSeqRot(ordemProducao.getSeqRot());
        mvp.setTurTrb(codigoTurno);
        mvpDao.setMvp(mvp);
        mvpDao.INCLUIR();
        calcularHorasRestantes();
    }

    public void enviarApontamentoProducao() {
        final long time = 40000; // a cada X ms
        Timer timer = new Timer();

        TimerTask tarefa = new TimerTask() {
            public void run() {
                try {
                    if (retorno) {
                        retorno = mvWebService.enviarMovimentoOrdemProducaoSapiens();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(tarefa, time, time);
    }
}
