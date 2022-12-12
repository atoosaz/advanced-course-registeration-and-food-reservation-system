package ir.ac.kntu;
/**
 * Filename:  ClassicClass.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * ClassicClass is a child of CourseGroup Class and implements ClassMode interface
 */
public class ClassicClass extends CourseGroup implements ClassMode {
    private int attenders;
    private Places place;
    private int maxAttender = 20;

    public ClassicClass(int id) {
        super(id);
    }

    public ClassicClass(String title) {
        super(title);
    }

    public ClassicClass(int id, String title) {
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

    @Override
    public void checkAttenders() {
        attenders = super.getAttendingStudents().size();
    }

    public int getAttenders() {
        return attenders;
    }

    public void setAttenders(int attenders) {
        this.attenders = attenders;
    }

    public Places getPlace() {
        return place;
    }

    public void setPlace(Places place) {
        this.place = place;
    }

}

/**
 * enum for places
 */
enum Places {
    class101,
    class102,
    class103,
    roof,
    basement
}