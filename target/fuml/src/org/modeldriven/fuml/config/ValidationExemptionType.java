//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.15 at 07:09:42 PM EST 
//


package org.modeldriven.fuml.config;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidationExemptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValidationExemptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="requiredProperty"/>
 *     &lt;enumeration value="undefinedProperty"/>
 *     &lt;enumeration value="externalReference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValidationExemptionType")
@XmlEnum
public enum ValidationExemptionType {

    @XmlEnumValue("requiredProperty")
    REQUIRED_PROPERTY("requiredProperty"),
    @XmlEnumValue("undefinedProperty")
    UNDEFINED_PROPERTY("undefinedProperty"),
    @XmlEnumValue("externalReference")
    EXTERNAL_REFERENCE("externalReference");
    private final String value;

    ValidationExemptionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationExemptionType fromValue(String v) {
        for (ValidationExemptionType c: ValidationExemptionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
