package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Filename:  Admin.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * admin class implements user interface
 */
public class Admin implements User {
    private static String username = "admin";
    private static String password = "admin";
    private boolean loginSuccess;

    public Admin() {

    }

    /**
     * login
     * @param user
     * @param password
     * @return
     */
    public String login(String user, String password) {
        if (username.equals(user)) {
            if (this.password.equals(password)) {
                loginSuccess = true;
                return "login was successful!: login as admin";

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
     * @param courseGroup
     */
    public void changeSits(CourseGroup courseGroup) {

        for (int i = 0; i < Data.getInstance().getConfigCourses().size(); i++) {
            if (Data.getInstance().getConfigCourses().get(i).getId() == courseGroup.getId()) {
                Data.getInstance().getConfigCourses().get(i).setSits(Data.getInstance().getConfigCourses().
                        get(i).getSits() - 1);
            }

        }


    }

    /**
     * Prerequisite Error
     */
    public void checkCoursesStudent() {

        for (int i = 0; i < Data.getInstance().getConfigStudent().size(); i++) {


            for (int j = 0; j < Data.getInstance().getConfigStudent().get(i).getObtainedCourses().size(); j++) {

                if (!Data.getInstance().getConfigStudent().get(i).getObtainedCourses().
                        get(j).checkPrerequisites(Data.getInstance().getConfigStudent().get(i))) {
                    System.out.println("[Prerequisite Error] Student:" + Data.getInstance().getConfigStudent()
                            .get(i) + " Course:"
                            + Data.getInstance().getConfigStudent()
                            .get(i).getObtainedCourses().get(j));

                }


            }

        }


    }

    /**
     * check Time Conflict
     * @param student
     * @param course
     * @return
     */
    public boolean checkTimeConflict(Student student, CourseGroup course) {

        for (int j = 0; j < student.getObtainedCourses().size(); j++) {
            if(!course.getSchedule().get("saturday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("saturday").equals("")){
                if (course.getSchedule().get("saturday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("saturday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("sunday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("sunday").equals("")){
                if (course.getSchedule().get("sunday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("sunday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("monday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("monday").equals("")){
                if (course.getSchedule().get("monday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("monday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("tuesday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("tuesday").equals("")){
                if (course.getSchedule().get("tuesday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("tuesday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("wednesday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("wednesday").equals("")){
                if (course.getSchedule().get("wednesday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("wednesday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("thursday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("thursday").equals("")){
                if (course.getSchedule().get("thursday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("thursday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("friday").equals("") && !student.getObtainedCourses().
                    get(j).getSchedule().get("friday").equals("")){
                if (course.getSchedule().get("friday").equals(student.getObtainedCourses().
                        get(j).getSchedule().get("friday"))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * update max sits
     */
    public void checkMaxSits() {

        for (int i = 0; i < Data.getInstance().getConfigCourses().size(); i++) {
            if (Data.getInstance().getConfigCourses().get(i).getSits() < 0) {
                System.out.println("[Courselimit Error] course:" + Data.getInstance().getConfigCourses().get(i) +
                        " Exceeded Number of Students:" +
                        (Data.getInstance().getConfigCourses().get(i).getSits() * -1));
            }
        }

    }

    /**
     *  check Duplication
     * @param student
     * @param courseGroup
     * @return
     */
    public boolean checkDuplication(Student student, CourseGroup courseGroup) {
        student.update();
        for (int j = 0; j < student.getObtainedCourses().size(); j++) {
            if (student.getObtainedCourses().get(j).getId() == courseGroup.getId()) {
                if (student.getObtainedCoursesMarks().get(courseGroup) >= 10 ||
                        (student.getObtainedCoursesMarks().get(courseGroup) == -1)) {
                    System.out.println("[CourseDuplication Error] " +
                            " Student" + student.getName() +
                            "course:" + courseGroup.getTitle());

                    return true;
                }
            }

        }
        return false;

    }

    /**
     * check time errors
     * @param professor
     * @param course
     * @return
     */
    public boolean checkTimeConflict(Professor professor, CourseGroup course) {

        for (int j = 0; j < professor.getObtainedCourses().size(); j++) {
            if(!course.getSchedule().get("saturday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("saturday").equals("")){
                if (course.getSchedule().get("saturday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("saturday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("sunday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("sunday").equals("")){
                if (course.getSchedule().get("sunday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("sunday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("monday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("monday").equals("")){
                if (course.getSchedule().get("monday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("monday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("tuesday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("tuesday").equals("")){
                if (course.getSchedule().get("tuesday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("tuesday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("wednesday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("wednesday").equals("")){
                if (course.getSchedule().get("wednesday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("wednesday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("thursday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("thursday").equals("")){
                if (course.getSchedule().get("thursday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("thursday"))){
                    return true;
                }
            }
            if(!course.getSchedule().get("friday").equals("") && !professor.getObtainedCourses().
                    get(j).getSchedule().get("friday").equals("")){
                if (course.getSchedule().get("friday").equals(professor.getObtainedCourses().
                        get(j).getSchedule().get("friday"))){
                    return true;
                }
            }

        }
        return false;


    }

    /**
     *
     * @return
     */
    public String getUsername() {

        return username;

    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        if (loginSuccess) {
            this.username = username;
        } else {
            System.out.println("Access denied");
        }
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
        if (loginSuccess) {
            this.password = password;
        } else {
            System.out.println("Access denied");
        }
    }

    /**
     * update database
     */
    public void syncCourses() {
        for (int i = 0; i < Data.getInstance().getConfigStudent().size(); i++) {
            for (int j = 0; j < Data.getInstance().getConfigStudent().get(i).getObtainedCourses().size(); j++) {
                int index = Data.getInstance().getConfigCourses().indexOf(Data.getInstance().
                        getConfigStudent().get(i).getObtainedCourses().get(j));
                ArrayList<Student> students = new ArrayList<>();
                try {
                    students = Data.getInstance().getConfigCourses().get(index).getAttendingStudents();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(Data.getInstance().getConfigStudent().get(i).getObtainedCourses().get(j).getTitle());
                }
                students.add(Data.getInstance().getConfigStudent().get(i));
                Data.getInstance().getConfigCourses().get(index).setAttendingStudents(students);
            }
        }
        for (int i = 0; i < Data.getInstance().getConfigProfessor().size(); i++) {
            for (int j = 0; j < Data.getInstance().getConfigProfessor().get(i).getObtainedCourses().size(); j++) {
                int index = Data.getInstance().getConfigCourses().indexOf(Data.getInstance().
                        getConfigProfessor().get(i).getObtainedCourses().get(j));
                ArrayList<Professor> professor = new ArrayList<>();
                professor = Data.getInstance().getConfigCourses().get(index).getTeachingProfessors();
                professor.add(Data.getInstance().getConfigProfessor().get(i));
                Data.getInstance().getConfigCourses().get(index).setTeachingProfessors(professor);
            }
        }

    }

    /**
     * remove student
     * @param id
     */
    public void removeStudent(String id) {
        for (Student stu : Data.getInstance().getConfigStudent()) {
            if (stu.getId().equals(id)) {
                for (CourseGroup courseGroup : stu.getObtainedCourses()) {
                    for (CourseGroup cgp : Data.getInstance().getConfigCourses()) {
                        if (courseGroup.equals(cgp)) {
                            cgp.setSits(cgp.getSits() + 1);

                        }
                    }
                }
                ArrayList<Student> students = Data.getInstance().getConfigStudent();
                students.remove(stu);
                Data.getInstance().setConfigStudent(students);
            }
        }
    }

    /**
     * remove professor
     * @param id
     */
    public void removeProfessor(String id) {
        for (Professor stu : Data.getInstance().getConfigProfessor()) {
            if (stu.getId().equals(id)) {

                Data.getInstance().getConfigProfessor().remove(stu);
            }
        }
    }

    /**
     * remove class
     * @param id
     */
    public void removeClass(String id) {
        for (CourseGroup courseGroup : Data.getInstance().getConfigCourses()) {
            if (courseGroup.getId() == Integer.parseInt(id)) {
                for (Student student : Data.getInstance().getConfigStudent()) {
                    for (CourseGroup courseGroup1 : Data.getInstance().getConfigCourses()) {
                        if (courseGroup.getId() == courseGroup1.getId()) {
                            student.getObtainedCourses().remove(courseGroup);
                        }
                    }
                }
                Data.getInstance().getConfigCourses().remove(courseGroup);
            }
        }
    }

}
