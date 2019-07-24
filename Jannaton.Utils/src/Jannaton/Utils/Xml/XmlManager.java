/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Xml;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author german
 */
public class XmlManager {

    private static XmlManager instance;
    private DocumentBuilderFactoryImpl dcFact;

    private XmlManager() {
        dcFact = new DocumentBuilderFactoryImpl();
    }

    public static XmlManager getInstance() {
        if (instance == null) {
            instance = new XmlManager();
        }

        return instance;
    }

    private DocumentBuilder getDocumentBuilder() {
        try {
            return dcFact.newDocumentBuilder();
        } catch (Exception ex) {
            //TODO report error
            return null;
        }

    }

    public Document loadDocument(URI pathFile) {

        try {
            DocumentBuilder builder = getDocumentBuilder();

            File file = new File(pathFile);

            return builder.parse(file);
        } catch (Exception ex) {
            //TODO report eception
            return null;
        }
    }

    public Document loadDocument(InputStream input) {

        try {
            DocumentBuilder builder = getDocumentBuilder();

            return builder.parse(input);
        } catch (Exception ex) {
            //TODO report eception
            return null;
        }
    }

    public static Node getRootElement(Document document) {
        Node root = null;
        if (document != null) {
            Node first = document.getFirstChild();
            while (!isElementType(first)) {
                first = first.getNextSibling();
            }
            root = first;
        }

        return root;
    }

    public static NodeList getChildNodes(Node node) {
        return node.getChildNodes();
    }

    public static NodeList getChildElementNodes(Node node) {
        NodeList children = getChildNodes(node);
        Node auxiliar = node.cloneNode(false);

        if (children != null) {
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (isElementType(child)) {
                    auxiliar.appendChild(child);
                }
            }
            NodeList auxChildren = auxiliar.getChildNodes();
            if(auxChildren.getLength() > 0){
                children = auxChildren;
            }
        }

        return children;
    }

    public static NamedNodeMap getAttributes(Node node) {
        return node.getAttributes();
    }

    public static String getNodeValue(Node node) {
        return node.getNodeValue();
    }

    public static Node getAttributeByName(Node ownerNode, String attributeName) {
        NamedNodeMap attributes = getAttributes(ownerNode);
        if ((attributes) != null) {
            return attributes.getNamedItem(attributeName);
        }
        return null;
    }

    public static String getAttributeByNameValue(Node ownerNode, String attributeName) {
        Node attribute = getAttributeByName(ownerNode, attributeName);
        if (attribute != null) {
            return getNodeValue(attribute);
        }
        return null;
    }

    //TODO implement the rest of cases 
    //Types checking
    public static boolean isElementType(Node node) {
        return (node != null && node.getNodeType() == Node.ELEMENT_NODE);
    }
}
