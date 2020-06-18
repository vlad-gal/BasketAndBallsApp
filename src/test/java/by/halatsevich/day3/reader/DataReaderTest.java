package by.halatsevich.day3.reader;

import by.halatsevich.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;
    static final String TEST_FILE = "src/main/resources/data/balls.txt";

    @BeforeClass
    public void setUp() {
        reader = new DataReader();
    }

    @Test
    public void testReadDataSuccess() {
        try {
            List<String> actual = reader.readData(TEST_FILE);
            List<String> expected = Arrays.asList("2 0.2 1", "4 1.4          2", "                   5 0.248 4", "5 0.32 3");
            assertEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test
    public void testReadDataFailure() {
        try {
            List<String> actual = reader.readData(TEST_FILE);
            List<String> expected = Arrays.asList("2 0.2 1", "4 1.4 2", "5 0.248 4", "5 0.32 3");
            assertNotEquals(actual, expected);
        } catch (InputDataException e) {
            fail("Something goes wrong");
        }
    }

    @Test(expectedExceptions = InputDataException.class,
            expectedExceptionsMessageRegExp = "The file doesn't exist")
    public void testReadDataExceptionMessage() throws InputDataException {
        reader.readData("1");
    }
}