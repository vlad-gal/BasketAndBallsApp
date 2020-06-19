package by.halatsevich.basket.parser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataParserTest {
    DataParser parser;

    @BeforeClass
    public void setUp() throws Exception {
        parser = new DataParser();
    }

    @Test
    public void testParseAllDataSuccess() {
        List<String> actualData = Arrays.asList("2 0.2 1", "4 1.4        2");
        List<double[]> actual = parser.parseAllData(actualData);
        List<double[]> expected = Arrays.asList(new double[]{2.0, 0.2, 1.0}, new double[]{4.0, 1.4, 2.0});
        boolean condition = Arrays.deepEquals(actual.toArray(), expected.toArray());
        assertTrue(condition);
    }

    @Test
    public void testParseAllDataFailure() {
        List<String> actualData = Arrays.asList("2 0.2 1", "4 1.4        2");
        List<double[]> actual = parser.parseAllData(actualData);
        List<double[]> expected = Arrays.asList(new double[]{1.0, 0.2, 1.0}, new double[]{4.0, 1.4, 2.0});
        boolean condition = Arrays.deepEquals(actual.toArray(), expected.toArray());
        assertFalse(condition);
    }

    @Test
    public void testParseLineDataSuccess() {
        double[] actual = parser.parseLineData("0.2 4 89.");
        double[] expected = {0.2, 4.0, 89.0};
        assertEquals(actual, expected);
    }

    @Test
    public void testParseLineDataFailure() {
        double[] actual = parser.parseLineData("0.2 4 89.");
        double[] expected = {0.2, 4.0};
        assertNotEquals(actual, expected);
    }
}