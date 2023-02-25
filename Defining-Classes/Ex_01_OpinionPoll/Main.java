package Ex_01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= peopleCount ; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String personName = personData[0];
            int personAge = Integer.parseInt(personData[1]);
            Person person = new Person(personName, personAge);
            personList.add(person);
        }
        personList = personList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());
        personList.sort(Comparator.comparing(person -> person.getName()));
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
