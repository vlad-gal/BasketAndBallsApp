package by.halatsevich.day3.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse string data
 *
 * @author Vladislav Halatsevich
 */
public class DataParser {
    private static final String REGEXP_DELIMITER = "\\s+";

    /**
     * Parse all data to list of double arrays
     *
     * @param dataToParse list of strings
     * @return parsed list of double arrays
     */
    public List<double[]> parseAllData(List<String> dataToParse) {
        List<double[]> parsedData = new ArrayList<>();
        for (String data : dataToParse) {
            parsedData.add(parseLineData(data));
        }
        return parsedData;
    }

    /**
     * Parse one line data to double array
     *
     * @param dataToParse string of data
     * @return array of parsed data
     */
    public double[] parseLineData(String dataToParse) {
        String[] temp = dataToParse.trim().split(REGEXP_DELIMITER);
        double[] data = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = Double.parseDouble(temp[i]);
        }
        return data;
    }
}
