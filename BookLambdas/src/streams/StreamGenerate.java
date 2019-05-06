package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamGenerate {

    public static void main(String[] args) {

        Stream.generate(Math::random)
                .limit(10)
                .map(m -> m * 100)
                .map(Math::round)
                .forEach(System.out::println);

        List<Integer> ints = IntStream.range(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        List<Long> longs = LongStream.rangeClosed(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longs);
    }

}
