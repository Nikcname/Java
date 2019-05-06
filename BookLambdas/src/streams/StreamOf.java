package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOf {

    public static void main(String[] args) {

        //Stream.of
        String simpsons = Stream.of("Homer", "Bart", "Lisa", "Maggie", "Margie")
                .collect(Collectors.joining(", "));

        System.out.println(simpsons);

    }

}
