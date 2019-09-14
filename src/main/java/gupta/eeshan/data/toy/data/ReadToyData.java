package gupta.eeshan.data.toy.data;

import gupta.eeshan.data.toy.data.BHD.BostonHousingData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class ReadToyData {
    /**
     * This class reads a data file that is separated by a <space>
     * delimiter and converts it into a list of lists.
     * Each list consist of a data point in Double format.
     */
    private static final String TOY_DATA = "/home/turing/Project/java/" +
            "machine-learning/src/main/java/resources/";
    static BostonHousingData bhd = new BostonHousingData();
    private String fileName;

    public ReadToyData(String fileName) {
        init(fileName);
    }

    private void init(String fileName) {
        this.fileName = fileName;
    }

    public static String getToyData() {
        return TOY_DATA;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static void test(Object str) {
        if (str instanceof String) {
            List<Double> dataPoint = Stream.of(((String) str).split(" "))
                    .map(String::new)
                    .filter(elem -> !elem.isEmpty() || !elem.isBlank())
                    .map(Double::parseDouble)
                    .collect(toList());
            bhd.add(dataPoint);
        }
    }

    public static void main(String[] args) {

        ReadToyData data = new ReadToyData(BostonHousingData.getDataPath());

        List<String> map = new ArrayList<>();

        try {
            Files.lines(Paths.get(data.getFileName()), UTF_8)
                    .forEach(ReadToyData::test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("THAT'S ALL FOLKS !!!");
    }
}
