package bg.softuni.models.emergencies;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

public class PublicOrderEmergency extends BaseEmergency {
    private boolean isSpecialCase;

    public PublicOrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, boolean isSpecialCase) {
        super(description, emergencyLevel, registrationTime);
        this.isSpecialCase = isSpecialCase;
    }

    public boolean isSpecialCase() {
        return this.isSpecialCase;
    }

    public void setSpecialCase(boolean specialCase) {
        isSpecialCase = specialCase;
    }
}
