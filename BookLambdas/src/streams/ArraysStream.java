package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysStream {

    public static void main(String[] args) {

        String[] simpsons = {"Homer", "Bart", "Lisa", "Maggie", "Margie"};
        String names = Arrays.stream(simpsons)
                .collect(Collectors.joining(", "));

        System.out.println(names);

    }

}
