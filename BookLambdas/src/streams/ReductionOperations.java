package streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReductionOperations {

    public static void main(String[] args) {

        String[] strings = "this is an array of strings".split(" ");
        long count = Arrays.stream(strings)
                .map(String::length)
                .count();
        System.out.println("There are " + count + " strings");

        int totalLength = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
        System.out.println("Total length " + totalLength);

        OptionalDouble ave = Arrays.stream(strings)
                .mapToInt(String::length)
                .average();
        System.out.println("The average length is " + ave.getAsDouble());

        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();

        OptionalInt max = Arrays.stream(strings)
                .mapToInt(String::length)
                .max();
        System.out.println("The max and min length are " + max.getAsInt() + " and " + min.getAsInt() + ".");

        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) ->{
//                    System.out.printf("x=%d y=%d%n", x, y);
                    return x + y;
                }).orElse(0);

        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> {
//                    System.out.printf("x=%d y=%d%n", x, y);
                    return x + y * 2;
                });

        int sum1_10 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);

        int max_ = Stream.of(3, 7, 44, 9, 1100, 997, 56, 1264, 994)
                .reduce(Integer.MIN_VALUE, Integer::max);

        String s = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);

        System.out.printf("s=%s max_=%d sum1_10=%d%n", s, max_, sum1_10);

        String s2 = Stream.of("this", "is", "a", "list", "two")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        List<Book> books = new ArrayList<>();
        books.add(new Book("firs", 1));
        books.add(new Book("second", 2));
        books.add(new Book("third", 3));
        HashMap<Integer, Book> bookMap = books.stream()
                .reduce(new HashMap<Integer, Book>(),
                        (map, book) -> {
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) ->{
                            map1.putAll(map2);
                            return map1;
                        });

        bookMap.forEach((k, v) -> System.out.println(k + ": " + v));

    }

}
