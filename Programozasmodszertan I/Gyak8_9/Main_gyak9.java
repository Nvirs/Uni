package gyak9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        //try with resources: modernebb kivételkezelés --> csak eszközök esetén alkalmazható

        //Fájlkezelés
        /*
        Fájlkezelés: stream-eken (folyamok) keresztül
        2 féle: szöveges folyam és
                bináris folyam
        Szöveges stream/folyam  1 egység: 1 karakter
        Bináris stream/folyam   1 egység: 1 byte (8 bit)

        Bináris folyam: nincsen rajta semmi értelmezés, letárolja úgy
        a byte-okat, ahogy megadjuk (1 és 0).
        Szöveges folyam: a karakter, mint egység jelenik meg.
         */



        //Szöveges folyam kezelése


        //Legprimitívebb, legalacsonyabb absztrakciós szintű
        //fájlkezelés.
        Writer w;
        Reader r;
        //Abstract osztályok.
        //Valamilyen leszármazottját szoktuk használni, pl.:


//        Scanner scn = new Scanner(System.in);
//        scn.close();
        try(FileWriter fw = new FileWriter("teszt.txt")){
            fw.write(65);
            fw.write(13);
            fw.write(66);
            fw.write(10);
            fw.write(67);
            fw.write('X');
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try(FileReader fr = new FileReader("teszt.txt")){
            int charCode;
            while((charCode = fr.read()) != -1){
                char character = (char)charCode;
                System.out.println(character);
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        // Bináris

        /*
        InputStream
        OutputStream
         */

        try(FileInputStream in = new FileInputStream("proba.pdf");
            FileOutputStream out = new FileOutputStream("proba_out.pdf")) {
                while(true)

                {
                    int readByte = in.read(); //beolvas 1 byte-ot
                    if (readByte == -1) {
                        break;
                    }
                    out.write(readByte);
                }

            }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try(PrintWriter out = new PrintWriter("sorok.txt")){
            for(int i = 1; i <= 20; i++){
                out.println(i + ". sor");
            }
        }





    }
}
