package p04_recharge;

public class Main {
    public static void main(String[] args) {
        RechargeStation station = new RechargeStation();
        Worker r = new Robot("asd", 3);
        Worker w = new Employee("asd");
        station.recharge((Rechargeable) r);
    }
}
