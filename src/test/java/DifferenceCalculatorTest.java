import junit.framework.Assert;
import org.custommonkey.xmlunit.Diff;
import org.junit.Test;
import org.xml.sax.InputSource;

import java.io.IOException;

/**
 * Created by Bartha on 12/25/2014.
 */
public class DifferenceCalculatorTest {

    @Test
    public void testGetDifference() throws IOException {

        final InputSource inputSource1 = new InputSource(getClass().getResource("/testFile1.xml").openStream());
        final InputSource inputSource2 = new InputSource(getClass().getResource("/testFile2.xml").openStream());

        final DifferenceCalculator calculator = new DifferenceCalculator();
        final Diff diff = calculator.getDifference(inputSource1, inputSource2);


        Assert.assertTrue(diff.identical());
    }

    @Test
    public void testSimilar() throws IOException {

        final InputSource inputSource1 = new InputSource(getClass().getResource("/testFile1.xml").openStream());
        final InputSource inputSource2 = new InputSource(getClass().getResource("/testFile2.xml").openStream());

        final DifferenceCalculator calculator = new DifferenceCalculator();
        final Diff diff = calculator.getDifference(inputSource1, inputSource2);


        Assert.assertTrue(diff.similar());
    }

    @Test
    public void testSimilarForDiffFiles() throws IOException {

        final InputSource inputSource1 = new InputSource(getClass().getResource("/testFile1.xml").openStream());
        final InputSource inputSource2 = new InputSource(getClass().getResource("/testFile3.xml").openStream());

        final DifferenceCalculator calculator = new DifferenceCalculator();
        final Diff diff = calculator.getDifference(inputSource1, inputSource2);


        Assert.assertTrue(diff.identical());
    }
}
