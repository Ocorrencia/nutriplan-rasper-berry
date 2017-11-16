/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import util.Enums;

/**
 *
 * @author diogo.melo
 */
public class TelaBotaoRefugo extends JFrame {
    
    JButton botaoRefugo = new JButton("REFUGO");
    
    public TelaBotaoRefugo() {
        
        setSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        add(botaoRefugo);
        
        botaoRefugo.addActionListener((ActionEvent e) -> {
            Enums.REFUGOSNAOIDENTIFICADOS = Enums.REFUGOSNAOIDENTIFICADOS + 1;
            TelaRefugo.getTela().campoQuantidadeNaoJustificados.setText("0" + Enums.REFUGOSNAOIDENTIFICADOS);
        });
    }
}
