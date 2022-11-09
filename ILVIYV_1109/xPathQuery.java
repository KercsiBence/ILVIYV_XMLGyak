package xPathILVIYV;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xPathQuery {

	public static void main(String[] args) {
		
		String expression1="/class//student";
		XPathQuery(expression1);
		String expression2="/*//student[@id=\"02\"]";
		XPathQuery(expression2);
		String expression3="/*//student";
		XPathQuery(expression3);
		String expression4="/class//student[2]";
		XPathQuery(expression4);
		String expression5="/class//student[last()]";
		XPathQuery(expression5);
		String expression6="/class//student[last()-1]";
		XPathQuery(expression6);
		String expression7="/class//student[position() >= 1 and position() < 3]";
		XPathQuery(expression7);
		String expression8="/class/*";
		XPathQuery(expression8);
		//expression9="/class/*[*=\"*\"";
		//XPathQuery(expression9);
		String expression10="/*";
		XPathQuery(expression10);
		String expression11="/class//student[kor>2]";
		XPathQuery(expression11);
		//String expression12="/class//student[]";
		//XPathQuery(expression12);
		
	}
	public static void XPathQuery(String expression) {
		System.out.println();
	try {
		File xmlFile=new File("E:\\Git\\ILVIYV_XMLGyak\\ILVIYV_1109\\studentILVIYV.xml");
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		
		Document document=documentBuilder.parse(xmlFile);
		
		XPath xPath=XPathFactory.newInstance().newXPath();
		
		NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		
		for(int i=0;i<nodeList.getLength();i++) {
			Node node=nodeList.item(i);
			System.out.println("\nAktuális elem: "+node.getNodeName());
			
			if(node.getNodeType()==Node.ELEMENT_NODE && node.getNodeName().equals("student"));{
				Element element=(Element) node;
				System.out.println("Hallgató ID: "+element.getAttribute("id"));
				System.out.println("Keresztnév: "+element.getElementsByTagName("keresztnév").item(0).getTextContent());
				System.out.println("Vezetéknév"+element.getElementsByTagName("vezetéknév").item(0).getTextContent());
				System.out.println("Becenév: "+element.getElementsByTagName("becenév").item(0).getTextContent());
				System.out.println("Kor: "+element.getElementsByTagName("kor").item(0).getTextContent());
			}
		}
	}catch(Exception e) {
		
	}
}

}
