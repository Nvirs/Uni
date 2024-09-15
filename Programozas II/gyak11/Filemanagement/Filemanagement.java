package Filemanagement;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Filemanagement {
    // TXT fájl beolvasása és sztring tömböket tartalmazó listába tárolása (v1)
    public static List<String[]> readTxtFileToList(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // String[] tömb létrehozása, feltöltése és hozzáadása a 'dataList'-hez (v1)
            /*String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\t");
                dataList.add(data);
            }*/

            // String[] tömb létrehozása, feltöltése és hozzáadása a 'dataList'-hez (v2)
            dataList = bufferedReader.lines().map(line -> line.split("\t")).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // TXT fájl beolvasása és listákat tartalmazó listába tárolása (v2)
    public static List<List<String>> readTxtFileToList2(String filePath) {
        List<List<String>> dataList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            dataList = bufferedReader.lines().map(line -> Arrays.asList(line.split("\t"))).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // TXT fájl beolvasása és 'triplet'-eket tartalmazó listába tárolása (v3)
    public static List<Triplet<String, Integer, Integer>> readTxtFileToList3(String filePath) {
        List<Triplet<String, Integer, Integer>> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            dataList = br.lines().map(line -> {
                String[] parts = line.split("\t");
                return new Triplet<>(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }).toList();
        } catch (IOException e) {
            System.out.println("Hiba a fájl beolvasásakor.");
            e.printStackTrace();
        }
        return dataList;
    }

    // TXT fájl beolvasása és 'Map'-be tárolása (v4)
    public static Map<String, Pair<Integer, Integer>> readTxtFileToMap(String filePath) {
        Map<String, Pair<Integer, Integer>> dataMap = new LinkedHashMap<>();
        try (InputStream inputStream = Filemanagement.class.getClassLoader().getResourceAsStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            // String[] tömb létrehozása, feltöltése és hozzáadása a 'dataMap'-hez (v1)
            /*String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\t");
                String key = columns[0];
                Integer intValue = Integer.parseInt(columns[1]);
                Integer intValue2 = Integer.parseInt(columns[2]);
                dataMap.put(key, new Pair<>(intValue, intValue2));
            }*/

            // String[] tömb létrehozása, feltöltése és hozzáadása a 'dataMap'-hez (v2)
            br.lines().map(line -> line.split("\t")).forEach(columns -> {
                String key = columns[0];
                Integer keyPair = Integer.parseInt(columns[1]);
                Integer valuePair = Integer.parseInt(columns[2]);
                dataMap.put(key, new Pair<>(keyPair, valuePair));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    // TXT fájl beolvasása és saját típust ('MyListType') tartalmazó 'Set'-be tárolása (v5)
    public static Set<MyListType> readTxtFileToSet(String filePath) {
        Set<MyListType> dataSet = new LinkedHashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // String[] tömb létrehozása, feltöltése és hozzáadása a 'Set'-hez (v1)
            /*String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\t");
                dataSet.add(new MyListType(columns[0], Integer.parseInt(columns[1]), Integer.parseInt(columns[2])));
            }*/

            // String[] tömb létrehozása, feltöltése és hozzáadása a 'Set'-hez (v2)
            dataSet = br.lines().map(line -> line.split("\t"))
                    .map(columns -> new MyListType(columns[0], Integer.parseInt(columns[1]), Integer.parseInt(columns[2])))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    // TXT fájl beolvasása és saját típusba ('MyMapType') tárolása (v6)
    public static MyMapType readTxtFileToMyMapType(String filePath) {
        MyMapType dataMyMap = new MyMapType();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Add data to MyMapType (old version)
            /*String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\t");
                dataMyMap.getMyItems().put(columns[0], new Pair<>(Integer.parseInt(columns[1]), Integer.parseInt(columns[2])));
            }*/

            // Add data to MyMapType (new version)
            br.lines().map(line -> line.split("\t"))
                    .forEach(columns -> dataMyMap.getMyItems().put(
                            columns[0],
                            new Pair<>(Integer.parseInt(columns[1]), Integer.parseInt(columns[2]))
                    ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMyMap;
    }

    /* Fájlbaírás */
    /* Példa:
        * Map<String, Pair<Integer, Integer>> típusú listát kér,
        * megnézi a középső oszlop értékeit (lásd: 'input_03.txt'), és ha 150 ezernél nagyobb,
          akkor a 150 ezernél nagyobb értékkel rendelkező adatokat írja egy fájlba. */
    public static void writeDataFromMapToFile(Map<String, Pair<Integer, Integer>> dataMap, String outputFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Pair<Integer, Integer>> entry : dataMap.entrySet()) {
                if (entry.getValue().getValue0() > 150000) {
                    bufferedWriter.write(entry.getKey() + "\t" + entry.getValue().getValue0() + "\t" + entry.getValue().getValue1() + "\n");
                }
            }

            // lambda kifejezés
            /*dataMap.entrySet().stream()
                    .filter(entry -> entry.getValue().getValue0() > 150000)
                    .forEach(entry -> {
                        try {
                            bufferedWriter.write(entry.getKey() + "\t" + entry.getValue().getValue0() + "\t" + entry.getValue().getValue1() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataFromMapToFile2(Set<MyListType> dataMap, String outputFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            /*for (MyListType item : dataMap) {
                // fullname(), data1(), data2(): a record típusú osztály Getter-ei, mely automatikus létrejöttek
                if (item.data1() > 150000) {
                    bufferedWriter.write(item.fullname() + "\t" + item.data1() + "\t" + item.data2() + "\n");
                }
            }*/

            // fullname(), data1(), data2(): a record típusú osztály Getter-ei, mely automatikus létrejöttek
            dataMap.stream().filter(item -> item.data1() > 150000).forEach(item -> {
                try {
                    bufferedWriter.write(item.fullname() + "\t" + item.data1() + "\t" + item.data2() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataFromMapToFile3(MyMapType dataMap, String outputFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            /*for (var item : dataMap.getMyItems().entrySet()) {
                if (item.getValue().getValue0() > 150000) {
                    bufferedWriter.write(item.getKey() + "\t" + item.getValue().getValue0() + "\t" + item.getValue().getValue1() + "\n");
                }
            }*/

            dataMap.getMyItems().entrySet().stream().filter(item -> item.getValue().getValue0() > 150000)
                    .forEach(item -> {
                        try {
                            bufferedWriter.write(item.getKey() + "\t" + item.getValue().getValue0() + "\t" + item.getValue().getValue1() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}