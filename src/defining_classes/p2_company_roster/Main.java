package defining_classes.p2_company_roster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        Map<String, List<Employee>> employeesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        employee = new Employee(name,
                                                salary,
                                                position,
                                                department,
                                                Integer.parseInt(tokens[4]));
                    } else {
                        employee = new Employee(name,
                                                salary,
                                                position,
                                                department,
                                                tokens[4]);
                    }
                    break;
                default:
                    employee = new Employee(name,
                                            salary,
                                            position,
                                            department,
                                            tokens[4],
                                            Integer.parseInt(tokens[5]));
                    break;
            }
            employees.add(employee);

            if (!employeesMap.containsKey(employee.getDepartment())) {
                employeesMap.put(employee.getDepartment(), new ArrayList<>());
                employeesMap.get(employee.getDepartment()).add(employee);
            } else {
                employeesMap.get(employee.getDepartment()).add(employee);
            }

        }
//        Map.Entry<String, List<Employee>> highestDepartment2 = employeesMap.entrySet()
//                                                                           .stream()
//                                                                           .sorted((e1, e2) -> {
//                                                                               double e1AvgSalary = e1.getValue()
//                                                                                                      .stream()
//                                                                                                      .mapToDouble(Employee::getSalary)
//                                                                                                      .average()
//                                                                                                      .getAsDouble();
//
//                                                                               double e2AvgSalary = e2.getValue()
//                                                                                                      .stream()
//                                                                                                      .mapToDouble(Employee::getSalary)
//                                                                                                      .average()
//                                                                                                      .getAsDouble();
//
//                                                                               return Double.compare(e2AvgSalary, e1AvgSalary);
//                                                                           })
//                                                                           .findFirst()
//                                                                           .orElse(null);


        Map.Entry<String, List<Employee>> highestDepartment = employees.stream()
                                                                       .collect(Collectors.groupingBy(Employee::getDepartment))
                                                                       .entrySet()
                                                                       .stream()
                                                                       .sorted((e1, e2) -> {
                                                                           double e1AvgSalary = e1.getValue()
                                                                                                  .stream()
                                                                                                  .mapToDouble(Employee::getSalary)
                                                                                                  .average()
                                                                                                  .getAsDouble();

                                                                           double e2AvgSalary = e2.getValue()
                                                                                                  .stream()
                                                                                                  .mapToDouble(Employee::getSalary)
                                                                                                  .average()
                                                                                                  .getAsDouble();

                                                                           return Double.compare(e2AvgSalary, e1AvgSalary);
                                                                       })
                                                                       .findFirst()
                                                                       .orElse(null);

        System.out.printf("Highest Average Salary: %s\n", highestDepartment.getKey());
        highestDepartment.getValue()
                         .stream()
                         .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                         .forEach(System.out::println);
    }
}
