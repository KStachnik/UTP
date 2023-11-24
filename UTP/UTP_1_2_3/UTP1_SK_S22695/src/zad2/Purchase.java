/**
 *
 *  @author Stachnik Krystian S22695
 *
 */

package zad2;

public class Purchase {

    private String id;
    private String name;
    private String productName;
    private double price;
    private double howMany;
    private double cost;

    public Purchase(String id, String name, String productName, double price, double howMany) {
        this.id = id;
        this.name = name;
        this.productName = productName;
        this.price = price;
        this.howMany = howMany;
        this.cost = price * howMany;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getHowMany() {
        return howMany;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return  id + ";" +
                name + ";" +
                productName + ";" +
                price + ";" +
                howMany;
    }

}
