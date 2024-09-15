package gyak4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gyak4 {

    public static void main(String[] args){

        //Függvények, metódusok

        // 1. Írjunk egy fgv.-t ami eldönti egy sztringről, hogy palindrom-e.
        String inputText = "A cápa ette apáca";
        palindrom(inputText);

        //2. Rekurzív metódusok: faktoriális és n. Fibonacci szám kiszámítására

        System.out.println(factor(5));
        int fib = fibonacci(10);
        System.out.println(fib);

        //3. Anagramma kereső
        //A találatokat adjuk vissza egy listában.

        String word = "baba";
        String[] szavak = {"abba", "aabb", "bbaa", "abab", "alma", "kecskebéka", "baracklekvár"};

        System.out.println(findAnagrams(word, szavak));
        List<String> anagrammak = findAnagrams(word, szavak);
        System.out.println(anagrammak);

        //4. Átváltás tizes számrendszerből hármasba

        System.out.println(decimalToBase3(90));

        // 5. Átváltás tizesből bármibe (2-9)

        System.out.println(decimalToBaseX(90,9));

    } //--------------------------------------------------------

    // Metódusok
    // 1. Palindrom
    public static void palindrom(String inputText){
        String convertedText = inputText.toLowerCase().replace(" ", "");
        char[] textArray = convertedText.toCharArray();
        int meret = convertedText.length();
        int counter = 0;

        for(int i = 0; i< meret; i++){
            if(textArray[i] == textArray[meret -(i+1)]){
                counter++;
            }
        }
        if(meret == counter){
            System.out.println("Palindrom");
        }else{
            System.out.println("Nem palindrom");
        }
    }

    // 2. faktoriális metódusok
    // Factoriális

    public static int factor(int n){
        if(n <= 1){
            return n;
        }else{
            return n * factor(n-1);
        }
    }

    //Fibonacci szám

    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }else{
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }

    //3. Anagramma kereső

    public static List<String> findAnagrams(String word, String[] szavak){
        //sorba rendezett szó előállítása:
        char[] wordCharacters = word.toCharArray();
        Arrays.sort(wordCharacters);
        String sortedWord = new String(wordCharacters);
        System.out.println(sortedWord);

        List<String> anagrams = new ArrayList<>();
        for(String w: szavak){
            if(w.length() == word.length()){
                char[] wCharacters = w.toCharArray();
                Arrays.sort(wCharacters);
                String sortedW = new String(wCharacters);
                if(sortedW.equals(sortedWord)){
                    anagrams.add(w);
                }
            }
        }
        return anagrams;
    }

    //4. Átváltó metódus: tizesből hármasba

    public static String decimalToBase3(int num){
        int temp = num / 3;
        int maradek = num % 3;
        String eredmeny = Integer.toString(maradek);

        while(temp > 0){
            maradek = temp % 3;
            temp /= 3;
            eredmeny += Integer.toString(maradek);
        }

        String eredmenyReversed = "";
        for(int i = eredmeny.length()-1; i >=0; i--){
            eredmenyReversed += eredmeny.charAt(i);
        }
        return eredmenyReversed;
    }

    //5. Általános átváltó metódus: tizesből bármibe (2-9)

    public static String decimalToBaseX(int num, int alap){

        int temp = num / alap;
        int maradek = num % alap;
        String eredmeny = Integer.toString(maradek);

        while(temp > 0){
            maradek = temp % alap;
            temp /= alap;
            eredmeny += Integer.toString(maradek);
        }
        String eredmenyReversed = "";
        for(int i = eredmeny.length()-1; i >=0; i--){
            eredmenyReversed += eredmeny.charAt(i);
        }
        return eredmenyReversed;
    }



}
