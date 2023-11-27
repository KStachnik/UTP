/**
 *
 *  @author Stachnik Krystian S22695
 *
 */

package zad2;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class Purchase {
    private final VetoableChangeSupport veto = new VetoableChangeSupport(Purchase.class);
    private String prod;
    private String data;
    private Double price;

    public Purchase(String prod, String date, Double price) {
        this.prod = prod;
        this.data = date;
        this.price = price;
    }
    public void addListener(VetoableChangeListener listener){
        veto.addVetoableChangeListener(listener);
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getData() {
        return data;
    }

    synchronized public void setData(String data) throws PropertyVetoException {
        veto.fireVetoableChange("data", this.data, data);
        this.data = data;
    }

    public Double getPrice() {
        return price;
    }

    synchronized public void setPrice(Double price) throws PropertyVetoException {
        veto.fireVetoableChange("price", this.price, price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchase " +
                "[prod=" + prod +
                ", data=" + data +
                ", price=" + price +"]";
    }

}
