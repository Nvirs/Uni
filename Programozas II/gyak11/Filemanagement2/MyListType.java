package Filemanagement2;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class MyListType {
    private final List<Triplet<String, Integer, Integer>> myItems = new ArrayList<>();

    public List<Triplet<String, Integer, Integer>> getMyItems() {
        return myItems;
    }
}