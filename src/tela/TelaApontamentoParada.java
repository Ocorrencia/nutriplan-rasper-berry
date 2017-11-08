/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import com.alee.laf.list.WebList;
import com.alee.laf.text.WebTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.miginfocom.swing.MigLayout;
import static tela.TelaOP.tecladoVirtual;
import static tela.TelaOP.telaParada;

/**
 *
 * @author diogo.melo
 */
public class TelaApontamentoParada extends JInternalFrame {

    public static TelaApontamentoParada telaAP;

    JPanel painelCampo = new JPanel();
    JPanel painelLista = new JPanel();

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    URL imagemOK = getClass().getResource("/imagens/icons8-enter-key.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    private ImageIcon icoOK = new ImageIcon(imagemOK);

    final WebTextField campoApontamento = new WebTextField();
    JButton ok = new JButton("", icoOK);

    private static String[] createSampleData() {
        return new String[]{"1000 - START",
            "1001 - SETUP",
            "1002 - TROCA DE PENEIRA",
            "1003 - PERIFÉRICOS",
            "1004 - REGULAGEM",
            "1005 - MANUTENÇÃO MECÂNICA",
            "1006 - ABSENTEÍSMO",
            "1007 - MATÉRIA-PRIMA",
            "1007 - MATÉRIA-PRIMA",
            "1007 - MATÉRIA-PRIMA",
            "1007 - MATÉRIA-PRIMA",
            "1007 - MATÉRIA-PRIMA",
            "1007 - MATÉRIA-PRIMA",
            "1008 - MANUTENÇÃO DE MOLDE",};
    }
    WebList webList = new WebList(createSampleData());
    JScrollPane js = new JScrollPane(webList);

    public TelaApontamentoParada() {
        super("Apontamento de Parada", false, true, false);
        setVisible(true);
        this.setFrameIcon(iconeprincipal);
        this.setSize(600, 320);
        initiComponents();
        lista();
        config();
        listener();
        //   cronometro();
    }

    public static TelaApontamentoParada getTela() {
        if (telaAP == null) {
            telaAP = new TelaApontamentoParada();
            telaAP.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaAP);
                    telaAP = null;
                }
            });
            TelaSistema.jdp.add(telaAP);
        }
        TelaSistema.jdp.setSelectedFrame(telaAP);
        TelaSistema.jdp.moveToFront(telaAP);
        TelaSistema.centraliza(telaAP);
        return telaAP;
    }

    public void lista() {
        webList.setVisibleRowCount(4);
        webList.setSelectedIndex(0);
        webList.setEditable(false);

    }

    public void listener() {
        campoApontamento.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               /* TecladoVirtual tela = tecladoVirtual.getTela();
                tela.set("Digite o código do apontamento de parada");
                tela.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        if (!tela.meuCampoValor.getText().isEmpty()) {
                            campoApontamento.setText(tela.meuCampoValor.getText());
                        }
                    }
                });*/
            }
        });
        webList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                campoApontamento.setText(webList.getSelectedValue().toString());
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /* if (campoApontamento.getText() == "") {
                    /*TecladoVirtual tela = tecladoVirtual.getTela();
                    tela.set("Digite o código de parada");
                    tela.addInternalFrameListener(new InternalFrameAdapter() {
                        @Override
                        public void internalFrameClosed(InternalFrameEvent e) {
                            int resp = JOptionPane.showConfirmDialog(null, "1023 - FALTA DE INSUMOS. \n"
                                    + "               Deseja Continuar?", "Operador Selecionado", JOptionPane.YES_OPTION);
                            if (resp == 0) {
                                telaAP.dispose();
                                TelaAvisoTravamento.getTela();
                            }
                        }
                    });
                } else {
                    TelaAvisoTravamento.getTela();
                    telaAP.dispose();
                }*/
            }
        });
    }

    public void cronometro() {
        long time, time1;
        time = System.currentTimeMillis();
        do {
            time1 = System.currentTimeMillis();
            System.out.println("tempo" + time1);
        } while ((time1 - time) < (10 * 1000));
        System.out.println("Pronto!");
    }

    public void config() {
        campoApontamento.setPreferredSize(new Dimension(500, 40));
        webList.setPreferredSize(580, 200);
    }

    private void initiComponents() {
        campoApontamento.setInputPrompt("Digite ou Selecione..");
        campoApontamento.setInputPromptFont(campoApontamento.getFont().deriveFont(Font.ITALIC));

        painelCampo.add(campoApontamento);
        painelCampo.add(ok);
        painelLista.add(webList);

        setLayout(new MigLayout());
        add(painelCampo, "wrap");
        add(painelLista);
    }

}
