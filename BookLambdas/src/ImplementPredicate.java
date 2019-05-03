import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImplementPredicate {

    public static final Predicate<String> LENGTH_FOUR = s -> s.length() == 4;
    public static final Predicate<String> START_WITH_T = s -> s.startsWith("T");

    //Finding strings that satisfy an arbitrary predicate
    public String getNamesSatisfyingCondition(
            Predicate<String> condition, String... names
    ){
        System.out.println(Arrays.asList(names));

        Arrays.stream(names).map(s->s.split(" ")).forEach(System.out::println);

        String str = Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));

        System.out.println(str);

        return str;
    }

}
