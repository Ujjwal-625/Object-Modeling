import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private String courseCode;
    private List<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.enrollCourse(this); // Maintain bidirectional association
        }
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}

class Student {
    private String studentName;
    private int studentId;
    private List<Course> enrolledCourses;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this); // Maintain bidirectional association
        }
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", students=" + students +
                '}';
    }
}

public class SchoolManagement {
    public static void main(String[] args) {
        School school = new School("City High School");

        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);
        Student student3 = new Student("Charlie", 103);

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        Course mathCourse = new Course("Mathematics", "MATH101");
        Course scienceCourse = new Course("Science", "SCI201");
        Course historyCourse = new Course("History", "HIST301");

        student1.enrollCourse(mathCourse);
        student1.enrollCourse(scienceCourse);
        student2.enrollCourse(scienceCourse);
        student2.enrollCourse(historyCourse);
        student3.enrollCourse(mathCourse);
        student3.enrollCourse(historyCourse);

        System.out.println("School: " + school.getSchoolName());
        System.out.println("Students: " + school.getStudents());

        System.out.println("\n" + student1.getStudentName() + "'s enrolled courses: " + student1.getEnrolledCourses());
        System.out.println(student2.getStudentName() + "'s enrolled courses: " + student2.getEnrolledCourses());
        System.out.println(student3.getStudentName() + "'s enrolled courses: " + student3.getEnrolledCourses());

        System.out.println("\n" + mathCourse.getCourseName() + "'s enrolled students: " + mathCourse.getEnrolledStudents());
        System.out.println(scienceCourse.getCourseName() + "'s enrolled students: " + scienceCourse.getEnrolledStudents());
        System.out.println(historyCourse.getCourseName() + "'s enrolled students: " + historyCourse.getEnrolledStudents());
    }
}