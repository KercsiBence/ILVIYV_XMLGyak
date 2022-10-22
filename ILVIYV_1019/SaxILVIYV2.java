//plusz feladat old meg, hogy az adatok egymás mellé (egy sorba kerüljenek)!

package SaxILVIYV1019;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class SaxILVIYV {

	public static void main(String[] args){
		try{
			
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

			SAXParser saxParser = saxParserFactory.newSAXParser();

			SaxHandler handler = new SaxHandler();

			saxParser.parse(new File("C:\\Users\\szabo\\eclipse-workspace\\SaxILVIYV\\src\\SaxILVIYV1019\\KB_kurzusfelvetel.xml"), handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SaxHandler extends DefaultHandler {
	
	private int indent = 0;

	private String formatAttributes(Attributes attributes) {
		int attrLength = attributes.getLength();
		if(attrLength == 0) {
			return "";
		}
	StringBuilder sb = new StringBuilder(", {");
	for (int i = 0; i < attrLength; i++) {
		sb.append(attributes.getLocalName(i) + "=" + attributes.getValue(i));
		if(i < attrLength - 1) {
			sb.append(", ");
		}
	}
	sb.append("}");
	return sb.toString();
}

private void indent() {
	for (int i = 0; i < indent; i++) {
		System.out.print(" ");
	}
}

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) {
	indent++; //behúz mindent
	indent(); //start húzza be
	System.out.print(qName + formatAttributes(attributes) + " start");
}

@Override
public void endElement(String uri, String localName, String qName) {
	indent(); //end húzza be
	indent --; //behúzás csökkentése
	System.out.println(qName + " end");
}

@Override
public void characters(char ch[], int start, int length) {
	String chars = new String(ch, start, length).trim();
	if(!chars.isEmpty()) {
		indent++; //behúz mindent
		indent(); //karakter behúzás
		indent--; //behúzás csökkentése
		System.out.print(chars);
		}
	}
}