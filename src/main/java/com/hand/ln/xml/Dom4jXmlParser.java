package com.hand.ln.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Text;
import org.dom4j.VisitorSupport;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jXmlParser {

    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/main/resources/books.xml"));
        Element root = document.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> elements = root.elements("book");
        for (Element e : elements) {
            int id = Integer.valueOf(e.attribute("id").getValue());
            String name = ((Element) (e.elements("name").get(0))).getText();
            double price = Double.valueOf(((Element) (e.elements("price").get(0))).getText());
            System.out.printf("id:%d\tname:%s\tprice:%f\n", id, name, price);
        }
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("books-copy.xml"), outputFormat);
        writer.write(root);
        writer.close();
    }

}

class MyVisitor extends VisitorSupport {
    @Override
    public void visit(Element element) {
        System.out.println(element.getName());
    }

    @Override
    public void visit(Attribute attr) {
        System.out.println(attr.getName());
    }

    @Override
    public void visit(Text node) {
        System.out.println(node.getText());
    }
}
