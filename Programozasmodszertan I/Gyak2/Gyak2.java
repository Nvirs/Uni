package gyak2;

public class Gyak2 {
    public static void main(String[] args){

        // cast: primitív típusok között (int)...
        // parse

        // int - Integer
        // char - Character

        String number = "5";

        // sztring --> int
        int number2 = Integer.parseInt(number);
        System.out.println(number2);

        // int --> sztring

        String number3 = Integer.toString(number2);
        System.out.println(number3);

        // Operátorok

        boolean b1 = true;
        boolean b2 = false;
        boolean sum = b1 && b2;
        System.out.println(sum);

        int z = 100;
        boolean sum2 = b2 & ++z < 1000;
        System.out.println(z);

        // post-increment - pre-increment
        // z++     ++z

        int i = 10;
        int j = 20;
        System.out.println(i++ + ++j); // 10 + 21
        System.out.println(++i + j++); // 12 + 21

        // feltételes hármas operátor
        // feltétel ? true opció : false opció

        int num = 240;
        System.out.println(num % 2 == 0 ? "A szám páros": "A szám páratlan");

        String isEven = num % 2 == 0 ? "A szám páros": "A szám páratlan";
        System.out.println(isEven);

        int year = 2022;
        System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "Szökőév": "Nem szökőév");

        int a = 10;
        int b = 50;
        int c = 20;

        System.out.println(a + b > c && a + c > b && b + c > a ? "Szerkeszthető": "Nem szerkeszthető");

        // else if()
        if(num % 2 == 0){
            System.out.println("A szám páros.");
        }else {
            System.out.println("A szám nem páros.");
        }

        // switch - case
        // switch utasítás
        // fall through logic
        int day = 2;
        switch(day){
            case 1:
                System.out.println("Hétfő");
                break;
            case 2:
                System.out.println("Kedd");
                break;
            case 3:
                System.out.println("Szerda");
                break;
            case 4:
                System.out.println("Csütörtök");
                break;
            case 5:
                System.out.println("Péntek");
        }

        // switch kifejezés - Java 12 óta

        String nameOfDay = switch(day){
            case 1 -> "monday";
            case 2 -> "tuesday";
            case 3 -> "wednesday";
            case 4 -> "thursday";
            default -> "unknown day";
        };

        System.out.println(nameOfDay);

        String fruit = "hülyeség";
        String fruits = switch(fruit){
            case "alma" -> "mérsékelt égövi gyümölcs";
            case "citrom" -> "déli gyümölcs";
            case "dragon fruit" -> "egzotikus gyümölcs";
            default -> "ismeretlen gyümölcs";
        };
        System.out.println(fruits);

        // Ciklusok
        /*
        számláló for
        for each
        while
        do - while
         */

        String[] konyvek = {"Harry Potter", "Gyűrűk ura", "Angyalok és démonok", "Egri csillagok"};

        // for each

        for(String konyv: konyvek){
            System.out.println(konyv);
        }

        // számláló for ciklus
        for(int k = 0; k < konyvek.length; k++){
            System.out.println(konyvek[k]);
        }

        int counter = 0;
        while(counter <= 20){
            counter ++;
            System.out.println("Futok.");
        }

        // végtelen ciklus (while)
        int y = 1;
        while(true){
            y *= 10;
            System.out.println(y);
            if(y > 1000)
                break;
        }

        // do - while
        int x = 10;

        do{
            x *= 5;
            System.out.println(x);
        }while(x < 1000);

        // cimkézett break utasítás

        String[] napok = {"hétfő", "kedd", "szerda", "csütörtök", "péntek"};
        String[] etkezesek = {"reggeli", "ebéd", "vacsora"};

        outer: for(String nap: napok){
            System.out.println(nap);
         inner:    for(String etkezes: etkezesek){
                if(nap.equals("csütörtök"))
                    break outer;
                System.out.println(etkezes);
            }
        }




    }


}
