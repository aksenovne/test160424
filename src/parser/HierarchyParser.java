package parser;

import domain.AdmHierarchy;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utils.XmlDocument;

import java.util.ArrayList;
import java.util.List;

public class HierarchyParser {
    private static final String fileName = "AS_ADM_HIERARCHY.XML";

    public static List<AdmHierarchy> getHierarchy() {
        List<AdmHierarchy> hierarchyList = new ArrayList<>();
        Document document = XmlDocument.getDocument(fileName);
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
