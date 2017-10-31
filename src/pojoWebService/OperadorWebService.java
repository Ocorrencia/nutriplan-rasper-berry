/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojoWebService;

import br.com.senior.services.OpOperadorOutConsultar;
import java.util.ArrayList;
import java.util.List;
import pojo.Operador;

/**
 *
 * @author diogo.melo
 */
public class OperadorWebService {

    public void buscarOperadoresSapiens() {
        br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();
        br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();
        br.com.senior.services.OpOperadorIn parameters = new br.com.senior.services.OpOperadorIn();
        br.com.senior.services.OpOperadorOut result = port.operador("integracao.op", "ERPintegracao.4651", 0, parameters);
        preencherOperador(result);
    }

    public void preencherOperador(br.com.senior.services.OpOperadorOut result) {
        List<Operador> itensOperadores = new ArrayList<Operador>();
        Operador operador = new Operador();
        for (OpOperadorOutConsultar operadores : result.getConsultar()) {
            operador = new Operador();
            operador.setNomOpe(operadores.getNomOpe().getValue());
            operador.setNumCad(operadores.getNumCad().getValue());
            operador.setTurTrb(operadores.getTurTrb().getValue());
            itensOperadores.add(operador);
            System.out.println("operadoress" + operadores.getNomOpe().getValue());
        }
        operador.setItensOperadores(itensOperadores);
        //TODO: enviar dados(itensOperadores) para o dao e executar a inclusao no banco
    }
}
