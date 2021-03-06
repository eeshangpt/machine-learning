package gupta.eeshan.data.toy;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class WRDTest {
    public static void main(String[] args) {
        long start, stop;
        start = System.currentTimeMillis();

        List data = new WineRecognition().getData();
        stop = System.currentTimeMillis();
        System.out.println("Time to load data\t:\t" + (stop - start) + " ms");

        start = System.currentTimeMillis();
        assertEquals(178, data.size());
        stop = System.currentTimeMillis();
        System.out.println("Time to assert correct size of dataset\t:\t"
                + (stop - start) + " ms");

        start = System.currentTimeMillis();
        data.stream().forEach(dataPoint -> {
            assertEquals(ArrayList.class, dataPoint.getClass());
        });
        stop = System.currentTimeMillis();
        System.out.println("Time to assert correct class of " +
                "each data point\t:\t" + (stop - start) + " ms");

        start = System.currentTimeMillis();
        data.stream().forEach(dataPoint -> {
            assertEquals(14, ((ArrayList) dataPoint).size());
        });
        stop = System.currentTimeMillis();
        System.out.println("Time to correct size of " +
                "each data point\t:\t" + (stop - start) + " ms");
    }
}
