package gupta.eeshan.data.toy;

import gupta.eeshan.data.utils.DataFile2Object;
import gupta.eeshan.data.utils.NumericalData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BostonHousing extends NumericalData {

    /**
     * Number of Instances : 506
     * Number of Attributes:
     * <p>
     * 13 numeric/categorical predictive. Median Value (attribute 14) is usually the target.
     * <p>
     * Attribute Information (in order):
     * <p>
     * CRIM per capita crime rate by town
     * ZN proportion of residential land zoned for lots over 25,000 sq.ft.
     * INDUS proportion of non-retail business acres per town
     * CHAS Charles River dummy variable (= 1 if tract bounds river; 0 otherwise)
     * NOX nitric oxides concentration (parts per 10 million)
     * RM average number of rooms per dwelling
     * AGE proportion of owner-occupied units built prior to 1940
     * DIS weighted distances to five Boston employment centres
     * RAD index of accessibility to radial highways
     * TAX full-value property-tax rate per $10,000
     * PTRATIO pupil-teacher ratio by town
     * B 1000(Bk - 0.63)^2 where Bk is the proportion of blacks by town
     * LSTAT % lower status of the population
     * MEDV Median value of owner-occupied homes in $1000’s
     * <p>
     * Missing Attribute Values : None
     * <p>
     * Creator : Harrison, D. and Rubinfeld, D.L.
     * <p>
     * It is available here.
     * https://archive.ics.uci.edu/ml/machine-learning-databases/housing/
     */

    // Path of the file where the data is stored.
    private static final String FilePath = "/home/turing/Project/java/" +
            "machine-learning/src/main/java/resources/BostonHousing/housing.data";

    // Path of the file where description of the data is stored.
    private static final String DescriptionFilePath =
            "/home/turing/Project/java/machine-learning/src/main/java" +
                    "/resources/BostonHousing/housing.names";

    // The dilimiting character that is used to separate columns.
    private static final String Delimiter = " ";

    public BostonHousing() {
        super();
    }

    /**
     * Getter of the BOSTON HOUSING DATA.
     *
     * @return data
     */
    public List getData() {
        this.objectifyFile();
        return super.getData();
    }

    /**
     * This method prints the description of the data.
     * */
    public static void printDescription() {
        try {
            Files.lines(Paths.get(BostonHousing.DescriptionFilePath),
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
     * This method reads in file at BostonHousing.FilePath and then
     * creates a {@link List} of Lists. Each sub-list is a List<Double>.
     */
    private void objectifyFile() {
        DataFile2Object data =
                new DataFile2Object(BostonHousing.FilePath,
                        BostonHousing.Delimiter);

        data.readDataFile().forEach(str -> {
            this.createData(DataFile2Object.tokenizeLine(str));
        });
    }
}
