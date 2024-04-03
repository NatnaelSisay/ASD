package com.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.models.Employee;
import com.example.models.Pension;

public class Main {
    public static void main(String[] args) {

        Pension p1 = new Pension(
                "EX1089",
                Utils.getCorspondingLocalDate("2023-01-17"),
                BigDecimal.valueOf(100.00));

        Pension p2 = new Pension("SM2307",
                Utils.getCorspondingLocalDate("2019-11-04"),
                BigDecimal.valueOf(1555.50));

        List<Employee> employees = List.of(
                new Employee(0, "Daniel", "Agar",
                        Utils.getCorspondingLocalDate("2018-01-17 "),
                        BigDecimal.valueOf(105943.60), p1),

                new Employee(0, "Daniel", "Agar",
                        Utils.getCorspondingLocalDate("2018-01-17 "),
                        BigDecimal.valueOf(105945.50), p1),

                new Employee(1, "Benard", "Shaw",
                        Utils.getCorspondingLocalDate("2019-04-03"),
                        BigDecimal.valueOf(197750.00), null));

        System.out.println("------- LIST OF EMPLOYEES ------");
        displayEmployees(employees);

        List<Employee> qualified = getMonthlyUpcomingEnrollees(employees);
        System.out.println("------- LIST OF QUALIFYING EMPLOYEES ------");
        displayEmployees(qualified);
    }

    private static List<Employee> getMonthlyUpcomingEnrollees(List<Employee> employees) {
        List<Employee> qualifiedEmployees = employees.stream()
                .filter(employee -> {
                    return Utils.willQualifyForTheYearNextMonth(
                            5,
                            employee.getEmployeeDate());
                })
                .filter(employee -> employee.getPension() == null)
                .collect(Collectors.toList());

        return qualifiedEmployees;
    }

    private static void displayEmployees(List<Employee> employees) {
        // sort them by last name in ascending order and decending order in
        // their sallary
        List<Employee> sortedEmployees = employees
                .stream()
                .sorted((a, b) -> {
                    int res = a.getLastName().compareTo(b.getLastName());
                    if (res != 0)
                        return res;
                    return b.getYearlySalary().compareTo(a.getYearlySalary());
                })
                .collect(Collectors.toList());

        String jsonFormat = Utils.getJsonFromList(sortedEmployees);
        System.out.println(jsonFormat);
    }
}