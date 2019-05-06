package suppliers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SupplierTest {

    public static void main(String[] args) {

        Logger logger =Logger.getLogger("...");

        //Anonymous random class
        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };

        logger.info(String.valueOf(randomSupplier.getAsDouble()));

        //Lambda expression reference
        randomSupplier = () -> Math.random();

        logger.info(String.valueOf(randomSupplier.getAsDouble()));

        //Method reference
        randomSupplier = Math::random;

        logger.info(String.valueOf(randomSupplier.getAsDouble()));

        //Finding a name from a collection
        List<String> names = Arrays.asList("Mal", "John", "Patric", "Peter","Huo");

        //Optional can return null or value
        Optional first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();

        //Prints Optional.empty
        System.out.println(first);

        //Prints the string "None"
        System.out.println(first.orElse("None"));

        //Forms the comma-separated collection, even when name is found
        System.out.println(first.orElse(String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));

        //Forms the comma-separated collection only if the Optional is empty
        System.out.println(first.orElseGet(()-> String.format("No results found in %s",
                names.stream().collect(Collectors.joining(", ")))));

    }

}
