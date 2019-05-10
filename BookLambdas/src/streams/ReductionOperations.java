package streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReductionOperations {

    public static void main(String[] args) {

        //Reduction operations on IntStream
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

        //Summing numbers using reduce
        //Printing the values of x and y
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) ->{
//                    System.out.printf("x=%d y=%d%n", x, y);
                    return x + y;
                }).orElse(0);

        //Doubling the values during the sum
        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> {
//                    System.out.printf("x=%d y=%d%n", x, y);
                    return x + y * 2;
                });

        //Performing a reduce with a binary operator
        int sum1_10 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);

        //Finding the max using reduce
        int max_ = Stream.of(3, 7, 44, 9, 1100, 997, 56, 1264, 994)
                .reduce(Integer.MIN_VALUE, Integer::max);

        //Concatenating strings from a stream using reduce(BAD)
        String s = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);

        System.out.printf("s=%s max_=%d sum1_10=%d%n", s, max_, sum1_10);

        //Concatenating strings from a stream using COLLECTORS(GOOD)
        String s2 = Stream.of("this", "is", "a", "list", "two")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        //Accumulating Books into a Map
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

        //Summing BigDecimals with reduce
        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
        System.out.println("Total is: " + total);

        //Sorting strings by length
        List<String> strs = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strs.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());
        System.out.println(sorted);

        //Finding max lenth string in list
        Optional<String> ssorted1 = strs.stream()
                //using peek()
                .peek(x -> System.out.println(x))
                .reduce((prev, curr) -> {
                    if (prev.length() <= curr.length())
                        return curr;
                    return prev;
                });
        System.out.println(Arrays.asList(ssorted1));

        System.out.println(sumDoubleDivisibleByTree(1, 5));
    }

    public static int sumDoubleDivisibleByTree(int start, int end){

        return IntStream.rangeClosed(start, end)
                .peek(n -> System.out.printf("Original: %d%n", n))
                .map(n -> n*2)
                .peek(n -> System.out.printf("Doubled: %d%n", n))
                .filter(n -> n%3 == 0)
                .peek(n -> System.out.printf("Filtered %d%n", n))
                .sum();

    }


}
