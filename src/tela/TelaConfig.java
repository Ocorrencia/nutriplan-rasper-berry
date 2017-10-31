/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import componente.MeuCampoFormatado;
import componente.MeuCampoSenha;
import dao.ConfiguracaoBancoDAO;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import pojo.ConfiguracaoBanco;
import util.Notificacao;

/**
 * ainelCom
 *
 * @author diogo.melo
 */
public class TelaConfig extends TelaCadastro {

    private static TelaConfig tela;
    MeuCampoFormatado campoServidor = new MeuCampoFormatado("Servidor:", true, 40);
    MeuCampoFormatado campoPorta = new MeuCampoFormatado("Porta:", true, 40);
    MeuCampoFormatado campoUser = new MeuCampoFormatado("User:", true, 40);
    MeuCampoFormatado campoURL = new MeuCampoFormatado("URL:", true, 40);
    MeuCampoSenha campoSenha = new MeuCampoSenha(true, "Senha:");
    ConfiguracaoBanco configBanco = new ConfiguracaoBanco();
    ConfiguracaoBancoDAO configBancoDAO = new ConfiguracaoBancoDAO();

    public static TelaConfig getTela() {
        if (tela == null) {
            tela = new TelaConfig();
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

    public TelaConfig() {
        super("Configuração do Banco de Dados");
        this.setFrameIcon(iconeprincipal);
        iniciarComponentes();
        adicionarComponentes();
        adicionarListeners();
        consultar();

        campoServidor.setFont(new Font("Arial", Font.BOLD, 12));
        campoPorta.setFont(new Font("Arial", Font.BOLD, 12));
        campoURL.setFont(new Font("Arial", Font.BOLD, 12));
        campoUser.setFont(new Font("Arial", Font.BOLD, 12));
        campoSenha.setFont(new Font("Arial", Font.BOLD, 12));
    }

    private void iniciarComponentes() {
        setVisible(true);
        this.setSize(800, 480);
        this.getContentPane().remove(painelDescricaoMaquina);
        // painelDescricaoMaquina.removeAll();;
    }

    private void adicionarComponentes() {
        migLayout(0, 1, 20, 0, 1, 70, 60, campoServidor, "", "");
        migLayout(0, 2, 20, 0, 1, 70, 60, campoPorta, "", "");
        migLayout(0, 3, 20, 0, 1, 70, 60, campoURL, "", "");
        migLayout(0, 4, 20, 0, 1, 70, 60, campoUser, "", "");
        migLayout(0, 5, 20, 0, 1, 70, 60, campoSenha, "", "");

        painelBotoes.add(btnIncluir);
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(botaocancelar);
        painelBotoes.add(btnVoltar1);

        campoServidor.setPreferredSize(new Dimension(240, 60));
        campoPorta.setPreferredSize(new Dimension(240, 60));
        campoURL.setPreferredSize(new Dimension(240, 60));
        campoUser.setPreferredSize(new Dimension(240, 60));
        campoSenha.setPreferredSize(new Dimension(240, 60));
        habilitaBotoes();
    }

    public void setPersistencia() {
        configBanco.setServidor((String) campoServidor.getValor());
        configBanco.setPorta((String) campoPorta.getValor());
        configBanco.setUrl((String) campoURL.getValor());
        configBanco.setUser((String) campoUser.getValor());
        configBanco.setSenha((String) campoSenha.getValor());
    }

    public void setGUI() {
        campoServidor.setValor((String) configBanco.getServidor());
        campoPorta.setValor((String) configBanco.getPorta());
        campoURL.setValor((String) configBanco.getUrl());
        campoUser.setValor((String) configBanco.getUser());
        campoSenha.setValor((String) configBanco.getSenha());
    }

    public void habilitaBotoes() {
        btnIncluir.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        botaocancelar.setEnabled(false);
    }

    private void adicionarListeners() {
        btnIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluir();
            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        botaocancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnVoltar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaConfig.tela.dispose();;
            }
        });
    }

    public void incluir() {
        if (validarCampos()) {
            setPersistencia();
            configBancoDAO.setPOJO(configBanco);
            if (configBancoDAO.alterar()) {
                Notificacao.infoBox("Gravado com Sucesso", true);
            } else {
                Notificacao.infoBox("Erro ao Gravar", false);
            }
        }
    }

    public void consultar() {
        configBancoDAO.consultar();
        configBanco = configBancoDAO.getPOJO();
        setGUI();
    }
}
