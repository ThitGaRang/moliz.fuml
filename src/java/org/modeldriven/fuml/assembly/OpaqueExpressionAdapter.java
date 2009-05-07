/*
 * Copyright 2008 Lockheed Martin Corporation, except as stated in the file 
 * entitled Licensing-Information. All modifications copyright 2009 Data Access Technologies, Inc. Licensed under the Academic Free License 
 * version 3.0 (http://www.opensource.org/licenses/afl-3.0.php), except as stated 
 * in the file entitled Licensing-Information. 
 *
 * Contributors:
 *   MDS - initial API and implementation
 *
 */
package org.modeldriven.fuml.assembly;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modeldriven.fuml.xmi.XmiNode;
import org.modeldriven.fuml.xmi.stream.StreamNode;

import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.LiteralBoolean;
import fUML.Syntax.Classes.Kernel.LiteralInteger;
import fUML.Syntax.Classes.Kernel.LiteralString;
import fUML.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import fUML.Syntax.Classes.Kernel.UnlimitedNatural;

public class OpaqueExpressionAdapter implements AssemblyAdapter {
    
    private static Log log = LogFactory.getLog(OpaqueExpressionAdapter.class);

    public Element assemble(StreamNode opaqueExpressionNode) {
        LiteralString literal = new LiteralString();
        
        XmiNode bodyNode = opaqueExpressionNode.findChildByName("body");
        
        String bodyContent = null;
        
        if (bodyNode != null)
        {    
            bodyContent = bodyNode.getData();
        }
        else
        {
            Attribute bodyAttrib = opaqueExpressionNode.getAttribute("body");
            if (bodyAttrib != null)
                bodyContent = bodyAttrib.getValue();
        }
        if (bodyContent != null)
        {    
            bodyContent = bodyContent.trim();
            if (bodyContent.startsWith("\"") && bodyContent.endsWith("\""))
            {
                bodyContent = bodyContent.substring(1, bodyContent.length()-1); 
                literal.setValue(bodyContent);
                return literal; // yup must be a string, no need to run the below, ahhhem, logic. 
            }
        }    
        literal.setValue(bodyContent);
        
        if ("true".equalsIgnoreCase(bodyContent) || "false".equalsIgnoreCase(bodyContent))
        {
            LiteralBoolean literalBoolean = new LiteralBoolean();
            literalBoolean.setValue(Boolean.valueOf(bodyContent).booleanValue()); 
            return literalBoolean;            
        }
        else if ("*".equals(bodyContent))
        {
            LiteralUnlimitedNatural literalUnlimitedNatural = new LiteralUnlimitedNatural();
            UnlimitedNatural value = new UnlimitedNatural();
            value.naturalValue = -1;
            literalUnlimitedNatural.setValue(value); 
            return literalUnlimitedNatural;            
        }
        else
        {    
            String type = findResultPinType(opaqueExpressionNode);            
            if ("UnlimitedNatural".equals(type))
            {
                int intValue = 0;
                try {
                    intValue = Integer.valueOf(bodyContent).intValue();
                }
                catch (NumberFormatException e) {
                    log.warn("could not parse content as unlimited-natural integer '"
                            + bodyContent + "'");
                }
                LiteralUnlimitedNatural literalUnlimitedNatural = new LiteralUnlimitedNatural();
                UnlimitedNatural value = new UnlimitedNatural();
                value.naturalValue = intValue;
                literalUnlimitedNatural.setValue(value); 
                return literalUnlimitedNatural;            
            }
            try {
                if (log.isDebugEnabled())
                    log.debug("parsing expression: '" + bodyContent + "'");
                LiteralInteger literalInt = new LiteralInteger();
                literalInt.setValue(Integer.valueOf(bodyContent).intValue()); 
                return literalInt;
            }
            catch (NumberFormatException e) {
                if (log.isDebugEnabled())
                    log.debug("invalid number format: " + e.getMessage());
                literal.setValue(bodyContent);
            }
        }
        
        return literal;
    }

    private String findResultPinType(StreamNode opaqueExpressionNode)
    {
        String result = null;
        StreamNode parent = (StreamNode)opaqueExpressionNode.getParent();
        if (parent == null)
        {
            log.warn("expected parent node");
            return null;
        }
        
        StreamNode resultNode = (StreamNode)parent.findChildByName("result");
        if (resultNode != null)
        {
            StreamNode typeNode = (StreamNode)resultNode.findChildByName("type");
            if (typeNode != null)
            {
                QName name = new QName("href");
                String href = typeNode.getAttributeValue(name);
                if (href != null)
                {    
                    // FIXME; gotta be a better way! URI resolver?? SOMETHING!
                    if (href.endsWith("Integer"))
                        result = "Integer";
                    else if (href.endsWith("String"))
                        result = "String";
                    else if (href.endsWith("Boolean"))
                        result = "Boolean";
                    else if (href.endsWith("UnlimitedNatural"))
                        result = "UnlimitedNatural";
                }
            }
        }
        return result;
    }
}
