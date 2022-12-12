package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Filename:  Professor.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * Professor class implements User interface
 */
public class Professor implements User {

    private String name;
    private String familyName;
    private String id;
    private String password;
    private int maximumCourseUnit;
    private ArrayList<CourseGroup> obtainedCourses;

    /**
     * default constructor
     */
    public Professor() {
    }

    /**
     * constructor
     * @param name
     * @param familyName
     * @param id
     * @param password
     * @param maximumCourseUnit
     * @param obtainedCourses
     */
    public Professor(String name, String familyName, String id,
                     String password, int maximumCourseUnit,
                     ArrayList<CourseGroup> obtainedCourses) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
        this.password = password;
        this.maximumCourseUnit = maximumCourseUnit;
        this.obtainedCourses = obtainedCourses;
    }

    /**
     * login
     * @param id
     * @param password
     * @return
     */
    public String login(String id, String password) {
        if (this.id.equals(id)) {
            if (this.password.equals(password)) {
                return "login was successful!:  Professor";
            } else {
                return "login was not successful! : password is not correct";
            }
        } else {
            return "login was not successful! : id not found";
        }
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     *
     * @param familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public int getMaximumCourseUnit() {
        return maximumCourseUnit;
    }

    /**
     *
     * @param maximumCourseUnit
     */
    public void setMaximumCourseUnit(int maximumCourseUnit) {
        this.maximumCourseUnit = maximumCourseUnit;
    }

    /**
     *
     * @return
     */
    public ArrayList<CourseGroup> getObtainedCourses() {
        return new ArrayList<>(obtainedCourses);
    }

    /**
     *
     * @param obtainedCourses
     */
    public void setObtainedCourses(ArrayList<CourseGroup> obtainedCourses) {
        this.obtainedCourses = new ArrayList<>(obtainedCourses);
    }

    /**
     * print Courses
     */
    public void printCourses() {
        for (CourseGroup courseGroup : this.getObtainedCourses()) {
            System.out.println(courseGroup.toString());
        }
    }

    /**
     * print Students
     */
    public void printStudents() {
        for (CourseGroup courseGroup : this.getObtainedCourses()) {
            System.out.println("Course: " + courseGroup.getTitle());
            for (Student student : courseGroup.getAttendingStudents()) {
                System.out.println(student.toString());
            }
        }
    }

    /**
     * print Weekly Schedule
     */
    public void printWeeklySchedule() {
        int counter = 0;
        System.out.println("Sturday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {
                if (!(obtainedCourses.get(i).getSchedule().get("saturday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("saturday"));
                    counter++;
                }
            } catch (NullPointerException ex) {
                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }

        }
        if (counter == 0) {
            System.out.println("-");
        }
        counter = 0;
        System.out.println("sunday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {

                if (!(obtainedCourses.get(i).getSchedule().get("sunday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("sunday"));
                    counter++;
                }
            } catch (NullPointerException ex) {
                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }

        }
        if (counter == 0) {
            System.out.println("-");
        }
        counter = 0;
        System.out.println("monday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {

                if (!(obtainedCourses.get(i).getSchedule().get("monday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("monday"));
                    counter++;
                }
            } catch (NullPointerException ex) {
                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }

        }
        if (counter == 0) {
            System.out.println("-");
        }
        counter = 0;
        System.out.println("tuesday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {

                if (!(obtainedCourses.get(i).getSchedule().get("tuesday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("tuesday"));
                    counter++;
                }
            } catch (NullPointerException ex) {
                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("-");
        }
        counter = 0;
        System.out.println("wednesday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {


                if (!(obtainedCourses.get(i).getSchedule().get("wednesday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("wednesday"));
                    counter++;
                }
            } catch (NullPointerException ex) {

                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }

        }
        if (counter == 0) {
            System.out.println("-");
        }
        counter = 0;
        System.out.println("thursday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {

                if (!(obtainedCourses.get(i).getSchedule().get("thursday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("thursday"));
                    counter++;
                }
            } catch (NullPointerException ex) {
                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("-");
        }
        counter = 0;
        System.out.println("friday:");
        for (int i = 0; i < obtainedCourses.size(); i++) {
            try {

                if (!(obtainedCourses.get(i).getSchedule().get("friday").equals(""))) {
                    System.out.println(obtainedCourses.get(i).getTitle());
                    System.out.println(obtainedCourses.get(i).getSchedule().get("friday"));
                    counter++;
                }
            } catch (NullPointerException ex) {
                if (counter == 0) {
                    System.out.println("-");
                }
                counter++;
            }

        }
        if (counter == 0) {
            System.out.println("-");
        }
    }

    /**
     * polymorphism
     * @param student
     * @param courseGroup
     * @param grade
     */
    public void grading(Student student, CourseGroup courseGroup, int grade) {
        System.out.println(courseGroup.getTitle());
        for (Student student1 : Data.getInstance().getConfigStudent()) {
            Data.getInstance().getConfigStudent().remove(student1);
            if (student1.getId().equals(student.getId())) {
                HashMap<CourseGroup,Integer> courseGroupE=student1.getObtainedCoursesMarks();
                courseGroupE.put(courseGroup, grade);
                student1.setObtainedCoursesMarks(courseGroupE);
                ArrayList<Student> students=Data.getInstance().getConfigStudent();
                students.add(student1);
                Data.getInstance().setConfigStudent(students);
            }
        }
    }

    /**
     * polymorphism
     * @param student
     * @param id
     * @param grade
     */
    public void grading(Student student, int id, int grade) {
        CourseGroup courseGroup = Data.getInstance().searchForCourse(id);
        for (Student student1 : Data.getInstance().getConfigStudent()) {

            if (student1.getId().equals(student.getId())) {
                ArrayList<Student> students=Data.getInstance().getConfigStudent();
                students.remove(student1);
                HashMap<CourseGroup,Integer> courseGroupE=student1.getObtainedCoursesMarks();
                courseGroupE.put(courseGroup, grade);
                student1.setObtainedCoursesMarks(courseGroupE);
                students.add(student1);
                Data.getInstance().setConfigStudent(students);

            }
        }

    }

    /**
     * print Grades
     */
    public void printGrades() {
        for (Student student1 : Data.getInstance().getConfigStudent()) {
            for (CourseGroup courseGroup : student1.getObtainedCourses()) {
                if (student1.getObtainedCoursesMarks().get(courseGroup) == -1) {
                    System.out.println("Student:" + student1.getFamilyName() +
                            " Course:" + courseGroup.getTitle() +
                            " Grade: not graded yet"
                    );
                } else {
                    System.out.println("Student:" + student1.getFamilyName() +
                            " Course:" + courseGroup.getTitle() +
                            " Grade: " + student1.getObtainedCoursesMarks().get(courseGroup)
                    );
                }
            }
        }
    }
}
