import java.util.*;

public class Lab_08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> academyGraduation = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] studentGrades = scanner.nextLine().split("\\s+");
            List<Double> grades = new ArrayList<>();

            for (int j = 0; j < studentGrades.length; j++) {
                grades.add(Double.parseDouble(studentGrades[j]));
                academyGraduation.put(name, grades);
            }
        }
        academyGraduation.entrySet().stream().forEach(entry -> {
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double avgSum = sum / entry.getValue().size();

            System.out.print(entry.getKey() + " is graduated with ");
            System.out.print(avgSum);
            System.out.println();
        });
    }
}

