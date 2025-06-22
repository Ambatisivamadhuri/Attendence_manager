# Attendence_manager
Files and Classes:
AttendanceRecord.java:

Represents an attendance record with fields for employeeId, date, and status.
Includes methods for serialization (toString) and deserialization (fromString).
Employee.java:

Represents an employee with fields for id, name, and department.
Includes methods for serialization (toString) and deserialization (fromString).
AttendanceManager.java:

Manages employees and attendance records.
Provides methods for adding employees, marking attendance, retrieving attendance by employee or date, and handling file I/O for persistence.
Main.java:

Implements a command-line interface for interacting with the attendance management system.
Provides options to add employees, view employees, mark attendance, and view attendance records.