package problem8_military_elite;

import problem8_military_elite.abstract_classes.Soldier;
import problem8_military_elite.implementations.*;
import problem8_military_elite.units.Mission;
import problem8_military_elite.units.Repair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        List<Private> privates = new ArrayList<>();
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] soldierData = command.split("\\s+");
            try{
                switch (soldierData[0]){
                    case "Private":
                        Private priv = new Private(Integer.parseInt(soldierData[1]), soldierData[2], soldierData[3], Double.parseDouble(soldierData[4]));
                        privates.add(priv);
                        System.out.println(priv);
                        break;
                    case "LeutenantGeneral":
                        LeutenantGeneral leutenantGeneral = new LeutenantGeneral(Integer.parseInt(soldierData[1]), soldierData[2], soldierData[3], Double.parseDouble(soldierData[4]));
                        for (int i = 5; i < soldierData.length; i++) {
                            int id = Integer.parseInt(soldierData[i]);
                            if(privates.stream().anyMatch(x -> x.getId().equals(id))){
                                privates.stream().filter(x -> x.getId().equals(id)).limit(1).forEach(leutenantGeneral::addSoldier);
                            }
                        }
                        System.out.println(leutenantGeneral);
                        break;
                    case "Engineer":
                        Engineer engineer = new Engineer(Integer.parseInt(soldierData[1]), soldierData[2], soldierData[3], Double.parseDouble(soldierData[4]), soldierData[5]);
                        for (int i = 6; i < soldierData.length; i += 2) {
                            Repair repair = new Repair(soldierData[i], Integer.parseInt(soldierData[i + 1]));
                            engineer.addRepair(repair);
                        }
                        System.out.println(engineer);
                        break;
                    case "Commando":
                        Commando commando = new Commando(Integer.parseInt(soldierData[1]), soldierData[2], soldierData[3], Double.parseDouble(soldierData[4]), soldierData[5]);
                        for (int i = 6; i < soldierData.length; i += 2) {
                            try {
                                Mission mission = new Mission(soldierData[i], soldierData[i + 1]);
                                commando.addMission(mission);
                            }catch (IllegalArgumentException ignored){}
                        }
                        System.out.println(commando);
                        break;
                    case "Spy":
                        Spy spy = new Spy(Integer.parseInt(soldierData[1]), soldierData[2], soldierData[3], soldierData[4]);
                        System.out.println(spy);

                        break;
                }
            }catch (IllegalArgumentException ignored){}

        }
    }
}
