package ir.ac.kntu;

import java.util.ArrayList;
/**
 * Filename:  Course.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * Creating Couarse Class
 */
public class Course {
    private int id;
    private String title;
    private ArrayList<Course> prerequisites = new ArrayList();

    /**
     * default constructor
     */
    public Course() {
    }

    /**
     * constructor
     * @param title
     */
    public Course(String title) {
        this.title = title;
    }

    /**
     * constructor
     * @param id
     */
    public Course(int id) {
        this.id = id;
    }

    /**
     * constructor
     * @param id
     * @param title
     */

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     *
     * @param student
     * @return
     */
    public boolean checkPrerequisites(Student student) {
        int counter = 0;
        for (int i = 0; i < student.getObtainedCourses().size(); i++) {
            for (int j = 0; j < prerequisites.size(); j++) {
                if (student.getObtainedCourses().get(i).getId() == this.prerequisites.get(j).id) {
                    counter++;
                }
            }


        }
        if (counter == prerequisites.size()) {
            return true;
        }
        return false;

    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public ArrayList<Course> getPrerequisites() {
        return new ArrayList<Course>(prerequisites);
    }

    /**
     *
     * @param prerequisites
     */
    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = new ArrayList<Course>(prerequisites);
    }

}
