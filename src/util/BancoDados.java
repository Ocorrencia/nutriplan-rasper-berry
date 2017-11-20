package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BancoDados {

    private static Connection conexao;
    protected static String sqlGenerator = "";

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/nutri_op?zeroDateTimeBehavior=convertToNull", "admin", "admin");
            }
            return conexao;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver do banco de dados Firebird não encontrado.");
            return null;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados.");
            return null;
        }
    }

    public static Connection getConexaoOracle() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String servidor = "192.168.254.10:xe";
            String porta = "8080";
            String user = "HR";
            String senha = "aB302302";
            String url = "jdbc: oracle:thin:@" + servidor + ":" + porta + ":";
            con = DriverManager.getConnection(url, user, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static ResultSet executaQuery(PreparedStatement ps) {
        try {
            return ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o banco de dados.");
            return null;
        }
    }

    public static int gerarCodigo(String gen) {
        try {
            PreparedStatement ps = getConexao().prepareStatement("SELECT GEN_ID(" + gen + ", 1) FROM RDB$DATABASE");
            ResultSet rs = executaQuery(ps);

            if (rs == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível obter o código (" + gen + ")");
                return -1;
            }
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o generator (" + gen + ")");
            e.printStackTrace();
            return -1;
        }

    }

    public static int pegarCodigo(String linha, String tabela) {
        try {
            PreparedStatement ps = getConexao().prepareStatement("SELECT MAX (" + linha + ") FROM (" + tabela + ")");
            ResultSet rs = executaQuery(ps);

            if (rs == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível obter o código (" + linha + ")");
                return -1;
            }
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter o generator (" + linha + ")");
            e.printStackTrace();
            return -1;
        }
    }

    public static ResultSet executaQuery(String sql) {
        try {
            Statement stmt = getConexao().createStatement();

            return stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int pegaGenerator(String generator) {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement("SELECT GEN_ID(" + generator + ", 1) FROM RDB$DATABASE");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int pegaGenerator(String generator, int numero) {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement("SELECT GEN_ID(" + generator + ", " + numero + ") FROM RDB$DATABASE");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static List<Object[]> pesquisar(String sql) {
        try {
            List<Object[]> retorno = new ArrayList();
            Statement st = getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            int colunas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] linha = new Object[colunas];
                for (int i = 1; i <= colunas; i++) {
                    linha[i - 1] = rs.getString(i);
                }
                retorno.add(linha);
            }
            return retorno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar a pesquisa");
            e.printStackTrace();
            return null;
        }
    }
    
   

}
