package ir.ac.kntu;
/**
 * Filename:  OnlineClass.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * OnlineClass is a child of CourseGroup Class and implements ClassMode interface
 */
public class OnlineClass extends CourseGroup implements ClassMode {
    static private int attenders;
    static private int maxAttender = 100;

    public OnlineClass(int id) {
        super(id);
    }

    public OnlineClass(String title) {
        super(title);
    }

    public OnlineClass(int id, String title) {
        super(id, title);
    }

    @Override
    public Integer getMaxAttenders() {
        return maxAttender;
    }

    @Override
    public void setMaxAttenders(Integer max) {
        this.maxAttender = max;
    }

    public static int getAttenders() {
        return attenders;
    }

    public static void setAttenders(int attenders) {
        OnlineClass.attenders = attenders;
    }

    @Override
    public void checkAttenders() {
        attenders = 0;
        for (CourseGroup courseGroup : Data.getInstance().getConfigCourses()) {
            if (courseGroup instanceof OnlineClass) {
                attenders = attenders + courseGroup.getAttendingStudents().size();
            }
        }

    }
}
