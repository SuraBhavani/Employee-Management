import dao.EmployeeDAO;
import model.Employee;

public class MainApp {

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        // Create
        Employee emp1 = new Employee("Harshita", "ECE", 45000);
        dao.saveEmployee(emp1);

        // Read
        System.out.println("Employee with ID 1: " + dao.getEmployee(1));

        // Update
        emp1.setSalary(50000);
        dao.updateEmployee(emp1);

        // List all
        dao.getAllEmployees().forEach(System.out::println);

        // Delete
        dao.deleteEmployee(1);
    }
}
