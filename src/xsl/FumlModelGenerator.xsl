<?xml version="1.0" encoding="UTF-8"?>
<!--
-->
<xsl:stylesheet version="2.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:lxslt="http://xml.apache.org/xslt"
  xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"
  xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML"
  xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore">

<xsl:output method="text"
    indent="no"/>

<xsl:param name="pkg" />
<xsl:param name="cls" />
<xsl:param name="uri" />
    
    <xsl:template match="/">
package <xsl:value-of select="$pkg" />;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Generalization;
import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import fUML.Syntax.Classes.Kernel.PrimitiveType;
import UMLPrimitiveTypes.UnlimitedNatural;
import fUML.Syntax.Classes.Kernel.ValueSpecification;
import fUML.Syntax.Classes.Kernel.Enumeration;
import fUML.Syntax.Classes.Kernel.EnumerationLiteral;
import fUML.Syntax.Classes.Kernel.Package;

import org.modeldriven.fuml.meta.MetaDataDocument;
import org.modeldriven.fuml.meta.Mapping;

import org.modeldriven.fuml.meta.Property;


public class <xsl:value-of select="$cls" /> extends MetaModelAssembler 
    implements MetaDataDocument
{

    private static Log log = LogFactory.getLog(<xsl:value-of select="$cls" />.class);
    private String uri;
    private MetaModelFactory factory;

    public <xsl:value-of select="$cls" />(Mapping mapping) {
        super(mapping);
        this.factory = new MetaModelFactory(mapping);
        this.uri = "<xsl:value-of select="$uri" />";
        construct();
    }

    private void construct() {
        log.info("initializing...");
        constructPackages();
        constructPrimitiveTypes();
        constructEnumerations();
        constructClasses();
        constructProperties();
        constructGeneralizations();
    } 

    public String getURI() {
        return uri;
    }
    
    private void constructPackages()
    {
        Package pkg = null;
     <xsl:for-each select="//packagedElement[@xmi:type = 'uml:Package']">
        <xsl:variable name="packageName">                 
          <xsl:call-template name="findPackageName">                    
            <xsl:with-param name="pkg" select="''"/>       
            <xsl:with-param name="clss" select="."/>       
          </xsl:call-template>                                                    
        </xsl:variable>                                                  
        <xsl:variable name="qualifiedPackageName">
            <xsl:choose>                                                           
                <xsl:when test="$packageName != ''"> 
                    <xsl:value-of select="concat(concat($packageName, '.'), @name)"/>        
                </xsl:when>                                                    
                <xsl:otherwise>                                                
                    <xsl:value-of select="@name"/>        
                </xsl:otherwise>                                               
            </xsl:choose>                                   
        </xsl:variable>    
                     
        // <xsl:value-of select="$qualifiedPackageName"/>
        <xsl:choose>                                                           
            <xsl:when test="$packageName = ''">            
    	pkg  = factory.createPackage("<xsl:value-of select="@name" />", "<xsl:value-of select="$qualifiedPackageName" />", "<xsl:value-of select="@xmi:id" />", this); // root package
    	mapping.mapPackage(pkg, null, this); 
            </xsl:when>                                                        
            <xsl:otherwise>                                                    
    	pkg  = factory.createPackage("<xsl:value-of select="@name" />", "<xsl:value-of select="$qualifiedPackageName" />", "<xsl:value-of select="@xmi:id" />", pkg, this);
    	mapping.mapPackage(pkg, "<xsl:value-of select="$packageName" />", this); 
            </xsl:otherwise>                                                   
        </xsl:choose>
        <xsl:for-each select="packageMerge">
        
         <xsl:variable name="localMergedPackage" select="@mergedPackage"/>                 
         <xsl:variable name="remoteMergedPackage" select="./mergedPackage/@href"/>                 
        <xsl:choose>                                                           
            <xsl:when test="$localMergedPackage != ''">            
        mapping.mapPackageMerge(pkg, "<xsl:value-of select="$localMergedPackage" />");
            </xsl:when>                                                        
            <xsl:otherwise>                                                    
        mapping.mapPackageMerge(pkg, "<xsl:value-of select="$remoteMergedPackage" />");
            </xsl:otherwise>                                                   
        </xsl:choose>
       
        </xsl:for-each>                                                          
    </xsl:for-each>
    }   

    private void constructPrimitiveTypes()
    {
        PrimitiveType type = null;
    <xsl:for-each select="//packagedElement[@xmi:type = 'uml:PrimitiveType']">
        <xsl:variable name="packageName">                 
          <xsl:call-template name="findPackageName">                    
            <xsl:with-param name="pkg" select="''"/>       
            <xsl:with-param name="clss" select="."/>       
          </xsl:call-template>                                                    
        </xsl:variable>                                                  
        // <xsl:value-of select="@name" />
    	type  = factory.createPrimitiveType("<xsl:value-of select="@name" />", "<xsl:value-of select="@xmi:id" />");
    	mapping.mapPrimitiveType(type, "<xsl:value-of select="$packageName" />", this); 
    </xsl:for-each>
    }   
       
    private void constructClasses()
    {
        Package pkg = null;
        Class_ clss = null;
    <xsl:for-each select="//packagedElement[@xmi:type = 'uml:Class']">
        <xsl:variable name="classVar"
            select="concat('the', translate(@xmi:id,'-',''))">
        </xsl:variable>    

        <xsl:variable name="packageName">                 
          <xsl:call-template name="findPackageName">                    
            <xsl:with-param name="pkg" select="''"/>       
            <xsl:with-param name="clss" select="."/>       
          </xsl:call-template>                                                    
        </xsl:variable>                                                  
        // <xsl:value-of select="$packageName" />.<xsl:value-of select="@name" /> 
        pkg = mapping.getPackageByQualifiedName("<xsl:value-of select="$packageName" />");       
    	clss  = factory.createClass("<xsl:value-of select="@name" />", "<xsl:value-of select="@xmi:id" />", pkg);
    	clss.isAbstract = <xsl:value-of select="boolean(@isAbstract)" />;
    	((Classifier)clss).isAbstract = <xsl:value-of select="boolean(@isAbstract)" />;
    	mapping.mapClass(clss, "<xsl:value-of select="$packageName" />", this); 
    </xsl:for-each>
    }   

    private void constructEnumerations()
    {
        Enumeration enumeration = null;
        EnumerationLiteral literal = null;
    <xsl:for-each select="//packagedElement[@xmi:type = 'uml:Enumeration']">
        <xsl:variable name="packageName">                 
          <xsl:call-template name="findPackageName">                    
            <xsl:with-param name="pkg" select="''"/>       
            <xsl:with-param name="clss" select="."/>       
          </xsl:call-template>                                                    
        </xsl:variable>                                                  
        // <xsl:value-of select="@name" />
    	enumeration  = factory.createEnumeration("<xsl:value-of select="@name" />", "<xsl:value-of select="@xmi:id" />");
    	mapping.mapEnumeration(enumeration, "<xsl:value-of select="$packageName" />"); 
        <xsl:for-each select="ownedLiteral">
        literal = factory.addEnumerationLiteral(enumeration, 
            "<xsl:value-of select="@name" />",
            "<xsl:value-of select="@xmi:id" />");
    	mapping.mapEnumerationLiteral(literal, "<xsl:value-of select="$packageName" />"); 
        </xsl:for-each>
    </xsl:for-each>
    }   

    private void constructProperties()
    {
        Class_ clss = null;
        Property prop = null;
        
    <xsl:for-each select="//packagedElement[@xmi:type = 'uml:Class']">
        // <xsl:value-of select="@name" />
    	clss  = (Class_)mapping.get("<xsl:value-of select="@xmi:id" />");
    	<xsl:for-each select="ownedAttribute">
    	<xsl:variable name="typeAttribute">
    	    <xsl:value-of select="@type" />
    	</xsl:variable>
    	<xsl:variable name="typeElement">
    	    <xsl:value-of select="type/@href"/>
    	</xsl:variable>    	
    	<xsl:variable name="hasLowerValue">
    	    <xsl:value-of select="boolean(count(lowerValue)=1)"/>
    	</xsl:variable>    	
    	<xsl:variable name="hasUpperValue">
    	    <xsl:value-of select="boolean(count(upperValue)=1)"/>
    	</xsl:variable>    	
    	prop = factory.addProperty(clss, "<xsl:value-of select="@name" />", 
    	    "<xsl:value-of select="@xmi:id" />",
    	    "<xsl:if test="$typeAttribute != ''">
    	    <xsl:value-of select="$typeAttribute" />
    	</xsl:if>
    	<xsl:if test="$typeElement != ''">
    	    <xsl:value-of select="$typeElement" />
    	</xsl:if>",
    	    "<xsl:value-of select="@redefinedProperty" />",    	    
    		<xsl:value-of select="boolean(@readOnly)" />, <xsl:value-of select="boolean(@derived)" />, <xsl:value-of select="boolean(@derivedUnion)" />);    	
        factory.addLowerValue(prop, <xsl:value-of select="$hasLowerValue" />, "<xsl:value-of select="normalize-space(lowerValue/@value)" />");
        factory.addUpperValue(prop, <xsl:value-of select="$hasUpperValue" />, "<xsl:value-of select="normalize-space(upperValue/@value)" />");
    	mapping.mapProperty(clss, prop, this);    
     	
    	<xsl:for-each select="defaultValue">
            <xsl:variable name="val">
            <xsl:choose>                                                           
                <xsl:when test="@xmi:type = 'uml:LiteralBoolean'">new Boolean(<xsl:value-of select="boolean(@value)" />)</xsl:when>                                                        
                <xsl:when test="@xmi:type = 'uml:LiteralInteger'">new Integer(<xsl:choose>
                    <xsl:when test="@value != ''">
                        <xsl:value-of select="@value" />
                    </xsl:when>
                    <xsl:otherwise><xsl:value-of select="'0'" /></xsl:otherwise>
                    </xsl:choose>)
                </xsl:when>                                                        
                <xsl:when test="@xmi:type = 'uml:OpaqueExpression'">
                    <xsl:value-of select="./body/text()" />            
                </xsl:when>                                                        
                <xsl:when test="@xmi:type = 'uml:LiteralString'">new String("<xsl:value-of select="@value" />")</xsl:when>                                                        
                <xsl:otherwise>new String("<xsl:value-of select="@value" />")</xsl:otherwise>                                                   
            </xsl:choose>
            </xsl:variable>
     	factory.addDefault(prop,
    	   <xsl:value-of select="$val" />,
    	   "<xsl:value-of select="@instance" />",
    	   "<xsl:value-of select="@xmi:id" />",  
    	   "<xsl:value-of select="@xmi:type" />",  
    	   "<xsl:value-of select="@type" />");
    	</xsl:for-each>
    	
    	</xsl:for-each> <!-- ownedAttribute -->
    	
    </xsl:for-each>
    }
    
    private void constructGeneralizations()
    {
        Class_ clss = null;
        
    <xsl:for-each select="//packagedElement[@xmi:type = 'uml:Class']">
        // <xsl:value-of select="@name" />
    	clss  = (Class_)mapping.get("<xsl:value-of select="@xmi:id" />");
    	<xsl:for-each select="generalization">
    	factory.addGeneralization(clss, "<xsl:value-of select="@general" />");
    	</xsl:for-each>    	
    	
    </xsl:for-each>
    }
}
    
    </xsl:template> <!-- root -->

    <xsl:template name="findPackageName">                                        
      <xsl:param name="pkg" />                                                   
      <xsl:param name="clss" />                                                  
                                                                                 
      <xsl:if test="$clss/../@xmi:type = 'uml:Package' or name($clss/..) = 'uml:Model'">                         
          <xsl:variable name="pkgvar">                                           
              <xsl:value-of select="concat($clss/../@name, $pkg)" />             
          </xsl:variable>                                                        
          <xsl:choose>                                                           
              <xsl:when test="$clss/../../@xmi:type = 'uml:Package' or name($clss/../..) = 'uml:Model'">            
                  <xsl:call-template name="findPackageName">                     
                    <xsl:with-param name="pkg" select="concat('.', $pkgvar)"/>   
                    <xsl:with-param name="clss" select="$clss/.."/>              
                  </xsl:call-template>                                                
              </xsl:when>                                                        
              <xsl:otherwise>                                                    
                  <xsl:value-of select="$pkgvar"/>                               
              </xsl:otherwise>                                                   
          </xsl:choose>                                                          
      </xsl:if>                                                                  
    </xsl:template>                                                              

    
</xsl:stylesheet>    
