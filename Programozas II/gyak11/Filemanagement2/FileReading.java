package Filemanagement2;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileReading {
    public static List<Triplet<String, Integer, Integer>> readDataToTriplets(String fileName) {
        List<Triplet<String, Integer, Integer>> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null)
                data.add(new Triplet<>(line, Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static MyListType readDataToTriplets2(String fileName) {
        MyListType data = new MyListType();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null)
                data.getMyItems().add(new Triplet<>(line, Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static Map<String, Pair<Integer, Integer>> readDataToMap(String fileName) {
        Map<String, Pair<Integer, Integer>> data = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null)
                data.put(line, new Pair<>(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}