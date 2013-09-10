package fr.treeptik.initjava.exercice.fichierxml;

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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FichierXmlDom {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws XPathExpressionException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException,
			IOException, XPathExpressionException {
		// DOM permet de récuperer une balise precise du xml
		File file = new File("personnages.xml");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document doc = builder.parse(file);
		Element element = doc.getDocumentElement();

		XPath newXPath = XPathFactory.newInstance().newXPath();

		// pour avoir le type du premier personnage
		String evaluate = newXPath.evaluate("/listPerso/personnage/type", element);
		System.out.println(evaluate);

		// Pour avoir tous les noeud en dessous de personnage
		XPathExpression xPathExpression = newXPath.compile("//personnage");
		NodeList list = (NodeList) xPathExpression.evaluate(element, XPathConstants.NODESET);
		System.out.println(list.getLength());
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);			
			System.out.println(node.getTextContent());
		}

		// Pour avoir tous les noeud en dessous de personnage qui on un type M
		xPathExpression = newXPath.compile("//personnage [type='M']");
		list = (NodeList) xPathExpression.evaluate(element, XPathConstants.NODESET);
		System.out.println(list.getLength());
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			System.out.println(node.getTextContent());
		}
		
		// Pour avoir tous le nbVie des personnage qui on un type M
		xPathExpression = newXPath.compile("//personnage [type='M']/nbVie");
		list = (NodeList) xPathExpression.evaluate(element, XPathConstants.NODESET);
		System.out.println(list.getLength());
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			System.out.println(node.getTextContent());
		}

	}

}
