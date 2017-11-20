
package br.com.senior.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de opTurnoDeTrabalhoXHorariosOutConsultar complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="opTurnoDeTrabalhoXHorariosOutConsultar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEtg" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="horFim" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="horIni" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="seqHtr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipHtr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="turTrb" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "opTurnoDeTrabalhoXHorariosOutConsultar", propOrder = {
    "codCre",
    "codEtg",
    "horFim",
    "horIni",
    "seqHtr",
    "tipHtr",
    "turTrb"
})
public class OpTurnoDeTrabalhoXHorariosOutConsultar {

    @XmlElementRef(name = "codCre", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codCre;
    @XmlElementRef(name = "codEtg", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> codEtg;
    @XmlElementRef(name = "horFim", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> horFim;
    @XmlElementRef(name = "horIni", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> horIni;
    @XmlElementRef(name = "seqHtr", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> seqHtr;
    @XmlElementRef(name = "tipHtr", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipHtr;
    @XmlElementRef(name = "turTrb", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> turTrb;

    /**
     * Obtém o valor da propriedade codCre.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodCre() {
        return codCre;
    }

    /**
     * Define o valor da propriedade codCre.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodCre(JAXBElement<String> value) {
        this.codCre = value;
    }

    /**
     * Obtém o valor da propriedade codEtg.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCodEtg() {
        return codEtg;
    }

    /**
     * Define o valor da propriedade codEtg.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCodEtg(JAXBElement<Integer> value) {
        this.codEtg = value;
    }

    /**
     * Obtém o valor da propriedade horFim.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getHorFim() {
        return horFim;
    }

    /**
     * Define o valor da propriedade horFim.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setHorFim(JAXBElement<Integer> value) {
        this.horFim = value;
    }

    /**
     * Obtém o valor da propriedade horIni.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getHorIni() {
        return horIni;
    }

    /**
     * Define o valor da propriedade horIni.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setHorIni(JAXBElement<Integer> value) {
        this.horIni = value;
    }

    /**
     * Obtém o valor da propriedade seqHtr.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getSeqHtr() {
        return seqHtr;
    }

    /**
     * Define o valor da propriedade seqHtr.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setSeqHtr(JAXBElement<Integer> value) {
        this.seqHtr = value;
    }

    /**
     * Obtém o valor da propriedade tipHtr.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipHtr() {
        return tipHtr;
    }

    /**
     * Define o valor da propriedade tipHtr.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipHtr(JAXBElement<String> value) {
        this.tipHtr = value;
    }

    /**
     * Obtém o valor da propriedade turTrb.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getTurTrb() {
        return turTrb;
    }

    /**
     * Define o valor da propriedade turTrb.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setTurTrb(JAXBElement<Integer> value) {
        this.turTrb = value;
    }

}
