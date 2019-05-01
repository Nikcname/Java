import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Assigning lambda to a variable
        Runnable r = () -> System.out.println("Lambda in variable");
        new Thread(r).start();

        //Using anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Testing without Lambdas");
            }
        }).start();

        //Replacing anonymous inner class with lambda
        new Thread(() -> System.out.println("Testing with Lambdas")).start();

        //Assigning path of folder
        File directory = new File("C:\\Users\\Nikcname\\IdeaProjects\\BookLambdas\\src");
        //Using anonymous inner class
        String names_[] = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");
            }
        });
        System.out.println(Arrays.asList(names_));

        //Replacing anonymous inner class with lambda
        String[] names = directory.list((dir, name) -> name.endsWith("java"));
        System.out.println(Arrays.asList(names));

    }

}
