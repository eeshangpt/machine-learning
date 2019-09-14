package gupta.eeshan.data.toy;

import gupta.eeshan.data.utils.DataFile2Object;
import gupta.eeshan.data.utils.NumericalData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Diabetes extends NumericalData {

    // Path of the file where the data is stored.
    private static final String FilePath = "/home/turing/Project/java/" +
            "machine-learning/src/main/java/resources/Diabetes/diabetes.data";

    // Path of the file where description of the data is stored.
    private static final String DescriptionFilePath =
            "/home/turing/Project/java/machine-learning/" +
                    "src/main/java/resources/Diabetes/diabetes.names";

    // The dilimiting character that is used to separate columns.
    private static final String Delimiter = "\t";

    public Diabetes() {
        super();
    }

    /**
     * Getter of the WINE RECOGNITION DATA.
     *
     * @return data
     */
    public List getData() {
        this.objectifyFile();
        return super.getData();
    }

    /**
     * This method prints the description of the data.
     */
    public static void printDescription() {
        try {
            Files.lines(Paths.get(Diabetes.DescriptionFilePath),
                    UTF_8).forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * This method appends the dataPoint at the end of the {@link List}.
     *
     * @param dataPoint, a {@link List} of {@link Double}s that represent
     *                   a data point from a data set.
     */
    private void createData(List<Double> dataPoint) {
        super.add(dataPoint);
    }

    /**
     * This method reads in file at FilePath and then
     * creates a {@link List} of Lists. Each sub-list is a List<Double>.
     */
    private void objectifyFile() {
        DataFile2Object data =
                new DataFile2Object(Diabetes.FilePath,
                        Diabetes.Delimiter);

        data.readDataFile().forEach(str -> {
            this.createData(DataFile2Object.tokenizeLine(str));
        });
    }
}
