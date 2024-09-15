package __Gyakorlat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListaVsLinkedLista {
    public static void main(String[] args) {
        /* Teljesítmény */

        // ArrayList
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long arrayListStartTime = System.currentTimeMillis();
        arrayList.add(50000, 999999); // Közepére beszúrás
        long arrayListEndTime = System.currentTimeMillis();
        System.out.println("ArrayList beszúrás ideje: " + (arrayListEndTime - arrayListStartTime) + " ms");

        // LinkedList példa
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        long linkedListStartTime = System.currentTimeMillis();
        linkedList.add(50000, 999999); // Közepére beszúrás
        long linkedListEndTime = System.currentTimeMillis();
        System.out.println("LinkedList beszúrás ideje: " + (linkedListEndTime - linkedListStartTime) + " ms");

        List<Integer> lancoltLista = new LinkedList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
    }
}