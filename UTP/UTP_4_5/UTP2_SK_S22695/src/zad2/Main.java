/**
 * @author Stachnik Krystian S22695
 */

package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
        System.out.println(purch);

        // --- tu należy dodać odpowiedni kod

        //set data
//    purch.addListener(evt ->
//      {
//        if(Objects.nonNull(evt) && evt.getPropertyName().equals("data")) {
//          System.out.println("Change value of: data from: " + evt.getOldValue().toString() + " to: " + evt.getNewValue());
//        }
//      }
//    );
        purch.addListener(
                new VetoableChangeListener() {
                    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                        if (Objects.nonNull(evt) && evt.getPropertyName().equals("data")) {
                            System.out.println("Change value of: data from: " + evt.getOldValue().toString() + " to: " + evt.getNewValue());
                        }
                    }
                }
        );

        //setPrice
//    purch.addListener(evt ->
//      {
//        if(Objects.nonNull(evt) && evt.getPropertyName().equals("price")) {
//          double price = (Double) evt.getNewValue();
//          if (price < 1000) {
//            throw new PropertyVetoException("Price change to: " + evt.getNewValue() + " not allowed", evt);
//          }
//          System.out.println("Change value of: price from: " + evt.getOldValue().toString() + " to: " + evt.getNewValue());
//        }
//      }
//    );

        purch.addListener(
                new VetoableChangeListener() {
                    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                        if (Objects.nonNull(evt) && evt.getPropertyName().equals("price")) {
                            double price = (Double) evt.getNewValue();
                            if (price < 1000) {
                                throw new PropertyVetoException("Price change to: " + evt.getNewValue() + " not allowed", evt);
                            }
                            System.out.println("Change value of: price from: " + evt.getOldValue().toString() + " to: " + evt.getNewValue());
                        }
                    }
                }
        );


        // ----------------------------------

        try {
            purch.setData("w promocji");
            purch.setPrice(2000.00);
            System.out.println(purch);

            purch.setPrice(500.00);

        } catch (PropertyVetoException exc) {
            System.out.println(exc.getMessage());
        }
        System.out.println(purch);

    }
}
