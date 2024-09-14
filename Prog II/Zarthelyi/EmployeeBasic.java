package __Gyakorlat.Zarthelyi;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class EmployeeBasic {
    private final int id;
    private final String name;
    private final int age;
    private final double wage;
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EmployeeBasic(int id, String name, int age, double wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWage() {
        return wage;
    }

    public static void storage(List<EmployeeBasic> list) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Kérem az azonosítót (0 -> vége): ");
            int id = scanner.nextInt();
            if (id == 0) break;
            scanner.nextLine();
            System.out.print("Kérem a nevet: ");
            String name = scanner.nextLine();
            System.out.print("Kérem az életkort: ");
            int age = scanner.nextInt();
            System.out.print("Kérem a fizetést: ");
            double wage = scanner.nextDouble();
            list.add(new EmployeeBasic(id, name, age, wage));
        }
    }

    public static void listing(List<EmployeeBasic> list) {
        System.out.println("\nAz összes dolgozó:");
        if (list.isEmpty()) {
            System.out.println("Nincs dolgozó az adatbázisban.");
            return;
        }

        for (EmployeeBasic employee : list)
            System.out.println(employee.getId() + " | " +
                    employee.getName() + " | " +
                    employee.getAge() + " | " +
                    currency.format(employee.getWage()));
    }

    public static String findLowestPaidEmployeeName(List<EmployeeBasic> list) {
        if (list.isEmpty()) return null;
        // Minimumkiválasztás
        EmployeeBasic lowestPaidEmployee = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getWage() < lowestPaidEmployee.getWage())
                lowestPaidEmployee = list.get(i);
        }
        return lowestPaidEmployee.getName();
    }

    public static void listAboveAverageWages(List<EmployeeBasic> list) {
        if (list.isEmpty()) {
            System.out.println("\nÁtlagfeletti fizetésű dolgozók:");
            System.out.println("Nincs dolgozó az adatbázisban.");
            return;
        }

        double sum = 0;
        for (EmployeeBasic employee : list) sum += employee.getWage();
        double averageWage = sum / list.size();

        System.out.println("\nÁtlagfizetés: " + currency.format(averageWage));
        System.out.println("\nÁtlagfeletti fizetésű dolgozók:");
        for (EmployeeBasic employee : list) {
            if (employee.getWage() > averageWage) {
                double difference = Math.abs(employee.getWage() - averageWage);
                System.out.println(employee.getName() +
                        " - Fizetés: " + currency.format(employee.getWage()) +
                        ", Többlet: " + currency.format(difference));
            }
        }
    }

    public static void printOldestEmployee(List<EmployeeBasic> list) {
        if (list.isEmpty()) {
            System.out.println("Nincs dolgozó az adatbázisban.");
            return;
        }
        // Maximumkiválasztás
        EmployeeBasic oldestEmployee = list.get(0);
        for (EmployeeBasic employee : list)
            if (employee.getAge() > oldestEmployee.getAge()) oldestEmployee = employee;
    }

    public static void getEmployeeInfoById(List<EmployeeBasic> list, int id) {
        for (EmployeeBasic employee : list) {
            if (employee.getId() == id) {
                System.out.println("Dolgozó neve: " + employee.getName());
                System.out.println("Dolgozó életkora: " + employee.getAge());
                System.out.println("Dolgozó fizetése: " + currency.format(employee.getWage()));
                return;
            }
        }
        System.out.println("Nincs ilyen azonosítójú dolgozó.");
    }
}