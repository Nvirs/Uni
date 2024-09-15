package Filemanagement2;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.List;
import java.util.Map;

public class MainFileReading {
    public static void main(String[] args) {
        String filePathName = "./src/main/resources/input_04.txt";
        List<Triplet<String, Integer, Integer>> dataAsTriplets = FileReading.readDataToTriplets(filePathName);

        // Display data from file (Triplet - v1)
        /*for (Triplet<String, Integer, Integer> triplet : dataAsTriplets) {
            System.out.println(triplet.getValue0() + '\t' + triplet.getValue1() + '\t' + triplet.getValue2());
        }*/

        // Display data from file (Triplet - v2)
        dataAsTriplets.stream().map(x -> x.getValue0() + '\t' + x.getValue1() + '\t' + x.getValue2()).forEach(System.out::println);

        System.out.println("=======================================");

        // Display data from file (MyListType - v3)
        MyListType dataAsTriplets2 = FileReading.readDataToTriplets2(filePathName);
        dataAsTriplets2.getMyItems().forEach(x -> System.out.println(x.getValue0() + '\t' + x.getValue1() + '\t' + x.getValue2()));

        System.out.println("=======================================");

        Map<String, Pair<Integer, Integer>> dataAsMap = FileReading.readDataToMap(filePathName);

        // Display data from file (Map - v1)
        /*for (Map.Entry<String, Pair<Integer, Integer>> entry : dataAsMap.entrySet()) {
            System.out.println(entry.getKey() + '\t' + entry.getValue().getValue0() + '\t' + entry.getValue().getValue1());
        }*/

        // Display data from file (Map - v2)
        dataAsMap.entrySet().stream()
                .map(entry -> entry.getKey() + '\t' + entry.getValue().getValue0() + '\t' + entry.getValue().getValue1())
                .forEach(System.out::println);
    }
}