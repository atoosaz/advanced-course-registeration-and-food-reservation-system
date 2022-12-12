package ir.ac.kntu;
/**
 * Filename:  CourseGroup.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

import java.util.ArrayList;
import java.util.HashMap;
// Creating CourseGroup Class
//this Class extends Course Class
public class CourseGroup extends Course {
    //Creating properties of CourseGroup Class
    private int courseGroupNumber;
    private ArrayList<Student> attendingStudents = new ArrayList<>();
    private int sits;
    private ArrayList<Professor> teachingProfessors = new ArrayList<>();
    private int semesterNumber;
    private HashMap<String, String> schedule = new HashMap<>();

    /**
     * constructor with argument
     * @param id
     */
    public CourseGroup(int id) {
        super(id);
        schedule.put("saturday", "");
        schedule.put("sunday", "");
        schedule.put("monday", "");
        schedule.put("tuesday", "");
        schedule.put("wednesday", "");
        schedule.put("thursday", "");
        schedule.put("friday", "");
    }

    /**
     * constructor with argument
     * @param title
     */
    public CourseGroup(String title) {
        super(title);
        schedule.put("saturday", "");
        schedule.put("sunday", "");
        schedule.put("monday", "");
        schedule.put("tuesday", "");
        schedule.put("wednesday", "");
        schedule.put("thursday", "");
        schedule.put("friday", "");
    }

    /**
     * constructor with arguments
     * @param id
     * @param title
     */
    public CourseGroup(int id, String title) {
        super(id, title);
        schedule.put("saturday", "");
        schedule.put("sunday", "");
        schedule.put("monday", "");
        schedule.put("tuesday", "");
        schedule.put("wednesday", "");
        schedule.put("thursday", "");
        schedule.put("friday", "");
    }

    /**
     * getCourseGroupNumber
     * @return course Group Number
     */
    public int getCourseGroupNumber() {
        return courseGroupNumber;
    }

    /**
     * setCourseGroupNumber
     * @param courseGroupNumber
     */
    public void setCourseGroupNumber(int courseGroupNumber) {
        this.courseGroupNumber = courseGroupNumber;
    }

    /**
     *
     * @return attending Students
     */
    public ArrayList<Student> getAttendingStudents() {
        return attendingStudents;
    }

    /**
     *
     * @param attendingStudents
     */
    public void setAttendingStudents(ArrayList<Student> attendingStudents) {
        this.attendingStudents = new ArrayList<>(attendingStudents);
    }

    /**
     *
     * @return number of sits
     */
    public int getSits() {
        return sits;
    }

    /**
     *
     * @param sits
     */
    public void setSits(int sits) {
        this.sits = sits;
    }

    /**
     *
     * @return Array list of teaching Professors
     */
    public ArrayList<Professor> getTeachingProfessors() {
        return new ArrayList<>(teachingProfessors);
    }

    /**
     *
     * @param teachingProfessors
     */
    public void setTeachingProfessors(ArrayList<Professor> teachingProfessors) {
        this.teachingProfessors = teachingProfessors;
    }

    /**
     *
     * @return semester Number
     */
    public int getSemesterNumber() {
        return semesterNumber;
    }

    /**
     *
     * @param semesterNumber
     */
    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    /**
     *
     * @return Hash map of timetable
     */
    public HashMap<String, String> getSchedule() {
        return new HashMap<>(schedule);
    }

    /**
     * sets Hash map of timetable
     * @param schedule
     */
    public void setSchedule(HashMap<String, String> schedule) {
        this.schedule = new HashMap<>(schedule);
    }

    /**
     *
     * @return override of toString method
     */
    @Override
    public String toString() {
        return "CourseGroup{" +
                "Course ID="+super.getId()+
                "courseGroupNumber=" + courseGroupNumber +
                ", sits=" + sits +
                ", semesterNumber=" + semesterNumber +
                '}';
    }
}
