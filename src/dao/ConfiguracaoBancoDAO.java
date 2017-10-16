/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;
import pojo.ConfiguracaoBanco;

/**
 *
 * @author diogo.melo
 */
public class ConfiguracaoBancoDAO {

    ConfiguracaoBanco configBanco = new ConfiguracaoBanco();
    String dados1 = "";

    public ConfiguracaoBancoDAO() {

    }

    public void setPOJO(ConfiguracaoBanco configBancoPOJO) {
        this.configBanco = configBancoPOJO;
    }

    public ConfiguracaoBanco getPOJO() {
        return configBanco;
    }

    public ConfiguracaoBanco consultar() {
        String dados = "";
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader("src/arquivos/configBanco"));
            while (true) {
                if (dados != null) {
                } else {
                    break;
                }
                dados1 += dados = buffRead.readLine();
            }
            buffRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setDados(dados1);
    }

    public boolean alterar() {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("src/arquivos/configBanco"));
            buffWrite.append(capturarTexto() + "\n");
            buffWrite.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String capturarTexto() {
        String dados = ":" + configBanco.getServidor() + "*\n";
        dados += ":" + configBanco.getPorta() + "*\n";
        dados += ":" + configBanco.getUrl() + "*\n";
        dados += ":" + configBanco.getUser() + "*\n";
        dados += ":" + configBanco.getSenha() + "*\n";
        return dados;
    }

    private ConfiguracaoBanco setDados(String linha) {
        String[] t = linha.split(Pattern.quote(":"));
        for (int s = 0; s < t.length; s++) {
            switch (s) {
                case 1:
                    configBanco.setServidor(t[s].toString().replace(":", "").replace("*", ""));
                    break;
                case 2:
                    configBanco.setPorta(t[s].toString().replace(":", "").replace("*", ""));
                    break;
                case 3:
                    configBanco.setUrl(t[s].toString().replace(":", "").replace("*", ""));
                    break;
                case 4:
                    configBanco.setUser(t[s].toString().replace(":", "").replace("*", ""));
                    break;
                case 5:
                    configBanco.setSenha(t[s].toString().replace(":", "").replace("*", "").replace("null", ""));
                    break;
            }
        }
        return configBanco;
    }

}
