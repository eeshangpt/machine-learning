package gupta.eeshan.data.toy.data.BHD;

import gupta.eeshan.data.toy.data.NumericalData;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BostonHousingData extends NumericalData {

    /**
     * Number of Instances:506
     * Number of Attributes:
     * 13 numeric/categorical predictive. Median Value (attribute 14) is usually the target.
     * Attribute Information (in order):
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
     * Missing Attribute Values:None
     * Creator:Harrison, D. and Rubinfeld, D.L.
     * <p>
     * It is available here.
     * https://archive.ics.uci.edu/ml/machine-learning-databases/housing/
     */

    private List<List<Double>> data;
    private static final String DATA_PATH = "/home/turing/Project/java/" +
            "machine-learning/src/main/java/resources/BostonHousingData" +
            "/housing.data";

    public BostonHousingData() {
        super();
    }

    public static String getDataPath() {
        return DATA_PATH;
    }

    /**
     * Getter of the BOSTON HOUSING DATA.
     *
     * @return data
     */
    public List<List<Double>> getData() {
        return this.data;
    }

    /**
     * This method appends the dataPoint at the end of the {@link List}.
     *
     * @param dataPoint, a {@link List} of {@link Double}s that represent
     *                   a data point from a data set.
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean add(List<Double> dataPoint) {
        return super.add(dataPoint.stream().map(elem -> (Object) elem).collect(toList()));
    }
}
