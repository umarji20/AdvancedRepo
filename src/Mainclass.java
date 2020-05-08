import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Mainclass {
	
	

	public static String  strRuleXml="";
	 HashMap<String,String> hm=new HashMap<String,String>();
	 ArrayList al  = new ArrayList();
	
    public Mainclass(String strValue) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
    	Document doc=StandardMethods.XmlParser(strRuleXml);
    	validate(doc);
	}
	private void validate(Document doc) throws XPathExpressionException {
       Element elm=doc.getDocumentElement();
       NamedNodeMap namenodemap=null;
       String StrType="";
       String strId="";
       Node nodeId=null;
       Node  nodeType=null;
       NodeList nd=StandardMethods.Nodeliist("VALIDATIONRULES/RULE", doc);
       if(nd!=null){
		for(int i=0;i<nd.getLength();i++){
			Node node=nd.item(i);
			namenodemap=node.getAttributes();
			nodeId=namenodemap.getNamedItem("ID");
			
			if(nodeId!=null){
     		 strId=nodeId.getTextContent();
			
			}
			nodeType=namenodemap.getNamedItem("TYPE");
			if(nodeType!=null){
				StrType=nodeType.getTextContent();
			}
			hm.put(strId, StrType);
			al.add(strId);
			System.out.println(hm.size()+" "+al.size()+" "+strId);
		}
       }
	}
	public void createNewXml(){
		
	}
	public static void main(String[] args) throws Exception, ParserConfigurationException {
		
		String strArg_0=args[0];
		String strArg_1=args[1];
		 if(strArg_0.equals("Validate")){
			 strRuleXml=strArg_1;
			 Mainclass mncls=new Mainclass(strRuleXml);
			 
			 
		 }

	}

}
