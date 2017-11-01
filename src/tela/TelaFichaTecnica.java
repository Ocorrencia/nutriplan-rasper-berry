/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.laf.separator.WebSeparator;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author diogo.melo
 */
public class TelaFichaTecnica extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);
    private static TelaFichaTecnica tela;

    JPanel painelFichaTecnica = new JPanel();
    JPanel painelItensFicha = new JPanel();

    JLabel lbFichaTecnica = new JLabel("Ficha Técnica");
    JLabel lbProduto = new JLabel("68-735 VASSOURA P/ GRAMA VERDE");

    JPanel painelQuantidade = new JPanel();
    JLabel lbConsumo = new JLabel("Consumo");
    JLabel lbPerda = new JLabel("Perda");
    JLabel lbTotal = new JLabel("Total");
    JLabel lbUm = new JLabel("U.M");
    JLabel lbCp = new JLabel("C.P");
    JLabel lbSeq = new JLabel("Seq");
    JLabel lbCodigo = new JLabel("Código");
    JLabel lbDescComponente = new JLabel("Descrição do Componente");
    JSeparator separador1 = new JSeparator(1);
    JSeparator separador2 = new JSeparator(1);
    JSeparator separador3 = new JSeparator(1);
    JSeparator separador4 = new JSeparator(1);
    JSeparator separador5 = new JSeparator(1);
    JSeparator separador6 = new JSeparator(1);
    JSeparator separador7 = new JSeparator(1);
    WebSeparator separator = new WebSeparator();

    public static TelaFichaTecnica getTela() {
        if (tela == null) {
            tela = new TelaFichaTecnica();
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

    public TelaFichaTecnica() {
        super("Ficha Técnica", true, true, true);
        setVisible(true);
        this.setFrameIcon(iconeprincipal);

        this.setSize(700, 420);
        initComponente();
    }

    private void initComponente() {
        this.setLayout(new MigLayout());

        painelFichaTecnica.setLayout(new MigLayout());

        painelFichaTecnica.add(lbFichaTecnica, "align center, wrap");
        painelFichaTecnica.add(separator, "align center, wrap");
        painelFichaTecnica.add(lbProduto);

        painelQuantidade.add(lbConsumo);
        painelQuantidade.add(separador1);
        painelQuantidade.add(lbPerda);
        painelQuantidade.add(separador2);
        painelQuantidade.add(lbTotal);
        painelQuantidade.add(separador3);
        painelQuantidade.add(lbUm);
        painelQuantidade.add(separador4);
        painelQuantidade.add(lbCp);
        painelQuantidade.add(separador5);
        painelQuantidade.add(lbSeq);
        painelQuantidade.add(separador6);
        painelQuantidade.add(lbCodigo);
        painelQuantidade.add(separador7);
        painelQuantidade.add(lbDescComponente);

        separator.setPreferredSize(new Dimension(690, 10));
        lbProduto.setFont(new Font("Arial", Font.BOLD, 14));
        lbFichaTecnica.setFont(new Font("Arial", Font.BOLD, 30));
        painelFichaTecnica.setPreferredSize(new Dimension(690, 60));

        add(painelFichaTecnica, "wrap");
        add(painelQuantidade);
    }
}
