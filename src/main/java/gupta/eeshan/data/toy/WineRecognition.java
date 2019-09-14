package gupta.eeshan.data.toy;

import gupta.eeshan.data.utils.DataFile2Object;
import gupta.eeshan.data.utils.NumericalData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class WineRecognition extends NumericalData {

    /**
     * Number of Instances: 178 (50 in each of three classes)
     * Number of Attributes: 13 numeric, predictive attributes and the class
     * Attribute Information:
     * class:
     * *   class_0
     * *   class_1
     * *   class_2
     * Alcohol
     * Malic acid
     * Ash
     * Alcalinity of ash
     * Magnesium
     * Total phenols
     * Flavanoids
     * Nonflavanoid phenols
     * Proanthocyanins
     * Color intensity
     * Hue
     * OD280/OD315 of diluted wines
     * Proline
     *
     * Class Distribution: class_0 (59), class_1 (71), class_2 (48)
     * Creator: R.A. Fisher
     * Donor: Michael Marshall
     * Date: July, 1988
     */
    // Path of the file where the data is stored.
    private static final String FilePath = "/home/turing/Project/java/" +
            "machine-learning/src/main/" +
            "java/resources/WineRecognition/wine.data";

    // Path of the file where description of the data is stored.
    private static final String DescriptionFilePath =
            "/home/turing/Project/java/machine-learning/" +
                    "src/main/java/resources/WineRecognition/wine.names";

    // The dilimiting character that is used to separate columns.
    private static final String Delimiter = ",";

    public WineRecognition() {
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
            Files.lines(Paths.get(WineRecognition.DescriptionFilePath),
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
                new DataFile2Object(WineRecognition.FilePath,
                        WineRecognition.Delimiter);

        data.readDataFile().forEach(str -> {
            this.createData(DataFile2Object.tokenizeLine(str));
        });
    }
}
