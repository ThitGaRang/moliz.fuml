<?xml version="1.0" encoding="UTF-8"?>
<!--
   Converts an XMI format to an "expanded" (also known as "striped") format 
   based on the the XMI 'type' attribute and its namespace.
-->
<xsl:stylesheet version="2.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:lxslt="http://xml.apache.org/xslt"
  xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore">

<xsl:output method="xml"
    indent="yes"/>
    
    <xsl:template match="*">

    <xsl:variable name="currentElemXmiType"
        select="@*[local-name() = 'type' and namespace-uri() = 'http://schema.omg.org/spec/XMI/2.1']">
    </xsl:variable>    
    <xsl:variable name="elementName" select="name()"></xsl:variable>
    
    <xsl:choose>
      <!-- When element has an xmi:type attrib and it's a UML type. (HACK: determine UML based on root level namespace prefix!)  -->
      <xsl:when test="$currentElemXmiType != '' and starts-with($currentElemXmiType,'uml:')">
        <xsl:text disable-output-escaping="yes">&lt;</xsl:text><xsl:value-of select="$elementName"/>
        <xsl:for-each select="@*">
            <xsl:choose>
              <xsl:when test="namespace-uri() = 'http://schema.omg.org/spec/XMI/2.1'">
                <xsl:value-of select="' '"/>
                <xsl:value-of select="name()"/>
                <xsl:value-of select="'='"/>
                <xsl:text disable-output-escaping="yes">&quot;</xsl:text>
                <xsl:value-of select="."/>
                <xsl:text disable-output-escaping="yes">&quot;</xsl:text>
              </xsl:when>      
              <xsl:otherwise>                               
              </xsl:otherwise>                               
            </xsl:choose>   
        </xsl:for-each>       
        <xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
        <xsl:text disable-output-escaping="yes">&lt;</xsl:text><xsl:value-of select="$currentElemXmiType"/>
        <xsl:for-each select="@*">
            <xsl:choose>
              <xsl:when test="namespace-uri() != 'http://schema.omg.org/spec/XMI/2.1'">
                <xsl:value-of select="' '"/>
                <xsl:value-of select="name()"/>
                <xsl:value-of select="'='"/>
                <xsl:text disable-output-escaping="yes">&quot;</xsl:text>
                <xsl:value-of select="."/>
                <xsl:text disable-output-escaping="yes">&quot;</xsl:text>
              </xsl:when>      
              <xsl:otherwise>                               
              </xsl:otherwise>                               
            </xsl:choose>   
        </xsl:for-each>       
        <xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
        <xsl:apply-templates/>
        <xsl:text disable-output-escaping="yes">&lt;/</xsl:text><xsl:value-of select="$currentElemXmiType"/><xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
        <xsl:text disable-output-escaping="yes">&lt;/</xsl:text><xsl:value-of select="$elementName"/><xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
      </xsl:when>      
      <xsl:otherwise> 
        <xsl:text disable-output-escaping="yes">&lt;</xsl:text><xsl:value-of select="name()"/>
          <xsl:for-each select="@*">
                <xsl:value-of select="' '"/>
                <xsl:value-of select="name()"/>
                <xsl:value-of select="'='"/>
                <xsl:text disable-output-escaping="yes">&quot;</xsl:text>
                <xsl:value-of select="."/>
                <xsl:text disable-output-escaping="yes">&quot;</xsl:text>
          </xsl:for-each>  
          <!-- NAMESPACE HACK - use Saxon ASAP. Xalan barfs on copy-of attributes and randomly excludes namespages -->
          <xsl:text disable-output-escaping="yes"> xmlns:ecore=&quot;http://www.eclipse.org/emf/2002/Ecore&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:MagicDrawProfile=&quot;http:///schemas/MagicDrawProfile/_U4FnkZoAEd2jetuWwvgiOQ/0&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:xmi=&quot;http://schema.omg.org/spec/XMI/2.1&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:uml=&quot;http://schema.omg.org/spec/UML/2.1.1&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:Default=&quot;http:///schemas/Default/1&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:DocumentationProfile=&quot;http:///schemas/DocumentationProfile/_r7CxYG4EEd2_24jOC3qRKg/18&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:Standard=&quot;http://www.eclipse.org/uml2/schemas/Standard/1&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:Uml2Debug=&quot;http:///schemas/Uml2Debug/_BYFEIP7yEdufa83D85EEEw/16&quot;</xsl:text>
          <xsl:text disable-output-escaping="yes"> xmlns:fUML2UML=&quot;http:///schemas/fUML2UML/_XoFiAGmEEd2B0NE0bmFUig/5&quot;</xsl:text>

          <xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
          <xsl:apply-templates/>
        <xsl:text disable-output-escaping="yes">&lt;/</xsl:text><xsl:value-of select="name()"/><xsl:text disable-output-escaping="yes">&gt;</xsl:text> 
      </xsl:otherwise>                               
    </xsl:choose>   
    

    </xsl:template>

    
</xsl:stylesheet>    
