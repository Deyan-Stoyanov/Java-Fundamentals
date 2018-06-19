package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        String[] customersData = reader.readLine().split(";");
        String[] productsData = reader.readLine().split(";");
        if(addPeople(people, customersData) && addProducts(products, productsData)){
            buyProducts(reader, people, products);
            printPersonData(people);
        }
    }

    private static void printPersonData(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static void buyProducts(BufferedReader reader, List<Person> people, List<Product> products) throws IOException {
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];
            for (Person person : people) {
                if(person.getName().equals(personName)){
                    for (Product product : products) {
                        if(product.getName().equals(productName)){
                            try {
                                person.buyProduct(product);
                            } catch (IllegalArgumentException ie){
                                System.out.println(ie.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean addProducts(List<Product> products, String[] productsData) {
        for (String pr : productsData) {
            String name = pr.split("=")[0];
            Double money = Double.parseDouble(pr.split("=")[1]);
            try {
                Product product = new Product(name, money);
                products.add(product);
            } catch (IllegalArgumentException ie){
                System.out.println(ie.getMessage());
                return false;
            }
        }
        return true;
    }

    private static boolean addPeople(List<Person> people, String[] customers) {
        for (String customer : customers) {
            String name = customer.split("=")[0];
            Double money = Double.parseDouble(customer.split("=")[1]);
            try {
                Person person = new Person(name, money);
                people.add(person);
            } catch (IllegalArgumentException ie){
                System.out.println(ie.getMessage());
                return false;
            }
        }
        return true;
    }
}
