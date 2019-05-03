import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateTest {

    public static void main(String[] args) {

        String names = "Hank Riley John Bin Taunt Keeper";

        MyFilter filter = new MyFilter();

        ImplementPredicate impl = new ImplementPredicate();

        //Finding strings of a given length
        int len = 4;
        System.out.println(Stream.of(names)
                .map(name -> name.split(" "))
                .map(name -> filter.getNamesOfLength(len, name))
                .collect(Collectors.joining("|")));

        //Finding strings that start with a given string
        System.out.println(Stream.of(names.split(" "))
                .filter(name -> name.startsWith("T"))
                .collect(Collectors.joining(", ")));

//        System.out.println(impl.getNamesSatisfyingCondition(ImplementPredicate.LENGTH_FOUR, names));
//        System.out.println(impl.getNamesSatisfyingCondition(ImplementPredicate.START_WITH_T, names));

    }

}
