package shopping_spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private Double money;
    private List<Product> products;

    public Person() {
        this.products = new ArrayList<>();
    }

    public Person(String name, Double money) {
        this();
        this.setName(name);
        this.setMoney(money);
    }

    public Person(String name, Double money, List<Product> products) {
        this(name, money);
        this.products = products;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    public void buyProduct(Product product){
        if(this.getMoney() < product.getCost()){
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
        this.products.add(product);
        this.setMoney(this.getMoney() - product.getCost());
        System.out.println(String.format("%s bought %s", this.getName(), product.getName()));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ");
        if(this.products.isEmpty()){
            sb.append("Nothing bought");
        } else {
            this.getProducts().forEach(x -> sb.append(x.getName()).append(", "));
        }
        if(sb.toString().contains(",")){
            sb.delete(sb.lastIndexOf(","), sb.length());
        }
        return sb.toString();
    }
}
