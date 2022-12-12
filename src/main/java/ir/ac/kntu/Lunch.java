package ir.ac.kntu;
/**
 * Filename:  Food.java
 * Description:  Project2 golestan plus plus
 *  @Author:  Atoosa Ayazbakhsh
 * @version 1.0
 * =====================================================================================
 */

/**
 * lunch Class extends Food
 */
public class Lunch extends Food{

    private Type type;
    @Override
    public PlacesFood getPlace() {
        return super.getPlace();
    }

    @Override
    public void setPlace(PlacesFood place) {
        super.setPlace(place);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public Type getType() {
        return this.type;
    }


    public void setType(Type type) {
        this.type=type;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "type=" + type +
                ", place=" + super.getPlace() +
                ", name='" + super.getName() +'\'' +
                ", price=" + super.getPrice() +
                '}';
    }
}

