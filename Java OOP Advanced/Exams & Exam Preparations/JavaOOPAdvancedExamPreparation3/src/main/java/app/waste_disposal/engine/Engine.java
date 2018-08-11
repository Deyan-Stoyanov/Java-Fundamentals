package app.waste_disposal.engine;

import app.waste_disposal.contracts.*;
import app.waste_disposal.factories.WasteFactory;
import app.waste_disposal.models.management_requirement.ManagementRequirement;

import java.io.IOException;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private GarbageProcessor processor;
    private double totalEnergy;
    private double totalCapital;
    private ManagementRequirement managementRequirement;

    public Engine(InputReader reader, OutputWriter writer, GarbageProcessor processor) {
        this.reader = reader;
        this.writer = writer;
        this.processor = processor;
        this.totalEnergy = 0;
        this.totalCapital = 0;
    }

    public void run() throws IOException {
        String command;
        while (!"TimeToRecycle".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("[\\s|]+");
            String commandName = tokens[0];
            switch (commandName) {
                case "ProcessGarbage":
                    Waste waste = WasteFactory.createWaste(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]), tokens[4]);
                    if (this.managementRequirement != null) {
                        if ((this.managementRequirement.getType() + "Garbage").equals(waste.getClass().getSimpleName()) && (this.managementRequirement.getMinCapital() > this.totalCapital || this.managementRequirement.getMinEnergy() > this.totalEnergy)) {
                            this.writer.printLine("Processing Denied!");
                            break;
                        }
                    }
                    ProcessingData data = this.processor.processWaste(waste);
                    this.totalCapital += data.getCapitalBalance();
                    this.totalEnergy += data.getEnergyBalance();
                    writer.printLine(waste.toString());
                    break;
                case "Status":
                    this.writer.printLine(String.format("Energy: %.2f Capital: %.2f", this.totalEnergy, this.totalCapital));
                    break;
                case "ChangeManagementRequirement":
                    this.managementRequirement = new ManagementRequirement(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), tokens[3]);
                    this.writer.printLine("Management requirement changed!");
                    break;
            }
        }
    }
}
