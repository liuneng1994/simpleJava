package com.hand.ln.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlResolver {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document = builder.parse(XmlResolver.class.getClassLoader().getResourceAsStream("books.xml"));
        Element books = document.getDocumentElement();
        NodeList nodes = books.getElementsByTagName("book");
        for (int i = 0; i < nodes.getLength(); i++) {
            int id = 0;
            String name = "";
            double price = 0;
            Element node = (Element) nodes.item(i);
            id = Integer.valueOf(node.getAttribute("id"));
            name = node.getElementsByTagName("name").item(0).getTextContent();
            price = Double.valueOf(node.getElementsByTagName("price").item(0).getTextContent());
            System.out.printf("id=%04d, name=%s, price=%.2f\n", id, name, price);
        }
    }

}
