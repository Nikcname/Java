package functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionTest {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Tiler", "Kile", "Morph", "Doom", "Peter", "River", "Kol", "Tem");

        //Anonymous inner class
        List<Integer> namesLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .collect(Collectors.toList());
        System.out.println(namesLengths);

        //Lambda expression
        namesLengths = names.stream()
                .map(m -> m.length())
                .collect(Collectors.toList());
        System.out.println(namesLengths);

        //Method reference
        namesLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(namesLengths);

    }
}
