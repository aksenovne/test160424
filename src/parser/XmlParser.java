package parser;

import domain.Address;
import domain.AdmHierarchy;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    private final DocumentBuilderFactory factory;
    private final DocumentBuilder builder;

    public XmlParser() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    public List<Address> getAddressList() throws IOException, SAXException {
        List<Address> addressList = new ArrayList<>();
        Document document = builder.parse("AS_ADDR_OBJ.XML");
        NodeList nodeList = document.getElementsByTagName("OBJECT");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            NamedNodeMap attributes = node.getAttributes();
            Address address = new Address();
            address.setObjectId(attributes.getNamedItem("OBJECTID").getNodeValue());
            address.setName(attributes.getNamedItem("NAME").getNodeValue());
            address.setTypeName(attributes.getNamedItem("TYPENAME").getNodeValue());
            address.setStartDate(attributes.getNamedItem("STARTDATE").getNodeValue());
            address.setEndDate(attributes.getNamedItem("ENDDATE").getNodeValue());
            address.setIsActual(attributes.getNamedItem("ISACTUAL").getNodeValue());
            address.setIsActive(attributes.getNamedItem("ISACTIVE").getNodeValue());
            addressList.add(address);
        }
        return addressList;
    }

    public List<AdmHierarchy> getHierarchy() throws IOException, SAXException {
        List<AdmHierarchy> hierarchyList = new ArrayList<>();
        Document document = builder.parse("AS_ADM_HIERARCHY.XML");
        NodeList nodeList = document.getElementsByTagName("ITEM");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            NamedNodeMap attributes = node.getAttributes();
            AdmHierarchy admHierarchy = new AdmHierarchy();
            admHierarchy.setObjectId(attributes.getNamedItem("OBJECTID").getNodeValue());
            admHierarchy.setParentObjectId(attributes.getNamedItem("PARENTOBJID").getNodeValue());
            admHierarchy.setStartDate(attributes.getNamedItem("STARTDATE").getNodeValue());
            admHierarchy.setEndDate(attributes.getNamedItem("ENDDATE").getNodeValue());
            admHierarchy.setIsActive(attributes.getNamedItem("ISACTIVE").getNodeValue());
            hierarchyList.add(admHierarchy);
        }
        return hierarchyList;
    }
}
