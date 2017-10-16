package componente;

import com.alee.laf.optionpane.WebOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MensagensSistema {

    private static Icon msgAtencao = new ImageIcon("src/imagens/atencao.png");
    private static Icon msgErro = new ImageIcon("src/imagens/erro.png");
    private static Icon msgSucesso = new ImageIcon("src/imagens/sucesso.png");

    public static void MensagemAtencao(String msg) {
//       UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 14)));
        WebOptionPane.showMessageDialog(null, msg, "ATENÇÃO", JOptionPane.PLAIN_MESSAGE);
    }

    public static void MensagemSucesso(String msg) {
//        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 14)));
        WebOptionPane.showMessageDialog(null, msg, "SUCESSO", JOptionPane.PLAIN_MESSAGE);
    }

    public static void MensagemErro(String msg) {
//        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 14)));
        WebOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.PLAIN_MESSAGE);
    }

    public static int MensagemConfirmarOperacao(String msg) {
//        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.BOLD, 14)));
        return JOptionPane.showConfirmDialog(null, msg, "ATENÇÃO", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
