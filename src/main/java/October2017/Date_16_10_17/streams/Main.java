package October2017.Date_16_10_17.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("one", 100, (double) 1);
        Order order1 = new Order("two", 875489, (double) 2);
        Order order2 = new Order("three", 9, (double) 3);
        Order order3 = new Order("five", 56, (double) 4);
        Order order4 = new Order("six", 11, (double) 10);
        Order order5 = new Order("seven", 636478326, (double) 1101);
        Order order6 = new Order("eight", 1, (double) 66);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);

        //orders.stream().forEach((or)-> System.out.println(or));
        //orders.stream().forEach(System.out::println);

        orders.stream().filter((ord) -> ord.name.startsWith("t")
                                            ||ord.summ > 100)
                       .sorted((o1, o2) -> {
                            if(o1.summ == o2.summ)
                                return 0;
                            else if(o1.summ > o2.summ)
                                return 1;
                            return -1;
                       }).map((ord) ->
                            new Report(order.name + " "
                                        + order.summ))
                       .forEach(System.out::println);

        System.out.println(
                orders.stream().allMatch( (ordd)-> {
                   return ordd.summ > 0;
                })
        );

        System.out.println(
                orders.stream().anyMatch( (ordd)-> {
                    return ordd.summ > 1_000_000;
                })
        );


        System.out.println(orders.stream().count());

        Optional<Integer> result = orders.stream()
                            .map((or) -> or.summ)
                            .reduce(
                                (sm1, sm2)-> {
                                    return sm1 + sm2;
                                }
                            );

        System.out.println(result.get());
        List<Order> orders1 =
                orders.stream().collect(Collectors.toList());
    }
}
