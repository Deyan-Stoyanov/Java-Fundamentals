package p02_services;

public class Main {
    public static void main(String[] args) {
        OnlineStoreOrder storeOrder = new OnlineStoreOrder(new SmsNotificationService(true), new EmailNotificationService(true));
        storeOrder.process();
    }
}
