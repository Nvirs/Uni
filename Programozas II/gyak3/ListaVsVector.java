package __Gyakorlat;

import java.util.Vector;

public class ListaVsVector {
    public static void main(String[] args) {
        // Eredeti lista
        //List<Integer> eredetiLista = new ArrayList<>();
        Vector<Integer> eredetiLista = new Vector<>();

        // Szálbiztos lista létrehozása (ha ArrayList-ről van szó)
        //List<Integer> szalbiztosLista = Collections.synchronizedList(eredetiLista);

        // Szálak módosítják a listát
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                eredetiLista.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                eredetiLista.add(i);
            }
        });

        // Szálak indítása
        thread1.start();
        thread2.start();

        // Várakozás a szálak befejezésére
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Szálbiztos lista kiíratása
        System.out.println("Szálbiztos lista mérete: " + eredetiLista.size());
    }
}