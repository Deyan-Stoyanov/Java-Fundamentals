package lab_2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Integer age;
    private List<BankAccount> bankAccounts;

    public Person() {
    }

    public Person(String name, Integer age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, Integer age, List<BankAccount> bankAccounts) {
        this.name = name;
        this.age = age;
        this.bankAccounts = bankAccounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public double getBalance(){
        return this.bankAccounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}
