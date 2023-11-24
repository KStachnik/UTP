/**
 *
 *  @author Stachnik Krystian S22695
 *
 */

package zad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CustomersPurchaseSortFind {

    private ArrayList<Purchase> customers;

    public void readFile(String file_name) {
        try (Stream<String> stream = Files.lines(Paths.get(file_name))) {
           customers = (ArrayList<Purchase>)stream
                    .map(line -> line.split(";"))
                    .map(parts -> new Purchase(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4])) )
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSortedBy(String sortBy) {
        switch (sortBy) {
            case "Nazwiska":
                System.out.println("Nazwiska");
                customers.stream()
                    .sorted(Comparator.comparing(Purchase::getName).thenComparing(Purchase::getId))
                    .forEach(System.out::println);
                System.out.println();
                break;
            case "Koszty":
                System.out.println("Koszty");
                customers.stream()
                    .sorted(Comparator.comparingDouble(Purchase::getCost).reversed().thenComparing(Purchase::getId))
                    .forEach(customer -> System.out.println(customer + "(koszt: " + (customer.getCost()) + ")"));
                System.out.println();
                break;
            default:
                System.out.println("Unknown: " + sortBy);
                return;
        }
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .forEach(System.out::println);
        System.out.println();
    }

}
