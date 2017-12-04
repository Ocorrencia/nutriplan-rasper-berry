/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import componente.MeuComboBox;
import dao.OrdemProducaoDao;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.miginfocom.swing.MigLayout;
import pojo.OrdemProducao;
import util.Cronometro;
import util.Enums;
import util.Modal;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class TelaAvisoInicioProducao extends JInternalFrame {

    URL urlTopo = getClass().getResource("/imagem/iconePrincipal.png");
    ImageIcon iconeprincipal = new ImageIcon(urlTopo);

    JLabel lbParada = new JLabel("INÍCIO DE PRODUÇÃO");
    JLabel lbTempo = new JLabel("00:00:00");
    JLabel lbTipo = new JLabel("");
    JLabel lbOrdemProducao = new JLabel("Ordem Produção");

    URL urlTimeWarning = getClass().getResource("/imagens/icons8-potted-plant.png");
    ImageIcon icoWarning = new ImageIcon(urlTimeWarning);

    JLabel iconeWarning = new JLabel(icoWarning);
    JButton btnIniciar = new JButton("INICIAR");
    public static TelaAvisoInicioProducao telaInicio;

    MeuComboBox comboOp = new MeuComboBox("SELECT NUMORP ,CONCAT(CODDER, ' - ', CODPRO, ' - ', DESPRO, ' ', DESDER) as PRODUTO  FROM nutri_op.op900qdo order by numpri", true, "OPS");

    OrdemProducao ordemProducao = new OrdemProducao();
    OrdemProducaoDao ordemProducaoDao = new OrdemProducaoDao(ordemProducao);

    public TelaAvisoInicioProducao() {
        JPanel painelInfo = new JPanel();
        setVisible(true);
        setResizable(false);
        setTitle("AVISO");
        btnIniciar.setPreferredSize(new Dimension(80, 40));

        lbParada.setFont(new Font("Arial", Font.BOLD, 20));
        lbTempo.setFont(new Font("Arial", Font.BOLD, 16));
        lbTipo.setFont(new Font("Arial", Font.BOLD, 16));
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 16));

        painelInfo.setLayout(new MigLayout());
        this.setFrameIcon(iconeprincipal);
        painelInfo.add(iconeWarning, "align center,wrap");
        painelInfo.add(lbParada, "align center,wrap");
        painelInfo.add(lbTempo, "align center,wrap");
        painelInfo.add(new JLabel(" "), "align center,wrap");
        painelInfo.add(lbOrdemProducao, "align center, wrap");
        painelInfo.add(comboOp, "align center, wrap");
        painelInfo.add(lbTipo, "align center, wrap");
        painelInfo.add(btnIniciar, "align center");
        add(painelInfo);
        listener();
        travarTela();
        setTitle("INÍCIO DE PRODUÇÃO");

        comboOp.setFont(new Font("Arial", Font.BOLD, 20));
        comboOp.setPreferredSize(new Dimension(550, 60));
        btnIniciar.setPreferredSize(new Dimension(550, 60));
        comboOp.setSelectedIndex(-1);
        pack();
    }

    public void travarTela() {
        BasicInternalFrameUI ui = (javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI();
        Component cp = ui.getNorthPane();
        MouseMotionListener[] actions
                = (MouseMotionListener[]) cp.getListeners(MouseMotionListener.class);
        for (MouseMotionListener action : actions) {
            cp.removeMouseMotionListener(action);
        }
    }

    public static TelaAvisoInicioProducao getTela() {
        if (telaInicio == null) {
            telaInicio = new TelaAvisoInicioProducao();
            telaInicio.addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosed(InternalFrameEvent e) {
                    TelaSistema.jdp.remove(telaInicio);
                    telaInicio = null;

                }
            });
            TelaSistema.jdp.add(telaInicio);
        }
        TelaSistema.jdp.setSelectedFrame(telaInicio);
        TelaSistema.jdp.moveToFront(telaInicio);
        TelaSistema.centraliza(telaInicio);
        if (Modal.telaPai == null) {
            Modal.getTela(telaInicio).moveToFront();
        } else {
            Modal.telaPai = telaInicio;
        }
        Enums.setSTATUSTELA(Enums.AVISOINICIOPRODUCAO);
        return telaInicio;
    }

    public void listener() {
        btnIniciar.addActionListener((ActionEvent e) -> {
            if (comboOp.getSelectedIndex() == -1) {
                Notificacao.infoBox("Selecione uma Ordem de Produção", false);
                return;
            }
            
            dispose();
            
            Modal.getTela(telaInicio).setVisible(false);
            
            Cronometro.iniciaCronometro(3600000);
            
            Enums.setSTATUSTELA(Enums.LIBERADOPRODUCAO);

            ordemProducao.setNumOrp((Integer) comboOp.getValor());
            ordemProducao = ordemProducaoDao.consultaOrdemProducao(ordemProducao.getNumOrp());

            TelaOP.getTela().campoOp.setText(ordemProducao.getCodDer() + " - " + ordemProducao.getCodPro() + " - " + ordemProducao.getDesPro() + " " + ordemProducao.getDesDer());
            TelaOP.tela.setOrdemProducao(ordemProducao);
        });
    }

    /* private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }*/
}
