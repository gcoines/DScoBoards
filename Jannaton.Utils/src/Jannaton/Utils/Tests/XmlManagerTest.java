/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Tests;

import Jannaton.Utils.Xml.XmlManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author german
 */
public class XmlManagerTest {

    /**
     * @param args the command line arguments
     */
    private Document document;
    
    private XmlManagerTest(){
        this.document = XmlManager.getInstance().loadDocument(this.getClass().getResourceAsStream("scoreboards.xml"));
    }
    
    private static XmlManagerTest getInstance(){
        return new XmlManagerTest();
    }
    
    private Document getDocument(){
        return this.document;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //TODO study if externalize this piece of code will be a better option.
            XmlManagerTest test = getInstance();
            test.testGetDocumentRoot();
            test.testGetChildElementNodes();
        } catch (Exception ex) {
            //TODO report error
            System.out.println(ex.getMessage());
        }
    }
    
    protected void testGetDocumentRoot() throws Exception{
        Node root = XmlManager.getRootElement(document);
        if (root == null){
            throw new Exception("testGetDocumentRoot() -> FAILED! NULL root");
        } else if ( !"scoreboards".equals(root.getNodeName())){
            throw new Exception("testGetDocumentRoot() -> FAILED! Root has not the expected value");
        } else {
            System.out.println("testGetDocumentRoot() -> SUCCEED!");
        }
    }
    
    protected void testGetChildElementNodes() throws Exception{
        Node root = XmlManager.getRootElement(document);
        NodeList children = XmlManager.getChildElementNodes(root);
        if(children == null){
            throw new Exception("testGetChildrenElements() -> FAILED! NULL children");
        }else if(children.getLength() != 4){
            throw new Exception("testGetChildrenElements() -> FAILED! Incorrect children number");
        }else {
            System.out.println("testGetChildrenElements() -> SUCCEED!");
        }
    }
}
