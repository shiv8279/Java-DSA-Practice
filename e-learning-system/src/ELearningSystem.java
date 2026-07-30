import java.util.*;

/**
 * Console-based E-Learning System demonstrating core Java and OOP concepts.
 * Features role-based access for Admin and Student users, course creation,
 * enrollment, progress tracking, and course listing.
 */
public class ELearningSystem {

    static abstract class User {
        private final int id;
        private final String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public abstract String getRole();
    }

    static class Admin extends User {
        Admin(int id, String name) { super(id, name); }
        @Override public String getRole() { return "ADMIN"; }
    }

    static class Student extends User {
        private final Map<Integer, Integer> progressByCourse = new HashMap<>();

        Student(int id, String name) { super(id, name); }
        @Override public String getRole() { return "STUDENT"; }

        void enroll(int courseId) { progressByCourse.putIfAbsent(courseId, 0); }
        boolean isEnrolled(int courseId) { return progressByCourse.containsKey(courseId); }
        void updateProgress(int courseId, int progress) { progressByCourse.put(courseId, progress); }
        int getProgress(int courseId) { return progressByCourse.getOrDefault(courseId, 0); }
        Set<Integer> getEnrolledCourseIds() { return progressByCourse.keySet(); }
    }

    static class Course {
        private final int id;
        private final String title;
        private final String instructor;

        Course(int id, String title, String instructor) {
            this.id = id;
            this.title = title;
            this.instructor = instructor;
        }

        int getId() { return id; }
        String getTitle() { return title; }
        String getInstructor() { return instructor; }

        @Override
        public String toString() {
            return id + ". " + title + " | Instructor: " + instructor;
        }
    }

    static class LearningService {
        private final Map<Integer, Course> courses = new LinkedHashMap<>();
        private int nextCourseId = 1;

        Course addCourse(String title, String instructor) {
            Course course = new Course(nextCourseId++, title, instructor);
            courses.put(course.getId(), course);
            return course;
        }

        Collection<Course> getCourses() { return courses.values(); }
        Course getCourse(int id) { return courses.get(id); }

        boolean enroll(Student student, int courseId) {
            if (!courses.containsKey(courseId)) return false;
            student.enroll(courseId);
            return true;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final LearningService service = new LearningService();
    private static final Admin admin = new Admin(1, "Administrator");
    private static final Student student = new Student(2, "Student User");

    public static void main(String[] args) {
        seedCourses();
        System.out.println("=== E-Learning System ===");

        while (true) {
            System.out.println("\nSelect role: 1. Admin  2. Student  0. Exit");
            int choice = readInt();
            if (choice == 0) break;
            if (choice == 1) adminMenu();
            else if (choice == 2) studentMenu();
            else System.out.println("Invalid choice.");
        }
        System.out.println("Thank you for using the E-Learning System.");
    }

    private static void seedCourses() {
        service.addCourse("Java Programming", "Shiv Upadhyay");
        service.addCourse("Data Structures & Algorithms", "Course Faculty");
    }

    private static void adminMenu() {
        System.out.println("\nLogged in as " + admin.getRole());
        while (true) {
            System.out.println("1. Add course  2. List courses  0. Back");
            int choice = readInt();
            if (choice == 0) return;
            if (choice == 1) {
                System.out.print("Course title: ");
                String title = scanner.nextLine().trim();
                System.out.print("Instructor: ");
                String instructor = scanner.nextLine().trim();
                Course course = service.addCourse(title, instructor);
                System.out.println("Created: " + course);
            } else if (choice == 2) {
                listCourses();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void studentMenu() {
        System.out.println("\nLogged in as " + student.getRole());
        while (true) {
            System.out.println("1. List courses  2. Enroll  3. Update progress  4. My learning  0. Back");
            int choice = readInt();
            if (choice == 0) return;
            switch (choice) {
                case 1 -> listCourses();
                case 2 -> enrollStudent();
                case 3 -> updateProgress();
                case 4 -> showLearning();
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : service.getCourses()) System.out.println(course);
    }

    private static void enrollStudent() {
        listCourses();
        System.out.print("Enter course ID: ");
        int id = readInt();
        if (service.enroll(student, id)) System.out.println("Enrollment successful.");
        else System.out.println("Course not found.");
    }

    private static void updateProgress() {
        System.out.print("Course ID: ");
        int id = readInt();
        if (!student.isEnrolled(id)) {
            System.out.println("Enroll in this course first.");
            return;
        }
        System.out.print("Progress (0-100): ");
        int progress = readInt();
        if (progress < 0 || progress > 100) {
            System.out.println("Progress must be between 0 and 100.");
            return;
        }
        student.updateProgress(id, progress);
        System.out.println("Progress updated.");
    }

    private static void showLearning() {
        if (student.getEnrolledCourseIds().isEmpty()) {
            System.out.println("No enrolled courses yet.");
            return;
        }
        System.out.println("\nMy Learning:");
        for (int id : student.getEnrolledCourseIds()) {
            Course course = service.getCourse(id);
            System.out.println(course.getTitle() + " - " + student.getProgress(id) + "% complete");
        }
    }

    private static int readInt() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
