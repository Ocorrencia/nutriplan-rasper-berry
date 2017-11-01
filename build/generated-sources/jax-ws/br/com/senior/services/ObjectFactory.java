
package br.com.senior.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.senior.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OpUsuarioInFlowName_QNAME = new QName("", "flowName");
    private final static QName _OpUsuarioInFlowInstanceID_QNAME = new QName("", "flowInstanceID");
    private final static QName _OpOperadorOutConsultarMensagemRetorno_QNAME = new QName("", "mensagemRetorno");
    private final static QName _OpOperadorOutConsultarNumCad_QNAME = new QName("", "numCad");
    private final static QName _OpOperadorOutConsultarTurTrb_QNAME = new QName("", "turTrb");
    private final static QName _OpOperadorOutConsultarNomOpe_QNAME = new QName("", "nomOpe");
    private final static QName _OpCentroDeRecursoOutErroExecucao_QNAME = new QName("", "erroExecucao");
    private final static QName _OpUsuarioOutConsultarCodUsu_QNAME = new QName("", "codUsu");
    private final static QName _OpUsuarioOutConsultarIntNet_QNAME = new QName("", "intNet");
    private final static QName _OpUsuarioOutConsultarNomUsu_QNAME = new QName("", "nomUsu");
    private final static QName _OpFichaTecnicaOutConsultarSeqMod_QNAME = new QName("", "seqMod");
    private final static QName _OpFichaTecnicaOutConsultarCodCmp_QNAME = new QName("", "codCmp");
    private final static QName _OpFichaTecnicaOutConsultarDesDer_QNAME = new QName("", "desDer");
    private final static QName _OpFichaTecnicaOutConsultarPrdQtd_QNAME = new QName("", "prdQtd");
    private final static QName _OpFichaTecnicaOutConsultarQtdUti_QNAME = new QName("", "qtdUti");
    private final static QName _OpFichaTecnicaOutConsultarUniMe2_QNAME = new QName("", "uniMe2");
    private final static QName _OpFichaTecnicaOutConsultarDerCmp_QNAME = new QName("", "derCmp");
    private final static QName _OpFichaTecnicaOutConsultarDesCmp_QNAME = new QName("", "desCmp");
    private final static QName _OpFichaTecnicaOutConsultarQtdTot_QNAME = new QName("", "qtdTot");
    private final static QName _OpFichaTecnicaOutConsultarTipPro_QNAME = new QName("", "tipPro");
    private final static QName _OpTurnoDeTrabalhoOutConsultarHorIni_QNAME = new QName("", "horIni");
    private final static QName _OpTurnoDeTrabalhoOutConsultarCodCre_QNAME = new QName("", "codCre");
    private final static QName _OpTurnoDeTrabalhoOutConsultarHorFim_QNAME = new QName("", "horFim");
    private final static QName _OpTurnoDeTrabalhoOutConsultarSeqHtr_QNAME = new QName("", "seqHtr");
    private final static QName _OpTurnoDeTrabalhoOutConsultarTipHtr_QNAME = new QName("", "tipHtr");
    private final static QName _OpTurnoDeTrabalhoOutConsultarCodEtg_QNAME = new QName("", "codEtg");
    private final static QName _OpTurnoDeTrabalhoOutConsultarDesTrb_QNAME = new QName("", "desTrb");
    private final static QName _OpOrdemProducaoOutConsultarCodDer_QNAME = new QName("", "codDer");
    private final static QName _OpOrdemProducaoOutConsultarPrxDer_QNAME = new QName("", "prxDer");
    private final static QName _OpOrdemProducaoOutConsultarQtdMax_QNAME = new QName("", "qtdMax");
    private final static QName _OpOrdemProducaoOutConsultarDesPrxPro_QNAME = new QName("", "desPrxPro");
    private final static QName _OpOrdemProducaoOutConsultarPrxPro_QNAME = new QName("", "prxPro");
    private final static QName _OpOrdemProducaoOutConsultarDesPrxDer_QNAME = new QName("", "desPrxDer");
    private final static QName _OpOrdemProducaoOutConsultarCodPro_QNAME = new QName("", "codPro");
    private final static QName _OpOrdemProducaoOutConsultarDesPro_QNAME = new QName("", "desPro");
    private final static QName _OpOrdemProducaoOutConsultarCicPad_QNAME = new QName("", "cicPad");
    private final static QName _OpOrdemProducaoOutConsultarCodOri_QNAME = new QName("", "codOri");
    private final static QName _OpOrdemProducaoOutConsultarQtdRfg_QNAME = new QName("", "qtdRfg");
    private final static QName _OpOrdemProducaoOutConsultarQtdPrv_QNAME = new QName("", "qtdPrv");
    private final static QName _OpOrdemProducaoOutConsultarNumOrp_QNAME = new QName("", "numOrp");
    private final static QName _OpOrdemProducaoInAportamentoProducaoHorMov_QNAME = new QName("", "horMov");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodRef_QNAME = new QName("", "codRef");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodDiv_QNAME = new QName("", "codDiv");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodLot_QNAME = new QName("", "codLot");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodCcu_QNAME = new QName("", "codCcu");
    private final static QName _OpOrdemProducaoInAportamentoProducaoQtdIql_QNAME = new QName("", "qtdIql");
    private final static QName _OpOrdemProducaoInAportamentoProducaoDatMov_QNAME = new QName("", "datMov");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodEqp_QNAME = new QName("", "codEqp");
    private final static QName _OpOrdemProducaoInAportamentoProducaoQtdRe1_QNAME = new QName("", "qtdRe1");
    private final static QName _OpOrdemProducaoInAportamentoProducaoQtdRe2_QNAME = new QName("", "qtdRe2");
    private final static QName _OpOrdemProducaoInAportamentoProducaoIndDiv_QNAME = new QName("", "indDiv");
    private final static QName _OpOrdemProducaoInAportamentoProducaoQtdRe3_QNAME = new QName("", "qtdRe3");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodMdv_QNAME = new QName("", "codMdv");
    private final static QName _OpOrdemProducaoInAportamentoProducaoCodDft_QNAME = new QName("", "codDft");
    private final static QName _OpOrdemProducaoInAportamentoProducaoNumSep_QNAME = new QName("", "numSep");
    private final static QName _OpOrdemProducaoInAportamentoProducaoSeqRot_QNAME = new QName("", "seqRot");
    private final static QName _OpOrdemProducaoInAportamentoProducaoTipOpr_QNAME = new QName("", "tipOpr");
    private final static QName _OpCentroDeRecursoOutConsultarDesCre_QNAME = new QName("", "desCre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.senior.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OpTurnoDeTrabalhoOutConsultar }
     * 
     */
    public OpTurnoDeTrabalhoOutConsultar createOpTurnoDeTrabalhoOutConsultar() {
        return new OpTurnoDeTrabalhoOutConsultar();
    }

    /**
     * Create an instance of {@link OpCentroDeRecursoIn }
     * 
     */
    public OpCentroDeRecursoIn createOpCentroDeRecursoIn() {
        return new OpCentroDeRecursoIn();
    }

    /**
     * Create an instance of {@link OpUsuarioOutConsultar }
     * 
     */
    public OpUsuarioOutConsultar createOpUsuarioOutConsultar() {
        return new OpUsuarioOutConsultar();
    }

    /**
     * Create an instance of {@link OpFichaTecnicaOutConsultar }
     * 
     */
    public OpFichaTecnicaOutConsultar createOpFichaTecnicaOutConsultar() {
        return new OpFichaTecnicaOutConsultar();
    }

    /**
     * Create an instance of {@link OpCentroDeRecursoOut }
     * 
     */
    public OpCentroDeRecursoOut createOpCentroDeRecursoOut() {
        return new OpCentroDeRecursoOut();
    }

    /**
     * Create an instance of {@link OpOperadorOutConsultar }
     * 
     */
    public OpOperadorOutConsultar createOpOperadorOutConsultar() {
        return new OpOperadorOutConsultar();
    }

    /**
     * Create an instance of {@link OpOperadorOut }
     * 
     */
    public OpOperadorOut createOpOperadorOut() {
        return new OpOperadorOut();
    }

    /**
     * Create an instance of {@link OpTurnoDeTrabalhoIn }
     * 
     */
    public OpTurnoDeTrabalhoIn createOpTurnoDeTrabalhoIn() {
        return new OpTurnoDeTrabalhoIn();
    }

    /**
     * Create an instance of {@link OpFichaTecnicaOut }
     * 
     */
    public OpFichaTecnicaOut createOpFichaTecnicaOut() {
        return new OpFichaTecnicaOut();
    }

    /**
     * Create an instance of {@link OpOrdemProducaoInAportamentoProducao }
     * 
     */
    public OpOrdemProducaoInAportamentoProducao createOpOrdemProducaoInAportamentoProducao() {
        return new OpOrdemProducaoInAportamentoProducao();
    }

    /**
     * Create an instance of {@link OpUsuarioIn }
     * 
     */
    public OpUsuarioIn createOpUsuarioIn() {
        return new OpUsuarioIn();
    }

    /**
     * Create an instance of {@link OpOrdemProducaoOutConsultar }
     * 
     */
    public OpOrdemProducaoOutConsultar createOpOrdemProducaoOutConsultar() {
        return new OpOrdemProducaoOutConsultar();
    }

    /**
     * Create an instance of {@link OpFichaTecnicaIn }
     * 
     */
    public OpFichaTecnicaIn createOpFichaTecnicaIn() {
        return new OpFichaTecnicaIn();
    }

    /**
     * Create an instance of {@link OpOrdemProducaoOut }
     * 
     */
    public OpOrdemProducaoOut createOpOrdemProducaoOut() {
        return new OpOrdemProducaoOut();
    }

    /**
     * Create an instance of {@link OpCentroDeRecursoOutConsultar }
     * 
     */
    public OpCentroDeRecursoOutConsultar createOpCentroDeRecursoOutConsultar() {
        return new OpCentroDeRecursoOutConsultar();
    }

    /**
     * Create an instance of {@link OpTurnoDeTrabalhoOut }
     * 
     */
    public OpTurnoDeTrabalhoOut createOpTurnoDeTrabalhoOut() {
        return new OpTurnoDeTrabalhoOut();
    }

    /**
     * Create an instance of {@link OpOrdemProducaoIn }
     * 
     */
    public OpOrdemProducaoIn createOpOrdemProducaoIn() {
        return new OpOrdemProducaoIn();
    }

    /**
     * Create an instance of {@link OpOperadorIn }
     * 
     */
    public OpOperadorIn createOpOperadorIn() {
        return new OpOperadorIn();
    }

    /**
     * Create an instance of {@link OpUsuarioOut }
     * 
     */
    public OpUsuarioOut createOpUsuarioOut() {
        return new OpUsuarioOut();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowName", scope = OpUsuarioIn.class)
    public JAXBElement<String> createOpUsuarioInFlowName(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowName_QNAME, String.class, OpUsuarioIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowInstanceID", scope = OpUsuarioIn.class)
    public JAXBElement<String> createOpUsuarioInFlowInstanceID(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowInstanceID_QNAME, String.class, OpUsuarioIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpOperadorOutConsultar.class)
    public JAXBElement<String> createOpOperadorOutConsultarMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpOperadorOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numCad", scope = OpOperadorOutConsultar.class)
    public JAXBElement<Integer> createOpOperadorOutConsultarNumCad(Integer value) {
        return new JAXBElement<Integer>(_OpOperadorOutConsultarNumCad_QNAME, Integer.class, OpOperadorOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "turTrb", scope = OpOperadorOutConsultar.class)
    public JAXBElement<Integer> createOpOperadorOutConsultarTurTrb(Integer value) {
        return new JAXBElement<Integer>(_OpOperadorOutConsultarTurTrb_QNAME, Integer.class, OpOperadorOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nomOpe", scope = OpOperadorOutConsultar.class)
    public JAXBElement<String> createOpOperadorOutConsultarNomOpe(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarNomOpe_QNAME, String.class, OpOperadorOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erroExecucao", scope = OpCentroDeRecursoOut.class)
    public JAXBElement<String> createOpCentroDeRecursoOutErroExecucao(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutErroExecucao_QNAME, String.class, OpCentroDeRecursoOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowName", scope = OpTurnoDeTrabalhoIn.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoInFlowName(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowName_QNAME, String.class, OpTurnoDeTrabalhoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowInstanceID", scope = OpTurnoDeTrabalhoIn.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoInFlowInstanceID(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowInstanceID_QNAME, String.class, OpTurnoDeTrabalhoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erroExecucao", scope = OpUsuarioOut.class)
    public JAXBElement<String> createOpUsuarioOutErroExecucao(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutErroExecucao_QNAME, String.class, OpUsuarioOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpUsuarioOutConsultar.class)
    public JAXBElement<String> createOpUsuarioOutConsultarMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpUsuarioOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codUsu", scope = OpUsuarioOutConsultar.class)
    public JAXBElement<Integer> createOpUsuarioOutConsultarCodUsu(Integer value) {
        return new JAXBElement<Integer>(_OpUsuarioOutConsultarCodUsu_QNAME, Integer.class, OpUsuarioOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "intNet", scope = OpUsuarioOutConsultar.class)
    public JAXBElement<String> createOpUsuarioOutConsultarIntNet(String value) {
        return new JAXBElement<String>(_OpUsuarioOutConsultarIntNet_QNAME, String.class, OpUsuarioOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "nomUsu", scope = OpUsuarioOutConsultar.class)
    public JAXBElement<String> createOpUsuarioOutConsultarNomUsu(String value) {
        return new JAXBElement<String>(_OpUsuarioOutConsultarNomUsu_QNAME, String.class, OpUsuarioOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erroExecucao", scope = OpTurnoDeTrabalhoOut.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoOutErroExecucao(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutErroExecucao_QNAME, String.class, OpTurnoDeTrabalhoOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seqMod", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<Integer> createOpFichaTecnicaOutConsultarSeqMod(Integer value) {
        return new JAXBElement<Integer>(_OpFichaTecnicaOutConsultarSeqMod_QNAME, Integer.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codCmp", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarCodCmp(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarCodCmp_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desDer", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarDesDer(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarDesDer_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "prdQtd", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<Double> createOpFichaTecnicaOutConsultarPrdQtd(Double value) {
        return new JAXBElement<Double>(_OpFichaTecnicaOutConsultarPrdQtd_QNAME, Double.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdUti", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<Double> createOpFichaTecnicaOutConsultarQtdUti(Double value) {
        return new JAXBElement<Double>(_OpFichaTecnicaOutConsultarQtdUti_QNAME, Double.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "uniMe2", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarUniMe2(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarUniMe2_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "derCmp", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarDerCmp(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarDerCmp_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desCmp", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarDesCmp(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarDesCmp_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdTot", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<Double> createOpFichaTecnicaOutConsultarQtdTot(Double value) {
        return new JAXBElement<Double>(_OpFichaTecnicaOutConsultarQtdTot_QNAME, Double.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tipPro", scope = OpFichaTecnicaOutConsultar.class)
    public JAXBElement<String> createOpFichaTecnicaOutConsultarTipPro(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarTipPro_QNAME, String.class, OpFichaTecnicaOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "horIni", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<Integer> createOpTurnoDeTrabalhoOutConsultarHorIni(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarHorIni_QNAME, Integer.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoOutConsultarMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codCre", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoOutConsultarCodCre(String value) {
        return new JAXBElement<String>(_OpTurnoDeTrabalhoOutConsultarCodCre_QNAME, String.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "horFim", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<Integer> createOpTurnoDeTrabalhoOutConsultarHorFim(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarHorFim_QNAME, Integer.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seqHtr", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<Integer> createOpTurnoDeTrabalhoOutConsultarSeqHtr(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarSeqHtr_QNAME, Integer.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tipHtr", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoOutConsultarTipHtr(String value) {
        return new JAXBElement<String>(_OpTurnoDeTrabalhoOutConsultarTipHtr_QNAME, String.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codEtg", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<Integer> createOpTurnoDeTrabalhoOutConsultarCodEtg(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarCodEtg_QNAME, Integer.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desTrb", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<String> createOpTurnoDeTrabalhoOutConsultarDesTrb(String value) {
        return new JAXBElement<String>(_OpTurnoDeTrabalhoOutConsultarDesTrb_QNAME, String.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "turTrb", scope = OpTurnoDeTrabalhoOutConsultar.class)
    public JAXBElement<Integer> createOpTurnoDeTrabalhoOutConsultarTurTrb(Integer value) {
        return new JAXBElement<Integer>(_OpOperadorOutConsultarTurTrb_QNAME, Integer.class, OpTurnoDeTrabalhoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erroExecucao", scope = OpOperadorOut.class)
    public JAXBElement<String> createOpOperadorOutErroExecucao(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutErroExecucao_QNAME, String.class, OpOperadorOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erroExecucao", scope = OpOrdemProducaoOut.class)
    public JAXBElement<String> createOpOrdemProducaoOutErroExecucao(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutErroExecucao_QNAME, String.class, OpOrdemProducaoOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "erroExecucao", scope = OpFichaTecnicaOut.class)
    public JAXBElement<String> createOpFichaTecnicaOutErroExecucao(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutErroExecucao_QNAME, String.class, OpFichaTecnicaOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codDer", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarCodDer(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodDer_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "prxDer", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarPrxDer(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarPrxDer_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdMax", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<Double> createOpOrdemProducaoOutConsultarQtdMax(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoOutConsultarQtdMax_QNAME, Double.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desPrxPro", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarDesPrxPro(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarDesPrxPro_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "prxPro", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarPrxPro(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarPrxPro_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desPrxDer", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarDesPrxDer(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarDesPrxDer_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codPro", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarCodPro(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodPro_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desPro", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarDesPro(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarDesPro_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cicPad", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<Double> createOpOrdemProducaoOutConsultarCicPad(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoOutConsultarCicPad_QNAME, Double.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codOri", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarCodOri(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodOri_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desDer", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<String> createOpOrdemProducaoOutConsultarDesDer(String value) {
        return new JAXBElement<String>(_OpFichaTecnicaOutConsultarDesDer_QNAME, String.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdRfg", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<Double> createOpOrdemProducaoOutConsultarQtdRfg(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoOutConsultarQtdRfg_QNAME, Double.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdPrv", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<Double> createOpOrdemProducaoOutConsultarQtdPrv(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoOutConsultarQtdPrv_QNAME, Double.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numOrp", scope = OpOrdemProducaoOutConsultar.class)
    public JAXBElement<Integer> createOpOrdemProducaoOutConsultarNumOrp(Integer value) {
        return new JAXBElement<Integer>(_OpOrdemProducaoOutConsultarNumOrp_QNAME, Integer.class, OpOrdemProducaoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowName", scope = OpOrdemProducaoIn.class)
    public JAXBElement<String> createOpOrdemProducaoInFlowName(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowName_QNAME, String.class, OpOrdemProducaoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowInstanceID", scope = OpOrdemProducaoIn.class)
    public JAXBElement<String> createOpOrdemProducaoInFlowInstanceID(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowInstanceID_QNAME, String.class, OpOrdemProducaoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowName", scope = OpCentroDeRecursoIn.class)
    public JAXBElement<String> createOpCentroDeRecursoInFlowName(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowName_QNAME, String.class, OpCentroDeRecursoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowInstanceID", scope = OpCentroDeRecursoIn.class)
    public JAXBElement<String> createOpCentroDeRecursoInFlowInstanceID(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowInstanceID_QNAME, String.class, OpCentroDeRecursoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "horMov", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoHorMov(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoHorMov_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codRef", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodRef(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodRef_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codDer", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodDer(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodDer_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codDiv", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodDiv(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodDiv_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codLot", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodLot(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodLot_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codCre", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoCodCre(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarCodCre_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codCcu", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodCcu(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodCcu_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdIql", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Double> createOpOrdemProducaoInAportamentoProducaoQtdIql(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoInAportamentoProducaoQtdIql_QNAME, Double.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "turTrb", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoTurTrb(Integer value) {
        return new JAXBElement<Integer>(_OpOperadorOutConsultarTurTrb_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datMov", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoDatMov(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoDatMov_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codEqp", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodEqp(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodEqp_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdRe1", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Double> createOpOrdemProducaoInAportamentoProducaoQtdRe1(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoInAportamentoProducaoQtdRe1_QNAME, Double.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdRe2", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Double> createOpOrdemProducaoInAportamentoProducaoQtdRe2(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoInAportamentoProducaoQtdRe2_QNAME, Double.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "indDiv", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoIndDiv(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoIndDiv_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdRe3", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Double> createOpOrdemProducaoInAportamentoProducaoQtdRe3(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoInAportamentoProducaoQtdRe3_QNAME, Double.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codMdv", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodMdv(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodMdv_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numOrp", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoNumOrp(Integer value) {
        return new JAXBElement<Integer>(_OpOrdemProducaoOutConsultarNumOrp_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codDft", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodDft(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoCodDft_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numSep", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoNumSep(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoInAportamentoProducaoNumSep_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codPro", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodPro(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodPro_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codOri", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<String> createOpOrdemProducaoInAportamentoProducaoCodOri(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodOri_QNAME, String.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qtdRfg", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Double> createOpOrdemProducaoInAportamentoProducaoQtdRfg(Double value) {
        return new JAXBElement<Double>(_OpOrdemProducaoOutConsultarQtdRfg_QNAME, Double.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numCad", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoNumCad(Integer value) {
        return new JAXBElement<Integer>(_OpOperadorOutConsultarNumCad_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seqRot", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoSeqRot(Integer value) {
        return new JAXBElement<Integer>(_OpOrdemProducaoInAportamentoProducaoSeqRot_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codEtg", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoCodEtg(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarCodEtg_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tipOpr", scope = OpOrdemProducaoInAportamentoProducao.class)
    public JAXBElement<Integer> createOpOrdemProducaoInAportamentoProducaoTipOpr(Integer value) {
        return new JAXBElement<Integer>(_OpOrdemProducaoInAportamentoProducaoTipOpr_QNAME, Integer.class, OpOrdemProducaoInAportamentoProducao.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mensagemRetorno", scope = OpCentroDeRecursoOutConsultar.class)
    public JAXBElement<String> createOpCentroDeRecursoOutConsultarMensagemRetorno(String value) {
        return new JAXBElement<String>(_OpOperadorOutConsultarMensagemRetorno_QNAME, String.class, OpCentroDeRecursoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codCre", scope = OpCentroDeRecursoOutConsultar.class)
    public JAXBElement<String> createOpCentroDeRecursoOutConsultarCodCre(String value) {
        return new JAXBElement<String>(_OpTurnoDeTrabalhoOutConsultarCodCre_QNAME, String.class, OpCentroDeRecursoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codEtg", scope = OpCentroDeRecursoOutConsultar.class)
    public JAXBElement<Integer> createOpCentroDeRecursoOutConsultarCodEtg(Integer value) {
        return new JAXBElement<Integer>(_OpTurnoDeTrabalhoOutConsultarCodEtg_QNAME, Integer.class, OpCentroDeRecursoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "desCre", scope = OpCentroDeRecursoOutConsultar.class)
    public JAXBElement<String> createOpCentroDeRecursoOutConsultarDesCre(String value) {
        return new JAXBElement<String>(_OpCentroDeRecursoOutConsultarDesCre_QNAME, String.class, OpCentroDeRecursoOutConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codDer", scope = OpFichaTecnicaIn.class)
    public JAXBElement<String> createOpFichaTecnicaInCodDer(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodDer_QNAME, String.class, OpFichaTecnicaIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowName", scope = OpFichaTecnicaIn.class)
    public JAXBElement<String> createOpFichaTecnicaInFlowName(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowName_QNAME, String.class, OpFichaTecnicaIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowInstanceID", scope = OpFichaTecnicaIn.class)
    public JAXBElement<String> createOpFichaTecnicaInFlowInstanceID(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowInstanceID_QNAME, String.class, OpFichaTecnicaIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codPro", scope = OpFichaTecnicaIn.class)
    public JAXBElement<String> createOpFichaTecnicaInCodPro(String value) {
        return new JAXBElement<String>(_OpOrdemProducaoOutConsultarCodPro_QNAME, String.class, OpFichaTecnicaIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowName", scope = OpOperadorIn.class)
    public JAXBElement<String> createOpOperadorInFlowName(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowName_QNAME, String.class, OpOperadorIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowInstanceID", scope = OpOperadorIn.class)
    public JAXBElement<String> createOpOperadorInFlowInstanceID(String value) {
        return new JAXBElement<String>(_OpUsuarioInFlowInstanceID_QNAME, String.class, OpOperadorIn.class, value);
    }

}
