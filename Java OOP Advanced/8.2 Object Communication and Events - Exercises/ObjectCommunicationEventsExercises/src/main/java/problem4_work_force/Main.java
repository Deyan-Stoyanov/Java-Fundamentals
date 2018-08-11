package problem4_work_force;

import problem4_work_force.abstractions.Command;
import problem4_work_force.abstractions.Employee;
import problem4_work_force.commands.*;
import problem4_work_force.models.Job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Employee> employees = new LinkedHashMap<>();
        Map<String, Job> jobs = new LinkedHashMap<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("\\s+");
            Command commandToExecute = null;
            switch (tokens[0]){
                case "StandartEmployee":
                case "PartTimeEmployee":
                    commandToExecute = new CreateEmployeeCommand(tokens[0], tokens[1], employees);
                    break;
                case "Job":
                    commandToExecute = new CreateJobCommand(tokens[1], Integer.parseInt(tokens[2]), tokens[3], employees, jobs);
                    break;
                case "Pass":
                    commandToExecute = new PassCommand(jobs);
                    break;
                case "Status":
                    commandToExecute = new StatusCommand(jobs);
                    break;
            }
            if(commandToExecute != null){
                CommandExecutor.executeCommand(commandToExecute);
            }
        }

    }
}
