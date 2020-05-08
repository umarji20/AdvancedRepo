import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class StandardMethods {
	
	// findout Nodelist using xpath
	
	public static NodeList Nodeliist(String xpath,Document doc) throws XPathExpressionException{
	    NodeList nl=null;
		XPathFactory xe=XPathFactory.newInstance();
	    XPath xp =xe.newXPath();
	   XPathExpression xpe=xp.compile(xpath);
	   nl=(NodeList) xpe.evaluate(doc, XPathConstants.NODESET);
	   return nl;
	   
	}
	
	//parse xml file usinng DOMParser
	
	public static Document XmlParser(String strXmlPath) throws SAXException, IOException, ParserConfigurationException{
		
		DocumentBuilderFactory df =DocumentBuilderFactory.newInstance() ;
		DocumentBuilder db=df.newDocumentBuilder();
		Document doc =db.parse(strXmlPath);
		return doc;
			
	}	
	
	public boolean FileExistnce(String StrPath){
		if(StrPath!=null){
			File file= new File(StrPath);
			
		}
		return false;
		
		
		
	}

}
