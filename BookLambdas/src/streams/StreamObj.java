package streams;

import trash.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamObj {

    public static void main(String[] args) {

        //transforming string into objects
        List<String> names = Arrays.asList("Yun Che", "Huo Po Yun", "Mu Bin", "Luo", "Lu");
        List<Person> people = names.stream()
                .map(name -> new Person(name))          //Using lambda expression
                .collect(Collectors.toList());

        List<Person> peopele1 = names.stream()
                .map(Person::new)                       //Using CONSTRUCTOR reference
                .collect(Collectors.toList());

        //Converting a list to a stream and back
        Person before = new Person("Yun Che");

        List<Person> people2 = Stream.of(before)        //Creating stream
                .collect(Collectors.toList());

        Person after = people2.get(0);                  //Assigning after to 0 element of stream

        before.setName("Fen Chu");                      //Changing before name

        //After name also changed
        System.out.println(after.getName() + " " + before.getName());

        //Using the copy constructor
        Person before1 = new Person("Yun Che");

        List<Person> people3 = Stream.of(before1)
                .map(Person::new)                       //Use copy constructor
                .collect(Collectors.toList());

        Person after1 = people3.get(0);                 //Assigning after to 0 element of stream

        before1.setName("Fen Chu");                     //Changing before name

        //After name NOT changed
        System.out.println(after1.getName() + " " + before1.getName());

        names.stream()
                .map(name -> name.split(" "))       //Creating stream of strings
                .map(Person::new)                     //Using Varargs constructor
                .collect(Collectors.toList());

    }

}
