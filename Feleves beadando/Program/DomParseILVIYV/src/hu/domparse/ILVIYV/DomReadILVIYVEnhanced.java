package hu.domparse.ILVIYV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadILVIYVEnhanced {

	public static void main(String argv[]) throws SAXException,
    IOException, ParserConfigurationException {

		File xmlFile = new File("E:\\Git\\ILVIYV_XMLGyak\\Feleves beadando\\Program\\XMLILVIYV.xml");
		String text="";
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		NodeList vevőList = doc.getElementsByTagName("vevő");
		
		for (int i = 0; i < vevőList.getLength(); i++) {
		
		    Node vevőNode = vevőList.item(i);
		
		    if (vevőNode.getNodeType() == Node.ELEMENT_NODE) {
		    	text+="\n";
		        Element vevő = (Element) vevőNode;
		
		        String vevő_id = vevő.getAttribute("id");
		        text+="A vevő ID-ja: "+vevő_id+"\n";
		        Node név = vevő.getElementsByTagName("név").item(0);
		        String név_text = név.getTextContent();
		        text+="A vevő neve: "+név_text+"\n";
		        Node email = vevő.getElementsByTagName("email").item(0);
		        String email_text = email.getTextContent();
		        text+="A vevő email címe: "+email_text+"\n";
		        Node telefonszám = vevő.getElementsByTagName("telefonszám").item(0);
		        String telefonszám_text = telefonszám.getTextContent();
		        text+="A vevő telefonszáma: "+telefonszám_text+"\n";
		        
		        Node címNode=vevő.getElementsByTagName("cím").item(0);
		        Element cím=(Element) címNode;
		        Node irányítószám = cím.getElementsByTagName("irányítószám").item(0);
		        String irányítószám_text = irányítószám.getTextContent();
		        text+="A vevő címének irányítószáma: "+irányítószám_text+"\n";
		        Node város = cím.getElementsByTagName("város").item(0);
		        String város_text = város.getTextContent();
		        text+="A vevő városa: "+város_text+"\n";
		        Node utca = cím.getElementsByTagName("utca").item(0);
		        String utca_text = utca.getTextContent();
		        text+="A vevő utcája: "+utca_text+"\n";
		        Node házszám = cím.getElementsByTagName("házszám").item(0);
		        String házszám_text = házszám.getTextContent();
		        text+="A vevő házszáma: "+házszám_text+"\n";
		        
		        NodeList rendelésekNodeList = vevő.getElementsByTagName("rendelések");
		        Node rendelésekNode=rendelésekNodeList.item(0);
		        Element rendelésekElement=(Element) rendelésekNode;
		        NodeList rendelésNodeList=rendelésekElement.getElementsByTagName("rendelés");
		        for (int j = 0; j < rendelésNodeList.getLength(); j++) {
		        	
		        	Node rendelésNode = rendelésNodeList.item(j);
		        	Element rendelés = (Element) rendelésNode;
			        
			        String rendelés_id = rendelés.getAttribute("id");
			        text+="\tA rendelés ID-ja: "+rendelés_id+"\n";
			        Node étterem_id = rendelés.getElementsByTagName("étterem_id").item(0);
			        String étterem_id_text = étterem_id.getTextContent();
			        text+="\tA rendelés éttermének ID-ja: "+étterem_id_text+"\n";
			        Node státusz = rendelés.getElementsByTagName("státusz").item(0);
			        String státusz_text = státusz.getTextContent();
			        text+="\tA rendelés státusza: "+státusz_text+"\n";
			        Node leadási_ideje = rendelés.getElementsByTagName("leadási_ideje").item(0);
			        String leadási_ideje_text = leadási_ideje.getTextContent();
			        text+="\tA rendelés leadási ideje: "+leadási_ideje_text+"\n";
			        Node szállítási_ideje = rendelés.getElementsByTagName("szállítási_ideje").item(0);
			        String szállítási_ideje_text = szállítási_ideje.getTextContent();
			        text+="\tA rendelés szállítási ideje: "+szállítási_ideje_text+"\n";
			        
			        Node tranzakcióNode=rendelés.getElementsByTagName("tranzakció").item(0);
			        Element tranzakció=(Element) tranzakcióNode;
			        String tranzakció_id=tranzakció.getAttribute("id");
			        text+="\tA tranzakció ID-ja: "+tranzakció_id+"\n";
			        Node összeg=tranzakció.getElementsByTagName("összeg").item(0);
			        String összeg_text=összeg.getTextContent();
			        text+="\tA tranzakció összege: "+összeg_text+"\n";
			        Node kitől=tranzakció.getElementsByTagName("kitől").item(0);
			        String kitől_text=kitől.getTextContent();
			        text+="\tA tranzakció feladója: "+kitől_text+"\n";
			        Node kinek=tranzakció.getElementsByTagName("kinek").item(0);
			        String kinek_text=kinek.getTextContent();
			        text+="\tA tranzakció kedvezményezettje: "+kinek_text+"\n";
			        Node közlemény=tranzakció.getElementsByTagName("közlemény").item(0);
			        String közlemény_text=közlemény.getTextContent();
			        text+="\tA tranzakció közleménye: "+közlemény_text+"\n";
			        
			        NodeList ételekkNodeList = rendelés.getElementsByTagName("ételek");
			        Node ételekkNode=ételekkNodeList.item(0);
			        Element ételekElement=(Element) ételekkNode;
			        NodeList ételNodeList=ételekElement.getElementsByTagName("étel");
			        for (int k = 0; k < ételNodeList.getLength(); k++) {
			        	
			        	Node ételNode = ételNodeList.item(k);
			        	Element étel = (Element) ételNode;
			        	
			        	String étel_név = étel.getAttribute("név");
			        	text+="\t\tAz étel neve: "+étel_név+"\n";
				        Node ár=étel.getElementsByTagName("ár").item(0);
				        String ár_text=ár.getTextContent();
				        text+="\t\tAz étel ára: "+ár_text+"\n";
				        Node elkészítési_idő=étel.getElementsByTagName("elkészítési_idő").item(0);
				        String elkészítési_idő_text=elkészítési_idő.getTextContent();
				        text+="\t\tAz étel elkészítési ideje: "+elkészítési_idő_text+"\n";
				        Node allergének=étel.getElementsByTagName("allergének").item(0);
				        String allergének_text=allergének.getTextContent();
				        text+="\t\tAz ételben lévő allergének: "+allergének_text+"\n";
				        
				        NodeList éttermekkNodeList = étel.getElementsByTagName("éttermek");
				        Node éttermekNode=éttermekkNodeList.item(0);
				        Element éttermekElement=(Element) éttermekNode;
				        NodeList étteremNodeList=éttermekElement.getElementsByTagName("étterem");
				        for (int l = 0; l < étteremNodeList.getLength(); l++) {
				        	
				        	Node étteremNode = étteremNodeList.item(l);
				        	Element étterem = (Element) étteremNode;
				        	
				        	String étterem_own_id = étterem.getAttribute("id");
				        	if(étterem_id_text.equals(étterem_own_id)) {
					        	text+="\t\t\tAz étterem ID-ja: "+étterem_own_id+"\n";
					        	Node étterem_cim=étterem.getElementsByTagName("cím").item(0);
						        String étterem_cim_text=étterem_cim.getTextContent();
						        text+="\t\t\tAz étterem címe: "+étterem_cim_text+"\n";
					        	Node étterem_név=étterem.getElementsByTagName("név").item(0);
						        String étterem_név_text=étterem_név.getTextContent();
						        text+="\t\t\tAz étterem neve: "+étterem_név_text+"\n";
					        	Node értékelés=étterem.getElementsByTagName("értékelés").item(0);
						        String értékelés_text=értékelés.getTextContent();
						        text+="\t\t\tAz étterem értékelése: "+értékelés_text+"\n";
				        	}
				        }
			        }
			        Node futárNode=rendelés.getElementsByTagName("futár").item(0);
			        Element futár=(Element) futárNode;
			        String futár_id=futár.getAttribute("id");
			        text+="\tA futár ID-ja: "+futár_id+"\n";
		        	Node futár_név=futár.getElementsByTagName("név").item(0);
			        String futár_text=futár_név.getTextContent();
			        text+="\tA futár neve: "+futár_text+"\n";
		        	Node helyzet=futár.getElementsByTagName("helyzet").item(0);
			        String helyzet_text=helyzet.getTextContent();
			        text+="\tA futár helyzete: "+helyzet_text+"\n";
		        	Node közlekedés=futár.getElementsByTagName("közlekedés").item(0);
			        String közlekedés_text=közlekedés.getTextContent();
			        text+="\tA futár közlekedésének módja: "+közlekedés_text+"\n";
		        }

		    	text+="\n";
		    }
		    FileWriter readResultFile;
	        try
	        {
	        	readResultFile = new FileWriter("E:\\Git\\ILVIYV_XMLGyak\\Feleves beadando\\Program\\ReadEnhancedResult.txt");
	             
	            BufferedWriter readResult = new BufferedWriter(readResultFile);
	            readResult.write(text);
	             
	            readResult.close();
	            System.out.println("Written successfully");
	        }
	        catch (IOException except)
	        {
	            except.printStackTrace();
	        }
			System.out.print(text);
		    
		}
	}
	

}
