package bg.softuni.abstractions;

public interface ManagementSystem {
    String registerPropertyEmergency();

    String registerHealthEmergency();

    String registerOrderEmergency();

    String registerFireServiceCenter();

    String registerMedicalServiceCenter();

    String registerPoliceServiceCenter();

    String processEmergencies();

    String emergencyReport();

    String[] getInput();

    void setInput(String[] input);
}
