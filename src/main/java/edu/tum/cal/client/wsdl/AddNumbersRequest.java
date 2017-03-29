//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.03.29 um 06:30:15 PM CEST 
//


package edu.tum.cal.client.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="n1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="n2" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "n1",
    "n2"
})
@XmlRootElement(name = "AddNumbersRequest", namespace = "http://add.cal.tum.edu")
public class AddNumbersRequest {

    @XmlElement(namespace = "http://add.cal.tum.edu", required = true)
    protected String n1;
    @XmlElement(namespace = "http://add.cal.tum.edu", required = true)
    protected String n2;

    /**
     * Ruft den Wert der n1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN1() {
        return n1;
    }

    /**
     * Legt den Wert der n1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN1(String value) {
        this.n1 = value;
    }

    /**
     * Ruft den Wert der n2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN2() {
        return n2;
    }

    /**
     * Legt den Wert der n2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN2(String value) {
        this.n2 = value;
    }

}
