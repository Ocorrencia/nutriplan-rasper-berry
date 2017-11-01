/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.extended.layout.ToolbarLayout;
import com.alee.extended.statusbar.WebMemoryBar;
import com.alee.extended.statusbar.WebStatusBar;
import com.alee.extended.statusbar.WebStatusLabel;
import com.alee.laf.button.WebButton;
import com.alee.laf.toolbar.WebToolBar;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import util.Sincronizacao;

/**
 *
 * @author diogo.melo
 */
public class TelaMenu extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/logoSuperior.png");
    URL imagemSinc = getClass().getResource("/imagens/icons8-synchronize.png");
    URL imagemRede = getClass().getResource("/imagens/icons8-network-cable.png");
    URL imagemNext = getClass().getResource("/imagens/icons8-more-than.png");
    URL imagemBack = getClass().getResource("/imagens/icons8-back.png");
    URL imagemConfig = getClass().getResource("/imagens/icons8-database-administrator.png");
    URL imagemPlay = getClass().getResource("/imagens/icons8-automation.png");
    URL imagemSair = getClass().getResource("/imagens/icons8-exit-sign-black.png");
    URL iconePrincipal = getClass().getResource("/imagem/timer.png");

    private final ImageIcon icoSinc = new ImageIcon(imagemSinc);
    private final ImageIcon icoRede = new ImageIcon(imagemRede);
    private final ImageIcon icoNext = new ImageIcon(imagemNext);
    private final ImageIcon icoBack = new ImageIcon(imagemBack);
    private final ImageIcon icoConfig = new ImageIcon(imagemConfig);
    private final ImageIcon icoPlay = new ImageIcon(imagemPlay);
    private final ImageIcon icoSair = new ImageIcon(imagemSair);
    private final ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JPanel painelBotoes = new JPanel();
    JPanel painelTitulo = new JPanel();
    JPanel painelRodape = new JPanel();
    JPanel painelOperacao = new JPanel();

    //icones menus
    GridLayout layoutTitulo = new GridLayout(0, 1);
    GridLayout layoutRodape = new GridLayout(0, 1);

    JButton btnIniciar = new JButton("INICIAR", icoPlay);
    JButton btnSincronizacao = new JButton("SINCRONIZAÇÃO", icoSinc);
    JButton btnRede = new JButton("REDE", icoRede);
    JButton tecladoVitrual = new JButton("Teclado", icoSinc);
    JButton btnSair = new JButton("SAIR", icoSair);
    JButton btnProximo = new JButton("Próximo", icoNext);
    JButton btnAnterior = new JButton("Anterior", icoBack);
    JButton btnConfig = new JButton("Configuração", icoConfig);

    public static TelaMenu tela;
    public static TecladoVirtual tecladoVirtual;

    WebStatusBar statusBar = new WebStatusBar();
    WebStatusBar statusBarSuperior = new WebStatusBar();
    WebMemoryBar memoryBar = new WebMemoryBar();
    final WebToolBar toolBar1 = new WebToolBar(WebToolBar.HORIZONTAL);

    public static TelaMenu getTela() {
        if (tela == null) {
            tela = new TelaMenu();
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

    public TelaMenu() {
        super("Menu", false, false, false, false);
        iniciarComponentes();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    private void iniciarComponentes() {
        setVisible(true);
        // this.setLayout(new GridLayout(3, 1));

        getContentPane().add("North", painelTitulo);
        getContentPane().add("West", painelOperacao);
        getContentPane().add("Center", painelBotoes);
        getContentPane().add("South", painelRodape);

        // adicionando layout
        painelBotoes.setLayout(new GridLayout());
        //  painelTitulo.setLayout(layoutTitulo);
        painelRodape.setLayout(layoutRodape);

        // adicionando colunas paineis botao 
        painelBotoes.setLayout(new GridLayout(2, 2));

        //adicionando colunas painel operacao
        painelOperacao.setLayout(new GridLayout(3, 1));

        // tamanho dos painels
        painelBotoes.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 50));
        painelRodape.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 50));
        painelTitulo.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 50));
        painelOperacao.setPreferredSize(new Dimension(200, Toolkit.getDefaultToolkit().getScreenSize().height));

        // adicionando botoes
        painelBotoes.add(btnIniciar);
        painelBotoes.add(btnSincronizacao);
        painelBotoes.add(btnRede);
        painelBotoes.add(btnSair);
        painelOperacao.add(btnProximo);
        painelOperacao.add(btnAnterior);
        painelOperacao.add(btnConfig);

        configTitulo();
        configBotoes();
        configRodape();
        alinhamentoBotoes();
        this.setSize(800, 480);
        iniciarListeners();
    }

    private void iniciarListeners() {
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaOP.getTela();
            }
        });
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTela().dispose();
            }
        });
        btnConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaConfig.getTela();
            }
        });
        tecladoVitrual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TecladoVirtual.getTela();
            }
        });
        btnSincronizacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sincronizacao.sincOperadores();
                Sincronizacao.sincFichaTecnica();
            }
        });

        btnRede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRede.getTela();
            }
        });

    }

    private void alinhamentoBotoes() {
        btnProximo.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnProximo.setHorizontalTextPosition(SwingConstants.CENTER);

        btnAnterior.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAnterior.setHorizontalTextPosition(SwingConstants.CENTER);

        btnConfig.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnConfig.setHorizontalTextPosition(SwingConstants.CENTER);

        tecladoVitrual.setVerticalTextPosition(SwingConstants.BOTTOM);
        tecladoVitrual.setHorizontalTextPosition(SwingConstants.CENTER);

        btnSair.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSair.setHorizontalTextPosition(SwingConstants.CENTER);

        btnSincronizacao.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSincronizacao.setHorizontalTextPosition(SwingConstants.CENTER);

        btnRede.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnRede.setHorizontalTextPosition(SwingConstants.CENTER);

        btnIniciar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnIniciar.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    private void configTitulo() {
        painelTitulo.add(toolBar1);
        toolBar1.setFloatable(false);
        toolBar1.add(WebButton.createIconWebButton(iconeprincipal, true));
        toolBar1.addSeparator();
        toolBar1.setPreferredSize(800, 40);
    }

    private void configBotoes() {
        //painelBotoes.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        btnSair.setFont(new Font("Arial", Font.BOLD, 20));
        btnSincronizacao.setFont(new Font("Arial", Font.BOLD, 20));
        btnRede.setFont(new Font("Arial", Font.BOLD, 20));
        tecladoVitrual.setFont(new Font("Arial", Font.BOLD, 20));
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 20));
    }

    private void configRodape() {
        //painelRodape.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        statusBar.add(new WebStatusLabel());
        memoryBar.setPreferredWidth(memoryBar.getPreferredSize().width + 20);
        statusBar.add(memoryBar, ToolbarLayout.END);
        painelRodape.add(statusBar);
    }
}
