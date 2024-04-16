import domain.Address;
import org.xml.sax.SAXException;
import parser.AddressFileParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        List<Address> addresses = AddressFileParser.getAddressList();

        addresses.stream().forEach(System.out::println);

    }
}