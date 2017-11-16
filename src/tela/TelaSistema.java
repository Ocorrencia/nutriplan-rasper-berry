/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.progressbar.WebProgressBar;
import dao.ControleOperacao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import util.Enums;

/**
 *
 * @author diogo.melo
 */
public class TelaSistema extends JFrame {

    public static MeuJDesktopPane jdp = new MeuJDesktopPane();
    final WebProgressBar progressBar = new WebProgressBar(0, 100);
    //private boolean increasing = true;
    JPanel jPanelProgressBar = new JPanel();
    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);
    public static TelaSistema telaSistema;
    //Servidor servidor = new Servidor();
    //usuarioDao usu = new usuarioDao();
    Enums consta;

    public TelaSistema() {
        getContentPane().add(jdp);
        setIconImage(iconeprincipal.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 480));
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white));
        setVisible(true);
        controleDeOperacao();
        setLocationRelativeTo(null);
        //servidor.iniciarServidor();
        travar();

    }

    public static void main(String args[]) throws IOException {
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
            telaSistema = new TelaSistema();
            System.gc();
            if (Enums.getSTATUSTELA() == Enums.PRODUCAO) {
                TelaOP.getTela();
            } else if (Enums.getSTATUSTELA() == Enums.MENU) {
                TelaMenu.getTela();
                TelaMenu.tela.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        telaSistema.dispose();
                    }
                });
            } else if (Enums.getSTATUSTELA() == Enums.PADRAO) {
                TelaMenu.getTela();
                TelaMenu.tela.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        telaSistema.dispose();
                    }
                });
            } else if (Enums.getSTATUSTELA() == Enums.FINALIZADO) {
                TecladoVirtual teclado = TecladoVirtual.getTela("Digite o Operador", Enums.TELAOP);
            }
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }

    public void controleDeOperacao() {
        Enums.setTIPOSISTEMA(Enums.WINDOWS);
        switch (ControleOperacao.consultar()) {
            case "PRODUCAO":
                Enums.setSTATUSTELA(Enums.PRODUCAO);
                break;
            case "MENU":
                Enums.setSTATUSTELA(Enums.MENU);
                break;
            case "FINALIZADO":
                Enums.setSTATUSTELA(Enums.FINALIZADO);
                break;
        }
    }

    public void fecharTela() {
        this.dispose();
    }

    public void travar() {
        JInternalFrame[] frames = TelaSistema.jdp.getAllFrames();
        for (JInternalFrame frame : frames) {
            BasicInternalFrameUI ui = (BasicInternalFrameUI) frame.getUI();
            Component northPane = ui.getNorthPane();
            MouseMotionListener[] motionListeners = (MouseMotionListener[]) northPane.getListeners(MouseMotionListener.class
            );

            for (MouseMotionListener listener : motionListeners) {
                northPane.removeMouseMotionListener(listener);
            }
        }
    }

    public static void centraliza(JInternalFrame janela) {
        int larguraDesk = jdp.getWidth();
        int alturaDesk = jdp.getHeight();
        int larguraIFrame = janela.getWidth();
        int alturaIFrame = janela.getHeight();
        janela.setLocation(larguraDesk / 2 - larguraIFrame / 2, alturaDesk / 2 - alturaIFrame / 2);
    }

    public static void centralizaJPanel(JPanel janela) {
        int larguraDesk = jdp.getWidth();
        int alturaDesk = jdp.getHeight();
        int larguraIFrame = janela.getWidth();
        int alturaIFrame = janela.getHeight();
        janela.setLocation(larguraDesk / 2 - larguraIFrame / 2, alturaDesk / 2 - alturaIFrame / 2);
    }

    public static void centralizaJDialog(JDialog janela) {
        int larguraDesk = jdp.getWidth();
        int alturaDesk = jdp.getHeight();
        int larguraIFrame = janela.getWidth();
        int alturaIFrame = janela.getHeight();
        janela.setLocation(larguraDesk / 2 - larguraIFrame / 2, alturaDesk / 2 - alturaIFrame / 2);
    }

}
