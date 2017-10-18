package October2017.Date_16_10_17.lambdas;

import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
       MyStringer stringer = new MyStringer();

       Function function = stringer::toString;
       System.out.println(function.apply(stringer));

       int x = 0;
       //x++;
        Thread thread = new Thread(()-> {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            returnInt(x);
        });

        thread.start();

       Function function1 = (a) -> {
           return "Function 2" + a + " " + x;
       };

//       x++;
       //x++;
        System.out.println(function1.apply(" message"));
        //x++;
        //System.out.println(function1.apply(" message"));
    }

    public static int returnInt(Integer x){
       return x++;
    }
}
