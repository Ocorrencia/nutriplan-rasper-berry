/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojoWebService;

import Dados.EnviarDadosCentroRecurso;
import br.com.senior.services.OpCentroDeRecursoOutConsultar;
import br.com.senior.services.OpOperadorOutConsultar;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import pojo.CentroRecurso;
import pojo.Operador;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class CentroRecursoWebService {
    
    EnviarEmail enviarEmail = new EnviarEmail();
    EnviarDadosCentroRecurso enviarDados = new EnviarDadosCentroRecurso();
    
    public CentroRecursoWebService() {
        
    }
    
    public boolean buscarCentroRecurso() {
        try {
            
            br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();
            br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();
            br.com.senior.services.OpCentroDeRecursoIn parameters = new br.com.senior.services.OpCentroDeRecursoIn();
            br.com.senior.services.OpCentroDeRecursoOut result = port.centroDeRecurso("integracao.op", "ERPintegracao.4651", 0, parameters);
            if (result.getErroExecucao().getValue() != null) {
                try {
                    Notificacao.infoBox("Não foi possivel executar a sincronização do centro de recurso", false);
                    enviarEmail.enviaEmail(result.getErroExecucao().getValue(), "Erro WebService Centro de Recurso");
                    return false;
                } catch (MessagingException e) {
                    return false;
                }
            } else {
                return preencherCentroRecurso(result);
            }
        } catch (Exception e) {
            try {
                enviarEmail.enviaEmail(e.getMessage(), "ERRO DE CONEXÃO COM O SAPIENS");
            } catch (MessagingException ex) {
                Logger.getLogger(OperadorWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean preencherCentroRecurso(br.com.senior.services.OpCentroDeRecursoOut result) {
        List<CentroRecurso> centroRecursoObj = new ArrayList<CentroRecurso>();
        CentroRecurso centroRecurso = new CentroRecurso();
        for (OpCentroDeRecursoOutConsultar itemCentroRecurso : result.getConsultar()) {
            centroRecurso = new CentroRecurso();
            System.out.println(itemCentroRecurso.getCodCre().getValue());
            centroRecurso.setCodCre(itemCentroRecurso.getCodCre().getValue());
            centroRecurso.setCodEtg(itemCentroRecurso.getCodEtg().getValue());
            centroRecurso.setDescCre(itemCentroRecurso.getDesCre().getValue());
            centroRecursoObj.add(centroRecurso);
        }
        centroRecurso.setItensCentroRecurso(centroRecursoObj);
        enviarDados.EnviarDadosCentroRecurso(centroRecursoObj);
        return true;
        //TODO: enviar dados(itensOperadores) para o dao e executar a inclusao no banco
    }
}
