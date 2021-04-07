package Practic2;
import java.time.LocalDate;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;
    Human(int age, String firstName, String lastName, LocalDate birthDate, int weight)
    {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return
                "Age: " + age +
                        ", firstName: " + firstName  +
                        ", lastName: " + lastName  +
                        ", birthday: " + birthDate +
                        ", weight: " + weight;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = Arrays.asList(
                new Human(33, "Artem", "Baranchik", LocalDate.of(2001, 2, 24), 60),
                new Human(55, "Sergay", "Atonyan", LocalDate.of(2000, 5,28), 100),
                new Human(88, "Alex", "Kostirenkov", LocalDate.of(2001, 3, 1), 70),
                new Human(20, "Boris", "Glushan", LocalDate.of(2001, 2, 24), 90),
                new Human(21, "Vitaliy", "Gavrilenko", LocalDate.of(2000,10,14), 95),
                new Human(20, "Victor", "Faust", LocalDate.of(2001,8,30), 65)
        );
        System.out.println("Сортировка по имени в обратном порядке: ");
        Stream<Human> stream = humanList.stream().sorted(Comparator.comparing(Human::getFirstName).reversed());
        stream.forEach(System.out::println);
        System.out.println("Сортировка по возрасту больше, чем 20: ");
        stream = humanList.stream().filter(human -> human.getAge() > 20);
        stream.forEach(System.out::println);
        System.out.println("Выбор первых 3 элементов списка: ");
        for (int i = 0; i < 3; i++)
        {
            System.out.println(humanList.get(i));
        }
        System.out.println("Конкатенация имен в строку через пробел:");
        String names = humanList.stream().map(Human::getFirstName).collect(Collectors.joining(" "));
        System.out.println(names);
    }
}
