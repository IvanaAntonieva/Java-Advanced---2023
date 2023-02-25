package Ex_07_Google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personList  = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");
            String name = inputData[0];
            if (!personList.containsKey(name)) {
                personList.put(name, new Person());
            }
            switch (inputData[1]) {
                case "company":
                    String companyName = inputData[2];
                    String department = inputData[3];
                    double salary = Double.parseDouble(inputData[4]);
                    Company company = new Company(companyName, department, salary);
                    personList.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = inputData[2];
                    String pokemonType = inputData[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personList.get(name).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String parentName = inputData[2];
                    String parentBirthday = inputData[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    personList.get(name).getParentsList().add(parent);
                    break;
                case "children":
                    String childName = inputData[2];
                    String childBirthday = inputData[3];
                    Children children = new Children(childName, childBirthday);
                    personList.get(name).getChildrenList().add(children);
                    break;
                case "car":
                    String carModel = inputData[2];
                    int carSpeed = Integer.parseInt(inputData[3]);
                    Car car = new Car(carModel, carSpeed);
                    personList.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String commandName = scanner.nextLine();
        System.out.println(commandName);
        Person person = personList.get(commandName);
        System.out.println(person);
    }
}
