/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import br.com.senior.services.OpOperadorOutConsultar;

public class Operador {

    OpOperadorOutConsultar opConsultaOperador = new OpOperadorOutConsultar();

    public void getOperador() {
        br.com.senior.services.G5SeniorServices service = new br.com.senior.services.G5SeniorServices();

        br.com.senior.services.SapiensSyncnutriplanOp port = service.getSapiensSyncnutriplanOpPort();

        br.com.senior.services.OpOperadorIn parameters = new br.com.senior.services.OpOperadorIn();

        br.com.senior.services.OpOperadorOut result = port.operador("integracao.op", "ERPintegracao.4651", 0, parameters);
    }

}
