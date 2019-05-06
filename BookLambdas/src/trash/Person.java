package trash;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Person {

    private String name;

    public Person(){}

    //Copy constructor
    public Person(Person p){
        this.name = p.name;
    }

    public Person(String name) {
        this.name = name;
    }

    //Varargs constructor
    public Person(String... names){
        this.name = Arrays.stream(names)
                .collect(Collectors.joining("_"));
        System.out.println(this.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
