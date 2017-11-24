/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojoWebService;

import br.com.senior.services.OpOrdemProducaoOutConsultar;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import pojo.Operador;
import pojo.OrdemProducao;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class OrdemProducaoWebService {

    EnviarEmail enviarEmail = new EnviarEmail();

    public boolean buscarOrdemProducaoapiens() {
        try {
            br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();
            br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();
            br.com.senior.services.OpOrdemProducaoIn parameters = new br.com.senior.services.OpOrdemProducaoIn();
            br.com.senior.services.OpOrdemProducaoOut result = port.ordemProducao("integracao.op", "ERPintegracao.4651", 0, parameters);

            if (result.getErroExecucao().getValue() != null) {
                try {
                    Notificacao.infoBox("Não foi possivel executar a sincronização da ordem de produção", false);
                    enviarEmail.enviaEmail(result.getErroExecucao().getValue(), "Erro WebService Ordem Produção");
                    return false;
                } catch (MessagingException e) {
                    return false;
                }
            } else {
                return preencherOrdemProducao(result);
            }
        } catch (Exception e) {
            try {
                enviarEmail.enviaEmail(e.getMessage(), "ERRO DE CONEXÃO COM O SAPIENS");
            } catch (MessagingException ex) {
                Logger.getLogger(OrdemProducaoWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean preencherOrdemProducao(br.com.senior.services.OpOrdemProducaoOut result) {
        List<OrdemProducao> itensOrdemProducao = new ArrayList<OrdemProducao>();
        OrdemProducao ordemProducao = new OrdemProducao();
        for (OpOrdemProducaoOutConsultar ordemProducaoobj : result.getConsultar()) {
            ordemProducao = new OrdemProducao();
            ordemProducao.setCicPad(ordemProducaoobj.getCicPad().getValue());
            ordemProducao.setCodDer(ordemProducaoobj.getCodDer().getValue());
            ordemProducao.setCodEmp(ordemProducaoobj.getCodEmp().getValue());
            ordemProducao.setCodEtg(ordemProducaoobj.getCodEtg().getValue());
            ordemProducao.setCodOri(ordemProducaoobj.getCodOri().getValue());
            ordemProducao.setCodPro(ordemProducaoobj.getCodPro().getValue());
            ordemProducao.setDesDer(ordemProducaoobj.getDesDer().getValue());
            ordemProducao.setDesEtg(ordemProducaoobj.getDesEtg().getValue());
            ordemProducao.setDesPro(ordemProducaoobj.getDesPro().getValue());
            ordemProducao.setDesPrxDer(ordemProducaoobj.getDesPrxDer().getValue());
            ordemProducao.setDesPrxDer(ordemProducaoobj.getDesPrxPro().getValue());
            ordemProducao.setNumOrp(ordemProducaoobj.getNumOrp().getValue());
            ordemProducao.setNumPri(ordemProducaoobj.getNumPri().getValue());
            ordemProducao.setPrxDer(ordemProducaoobj.getPrxDer().getValue());
            ordemProducao.setPrxPro(ordemProducaoobj.getPrxPro().getValue());
            ordemProducao.setQtdMax(ordemProducaoobj.getQtdMax().getValue());
            ordemProducao.setQtdPrv(ordemProducaoobj.getQtdPrv().getValue());
            ordemProducao.setQtdRfg(ordemProducaoobj.getQtdRfg().getValue());
            ordemProducao.setStatusRegistro(ordemProducaoobj.getStatusRegistro().getValue());
            itensOrdemProducao.add(ordemProducao);
        }
        ordemProducao.setItensOrdemProducao(itensOrdemProducao);
        return true;
        //TODO: enviar dados(itensOperadores) para o dao e executar a inclusao no banco
    }
}
