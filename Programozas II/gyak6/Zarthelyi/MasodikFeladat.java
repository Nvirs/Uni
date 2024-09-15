package __Gyakorlat.Zarthelyi;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MasodikFeladat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        System.out.print("Adja meg a lista méretét: ");
        int pieceOfElement = scanner.nextInt();

        // Lista feltöltése véletlenszámokkal (v1)
        int num;
        boolean isDuplicate;
        System.out.print("A generált véletlenszámok (v1): ");
        for (int i = 0; i < pieceOfElement; i++) {
            do {
                num = rand.nextInt(10, 106);
                isDuplicate = false;
                for (int j : list) {
                    if (j == num) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            list.add(num);
            System.out.print(num + ((i < pieceOfElement - 1) ? ", " : "."));
        }
        System.out.println();
        list.clear();

        // Lista feltöltése véletlenszámokkal (v2)
        int loopIndex = 0;
        System.out.print("A generált véletlenszámok (v2): ");
        while (loopIndex < pieceOfElement) {
            num = rand.nextInt(10, 106);
            if (!list.contains(num)) list.add(num);
            System.out.print(num + ((loopIndex < pieceOfElement - 1) ? ", " : "."));
            loopIndex++;
        }

        System.out.println();
        list.clear();

        // Lista feltöltése véletlenszámokkal (v3)
        System.out.print("A generált véletlenszámok (v3): ");
        for (int i = 0; i < pieceOfElement; i++) list.add(rand.nextInt(10, 106));
        Collections.shuffle(list);
        for (Integer number : list)
            System.out.print(number + (list.indexOf(number) < pieceOfElement - 1 ? ", " : "."));
        System.out.println();

        // Lista feltöltése véletlenszámokkal (v4)
        Set<Integer> set = new HashSet<>();
        loopIndex = 0;
        System.out.print("A generált véletlenszámok (v4): ");
        do {
            int randNumbers = rand.nextInt(10, 106);
            set.add(randNumbers);
            System.out.print(randNumbers + (loopIndex < pieceOfElement - 1 ? ", " : "."));
            loopIndex++;
        } while (loopIndex < pieceOfElement);

        System.out.println();

        /* Feladatok: átlagszámítás, páros számok megtalálása, a második páratlanszám megtalálása */

        // Átlag
        int sum = 0;
        for (int i : list) sum += i;
        double average = (double) sum / list.size();
        System.out.println("Az átlag (v1): " + new DecimalFormat("#.##").format(average));

        average = list.stream().mapToInt(Integer::intValue).average().orElseThrow(); // i -> i.intValue() => Integer::intValue
        System.out.println("Az átlag (v2): " + new DecimalFormat("#.##").format(average));

        // Páros számok
        System.out.print("A páros számok (v1): ");
        for (int i : list) if (i % 2 == 0) System.out.print(i + " ");
        System.out.println();

        System.out.print("A páros számok (v2): ");
        list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Második páratlan szám megtalálása
        int count = 0;
        for (int i : list) {
            if (i % 2 != 0) {
                count++;
                if (count == 2) {
                    System.out.println("A második páratlan szám: " + i);
                    break;
                }
            }
        }
        if (count == 0) System.out.println("Nincs páratlan szám a listában.");
        else if (count == 1) System.out.println("Nincs második páratlan szám a listában.");

        int secondOdd = list.stream().filter(n -> n % 2 != 0).skip(1).findFirst().orElse(-1);
        System.out.println(secondOdd != -1 ? ("A második páratlan szám: " + secondOdd) : "Nincs második páratlan szám a listában.");
    }
}