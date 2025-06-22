import java.util.*;
import java.io.*;

public class AttendanceManager {
    private List<Employee> employees = new ArrayList<>();
    private List<AttendanceRecord> attendanceRecords = new ArrayList<>();

    private final String employeeFile = "data/employees.csv";
    private final String attendanceFile = "data/attendance.csv";

    public AttendanceManager() {
        loadEmployees();
        loadAttendance();
    }

    // Employee Methods
    public void addEmployee(Employee emp) {
        employees.add(emp);
        saveEmployees();
    }

    public List<Employee> getEmployees() { return employees; }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees)
            if (emp.getId() == id) return emp;
        return null;
    }

    // Attendance Methods
    public void markAttendance(int empId, String date, String status) {
        attendanceRecords.add(new AttendanceRecord(empId, date, status));
        saveAttendance();
    }

    public List<AttendanceRecord> getAttendanceForEmployee(int empId) {
        List<AttendanceRecord> list = new ArrayList<>();
        for (AttendanceRecord rec : attendanceRecords)
            if (rec.getEmployeeId() == empId)
                list.add(rec);
        return list;
    }

    public List<AttendanceRecord> getAttendanceForDate(String date) {
        List<AttendanceRecord> list = new ArrayList<>();
        for (AttendanceRecord rec : attendanceRecords)
            if (rec.getDate().equals(date))
                list.add(rec);
        return list;
    }

    // File I/O Methods
    private void loadEmployees() {
        employees.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(employeeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                employees.add(Employee.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No employee data found, starting fresh.");
        }
    }

    private void saveEmployees() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(employeeFile))) {
            for (Employee emp : employees)
                bw.write(emp.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving employees.");
        }
    }

    private void loadAttendance() {
        attendanceRecords.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(attendanceFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                attendanceRecords.add(AttendanceRecord.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No attendance data found, starting fresh.");
        }
    }

    private void saveAttendance() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(attendanceFile))) {
            for (AttendanceRecord rec : attendanceRecords)
                bw.write(rec.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving attendance.");
        }
    }
}