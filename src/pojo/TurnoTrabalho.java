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
public class TurnoTrabalho {

    String codCre;
    Integer codEtg;
    String desTrb;
    Integer horFim;
    Integer horIni;
    Integer seqHtr;
    String tipHtr;
    Integer turTrb;

    List<TurnoTrabalho> itensTurnoTrabalho = new ArrayList<TurnoTrabalho>();

    public String getCodCre() {
        return codCre;
    }

    public void setCodCre(String codCre) {
        this.codCre = codCre;
    }

    public Integer getCodEtg() {
        return codEtg;
    }

    public void setCodEtg(Integer codEtg) {
        this.codEtg = codEtg;
    }

    public String getDesTrb() {
        return desTrb;
    }

    public void setDesTrb(String desTrb) {
        this.desTrb = desTrb;
    }

    public Integer getHorFim() {
        return horFim;
    }

    public void setHorFim(Integer horFim) {
        this.horFim = horFim;
    }

    public Integer getHorIni() {
        return horIni;
    }

    public void setHorIni(Integer horIni) {
        this.horIni = horIni;
    }

    public Integer getSeqHtr() {
        return seqHtr;
    }

    public void setSeqHtr(Integer seqHtr) {
        this.seqHtr = seqHtr;
    }

    public String getTipHtr() {
        return tipHtr;
    }

    public void setTipHtr(String tipHtr) {
        this.tipHtr = tipHtr;
    }

    public Integer getTurTrb() {
        return turTrb;
    }

    public void setTurTrb(Integer turTrb) {
        this.turTrb = turTrb;
    }

    public List<TurnoTrabalho> getItensTurnoTrabalho() {
        return itensTurnoTrabalho;
    }

    public void setItensTurnoTrabalho(List<TurnoTrabalho> itensTurnoTrabalho) {
        this.itensTurnoTrabalho = itensTurnoTrabalho;
    }
}
