package gupta.eeshan.data.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class DataFile2Object {
    /**
     * This class reads a data file `fileName` that is separated by a
     * `delimiter` and converts it into a list of lists.
     * Each list consist of a data point in Double format.
     */

    private static String fileName, delimiter;

    public DataFile2Object(String fileName, String delimiter) {
        setFileName(fileName);
        setDelimiter(delimiter);
    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        DataFile2Object.fileName = fileName;
    }

    public String getDelimiter() {
        return delimiter;
    }

    private void setDelimiter(String delimiter) {
        DataFile2Object.delimiter = delimiter;
    }

    public static List<Double> tokenizeLine(Object str) {
        List<Double> dataPoint = null;
        try {
            if (str instanceof String) {
                dataPoint = Stream.of(((String) str).split(DataFile2Object.delimiter))
                        .map(String::new)
                        .filter(elem -> !elem.isEmpty() || !elem.isBlank())
                        .map(Double::parseDouble)
                        .collect(toList());
            } else {
                throw new Exception("String are not read properly. Please " +
                        "check the file.");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return dataPoint;
    }

    public Stream<String> readDataFile() {
        Stream<String> stringStream = null;
        try {
            stringStream =
                    Files.lines(Paths.get(this.getFileName()), UTF_8);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return stringStream;
    }
}
