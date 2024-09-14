package __Gyakorlat.Zarthelyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HarmadikFeladat {
    public static void main(String[] args) {
        List<EmployeeBasic> members = new ArrayList<>();
        EmployeeBasic.storage(members);
        EmployeeBasic.listing(members);
        System.out.println("\nAkinek a legkevesebb a fizetése: " + EmployeeBasic.findLowestPaidEmployeeName(members));
        EmployeeBasic.listAboveAverageWages(members);
        EmployeeBasic.printOldestEmployee(members);
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nAdja meg a dolgozó azonosítóját: ");
        int memberId = scanner.nextInt();
        EmployeeBasic.getEmployeeInfoById(members, memberId);
    }
}