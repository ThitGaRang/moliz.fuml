//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.25 at 08:24:09 PM EST 
//


package org.modeldriven.fuml.config;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NamespaceDomain.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NamespaceDomain">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="xmi"/>
 *     &lt;enumeration value="uml"/>
 *     &lt;enumeration value="ecore"/>
 *     &lt;enumeration value="magicdraw"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NamespaceDomain")
@XmlEnum
public enum NamespaceDomain {

    @XmlEnumValue("xmi")
    XMI("xmi"),
    @XmlEnumValue("uml")
    UML("uml"),
    @XmlEnumValue("ecore")
    ECORE("ecore"),
    @XmlEnumValue("magicdraw")
    MAGICDRAW("magicdraw");
    private final String value;

    NamespaceDomain(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NamespaceDomain fromValue(String v) {
        for (NamespaceDomain c: NamespaceDomain.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}