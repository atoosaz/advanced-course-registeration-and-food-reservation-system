package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Filename:  Student.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * Creating Student Class that implements User interface
 */
public class Student implements User {

    private String name;
    private String familyName;
    private String id;
    private String password;
    final static private int MAXIMUM_UNIT = 20;
    private int courseNumbers;
    private ArrayList<CourseGroup> obtainedCourses = new ArrayList<>();
    private HashMap<CourseGroup, Integer> obtainedCoursesMarks = new HashMap<>();
    private boolean loginSuccess;
    private ArrayList<Food> foods = new ArrayList<>();

    /**
     * default constructor
     */
    public Student() {
        this.courseNumbers = 0;
    }

    /**
     * constructor
     * @param name
     * @param familyName
     * @param id
     * @param password
     * @param obtainedCourses
     */
    public Student(String name, String familyName, String id,
                   String password, ArrayList<CourseGroup> obtainedCourses) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
        this.password = password;
        this.obtainedCourses = obtainedCourses;
        for (int i = 0; i < obtainedCourses.size(); i++) {
            this.obtainedCoursesMarks.put(this.obtainedCourses.get(i), -1);
        }
        this.courseNumbers = 0;
    }

    /**
     * update
     */
    public void update() {
        for (int i = 0; i < obtainedCourses.size(); i++) {
            if (!obtainedCoursesMarks.containsKey(obtainedCourses.get(i)) ||
                    obtainedCoursesMarks.get(obtainedCourses.get(i)) > -1) {
                this.obtainedCoursesMarks.put(this.obtainedCourses.get(i), -1);
            }
        }
        courseNumbers = obtainedCourses.size();
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
                loginSuccess = true;
                return "login was successful!: login as a Student";
            } else {
                loginSuccess = false;
                return "login was not successful! : password is not correct";
            }
        } else {
            loginSuccess = false;
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
        if (loginSuccess) {
            return password;
        } else {
            System.out.println("Access denied");
            return ("Access denied");
        }
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
     * @param obtainedCoursesMarks
     */
    public void setObtainedCoursesMarks(HashMap<CourseGroup, Integer> obtainedCoursesMarks) {
        this.obtainedCoursesMarks = new HashMap<>(obtainedCoursesMarks);
    }

    /**
     *
     * @return
     */
    public HashMap<CourseGroup, Integer> getObtainedCoursesMarks() {
        return new HashMap<>(obtainedCoursesMarks);
    }

    /**
     *
     * @return
     */
    public ArrayList<CourseGroup> getObtainedCourses() {
        return new ArrayList<CourseGroup>(obtainedCourses);
    }

    /**
     *
     * @param obtainedCourses
     */
    public void setObtainedCourses(ArrayList<CourseGroup> obtainedCourses) {
        if (obtainedCourses.size() <= MAXIMUM_UNIT) {
            this.obtainedCourses = new ArrayList<CourseGroup>(obtainedCourses);
            changeCourseNumber();
        } else {
            System.out.println("Error: you have exceeded the maximum course unit for a student:" +
                    "max is = " + MAXIMUM_UNIT);

        }

    }

    /**
     *
     * @return
     */
    public int getCourseNumbers() {
        return courseNumbers;
    }

    /**
     *
     * @param courseNumbers
     */
    public void setCourseNumbers(int courseNumbers) {
        this.courseNumbers = courseNumbers;
    }

    /**
     *
     * @return
     */
    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    /**
     *
     * @param loginSuccess
     */
    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    /**
     * changr course number
     */
    public void changeCourseNumber() {
        courseNumbers = obtainedCourses.size();
    }

    /**
     *
     * @param course
     */
    public void addingCourse(CourseGroup course) {
        if (!course.checkPrerequisites(this)) {
            System.out.println("Course prerequisites does not match");
        } else if (courseNumbers >= 20) {
            System.out.println("you have exceeded the maximum course unit for a student");
        } else {
            obtainedCourses.add(course);
            courseNumbers++;
            System.out.println("Class added");


        }
        update();
    }

    /**
     * print weekly schedule
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
     * print transcript
     */
    public void printTranscript() {
        for (int i = 0; i < obtainedCoursesMarks.size(); i++) {
            if (!(obtainedCoursesMarks.get(obtainedCourses.get(i)) == -1)) {
                System.out.println("Course: " + obtainedCourses.get(i) + " : " +
                        obtainedCoursesMarks.get(obtainedCourses.get(i)));
            } else {
                System.out.println("Course: " + obtainedCourses.get(i) + " : " +
                        "not graded yet");
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", courseNumbers=" + courseNumbers +
                '}';
    }

    /**
     *
     * @param id
     */
    public void removeCourse(int id) {
        for (CourseGroup courseGroup : obtainedCourses) {
            if (id == courseGroup.getId()) {
                obtainedCourses.remove(courseGroup);
                obtainedCoursesMarks.remove(courseGroup);
            }
        }
    }

    /**
     * print courses
     */
    public void printCourses() {
        for (CourseGroup courseGroup : this.getObtainedCourses()) {
            System.out.println(courseGroup.toString());
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    /**
     *
     * @param foods
     */
    public void setFoods(ArrayList<Food> foods) {
        this.foods = new ArrayList<>(foods);
    }
}
