//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.25 at 08:24:09 PM EST 
//


package org.modeldriven.fuml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImportAdapter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportAdapter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="type" use="required" type="{http://www.modeldriven.org/fuml/config}ImportAdapterType" />
 *       &lt;attribute name="className" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="adapterClassName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportAdapter")
public class ImportAdapter {

    @XmlAttribute(required = true)
    protected ImportAdapterType type;
    @XmlAttribute(required = true)
    protected String className;
    @XmlAttribute(required = true)
    protected String adapterClassName;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ImportAdapterType }
     *     
     */
    public ImportAdapterType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportAdapterType }
     *     
     */
    public void setType(ImportAdapterType value) {
        this.type = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the adapterClassName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdapterClassName() {
        return adapterClassName;
    }

    /**
     * Sets the value of the adapterClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdapterClassName(String value) {
        this.adapterClassName = value;
    }

}
