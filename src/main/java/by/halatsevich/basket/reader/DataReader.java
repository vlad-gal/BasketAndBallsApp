package by.halatsevich.basket.reader;

import by.halatsevich.basket.exception.InputDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Data reader from file
 *
 * @author Vladislav Halatsevich
 */
public class DataReader {

    /**
     * Read all data from file
     *
     * @param filePath path to exist file
     * @return list of strings
     * @throws InputDataException if filePath is directory or file doesn't exist
     */
    public List<String> readData(String filePath) throws InputDataException {
        Path path = Paths.get(filePath);
        if (Files.isDirectory(path) || !Files.exists(path)) {
            throw new InputDataException("The file doesn't exist");
        }
        List<String> data;
        try {
            data = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file", e);
        }
        return data;
    }
}
