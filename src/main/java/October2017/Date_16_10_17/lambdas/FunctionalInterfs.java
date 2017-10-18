package October2017.Date_16_10_17.lambdas;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfs {
    public static void main(String[] args) {
        //predicate();
        //function();
        //supplier2();
        //consumer();
        //comparator();
        //optional();
    }

    public static void optional(){
        Optional<MyStringer> optional =
                Optional.ofNullable(null);

        System.out.println(optional.isPresent());
    }

    public static void comparator(){
        Comparator<String> comparator =
                (a, b) ->{
                    if(a.length() == b.length())
                        return 1;
                    else
                        return -1;
                };

        System.out.println(
                comparator
                        .compare("jklfjkd", "kjfdk"));
    }

    public static void consumer(){
        Consumer<String> consumer =
                (hh) -> {
                    System.out.println(hh.toLowerCase());
                };

        consumer.accept("Hello");
    }

    public static void supplier2(){
        Supplier<MyStringer> supplier =
                MyStringer::new;

        MyStringer stringer = supplier.get();
        System.out.println(stringer.toString(""));
    }

    public static void supplier(){
        Supplier<MyStringer> supplier =
                () -> {
                    return new MyStringer();
                };

        MyStringer stringer = supplier.get();
        System.out.println(stringer.toString(""));
    }

    public static void function(){
        Function<String, Integer>
                lenght = (a) -> {
                    return a.length();
                };

        System.out.println(lenght.apply("jhfdsohfjk"));
    }

    public static void predicate(){
        Predicate<String> comparator =
                (s) -> s.contains("a");

        System.out.println(
                comparator.test("bcd"));
    }
}
