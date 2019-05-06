package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        //Creating a stream
        Stream.of(1, 2, 3, 4, 5)
                .forEach(x -> System.out.println(x));   //Using lambda expression

        Stream.of(5, 4, 3, 2, 1)
                .forEach(System.out::println);          //Using method reference

        Consumer<Integer> printer = System.out::println;//Assigning method reference to functional interface
        Stream.of(3, 5, 1, 2, 4)
                .forEach(printer);

        //Generate 5 random variables
        Stream.generate(Math::random)                   //Using method reference with static methods
                .limit(5)
                .map(x -> (int)(x*100))                 //Multiply generated to 100
                .forEach(System.out::println);          //With instance methods

        //Invoke the instance method on a reference to an object supplied by the context
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))   //Lambda reference to the target
                .collect(Collectors.toList());

        List<String> sorteds = strings.stream()
                .sorted(String::compareTo)              //Method reference to the target
                .collect(Collectors.toList());
    }

}
