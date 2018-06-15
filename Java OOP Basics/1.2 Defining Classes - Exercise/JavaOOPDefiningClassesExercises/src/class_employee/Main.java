package class_employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Employee>> departments = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] employeeData = reader.readLine().split(" ");
            String employeeName = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            String email = "n/a";
            int age = -1;
            if(employeeData.length == 5){
                if(employeeData[4].matches("[0-9]+")){
                    age = Integer.parseInt(employeeData[4]);
                } else {
                    email = employeeData[4];
                }
            }
            if(employeeData.length == 6){
                email = employeeData[4];
                age = Integer.parseInt(employeeData[5]);
            }
            Employee employee = new Employee(employeeName, salary, position, department, email, age);
            if(!departments.containsKey(department)){
                departments.putIfAbsent(department, new ArrayList<>());
            }
            departments.get(department).add(employee);
        }
        StringBuilder sb = new StringBuilder();

        departments.entrySet().stream()
                .sorted((x, y) -> Double.compare(y.getValue().stream().mapToDouble(Employee::getSalary).sum(), x.getValue().stream().mapToDouble(Employee::getSalary).sum()))
                .limit(1).forEach(x -> sb.append("Highest Average Salary: ").append(x.getKey()).append(System.lineSeparator()));

        departments.entrySet().stream()
                .sorted((x, y) -> Double.compare(y.getValue().stream().mapToDouble(Employee::getSalary).sum(), x.getValue().stream().mapToDouble(Employee::getSalary).sum()))
                .limit(1).
                forEach(x -> x.getValue().stream()
                        .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                        .forEach(y -> sb.append(y.getName()).append(" ").append(String.format("%.2f ", y.getSalary())).append(y.getEmail()).append(" ").append(y.getAge()).append(System.lineSeparator())));

        System.out.println(sb.toString());
    }
}
