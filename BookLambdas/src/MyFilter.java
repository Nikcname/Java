import java.util.Arrays;
import java.util.stream.Collectors;

public class MyFilter implements PredicateIntTest {

    @Override
    public String getNamesOfLength(int len, String... name) {
        return Arrays.stream(name)
                .filter(s -> s.length() == len)
                .collect(Collectors.joining(", "));
    }
}
