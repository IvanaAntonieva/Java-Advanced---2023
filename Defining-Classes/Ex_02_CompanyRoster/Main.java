package Ex_02_CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeesCount = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 1; i <= employeesCount; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");
            String nameOfTheEmployee = employeeData[0];
            double salaryOfTheEmployee = Double.parseDouble(employeeData[1]);
            String positionOfTheEmployee = employeeData[2];
            String departmentOfTheEmployee = employeeData[3];
            String emailOfTheEmployee = "n/a";
            int ageOfTheEmployee = -1;

            if (employeeData.length == 6) {
                emailOfTheEmployee = employeeData[4];
                ageOfTheEmployee = Integer.parseInt(employeeData[5]);
            } else if (employeeData.length == 5) {
                if (Character.isDigit(employeeData[4].charAt(0))) {
                    ageOfTheEmployee = Integer.parseInt(employeeData[4]);
                } else {
                    emailOfTheEmployee = employeeData[4];
                }
            }
            Employee employee = new Employee(nameOfTheEmployee, salaryOfTheEmployee, positionOfTheEmployee, departmentOfTheEmployee, emailOfTheEmployee, ageOfTheEmployee);
                if (!departments.containsKey(departmentOfTheEmployee)) {
                    departments.put(departmentOfTheEmployee, new Department(departmentOfTheEmployee));
                }
                departments.get(departmentOfTheEmployee).getEmployees().add(employee);
        }
        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().getAverageSalary()))
                .get().getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
