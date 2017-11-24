/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojoWebService;

import Dados.EnviarDadosDefeito;
import br.com.senior.services.OpDefeitoFabricacaoOutConsultar;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import pojo.Defeito;
import pojo.Operador;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class DefeitoWebService {

    EnviarEmail enviarEmail = new EnviarEmail();
    EnviarDadosDefeito enviarDados = new EnviarDadosDefeito();

    public boolean buscarOperadoresSapiens() {
        try {
            br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();
            br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();
            br.com.senior.services.OpDefeitoFabricacaoIn parameters = new br.com.senior.services.OpDefeitoFabricacaoIn();
            br.com.senior.services.OpDefeitoFabricacaoOut result = port.defeitoFabricacao("integracao.op", "ERPintegracao.4651", 0, parameters);

            if (result.getErroExecucao().getValue() != null) {
                try {
                    Notificacao.infoBox("Não foi possivel executar a sincronização de defeitos", false);
                    enviarEmail.enviaEmail(result.getErroExecucao().getValue(), "Erro WebService Defeitos");
                    return false;
                } catch (MessagingException e) {
                    return false;
                }
            } else {
                return preencherOperador(result);
            }
        } catch (Exception e) {
            try {
                enviarEmail.enviaEmail(e.getMessage(), "ERRO DE CONEXÃO COM O SAPIENS");
            } catch (MessagingException ex) {
                Logger.getLogger(DefeitoWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean preencherOperador(br.com.senior.services.OpDefeitoFabricacaoOut result) {
        List<Defeito> itensDefeito = new ArrayList<Defeito>();
        Defeito objDefeito = new Defeito();
        for (OpDefeitoFabricacaoOutConsultar defeito : result.getConsultar()) {
            objDefeito = new Defeito();
            System.out.println(defeito.getDesDft().getValue());
            objDefeito.setCodEmp(defeito.getCodEmp().getValue());
            objDefeito.setCodDft(defeito.getCodDft().getValue());
            objDefeito.setDesDft(defeito.getDesDft().getValue());
            itensDefeito.add(objDefeito);
        }
        objDefeito.setItensDefeito(itensDefeito);
        enviarDados.EnviarDadosDefeito(itensDefeito);
        return true;
    }
}
