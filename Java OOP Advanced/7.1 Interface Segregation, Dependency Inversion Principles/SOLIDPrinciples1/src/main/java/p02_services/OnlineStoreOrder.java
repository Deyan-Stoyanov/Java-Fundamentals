package p02_services;

public class OnlineStoreOrder {

    private NotificationService[] notificationServices;

    public OnlineStoreOrder(NotificationService... services) {
        this.notificationServices = services;
    }

    public void process() {
        for (NotificationService service : notificationServices) {
            if(service.isActive()){
                service.sendNotification();
            }
        }
    }
}
