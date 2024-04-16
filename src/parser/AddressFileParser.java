package parser;

import domain.Address;
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

public class AddressFileParser {
    private static final String fileName = "AS_ADDR_OBJ.XML";

    public static List<Address> getAddressList() throws ParserConfigurationException, IOException, SAXException {
        List<Address> addressList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileName);

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
}
