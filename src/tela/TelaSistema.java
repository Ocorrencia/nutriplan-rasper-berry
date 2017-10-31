/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.progressbar.WebProgressBar;
import dao.usuarioDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import util.Servidor;

/**
 *
 * @author diogo.melo
 */
public class TelaSistema extends JFrame implements ActionListener {

    public static MeuJDesktopPane jdp = new MeuJDesktopPane();
    final WebProgressBar progressBar = new WebProgressBar(0, 100);
    private boolean increasing = true;
    JPanel jPanelProgressBar = new JPanel();
    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);
    public static TelaSistema telaSistema;
    Servidor servidor = new Servidor();
    usuarioDao usu = new usuarioDao();
    public TelaSistema() {
        getContentPane().add(jdp);
        setIconImage(iconeprincipal.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 480));
        setUndecorated(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white));
        setVisible(true);
        setLocationRelativeTo(null);
        servidor.iniciarServidor();
    }

    public static void main(String args[]) throws IOException {
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
            telaSistema = new TelaSistema();
            TelaMenu.getTela();
            TelaMenu.tela.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    telaSistema.dispose();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fecharTela() {
        this.dispose();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
