package Filemanagement;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.*;

public class MainFileManagement {
    public static void main(String[] args) {
        String filepath = "./src/main/resources/";
        String filename = "input_03.txt";

        // Read text file to List (version 1 - old version)
        System.out.println("\nRead text file to List (version 1 - old version)");
        System.out.println("================================================");
        List<String[]> dataList = Filemanagement.readTxtFileToList(filepath + filename);
        for (String[] data : dataList) {
            for (String value : data)
                System.out.print(value + '\t');
            System.out.println();
        }

        // Read text file to List (version 1 - new version)
        System.out.println("\nRead text file to List (version 1 - new version)");
        System.out.println("================================================");
        dataList.forEach(data -> {
            Arrays.stream(data).forEach(value -> System.out.print(value + '\t'));
            System.out.println();
        });

        // Read text file to List (version 2)
        System.out.println("\nRead text file to List (version 2)");
        System.out.println("==================================");
        List<List<String>> dataList2 = Filemanagement.readTxtFileToList2(filepath + filename);
        dataList2.forEach(row -> {
            row.forEach(value -> System.out.print(value + '\t'));
            System.out.println();
        });

        // Read text file to List (version 3)
        System.out.println("\nRead text file to List (version 3)");
        System.out.println("==================================");
        List<Triplet<String, Integer, Integer>> data = Filemanagement.readTxtFileToList3(filepath + filename);
        // Adatok kiíratása
        data.forEach(row -> {
            row.forEach(value -> System.out.print(value + "\t"));
            System.out.println();
        });

        // Read text file to Map (version 4)
        System.out.println("\nRead text file to Map (version 4) - Printing version 1");
        System.out.println("======================================================");
        Map<String, Pair<Integer, Integer>> dataMap = Filemanagement.readTxtFileToMap(filename);
        dataMap.entrySet().stream()
                .map(entry -> entry.getKey() + '\t' + entry.getValue().getValue0() + '\t' + entry.getValue().getValue1())
                .forEach(System.out::println);

        System.out.println("\nRead text file to Map (version 4) - Printing version 2");
        System.out.println("======================================================");
        dataMap.forEach((key, pair) -> System.out.println(key + '\t' + pair.getValue0() + '\t' + pair.getValue1()));

        // Read text file to 'MyListType' typed Set (version 5)
        System.out.println("\nRead text file to 'MyListType' type Set (version 5)");
        System.out.println("======================================================");
        Set<MyListType> dataSet = Filemanagement.readTxtFileToSet(filepath + filename);
        dataSet.forEach(item -> System.out.println(item.fullname() + "\t" + item.data1() + "\t" + item.data2()));

        // Read text file to 'MyMapType' typed Object (version 6)
        System.out.println("\nRead text file to 'MyMapType' type Object (version 6)");
        System.out.println("======================================================");
        MyMapType dataMyMap = Filemanagement.readTxtFileToMyMapType(filepath + filename);
        dataMyMap.getMyItems().forEach((k, v) -> System.out.println(k + "\t" + v.getValue0() + "\t" + v.getValue1()));

        System.out.println("\nFind the largest Key of Pair, and display the name associated with the largest value");
        System.out.println("====================================================================================");
        // Find the largest Key of Pair, and display the name associated with the largest value (version 1)
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Pair<Integer, Integer>> entry : dataMap.entrySet()) {
            int currentKey = entry.getValue().getValue0();
            if (currentKey > maxValue) {
                maxValue = currentKey;
                maxKey = entry.getKey();
            }
        }

        if (maxKey != null)
            System.out.println("Version 1 => Maximum value of Key Pair: " + maxValue + " (Key of Map: '" + maxKey + "').");

        // Find the largest Key of Pair, and display the name associated with the largest value (version 2)
        Optional<Map.Entry<String, Pair<Integer, Integer>>> maxEntry = dataMap.entrySet()
                .stream().max(Comparator.comparingInt(entry -> entry.getValue().getValue0()));
        maxEntry.ifPresent(entry ->
                System.out.println("Version 2 => Maximum value of Key Pair: " + entry.getValue().getValue0() +
                        " (Key of Map: '" + entry.getKey() + "')."));

        // Display Keys of Map that have below average value of Pair
        System.out.println("\nDisplay Keys of Map that have below average value of Pair");
        System.out.println("=========================================================");
        double averageValueOfPair = dataMap.values().stream().mapToDouble(Pair::getValue1).average().orElse(0.0);
        List<String> belowAverageKeys = dataMap.entrySet().stream()
                .filter(entry -> entry.getValue().getValue1() < averageValueOfPair).map(Map.Entry::getKey).toList();
        System.out.print("Keys of Map that have below average value of Pair (version 1): ");
        belowAverageKeys.forEach(key -> {
            int index = belowAverageKeys.indexOf(key);
            System.out.print(key + ((index < belowAverageKeys.size() - 1) ? ", " : "."));
        });
        System.out.print("\nKeys of Map that have below average value of Pair (version 2): ");
        System.out.println(String.join(", ", belowAverageKeys) + ".");

        // Fájlbaírás
        Filemanagement.writeDataFromMapToFile(dataMap, filepath + "output_03_1.txt");
        Filemanagement.writeDataFromMapToFile2(dataSet, filepath + "output_03_2.txt");
        Filemanagement.writeDataFromMapToFile3(dataMyMap, filepath + "output_03_3.txt");
    }
}