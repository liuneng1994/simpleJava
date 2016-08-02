package com.hand.ln.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class XmlWriter {

    public static void main(String[] args) throws ParserConfigurationException, IOException {
        Map<String, String> map = System.getenv();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("envirements");
        for (String name : map.keySet()) {
            Element env = document.createElement("env");
            Attr nameAttr = document.createAttribute("name");
            nameAttr.setValue(name);
            Attr valueAttr = document.createAttribute("value");
            valueAttr.setValue(map.get(name));
            env.setAttributeNode(nameAttr);
            env.setAttributeNode(valueAttr);
            root.appendChild(env);
        }
        document.appendChild(root);
        OutputFormat of = new OutputFormat(document);
        of.setIndent(4);
        FileOutputStream file = new FileOutputStream("src/main/resources/envirements.xml");
        XMLSerializer xmlSerializer = new XMLSerializer(file, of);
        xmlSerializer.serialize(document);

    }

}
