package __Gyakorlat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Listak {
    public static void main(String[] args) {
        int[] tömb = {10, 4, 6, 8, 3}; // primitív tömb
        // ArrayList
        ArrayList<Integer> lista = new ArrayList<>(); // vagy List<Integer> lista = new ArrayList<>();
        for (int elem : tömb) {
            lista.add(elem); // Az autoboxing automatikusan átalakítja az int-et Integer objektummá
        }

        // a lista legnagyobb elemének megkeresése
        Integer legnagyobb = Collections.max(lista);
        System.out.println("A lista legnagyobb eleme: " + legnagyobb);

        // a listából való törlés, majd újból megkeresni a legnagyobb elemet
        lista.remove(0);
        System.out.println(lista);
        legnagyobb = Collections.max(lista);
        System.out.println("A lista legnagyobb eleme: " + legnagyobb);

        // a lista elemének módosítása, majd újból megkeresni a legnagyobb elemet
        lista.set(1, 7);
        System.out.println(lista);
        legnagyobb = Collections.max(lista);
        System.out.println("A lista legnagyobb eleme: " + legnagyobb);

        // LinkedList
        List<Integer> láncoltLista = new LinkedList<>(); // vagy List<Integer> lista = new ArrayList<>();
        for (int elem : tömb) {
            láncoltLista.add(elem); // Az autoboxing automatikusan átalakítja az int-et Integer objektummá
        }
        legnagyobb = Collections.max(láncoltLista);
        System.out.println("A láncolt lista legnagyobb eleme: " + legnagyobb);

        // fix méretű listák, melyek nem módosíthatók
        List<Integer> fixMéretűLista = Arrays.asList(new Integer[]{1, 2, 3, 4, 5}); // vagy Arrays.asList(1, 2, 3, 4, 5)
        //fixMéretűLista.add(6); // a hozzáadás nem támogatott Arrays.asList() esetén
        //fixMéretűLista.remove(2); // a törlés nem támogatott Arrays.asList() esetén
        System.out.println("A lista mérete: " + fixMéretűLista.size());
        System.out.println("Az új lista tartalma (v1): " + fixMéretűLista);

        List<Integer> fixMéretűLista2 = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList()); // vagy .toList() (Java 8)
        System.out.println("Az új lista tartalma (v2): " + fixMéretűLista2);

        List<Integer> fixMéretűLista3 = Arrays.asList(1, 2, 3, 4, 5); // (Java 8)
        fixMéretűLista3 = Collections.unmodifiableList(fixMéretűLista3);
        System.out.println("Az új lista tartalma (v3): " + fixMéretűLista3);

        List<Integer> fixMéretűLista4 = List.of(1, 2, 3, 4, 5); // (Java 9)
        System.out.println("Az új lista tartalma (v4): " + fixMéretűLista4);

        Set<Integer> fixMéretűLista5 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)); // (Java 8)
        fixMéretűLista5 = Collections.unmodifiableSet(fixMéretűLista5); // a Set nem garantálja az elemek megfelelő sorrendjét, ahogy megadtuk
        System.out.println("Az új lista tartalma (v5): " + fixMéretűLista5);

        Set<Integer> fixMéretűLista6 = Set.of(1, 2, 3, 4, 5); // (Java 9)
        System.out.println("Az új lista tartalma (v6): " + fixMéretűLista6);

        List<Integer> fixMéretűLista7 = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        System.out.println("Az új lista tartalma (v7): " + fixMéretűLista7);

        Set<Integer> fixMéretűLista8 = new LinkedHashSet<>() {{
            for (int i = 1; i <= 5; i++) add(i);
        }};
        System.out.println("Az új lista tartalma (v8): " + fixMéretűLista8);

        System.out.println("A fixMéretűLista4 3. eleme: " + fixMéretűLista4.get(2));
        //fixMéretűLista4.set(2,8); // a fixMéretűLista4 nem módosítható lista típusú
        fixMéretűLista4 = new ArrayList<>(fixMéretűLista4); // a fixMéretűLista4 módosítható lett
        fixMéretűLista4.set(2, 8);
        System.out.println("A fixMéretűLista4 3. eleme: " + fixMéretűLista4.get(2));
        System.out.println("A fixMéretűLista4 elemei: " + fixMéretűLista4);

        List<Integer> finalFixMéretűLista = fixMéretűLista7;
        fixMéretűLista7 = new ArrayList<>() {{
            addAll(finalFixMéretűLista); // finalFixMéretűLista egy effektív final (lásd: lambda kifejezés és  névtelen osztályok)
        }};
        fixMéretűLista7.add(9);
        System.out.println("A finalFixMéretűLista elemei: " + fixMéretűLista7);
        System.out.println("A finalFixMéretűLista listában van 9-es szám? " + fixMéretűLista7.contains(9));
        System.out.println("A finalFixMéretűLista listában van 14-es szám? " + fixMéretűLista7.contains(14));

        Random rnd = new Random();
        List<Integer> rndList = new ArrayList<>();
        System.out.print("A lista elemei, melyek véletlenszámok 10 és 40 között: ");
        for (int i = 0; i < 10; i++) {
            rndList.add(rnd.nextInt(10,40));
            System.out.print(rndList.get(i) + " ");
        }
        System.out.println();
        System.out.print("A lista elemei, melyek véletlenszámok 10 és 40 között: " + rndList);
        System.out.println();
    }
}