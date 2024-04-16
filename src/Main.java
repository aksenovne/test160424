import domain.Address;
import domain.AdmHierarchy;
import org.xml.sax.SAXException;
import parser.AddressFileParser;
import parser.HierarchyParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        LocalDate currentDate = LocalDate.parse("2010-01-01");
        String objectIdsString = "1422396, 1450759, 1449192, 1451562";
        String[] objectIdsArray = objectIdsString.split(",");
        List<String> objectIds = new ArrayList<>();
        for (String objectId : objectIdsArray) {
            objectIds.add(objectId.trim());
        }

        List<Address> allAddresses = AddressFileParser.getAddressList();

        System.out.println("Задача №1");

        for (Address address : allAddresses) {
            if (currentDate.isAfter(address.getStartDate()) && currentDate.isBefore(address.getEndDate())) {
                if (objectIds.contains(address.getObjectId())) {
                    System.out.println(address.getObjectId() + ": " + address.getTypeName() + " " + address.getName());
                }
            }
        }

        System.out.println("Задача №2");

        List<AdmHierarchy> hierarchy = HierarchyParser.getHierarchy();
        Map<String, String> mapHierarchy = hierarchy.stream()
                .filter(AdmHierarchy::isActive)
                .collect(Collectors.toMap(AdmHierarchy::getObjectId, AdmHierarchy::getParentObjectId));

        Map<String, Address> mapActiveAddress = allAddresses.stream()
                .filter(Address::isActiveAndActual)
                .collect(Collectors.toMap(Address::getObjectId, Function.identity()));

        allAddresses.stream()
                .filter(Address::isActiveAndActual)
                .filter(address -> address.getTypeName().equals("проезд"))
                .forEach(address -> {
                    List<String> fullAddress = new ArrayList<>();
                    buildFullAddress(fullAddress, address, mapHierarchy, mapActiveAddress);
                    System.out.println(String.join(", ", fullAddress));
                });
    }

    public static void buildFullAddress(List<String> fullAddress, Address address, Map<String, String> mapHierarchy, Map<String, Address> mapAddress) {
        String parentObjectId = mapHierarchy.get(address.getObjectId());
        if (parentObjectId != null && mapAddress.containsKey(parentObjectId)) {
            buildFullAddress(fullAddress, mapAddress.get(parentObjectId), mapHierarchy, mapAddress);
        }
        fullAddress.add(address.getTypeName() + " " + address.getName());
    }
}