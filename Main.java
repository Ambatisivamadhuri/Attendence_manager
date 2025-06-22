import java.util.*;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nAttendance Tracking System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance by Employee");
            System.out.println("5. View Attendance by Date");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    manager.addEmployee(new Employee(id, name, dept));
                    System.out.println("Employee added.");
                    break;
                case 2:
                    for (Employee emp : manager.getEmployees())
                        System.out.println(emp.getId() + " | " + emp.getName() + " | " + emp.getDepartment());
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = sc.nextLine();
                    manager.markAttendance(eid, date, status);
                    System.out.println("Attendance marked.");
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    List<AttendanceRecord> records = manager.getAttendanceForEmployee(empId);
                    for (AttendanceRecord rec : records)
                        System.out.println(rec.getDate() + " | " + rec.getStatus());
                    break;
                case 5:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String d = sc.nextLine();
                    List<AttendanceRecord> recs = manager.getAttendanceForDate(d);
                    for (AttendanceRecord rec : recs)
                        System.out.println("EmpID: " + rec.getEmployeeId() + " | " + rec.getStatus());
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}