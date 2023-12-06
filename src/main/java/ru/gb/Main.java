package ru.gb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * * 1.1 Найти максимальное
 * * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 * *
 * * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * * 2.1 Создать список из 10-20 сотрудников
 * * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> randNumbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            randNumbers.add(rand.nextInt(1000000));
        }
        int maxNumber = randNumbers.stream().max(Integer::compare).get();
        System.out.println(randNumbers.stream().filter(x -> x > 500000).mapToLong(x -> (x * 5) - 150).sum());
        System.out.println(randNumbers.stream().filter(x -> (x * x) < 100000).count());

        List<Employee> employees = Arrays.asList(
                new Employee("Vasya",27,30000.0,"Consult"),
                new Employee("Petya",25,3000.0,"Sale"),
                new Employee("Alex",22,100.0,"Support"),
                new Employee("Leo",30,2400.0,"Consult"),
                new Employee("Nick",19,34500.0,"Sale"),
                new Employee("Michael",24,12300.0,"Support"),
                new Employee("Petr",26,4500.0,"Consult"),
                new Employee("Olga",28,37750.0,"Support"),
                new Employee("Vika",29,30234.0,"Consult"),
                new Employee("Masha",40,301230.0,"Sale"),
                new Employee("Lera",23,54600.0,"Support"));

        employees.stream().map(x->x.getDepartment()).distinct().forEach(System.out::println);
        employees.stream().filter(e -> e.getSalary() < 10000).forEach(e -> e.setSalary(e.getSalary() * 1.20));
    }
}