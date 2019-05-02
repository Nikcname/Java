import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        //Using anonymous method
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //Using lambda
        strings.forEach(s -> System.out.println(s));

        //Using method reference
        strings.forEach(System.out::println);

    }

}
