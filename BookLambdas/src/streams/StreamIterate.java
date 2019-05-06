package streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIterate {

    public static void main(String[] args) {
        List<BigDecimal> nums = Stream.iterate(BigDecimal.ONE, n->n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(nums);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);
    }

}
