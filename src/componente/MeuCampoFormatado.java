package componente;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MeuCampoFormatado extends JFormattedTextField implements FocusListener, MeuComponente, CaretListener {

    private boolean obrigatorio;
    private boolean podeHabilitar;
    private String dica;

    public MeuCampoFormatado(boolean obrigatorio, String dica, int tamanho, int maxChar) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        try {
            setDocument(new PlainDocument() {
                @Override
                public void insertString(int offs, String str, AttributeSet a)
                        throws BadLocationException {
                    String novoValor = getValor().toString();
                    if (novoValor.length() >= maxChar) {
                        Toolkit.getDefaultToolkit().beep();
                        return;
                    }
                    super.insertString(offs, str.toUpperCase().replaceAll("[^A-Z|^ |^@^.^^]", ""), a);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo Com valores Invalidos");
        }

        //  setColumns(tamanho);
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    public MeuCampoFormatado(String dica, boolean obrigatorio, int tamanho, int maxChar) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        setColumns(tamanho);
        addFocusListener(this);
        try {
            setDocument(new PlainDocument() {
                @Override
                public void insertString(int offs, String str, AttributeSet a)
                        throws BadLocationException {
                    String novoValor = getValor().toString();
                    if (novoValor.length() >= maxChar) {
                        Toolkit.getDefaultToolkit().beep();
                        return;
                    }
                    super.insertString(offs, str.toUpperCase(), a);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo Com valores Invalidos");
        }
        
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    public MeuCampoFormatado(String dica, boolean obrigatorio, int tamanho) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        setColumns(tamanho);
        addFocusListener(this);
        try {
            setDocument(new PlainDocument() {
                @Override
                public void insertString(int offs, String str, AttributeSet a)
                        throws BadLocationException {
                    String novoValor = getValor().toString();
                    super.insertString(offs, str.toUpperCase(), a);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo Com valores Invalidos");
        }

        if (eObrigatorio()) {
            setBackground(Color.WHITE);
        }
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    @Override
    public void focusGained(FocusEvent e) {
     //   setBackground(new Color(240, 230, 210));
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (eObrigatorio()) {

          //  setBackground(Color.WHITE);
        } else {
          //  setBackground(Color.RED);
        }
    }

    @Override
    public void limpar() {
        setText("");
    }

    @Override
    public boolean eValido() {
        return true;
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public boolean eVazio() {
        return getText().trim().isEmpty();
    }

    @Override
    public void setValor(Object valor) {
        setText("" + valor);
    }

    @Override
    public Object getValor() {
        return "" + getText();
    }

    @Override
    public String getDica() {
        return dica;
    }

    @Override
    public void caretUpdate(CaretEvent ce) {
    }
}
