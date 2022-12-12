package ir.ac.kntu;
/**
 * Filename:  Food.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * abstract Food class
 */
abstract class  Food {
    private PlacesFood place;
    private String name;
    private double price;

    /**
     *
     * @return
     */
    public PlacesFood getPlace() {
        return place;
    }

    /**
     *
     * @param place
     */
    public void setPlace(PlacesFood place) {
        this.place = place;
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
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Food{" +
                "place=" + place +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

/**
 * enum for eating places
 */
enum PlacesFood{
    Dorm,
    Faculty
}

/**
 * enum for lunch types
 */
enum Type{
    MainCourse,
    Salad,
    Drink
}