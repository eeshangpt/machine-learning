package gupta.eeshan.data.toy.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class NumericalData {// extends Data {
//    private final
    List<List<Double>> data;

    public NumericalData() {
        super();
        data = new ArrayList();
    }

    public boolean add(List<Object> dataPoint) {
        List<Double> collect = null;
        try {
            collect = dataPoint.stream()
                    .map(elem -> {
                        if (elem instanceof Double || elem instanceof Integer)
                            return (Double) elem;
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(toList());
        } catch (ClassCastException ex) {

        }
        return data.add(collect);
    }
}
