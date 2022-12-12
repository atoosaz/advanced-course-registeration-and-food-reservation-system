package ir.ac.kntu;

import java.util.ArrayList;

/**
 * Filename:  Data.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */



/**
 * Creating Data Class
 * This class in singleton
 */
public class Data {
    // Singleton class
    private static Data singleInstance = null;
    private ArrayList<Student> configStudent = new ArrayList<>();
    private ArrayList<Professor> configProfessor = new ArrayList<>();
    private ArrayList<CourseGroup> configCourses = new ArrayList<>();
    private ArrayList<Lunch> lunches=new ArrayList<>();
    private ArrayList<Breakfast> breakfasts=new ArrayList<>();

    /**
     *Singleton options
     */
    private Data() {
        ArrayList<Student> configStudent = new ArrayList<>();
        ArrayList<Professor> configProfessor = new ArrayList<>();
        ArrayList<CourseGroup> configCourses = new ArrayList<>();
    }

    /**
     * singleton instance
     * @return
     */
    public static Data getInstance() {
        if (singleInstance == null) {
            singleInstance = new Data();
        }

        return singleInstance;
    }

    /**
     * getter Array list of Students
     * @return
     */
    public ArrayList<Student> getConfigStudent() {
        return new ArrayList<>(configStudent);
    }

    /**
     *
     * @param configStudent
     */
    public void setConfigStudent(ArrayList<Student> configStudent) {
        this.configStudent = new ArrayList<>(configStudent);

    }

    /**
     * getter for Array of professors
     * @return
     */
    public ArrayList<Professor> getConfigProfessor() {
        return new ArrayList<>(configProfessor);
    }

    /**
     *
     * @param configProfessor
     */
    public void setConfigProfessor(ArrayList<Professor> configProfessor) {

        this.configProfessor = new ArrayList<>(configProfessor);

    }

    /**
     * getter of Arraylist of Courses
     * @return
     */
    public ArrayList<CourseGroup> getConfigCourses() {
        return new ArrayList<>(configCourses);
    }

    /**
     *
     * @param configCourses
     */
    public void setConfigCourses(ArrayList<CourseGroup> configCourses) {

        this.configCourses = new ArrayList<>(configCourses);

    }

    /**
     * search courses with id
     * @param id
     * @return
     */
    public CourseGroup searchForCourse(int id){
        for (CourseGroup courseGroup:Data.getInstance().getConfigCourses()){
            if (courseGroup.getId()==id){
                return courseGroup;
            }
        }
        return null;
    }

    /**
     * search Students with id
     * @param id
     * @return
     */
    public Student searchForStudent(String id){
        for (Student student:Data.getInstance().getConfigStudent()){
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    /**
     * search Professors with id
     * @param id
     * @return
     */
    public Professor searchForProfessor(String id){
        for (Professor professor:Data.getInstance().getConfigProfessor()){
            if (professor.getId().equals(id)){
                return professor;
            }
        }
        return null;
    }

    /**
     * getter for lunch
     * @return
     */
    public ArrayList<Lunch> getLunches() {
        return new ArrayList<>(lunches);
    }

    /**
     *
     * @param lunches
     */
    public void setLunches(ArrayList<Lunch> lunches) {
        this.lunches = new ArrayList<>(lunches);
    }

    /**
     * getter for food
     * @return
     */
    public ArrayList<Breakfast> getBreakfasts() {
        return new ArrayList<>(breakfasts);
    }

    /**
     *
     * @param breakfasts
     */
    public void setBreakfasts(ArrayList<Breakfast> breakfasts) {
        this.breakfasts = new ArrayList<>(breakfasts);
    }
}
