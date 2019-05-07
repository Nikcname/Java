package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaxedStream {

    public static void main(String[] args) {

        //Creating list of strings
        List<String> names = Stream.of("this", "is", "a", "list", "of", "strings")
                .collect(Collectors.toList());

        //Does NOT WORK
        //IntStream.of(1, 2, 3, 4, 5)
        //        .collect(Collectors.toList());

        // 1 Alternative Using the boxed method
        List<Integer> ints = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        // 2 Alternative Using the mapToObj method
        List<Integer> ints2 = IntStream.of(2, 3, 4, 5, 6)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(ints2);

        // 3 Alternative Using the three-argument version of collect
        List<Integer> ints3 = IntStream.of(5, 6, 7, 8, 9)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
        System.out.println(ints3);

        //Convert an IntStream to an int array
        int[] ints4 = IntStream.of(1, 6, 7, 0, 5).toArray();
    }

}
