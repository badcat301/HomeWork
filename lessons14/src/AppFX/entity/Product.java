package AppFX.entity;

/**
 * Created by adm on 15.06.2017.
 */
public class Product {
    private String name;
    private String discription;
    private String type;
    private int price;

    public Product(String name, String discription, String type, int price) {
        this.name = name;
        this.discription = discription;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
