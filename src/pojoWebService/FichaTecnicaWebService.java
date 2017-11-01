/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojoWebService;

import br.com.senior.services.OpFichaTecnicaOutConsultar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.mail.MessagingException;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import pojo.FichaTecnica;
import util.EnviarEmail;
import util.Notificacao;

/**
 *
 * @author diogo.melo
 */
public class FichaTecnicaWebService {

    EnviarEmail enviarEmail = new EnviarEmail();
    String codPro = "7100101";
    String codDer = "19";

    public void buscarFichaTenicaSapiens() {

        JAXBElement<String> jaxbCodPro = new JAXBElement(new QName("", "codPro"), String.class, codPro);
        JAXBElement<String> jaxbCodDer = new JAXBElement(new QName("", "codDer"), String.class, codDer);

        br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();
        br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();
        br.com.senior.services.OpFichaTecnicaIn parameters = new br.com.senior.services.OpFichaTecnicaIn();

        parameters.setCodPro(jaxbCodPro);
        parameters.setCodDer(jaxbCodDer);

        br.com.senior.services.OpFichaTecnicaOut result = port.fichaTecnica("integracao.op", "ERPintegracao.4651", 0, parameters);

        if (result.getErroExecucao().getValue() != null) {
            try {
                Notificacao.infoBox("Não foi possivel executar a sincronização de operadores", false);
                enviarEmail.enviaEmail(result.getErroExecucao().getValue(), "Erro WebService Operadores");
            } catch (MessagingException e) {
            }
        } else {
            preencherFichaTecnica(result);
        }
    }

    public void preencherFichaTecnica(br.com.senior.services.OpFichaTecnicaOut result) {
        List<FichaTecnica> itensFichaTecnica = new ArrayList<FichaTecnica>();
        FichaTecnica fichaTecnica = new FichaTecnica();

        for (OpFichaTecnicaOutConsultar objFichaTecnica : result.getConsultar()) {
            fichaTecnica = new FichaTecnica();

            fichaTecnica.setCodCmp(objFichaTecnica.getCodCmp().getValue());
            fichaTecnica.setDerCmp(objFichaTecnica.getDerCmp().getValue());
            fichaTecnica.setDesCmp(objFichaTecnica.getDesCmp().getValue());
            fichaTecnica.setDesDer(objFichaTecnica.getDesDer().getValue());
            fichaTecnica.setPrdQtd(objFichaTecnica.getPrdQtd().getValue());
            fichaTecnica.setQtdTot(objFichaTecnica.getQtdTot().getValue());
            fichaTecnica.setQtdUti(objFichaTecnica.getQtdUti().getValue());
            fichaTecnica.setSeqMod(objFichaTecnica.getSeqMod().getValue());
            fichaTecnica.setTipPro(objFichaTecnica.getTipPro().getValue());
            fichaTecnica.setUniMe2(objFichaTecnica.getUniMe2().getValue());
            itensFichaTecnica.add(fichaTecnica);
        }
        fichaTecnica.setItensFichaTecnica(itensFichaTecnica);
        //TODO: enviar dados(itensFichaTecnica) para o dao e executar a inclusao no banco
    }

}
