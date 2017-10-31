
package br.com.senior.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "sapiens_Syncnutriplan_op", targetNamespace = "http://services.senior.com.br")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SapiensSyncnutriplanOp {


    /**
     * 
     * @param password
     * @param encryption
     * @param user
     * @param parameters
     * @return
     *     returns br.com.senior.services.OpCentroDeRecursoOut
     */
    @WebMethod(operationName = "CentroDeRecurso")
    @WebResult(name = "result", partName = "result")
    @Action(input = "http://services.senior.com.br/sapiens_Syncnutriplan_op/CentroDeRecursoRequest", output = "http://services.senior.com.br/sapiens_Syncnutriplan_op/CentroDeRecursoResponse")
    public OpCentroDeRecursoOut centroDeRecurso(
        @WebParam(name = "user", partName = "user")
        String user,
        @WebParam(name = "password", partName = "password")
        String password,
        @WebParam(name = "encryption", partName = "encryption")
        int encryption,
        @WebParam(name = "parameters", partName = "parameters")
        OpCentroDeRecursoIn parameters);

    /**
     * 
     * @param password
     * @param encryption
     * @param user
     * @param parameters
     * @return
     *     returns br.com.senior.services.OpTurnoDeTrabalhoOut
     */
    @WebMethod(operationName = "TurnoDeTrabalho")
    @WebResult(name = "result", partName = "result")
    @Action(input = "http://services.senior.com.br/sapiens_Syncnutriplan_op/TurnoDeTrabalhoRequest", output = "http://services.senior.com.br/sapiens_Syncnutriplan_op/TurnoDeTrabalhoResponse")
    public OpTurnoDeTrabalhoOut turnoDeTrabalho(
        @WebParam(name = "user", partName = "user")
        String user,
        @WebParam(name = "password", partName = "password")
        String password,
        @WebParam(name = "encryption", partName = "encryption")
        int encryption,
        @WebParam(name = "parameters", partName = "parameters")
        OpTurnoDeTrabalhoIn parameters);

    /**
     * 
     * @param password
     * @param encryption
     * @param user
     * @param parameters
     * @return
     *     returns br.com.senior.services.OpOperadorOut
     */
    @WebMethod(operationName = "Operador")
    @WebResult(name = "result", partName = "result")
    @Action(input = "http://services.senior.com.br/sapiens_Syncnutriplan_op/OperadorRequest", output = "http://services.senior.com.br/sapiens_Syncnutriplan_op/OperadorResponse")
    public OpOperadorOut operador(
        @WebParam(name = "user", partName = "user")
        String user,
        @WebParam(name = "password", partName = "password")
        String password,
        @WebParam(name = "encryption", partName = "encryption")
        int encryption,
        @WebParam(name = "parameters", partName = "parameters")
        OpOperadorIn parameters);

    /**
     * 
     * @param password
     * @param encryption
     * @param user
     * @param parameters
     * @return
     *     returns br.com.senior.services.OpOrdemProducaoOut
     */
    @WebMethod(operationName = "OrdemProducao")
    @WebResult(name = "result", partName = "result")
    @Action(input = "http://services.senior.com.br/sapiens_Syncnutriplan_op/OrdemProducaoRequest", output = "http://services.senior.com.br/sapiens_Syncnutriplan_op/OrdemProducaoResponse")
    public OpOrdemProducaoOut ordemProducao(
        @WebParam(name = "user", partName = "user")
        String user,
        @WebParam(name = "password", partName = "password")
        String password,
        @WebParam(name = "encryption", partName = "encryption")
        int encryption,
        @WebParam(name = "parameters", partName = "parameters")
        OpOrdemProducaoIn parameters);

    /**
     * 
     * @param password
     * @param encryption
     * @param user
     * @param parameters
     * @return
     *     returns br.com.senior.services.OpUsuarioOut
     */
    @WebMethod(operationName = "Usuario")
    @WebResult(name = "result", partName = "result")
    @Action(input = "http://services.senior.com.br/sapiens_Syncnutriplan_op/UsuarioRequest", output = "http://services.senior.com.br/sapiens_Syncnutriplan_op/UsuarioResponse")
    public OpUsuarioOut usuario(
        @WebParam(name = "user", partName = "user")
        String user,
        @WebParam(name = "password", partName = "password")
        String password,
        @WebParam(name = "encryption", partName = "encryption")
        int encryption,
        @WebParam(name = "parameters", partName = "parameters")
        OpUsuarioIn parameters);

}
