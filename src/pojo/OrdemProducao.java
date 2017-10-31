/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diogo.melo
 */
public class OrdemProducao {

    Double cicPad;
    String codDer;
    String codOri;
    String codPro;
    String desDer;
    String desPro;
    String desPrxDer;
    String desPrxPro;
    String MenssagemRetorno;
    Integer numOrp;
    String prxDer;
    String prxPro;
    Double qtdMax;
    Double qtdPrv;
    Double qtdRfg;
    List<OrdemProducao> itensOrdemProducao = new ArrayList<OrdemProducao>();

    public Double getCicPad() {
        return cicPad;
    }

    public void setCicPad(Double cicPad) {
        this.cicPad = cicPad;
    }

    public String getCodDer() {
        return codDer;
    }

    public void setCodDer(String codDer) {
        this.codDer = codDer;
    }

    public String getCodOri() {
        return codOri;
    }

    public void setCodOri(String codOri) {
        this.codOri = codOri;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public String getDesDer() {
        return desDer;
    }

    public void setDesDer(String desDer) {
        this.desDer = desDer;
    }

    public String getDesPro() {
        return desPro;
    }

    public void setDesPro(String desPro) {
        this.desPro = desPro;
    }

    public String getDesPrxDer() {
        return desPrxDer;
    }

    public void setDesPrxDer(String desPrxDer) {
        this.desPrxDer = desPrxDer;
    }

    public String getDesPrxPro() {
        return desPrxPro;
    }

    public void setDesPrxPro(String desPrxPro) {
        this.desPrxPro = desPrxPro;
    }

    public String getMenssagemRetorno() {
        return MenssagemRetorno;
    }

    public void setMenssagemRetorno(String MenssagemRetorno) {
        this.MenssagemRetorno = MenssagemRetorno;
    }

    public Integer getNumOrp() {
        return numOrp;
    }

    public void setNumOrp(Integer numOrp) {
        this.numOrp = numOrp;
    }

    public String getPrxDer() {
        return prxDer;
    }

    public void setPrxDer(String prxDer) {
        this.prxDer = prxDer;
    }

    public String getPrxPro() {
        return prxPro;
    }

    public void setPrxPro(String prxPro) {
        this.prxPro = prxPro;
    }

    public Double getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(Double qtdMax) {
        this.qtdMax = qtdMax;
    }

    public Double getQtdPrv() {
        return qtdPrv;
    }

    public void setQtdPrv(Double qtdPrv) {
        this.qtdPrv = qtdPrv;
    }

    public Double getQtdRfg() {
        return qtdRfg;
    }

    public void setQtdRfg(Double qtdRfg) {
        this.qtdRfg = qtdRfg;
    }

    public List<OrdemProducao> getItensOrdemProducao() {
        return itensOrdemProducao;
    }

    public void setItensOrdemProducao(List<OrdemProducao> itensOrdemProducao) {
        this.itensOrdemProducao = itensOrdemProducao;
    }

    
}
