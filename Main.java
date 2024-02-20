import java.util.*;

class Shift {
    private String position;
    private String date;
    private int hours;
    private String timeIn;
    private String timeOut;

    public Shift( String position,String date, int hours, String timeIn, String timeOut) {
        this.position = position;
        this.date = date;
        this.hours = hours;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public String getPosition(){
        return position;
    }
    public String getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public String setPosition(String position){
        this.position = position;
        return position;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Position" + position + "Date: " + date + ", Hours: " + hours + ", Time In: " + timeIn + ", Time Out: " + timeOut;
    }

    public void setTimeIn(String newTimeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(String newTimeOut) {
        this.timeOut = timeOut;
    }
}

class Employee {
    private int employeeId;
    private String name;
    private String gender;
    private int phoneNumber;
    private List<Shift> schedule;

    public Employee(int employeeId, String name, String gender, int phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.schedule = new ArrayList<>();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void scheduleShift(String position, String date, int hours, String timeIn, String timeOut) {
        Shift shift = new Shift(position, date, hours, timeIn, timeOut);
        schedule.add(shift);
    }

    public List<Shift> getSchedule() {
        return schedule;
    }

    public void updateShift(int index, String newPosition, int newHours, String newTimeIn, String newTimeOut) {
        if (index >= 0 && index < schedule.size()) {
            Shift shift = schedule.get(index);
            shift.setPosition(newPosition);
            shift.setHours(newHours);
            shift.setTimeIn(newTimeIn);
            shift.setTimeOut(newTimeOut);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void deleteShift(int index) {
        if (index >= 0 && index < schedule.size()) {
            schedule.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Gender: " + gender + ", Phone: " + phoneNumber;
    }
    public void setEmployeeId(int newID){
        this.employeeId = newID;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setPhoneNumber(int newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    public void setGender(String newGender){
        this.gender = newGender;
    }
}

class EmployeeScheduler {
    private Map<Integer, Employee> employees;

    public EmployeeScheduler() {
        this.employees = new HashMap<>();
    }

    public void addEmployee(int employeeId, String name, int phoneNumber) {
        System.out.print("Enter gender (Male/Female): ");
        Scanner scanner = new Scanner(System.in);
        String gender = scanner.next();
        Employee employee = new Employee(employeeId, name, gender, phoneNumber);
        employees.put(employeeId, employee);
    }

    public Employee getEmployee(int employeeId) {
        return employees.get(employeeId);
    }

    public void scheduleShift( String position, int employeeId, String date, int hours) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            System.out.print("Enter time in (HH:mm): ");
            Scanner scanner = new Scanner(System.in);
            String timeIn = scanner.next();
            System.out.print("Enter time out (HH:mm): ");
            String timeOut = scanner.next();
            employee.scheduleShift(date, position, hours, timeIn, timeOut);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void displayAllSchedules() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
            List<Shift> schedule = employee.getSchedule();
            for (Shift shift : schedule) {
                System.out.println(shift);
            }
        }
    }

    public void updateEmployee(int employeeId,int newID, String newName, String newGender, int newPhoneNumber) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            employee.setEmployeeId(newID);
            employee.setName(newName);
            employee.setPhoneNumber(newPhoneNumber);
            employee.setGender(newGender);
            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            employees.remove(employeeId);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateShift(int employeeId, int index, String newPosition, int newHours) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            System.out.print("Enter new time in (HH:mm): ");
            Scanner scanner = new Scanner(System.in);
            String newTimeIn = scanner.next();
            System.out.print("Enter new time out (HH:mm): ");
            String newTimeOut = scanner.next();
            employee.updateShift(index, newPosition, newHours, newTimeIn, newTimeOut);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteShift(int employeeId, int index) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            employee.deleteShift(index);
        } else {
            System.out.println("Employee not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeScheduler scheduler = new EmployeeScheduler();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Schedule Shift");
            System.out.println("3. Display All Employees");
            System.out.println("4. Display All Schedules");
            System.out.println("5. Update Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Update Shift");
            System.out.println("8. Delete Shift");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Add employee
                    System.out.println("Enter employee details (ID, Name, Numberphome): ");
                    System.out.print("EmployeeID:");
                    int employeeId = scanner.nextInt();
                    System.out.print("EmployeeName:");
                    String name = scanner.next();
                    System.out.print("EmployeePhone:");
                    int phoneNumber = scanner.nextInt();
                    scheduler.addEmployee(employeeId, name, phoneNumber);
                    break;

                case 2:
                    // Schedule shift
                    System.out.println("Schedule shifts (Employee ID, Position, Date, Hours):");
                    System.out.print("Shift for Employee: ");
                    int shiftEmployeeId = scanner.nextInt();
                    System.out.print("Position: ");
                    String position = scanner.next();
                    System.out.print("Date: ");
                    String date = scanner.next();
                    System.out.print("Hours: ");
                    int hours = scanner.nextInt();
                    scheduler.scheduleShift(position, shiftEmployeeId, date, hours);
                    break;

                case 3:
                    // Display all employees
                    scheduler.displayAllEmployees();
                    break;

                case 4:
                    // Display all schedules
                    scheduler.displayAllSchedules();
                    break;

                case 5:
                    // Update employee
                    System.out.print("Enter employee ID to update: ");
                    int updateEmployeeId = scanner.nextInt();
                    System.out.print("Enter new id: ");
                    int updateID = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String updateEmployeeName = scanner.nextLine();
                    System.out.print("Enter new gender: ");
                    String updateEmployeeGender = scanner.next();
                    System.out.print("Enter new phone number: ");
                    int updateEmployeePhone = scanner.nextInt();
                    scheduler.updateEmployee(updateEmployeeId, updateID, updateEmployeeName, updateEmployeeGender, updateEmployeePhone);
                    break;

                case 6:
                    // Delete employee
                    System.out.print("Enter employee ID to delete: ");
                    int deleteEmployeeId = scanner.nextInt();
                    scheduler.deleteEmployee(deleteEmployeeId);
                    break;

                case 7:
                    // Update shift
                    System.out.print("Enter employee ID to update shift: ");
                    int updateShiftEmployeeId = scanner.nextInt();
                    System.out.print("Enter shift index to update: ");
                    int updateShiftIndex = scanner.nextInt();
                    String updateShiftPosition = scanner.next();
                    System.out.print("Enter new hours for the shift: ");
                    int updateShiftHours = scanner.nextInt();
                    scheduler.updateShift(updateShiftEmployeeId, updateShiftIndex, updateShiftPosition, updateShiftHours);
                    break;

                case 8:
                    // Delete shift
                    System.out.print("Enter employee ID to delete shift: ");
                    int deleteShiftEmployeeId = scanner.nextInt();
                    System.out.print("Enter shift index to delete: ");
                    int deleteShiftIndex = scanner.nextInt();
                    scheduler.deleteShift(deleteShiftEmployeeId, deleteShiftIndex);
                    break;

                case 0:
                    // Exit
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}
