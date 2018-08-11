package bg.softuni.abstractions;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public interface Emergency {

    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();
}
