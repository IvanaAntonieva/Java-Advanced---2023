import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab_02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guestList = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            guestList.add(input);
            input = scanner.nextLine();
        }
        String nextInput = scanner.nextLine();
        while (!nextInput.equals("END")) {
            guestList.remove(nextInput);
            nextInput = scanner.nextLine();
        }
        System.out.println(guestList.size());
        for (String guest:guestList) {
            System.out.println(guest);
        }
    }
}
