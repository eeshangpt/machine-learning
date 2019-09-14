package gupta.eeshan.data.utils;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class NumericalData {
    List data;

    public NumericalData() {
        init();
    }

    private void init() {
        this.data = new ArrayList<List<Double>>();
    }


    private static Double checkDouble(Double elem) {
        if (elem != null)
            return (Double) elem;
        return Double.MIN_VALUE;
    }

    public boolean add(List<Double> dataPoint) {
        List<Double> collect = null;
        try {
            collect = dataPoint.stream()
                    .map(NumericalData::checkDouble)
                    .collect(toList());

        } catch (ClassCastException | NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
        return data.add(collect);
    }

    public List getData() {
        return data;
    }
}
