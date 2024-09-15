package Filemanagement;

import org.javatuples.Pair;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyMapType {
    private final Map<String, Pair<Integer, Integer>> myItems = new LinkedHashMap<>();

    public Map<String, Pair<Integer, Integer>> getMyItems() {
        return myItems;
    }
}