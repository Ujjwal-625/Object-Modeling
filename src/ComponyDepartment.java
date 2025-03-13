import java.util.ArrayList;
import java.util.List;

class Employee {
    private String employeeName;
    private int employeeId;

    public Employee(String employeeName, int employeeId) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}

class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", departments=" + departments +
                '}';
    }
}

public class ComponyDepartment {
    public static void main(String[] args) {
        Company company = new Company("Tech Innovations");

        Department hrDepartment = new Department("Human Resources");
        hrDepartment.addEmployee(new Employee("Alice", 101));
        hrDepartment.addEmployee(new Employee("Bob", 102));

        Department devDepartment = new Department("Development");
        devDepartment.addEmployee(new Employee("Charlie", 201));
        devDepartment.addEmployee(new Employee("David", 202));
        devDepartment.addEmployee(new Employee("Eve", 203));

        company.addDepartment(hrDepartment);
        company.addDepartment(devDepartment);

        System.out.println(company);
    }
}