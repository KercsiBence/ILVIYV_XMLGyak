package hu.domparse.ILVIYV;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyILVIYV {
	
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        
        File xmlFile = new File("E:\\Git\\ILVIYV_XMLGyak\\Feleves beadando\\Program\\XMLILVIYV.xml");
        File xmlOutputFile = new File("E:\\git\\ILVIYV_XMLGyak\\Feleves beadando\\Program\\XMLILVIYVModifyResult.xml");

       
        Scanner in = new Scanner(System.in);

        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        
        Document doc = dBuilder.parse(xmlFile);
        
        
        doc.getDocumentElement().normalize();

        
        NodeList nList = doc.getElementsByTagName("futár");

        for (int i = 0; i < nList.getLength(); i++) { 
            
            Node nNode = nList.item(i);

            Element elem = (Element) nNode;

            
            Node node1 = elem.getElementsByTagName("név").item(0);
            String nev = node1.getTextContent();

            
            System.out.println("A futár jelenlegi neve: " + nev);
            System.out.println("Adja meg a futár új nevét: ");
            String newname = in.next();
            node1.setTextContent(newname);
        }

        
        in.close();

        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        
        DOMSource source = new DOMSource(doc);

        
        StreamResult result = new StreamResult(xmlOutputFile);

        
        transformer.transform(source, result);
    }
}