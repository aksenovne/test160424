import domain.Address;
import org.xml.sax.SAXException;
import parser.AddressFileParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        LocalDate currentDate = LocalDate.parse("2010-01-01");
        String objectIdsString = "1422396, 1450759, 1449192, 1451562";
        String[] objectIdsArray = objectIdsString.split(",");
        List<String> objectIds = new ArrayList<>();
        for (String objectId : objectIdsArray) {
            objectIds.add(objectId.trim());
        }

        List<Address> addresses = AddressFileParser.getAddressList();

        addresses.stream()
                .filter(address -> currentDate.isAfter(address.getStartDate()) && currentDate.isBefore(address.getEndDate()))
                .filter(address -> objectIds.contains(address.getObjectId()))
                .forEach(address -> {
                    System.out.println(address.getObjectId() + ": " + address.getTypeName() + " " + address.getName());
                });

    }
}