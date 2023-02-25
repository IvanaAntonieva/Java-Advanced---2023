import java.util.*;

public class Lab_05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> register = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] studentData = scanner.nextLine().split("\\s+");
            String student = studentData[0];
            double grade = Double.parseDouble(studentData[1]);

            register.putIfAbsent(student, new ArrayList<>());
            register.get(student).add(grade);
        }
        register.entrySet().stream().forEach(entry -> {
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double avgSum = sum / entry.getValue().size();

            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });
    }
}
