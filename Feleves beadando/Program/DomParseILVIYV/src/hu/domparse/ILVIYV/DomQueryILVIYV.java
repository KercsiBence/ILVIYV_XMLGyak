package hu.domparse.ILVIYV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomQueryILVIYV {

	static String text="";
	public static void main(String[] args) {
		
		String expression1="//rendelés";
		XPathQuery(expression1,"Az összes rendelés");
		String expression2="//tranzakció[@id=\"2\"]";
		XPathQuery(expression2,"A rendelés aminek tranzakció ID-ja 2");
		String expression3="//tranzakció[összeg>4000]";
		XPathQuery(expression3,"A 4000-nél drágább rendelések");
		String expression4="//rendelés[státusz=\"Aktív\"]";
		XPathQuery(expression4,"Aktív státuszú rendelések");
		String expression5="//futár[név=\"Sándy\"]";
		XPathQuery(expression5,"Azok a rendelések amiket Sándy szállít ki");

		FileWriter queryResultFile;
        try
        {
        	queryResultFile = new FileWriter("E:\\Git\\ILVIYV_XMLGyak\\Feleves beadando\\Program\\QueryResult.txt");
             
            BufferedWriter queryResultWrite = new BufferedWriter(queryResultFile);
            queryResultWrite.write(text);
             
            queryResultWrite.close();
            System.out.println("Written successfully");
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }
		System.out.print(text);
		
	}
	public static void XPathQuery(String expression, String kérdés) {
		text+="\n";
		try {
			File xmlFile=new File("E:\\Git\\ILVIYV_XMLGyak\\Feleves beadando\\Program\\XMLILVIYV.xml");
			DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
			
			Document document=documentBuilder.parse(xmlFile);
			
			XPath xPath=XPathFactory.newInstance().newXPath();
			
			NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
			for(int i=0;i<nodeList.getLength();i++) {
				Node node=nodeList.item(i);
				
				if(node.getNodeType()==Node.ELEMENT_NODE && node.getNodeName().equals("rendelés"));{
					Element element=(Element) node;
					text+=kérdés+"\n";
					text+="Rendelés ID: "+element.getAttribute("id")+"\n";
					text+="--------------------------------------"+"\n";
				}
			}
		}catch(Exception e) {
			
		}
	}
}
