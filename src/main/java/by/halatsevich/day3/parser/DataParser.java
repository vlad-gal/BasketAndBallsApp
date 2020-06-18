package by.halatsevich.day3.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String REGEXP_DELIMITER = "\\s+";

    public List<double[]> parseAllData(List<String> dataToParse) {
        List<double[]> parsedData = new ArrayList<>();
        for (String data : dataToParse) {
            parsedData.add(parseLineData(data));
        }
        return parsedData;
    }

    public double[] parseLineData(String dataToParse) {
        String[] temp = dataToParse.trim().split(REGEXP_DELIMITER);
        double[] data = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = Double.parseDouble(temp[i]);
        }
        return data;
    }
}
