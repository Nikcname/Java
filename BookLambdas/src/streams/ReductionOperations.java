package streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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

    }

}
