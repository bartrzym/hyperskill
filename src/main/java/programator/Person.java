package programator;

import java.util.Comparator;

public class Person {
    private String name;
    private String number;

    String getName() {
        return name;
    }

    Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "\n" + "Person{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }


}
