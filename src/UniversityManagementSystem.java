import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String facultyName;
    private String facultyId;

    public Faculty(String facultyName, String facultyId) {
        this.facultyName = facultyName;
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", facultyId='" + facultyId + '\'' +
                '}';
    }
}

class UniversityDepartment {
    private String departmentName;
    private List<Faculty> facultyMembers;

    public UniversityDepartment(String departmentName) {
        this.departmentName = departmentName;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFacultyMember(Faculty faculty) {
        this.facultyMembers.add(faculty);
    }

    public List<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", facultyMembers=" + facultyMembers +
                '}';
    }
}

class University {
    private String universityName;
    private List<UniversityDepartment> departments;
    private List<Faculty> facultyMembers;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(UniversityDepartment department) {
        this.departments.add(department);
    }

    public void addFacultyMember(Faculty faculty){
        this.facultyMembers.add(faculty);
    }

    public List<UniversityDepartment> getDepartments() {
        return departments;
    }

    public List<Faculty> getFacultyMembers(){
        return facultyMembers;
    }

    public String getUniversityName() {
        return universityName;
    }

    // Composition: Departments are deleted when the University is deleted.
    // (Implicitly, when the University object is no longer referenced,
    // the garbage collector will reclaim the memory, deleting the University
    // and its Departments.)

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", departments=" + departments +
                ", facultyMembers=" + facultyMembers +
                '}';
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        University university = new University("Global University");

        UniversityDepartment mathDepartment = new UniversityDepartment("Mathematics");
        UniversityDepartment csDepartment = new UniversityDepartment("Computer Science");

        university.addDepartment(mathDepartment);
        university.addDepartment(csDepartment);

        Faculty faculty1 = new Faculty("Dr. Smith", "FS101");
        Faculty faculty2 = new Faculty("Prof. Johnson", "FS202");
        Faculty faculty3 = new Faculty("Dr. Lee", "FS303");

        university.addFacultyMember(faculty1);
        university.addFacultyMember(faculty2);
        university.addFacultyMember(faculty3);

        mathDepartment.addFacultyMember(faculty1);
        csDepartment.addFacultyMember(faculty2);

        System.out.println(university);

        System.out.println("\nFaculty members in Math Department: " + mathDepartment.getFacultyMembers());
        System.out.println("Faculty members in CS Department: " + csDepartment.getFacultyMembers());
        System.out.println("All Faculty members of University: " + university.getFacultyMembers());

        // Composition: Departments are part of the University.
        // Aggregation: Faculty members can exist outside of departments and university.
        Faculty faculty4 = new Faculty("Dr. Brown", "FS404");
        System.out.println("\nIndependent Faculty: " + faculty4);

        // Simulate university deletion (in Java, by setting university to null).
        // university = null;
        // If you were to try and access mathDepartment or csDepartment here,
        // you would get a NullPointerException if you accessed them through
        // the now null university object.
    }
}