package gyak3;

import java.util.*;

public class Gyak3 {
    public static void main(String[] args){

        //Tömbök

        int[] numbers = {9,5,8,7,6};
        int[] numbers2 = new int[numbers.length];

        //Kiíratás
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers2));

        //Többdimenziós tömbök

        int[][] szamok2D = {{1,2,3}, {4,5}};

        int[][] szamok2D2 = new int[3][]; //deklaráltuk az "oszlopok" számát.
        int[] data1 = new int[3]; //deklaráltuk a "sorokat".
        int[] data2 = new int[4];
        int[] data3 = new int[5];
        szamok2D2[0] = data1;
        szamok2D2[1] = data2;
        szamok2D2[2] = data3;

        szamok2D2[0][2] = 42;

        String[][] names = {{"peter", "eve", "leslie"}, {"adam"}};

        //Számláló  for ciklus
        for(int i = 0; i < szamok2D.length; i++){
            for(int j = 0; j < szamok2D[i].length; j++){
                System.out.println(szamok2D[i][j]);
            }
        }

        // for each
        for(int[] szamok1D: szamok2D){
            for(int szam: szamok1D){
                System.out.println(szam);
            }
        }

        //Sorbarendezés
       Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        //System.out.println(Arrays.sort(numbers));

        Integer[] numbers3 = {5,6,9,8};
        Arrays.sort(numbers3, Collections.reverseOrder()); //generikus metódus
        System.out.println(Arrays.toString(numbers3));

        //Listák
        List<Integer> lottoSzamok = new ArrayList<>();

        for(int i = 1; i <= 90; i++){
            lottoSzamok.add(i);
        }
        System.out.println(lottoSzamok);

        //Lista bejárása
        for(int i = 0; i < lottoSzamok.size(); i++){
            System.out.println(lottoSzamok.get(i));
        }

        //Egysoros inicializáció

        List<String> nevek = Arrays.asList("Péter", "Anna", "Kázmér");

        //Randomizálás
//        Random rnd = new Random();
//        int nyeroszam;
//        nyeroszam = rnd.nextInt(90+1); //(max-min) + min

        List<Integer> nyeroszamok = new ArrayList<>();
        int nyeroszam;
        Random rnd = new Random();

        while(nyeroszamok.size() < 5){
            nyeroszam = rnd.nextInt(90 + 1);
            if(!nyeroszamok.contains(nyeroszam)){
                nyeroszamok.add(nyeroszam);
            }
        }
        System.out.println(nyeroszamok);

        // Számoljuk meg egy sztringben, hogy milyen karakterekből hányat tartalmaz.
        String inputText = "Hellobello világ!";
        List<Character> karakterek = new ArrayList<>();
        List<Integer> elofordulas = new ArrayList<>();

        int index;
        for(char karakter: inputText.toCharArray()){
            if(!karakterek.contains(karakter)){
                karakterek.add(karakter);
                elofordulas.add(1);
            }else{
                index = karakterek.indexOf(karakter);
                elofordulas.set(index, elofordulas.get(index)+1);
            }
        }
        System.out.println(karakterek);
        System.out.println(elofordulas);

        // Map
        Map<Character, Integer> karakterElofordulas = new HashMap<>();
        for(char karakter: inputText.toCharArray()){
            if(!karakterElofordulas.containsKey(karakter)){
                karakterElofordulas.put(karakter, 1);
            }else{
                karakterElofordulas.put(karakter, karakterElofordulas.get(karakter)+1);
            }
        }
        System.out.println(karakterElofordulas);







    }


}
