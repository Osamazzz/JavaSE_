package newStart;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) throws JAXBException, SAXException {
        List<String> L = new ArrayList<>();
        L.add("a");
        L.add("b");

    }
}
