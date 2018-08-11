package bg.softuni.abstractions;

import java.util.Set;

public interface EmergencyCenter {
    String getName();
    Integer getAmountOfMaximumEmergencies();
    Boolean isForRetirement();

    Set<Emergency> getEmergencies();

    void addEmergency(Emergency emergency);

    void removeEmergency(Emergency emergency);
}
