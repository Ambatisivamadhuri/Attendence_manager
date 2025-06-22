public class AttendanceRecord {
    private int employeeId;
    private String date; // Format: YYYY-MM-DD
    private String status; // "Present" or "Absent"

    public AttendanceRecord(int employeeId, String date, String status) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    public int getEmployeeId() { return employeeId; }
    public String getDate() { return date; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return employeeId + "," + date + "," + status;
    }

    public static AttendanceRecord fromString(String data) {
        String[] parts = data.split(",");
        return new AttendanceRecord(Integer.parseInt(parts[0]), parts[1], parts[2]);
    }
}