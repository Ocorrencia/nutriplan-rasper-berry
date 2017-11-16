/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.extended.label.WebStepLabel;
import com.alee.laf.tabbedpane.WebTabbedPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;
import util.Servidor;

/**
 *
 * @author diogo.melo
 */
public class TelaRede extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/logoSuperior.png");
    private final ImageIcon iconeprincipal = new ImageIcon(urlTopo);
    URL urlError = getClass().getResource("/imagens/icons8-disconnected.png");
    URL urlCon = getClass().getResource("/imagens/icons8-connected.png");
    private final ImageIcon iconeError = new ImageIcon(urlError);
    private final ImageIcon iconeConnected = new ImageIcon(urlCon);
    WebTabbedPane tabbedPane3 = new WebTabbedPane();
    private static TelaRede tela;
    JButton btnVoltar = new JButton();

    /*SOFTWARE*/
    WebStepLabel s1 = new WebStepLabel();
    WebStepLabel s2 = new WebStepLabel();
    WebStepLabel s3 = new WebStepLabel();
    WebStepLabel s4 = new WebStepLabel();
    WebStepLabel s5 = new WebStepLabel();
    WebStepLabel s6 = new WebStepLabel();
    WebStepLabel s7 = new WebStepLabel();
    WebStepLabel s8 = new WebStepLabel();

    JLabel lbIpServidor = new JLabel("IP SERVIDOR:..");
    JLabel lbIpServidorD = new JLabel("");
    JLabel lbPortaServidor = new JLabel("PORTA SERVIDOR:..");
    JLabel lbPortaServidorD = new JLabel();
    JLabel lbEnderecoSocket = new JLabel("ENDEREÇO SOCKET:..");
    JLabel lbEnderecoSocketD = new JLabel();
    JLabel lbCanal = new JLabel("CANAL:..");
    JLabel lbCanalD = new JLabel();
    JLabel lbTimeOut = new JLabel("TIME OUT:.");
    JLabel lbTimeOutD = new JLabel();

    /**/

    /**
     *
     * @return
     */

    public static TelaRede getTela() {
        if (tela == null) {
            tela = new TelaRede();
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

    public TelaRede() {
        super("Informações de Rede", true, true, true);
        setVisible(true);
        setFrameIcon(iconeprincipal);
        tabbedPane3.setPreferredSize(new Dimension(700, 420));
        tabbedPane3.setTabPlacement(WebTabbedPane.LEFT);
        this.add(tabbedPane3);

        tabbedPane3.addTab("Software", painelServidor());
        tabbedPane3.addTab("Raspberry Pi", painelRasper());

        pack();
        setInfo();
        adicionarListener();
    }

    public JLabel tamanhoFonte(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 20));
        return label;
    }

    public void setInfo() {
        try {
            if (!Servidor.servidor.isClosed()) {
                s1.setIcon(iconeConnected);
                s2.setIcon(iconeConnected);
                s3.setIcon(iconeConnected);
                s4.setIcon(iconeConnected);
                s5.setIcon(iconeConnected);

                lbIpServidorD.setText("" + Servidor.servidor.getInetAddress());
                lbPortaServidorD.setText("" + Servidor.servidor.getLocalPort());
                lbEnderecoSocketD.setText("" + Servidor.servidor.getLocalSocketAddress());

                lbCanalD.setText("" + Servidor.servidor.getChannel());
                if (Servidor.servidor.getChannel() == null) {
                    s4.setIcon(iconeError);
                }

                lbTimeOutD.setText("" + Servidor.servidor.getSoTimeout());
                if (Servidor.servidor.getSoTimeout() == 0) {
                    s5.setIcon(iconeError);
                }

            } else {
                s1.setIcon(iconeError);
                s2.setIcon(iconeError);
                s3.setIcon(iconeError);
                s4.setIcon(iconeError);
                s5.setIcon(iconeError);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel painelServidor() {
        JPanel painelServidor = new JPanel();
        painelServidor.setLayout(new MigLayout());
        painelServidor.add(s1);
        painelServidor.add(tamanhoFonte(lbIpServidor), "gapleft 20");
        painelServidor.add(tamanhoFonte(lbIpServidorD), "wrap");
        painelServidor.add(s2);
        painelServidor.add(tamanhoFonte(lbPortaServidor), "gapleft 20");
        painelServidor.add(tamanhoFonte(lbPortaServidorD), "wrap");
        painelServidor.add(s3);
        painelServidor.add(tamanhoFonte(lbEnderecoSocket), "gapleft 20");
        painelServidor.add(tamanhoFonte(lbEnderecoSocketD), "wrap");
        painelServidor.add(s4);
        painelServidor.add(tamanhoFonte(lbCanal), "gapleft 20");
        painelServidor.add(tamanhoFonte(lbCanalD), "wrap");
        painelServidor.add(s5);
        painelServidor.add(tamanhoFonte(lbTimeOut), "gapleft 20");
        painelServidor.add(tamanhoFonte(lbTimeOutD), "wrap");
        painelServidor.add(btnVoltar);
        return painelServidor;
    }

    public JPanel painelRasper() {
        JPanel painelRasper = new JPanel();

        return painelRasper;
    }

    private void adicionarListener() {
        btnVoltar.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }
}
