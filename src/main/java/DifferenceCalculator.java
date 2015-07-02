import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.examples.RecursiveElementNameAndTextQualifier;
import org.xml.sax.InputSource;

import java.io.InputStream;

/**
 * Created by Bartha on 12/25/2014.
 */

public class DifferenceCalculator {

    public Diff getDifference(InputSource xmlOne, InputSource xmlTwo) {
        Diff xmlDiff = null;
        try {
            XMLUnit.setIgnoreWhitespace(true);
            xmlDiff = new Diff(xmlOne, xmlTwo);
            xmlDiff.overrideElementQualifier(new RecursiveElementNameAndTextQualifier());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return xmlDiff;
    }
}
