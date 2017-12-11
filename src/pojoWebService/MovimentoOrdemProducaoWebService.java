/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojoWebService;

import Dados.EnviarDadosMotivoParada;
import br.com.senior.services.OpApontamentoProducaoInApontar;
import br.com.senior.services.OpApontamentoProducaoOutRespostaApontar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import util.ConexaoMysql;
import util.EnviarEmail;
import util.Notificacao;
import util.Consulta;

/**
 *
 * @author diogo.melo
 */
public class MovimentoOrdemProducaoWebService {

    EnviarEmail enviarEmail = new EnviarEmail();
    String codCre;
    EnviarDadosMotivoParada enviarDados = new EnviarDadosMotivoParada();
    private final String CONSULTARSQL = "SELECT\n"
            + "    op900eoq.CODORI,\n"
            + "    op900eoq.NUMORP,\n"
            + "    op900eoq.CODETG,\n"
            + "    op900eoq.SEQROT,\n"
            + "    op900eoq.DATMOV,\n"
            + "    op900eoq.HORMOV,\n"
            + "    op900eoq.NUMCAD,\n"
            + "    op900eoq.QTDRE1,\n"
            + "    op900eoq.QTDRFG,\n"
            + "    op900eoq.TURTRB,\n"
            + "    op900eoq.SEQMOV\n"
            + "FROM nutri_op.op900eoq WHERE op900eoq.EXPERP = 0";

    JAXBElement<String> jaxbCodOri = new JAXBElement(new QName("", "codOri"), String.class, "");
    JAXBElement<Integer> jaxbNumOrp = new JAXBElement(new QName("", "numOrp"), Integer.class, 0);
    JAXBElement<Integer> jaxbCodEtg = new JAXBElement(new QName("", "codEtg"), Integer.class, 0);
    JAXBElement<Integer> jaxbSeqRot = new JAXBElement(new QName("", "seqRot"), Integer.class, 0);
    JAXBElement<Integer> laxbNumcad = new JAXBElement(new QName("", "numCad"), Integer.class, 0);
    JAXBElement<Integer> jaxbturTrb = new JAXBElement(new QName("", "turTrb"), Integer.class, 0);
    JAXBElement<Integer> jaxbSeqMov = new JAXBElement(new QName("", "sequenciaMovimento"), Integer.class, 0);
    JAXBElement<String> jaxbDatMov = new JAXBElement(new QName("", "datMov"), String.class, "");
    JAXBElement<String> jaxbHorMov = new JAXBElement(new QName("", "horMov"), String.class, "");
    JAXBElement<Double> laxbQtdRe1 = new JAXBElement(new QName("", "qtdRe1"), Double.class, 0);
    JAXBElement<Double> laxbQtdRfg = new JAXBElement(new QName("", "qtdRfg"), Double.class, 0);

    public void limpar() {
        jaxbCodOri = new JAXBElement(new QName("", "codOri"), String.class, "");
        jaxbNumOrp = new JAXBElement(new QName("", "numOrp"), Integer.class, 0);
        jaxbCodEtg = new JAXBElement(new QName("", "codEtg"), Integer.class, 0);
        jaxbSeqRot = new JAXBElement(new QName("", "seqRot"), Integer.class, 0);
        laxbNumcad = new JAXBElement(new QName("", "numCad"), Integer.class, 0);
        jaxbturTrb = new JAXBElement(new QName("", "turTrb"), Integer.class, 0);
        jaxbSeqMov = new JAXBElement(new QName("", "sequenciaMovimento"), Integer.class, 0);
        jaxbDatMov = new JAXBElement(new QName("", "datMov"), String.class, "");
        jaxbHorMov = new JAXBElement(new QName("", "horMov"), String.class, "");
        laxbQtdRe1 = new JAXBElement(new QName("", "qtdRe1"), Double.class, 0);
        laxbQtdRfg = new JAXBElement(new QName("", "qtdRfg"), Double.class, 0);
    }

    public boolean enviarMovimentoOrdemProducaoSapiens() {
        try {
            br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();
            br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();
            br.com.senior.services.OpApontamentoProducaoIn parameters = new br.com.senior.services.OpApontamentoProducaoIn();

            PreparedStatement ps = ConexaoMysql.getConexaoMySQL().prepareStatement(CONSULTARSQL);
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()) {
                OpApontamentoProducaoInApontar objApontar = new OpApontamentoProducaoInApontar();
                jaxbCodOri.setValue(rs.getString(1));
                jaxbNumOrp.setValue(rs.getInt(2));
                jaxbCodEtg.setValue(rs.getInt(3));
                jaxbSeqRot.setValue(rs.getInt(4));
                jaxbDatMov.setValue(rs.getString(5));
                jaxbHorMov.setValue(rs.getString(6));
                laxbNumcad.setValue(rs.getInt(7));
                laxbQtdRe1.setValue(rs.getDouble(8));
                laxbQtdRfg.setValue(rs.getDouble(9));
                jaxbturTrb.setValue(rs.getInt(10));
                jaxbSeqMov.setValue(rs.getInt(11));

                objApontar.setCodOri(jaxbCodOri);
                objApontar.setNumOrp(jaxbNumOrp);
                objApontar.setCodEtg(jaxbCodEtg);
                objApontar.setSeqRot(jaxbSeqRot);
                objApontar.setDatMov(jaxbDatMov);
                objApontar.setHorMov(jaxbHorMov);
                objApontar.setNumCad(laxbNumcad);
                objApontar.setQtdRe1(laxbQtdRe1);
                objApontar.setQtdRfg(laxbQtdRfg);
                objApontar.setTurTrb(jaxbturTrb);
                objApontar.setSequenciaMovimento(jaxbSeqMov);

                parameters.getApontar().add(objApontar);
                limpar();
            }
            br.com.senior.services.OpApontamentoProducaoOut result = port.apontamentoProducao("integracao.op", "ERPintegracao.4651", 0, parameters);
            if (result.getErroExecucao().getValue() != null) {
                try {
                    System.out.println("" + result.getErroExecucao().getValue());
                    Notificacao.infoBox("Não foi possivel enviar apontamento de producao", false);
                    enviarEmail.enviaEmail(result.getErroExecucao().getValue(), "Erro WebService Motivo Parada");
                    return false;
                } catch (MessagingException e) {
                    return false;
                }
            } else {
                for (OpApontamentoProducaoOutRespostaApontar itens : result.getRespostaApontar()) {
                    if ("OK".equals(itens.getMensagemRetorno().getValue())) {
                        Consulta.UPDATE("nutri_op.op900eoq", "EXPERP = 1", "SEQMOV =  " + itens.getSequenciaMovimento().getValue() + " ");
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Notificacao.infoBox("Ocorreu um Erro: ao consultar o movimento de apontamento", true);
            try {
                enviarEmail.enviaEmail(e.getMessage(), "Erro ao consultar o movimento de apontametno");
            } catch (MessagingException ex) {
                // Logger.getLogger(EventosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
