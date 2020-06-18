package by.halatsevich.day3.reader;

import by.halatsevich.day3.exception.InputDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

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
