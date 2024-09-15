package gyak8;

public class Main {

    int main_parameter = 5;

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void display(){
            System.out.println("külső változó értéke: " + main_parameter);
        }

    }

    static class PointStatic{
        int x;
        int y;

        public PointStatic(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void display(){
         //   System.out.println(main_parameter);
        }
    }

    public static void main(String[] args){

       // Point p = new Point(3,4);
        Main mainObject = new Main();
        Main.Point p = mainObject.new Point(3,4);
        System.out.println(p.x);

        PointStatic ps = new PointStatic(5,6);
        System.out.println(ps.y);


        Hello english = new HelloEnglish();
        english.sayHi();

        //Névtelen vagy anonymous osztály

        Hello spanish = new Hello(){
            @Override
            public void sayHi(){
                System.out.println("Hola a todos!");
            }
        };

        Decide fobj = new Decide(){
            @Override
            public boolean ifCondition(int x){
                return x % 2 == 0;
            }
        };

        //Lambda kifejezés
        Decide fobj2 = x -> x % 2 == 0;
        /*
        (a, b) -> a + b

       (a, b) -> {
               int c;
               c = a+ b;
               return c;
       }
         */

        int v[] = {1,2,3,4,5,6,7,8,9,10};
        int darab = nrT(v, fobj2);
        System.out.println("A T tulajdonságú elemek száma: " + darab);

    }

    static int nrT(int v[], Decide fobj){
        int db = 0;
        for(int i = 0; i < v.length; i++){
            if(fobj.ifCondition(v[i])){
                db++;
            }
        }
        return db;
    }

}
