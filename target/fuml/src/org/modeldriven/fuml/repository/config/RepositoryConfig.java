//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.27 at 03:14:18 PM EST 
//


package org.modeldriven.fuml.repository.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RepositoryConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepositoryConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artifact" type="{http://www.modeldriven.org/fuml/repository/config}Artifact" maxOccurs="unbounded"/>
 *         &lt;element name="ignoredPackage" type="{http://www.modeldriven.org/fuml/repository/config}IgnoredPackage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ignoredClass" type="{http://www.modeldriven.org/fuml/repository/config}IgnoredClass" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="defaultUMLNamespaceURI" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepositoryConfig", propOrder = {
    "artifact",
    "ignoredPackage",
    "ignoredClass"
})
public class RepositoryConfig {

    @XmlElement(required = true)
    protected List<Artifact> artifact;
    protected List<IgnoredPackage> ignoredPackage;
    protected List<IgnoredClass> ignoredClass;
    @XmlAttribute(required = true)
    protected String defaultUMLNamespaceURI;

    /**
     * Gets the value of the artifact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artifact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtifact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Artifact }
     * 
     * 
     */
    public List<Artifact> getArtifact() {
        if (artifact == null) {
            artifact = new ArrayList<Artifact>();
        }
        return this.artifact;
    }

    /**
     * Gets the value of the ignoredPackage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ignoredPackage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIgnoredPackage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IgnoredPackage }
     * 
     * 
     */
    public List<IgnoredPackage> getIgnoredPackage() {
        if (ignoredPackage == null) {
            ignoredPackage = new ArrayList<IgnoredPackage>();
        }
        return this.ignoredPackage;
    }

    /**
     * Gets the value of the ignoredClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ignoredClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIgnoredClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IgnoredClass }
     * 
     * 
     */
    public List<IgnoredClass> getIgnoredClass() {
        if (ignoredClass == null) {
            ignoredClass = new ArrayList<IgnoredClass>();
        }
        return this.ignoredClass;
    }

    /**
     * Gets the value of the defaultUMLNamespaceURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultUMLNamespaceURI() {
        return defaultUMLNamespaceURI;
    }

    /**
     * Sets the value of the defaultUMLNamespaceURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultUMLNamespaceURI(String value) {
        this.defaultUMLNamespaceURI = value;
    }

}
