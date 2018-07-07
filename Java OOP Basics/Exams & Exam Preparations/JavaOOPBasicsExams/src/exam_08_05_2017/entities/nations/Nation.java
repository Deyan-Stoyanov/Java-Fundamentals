package exam_08_05_2017.entities.nations;

import exam_08_05_2017.entities.benders.Bender;
import exam_08_05_2017.entities.monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nation {
    private String type;
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(String type) {
        this.type = type;
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    public List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    private void setBenders(List<Bender> benders) {
        this.benders = benders;
    }

    public List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    private void setMonuments(List<Monument> monuments) {
        this.monuments = monuments;
    }

    public double getTotalBenderPower(){
        return this.benders.stream().mapToDouble(Bender::getTotalPower).sum();
    }

    public int getTotalMonumentPower(){
        return this.monuments.stream().mapToInt(Monument::getAffinity).sum();
    }

    public double getTotalNationPower(){
        return this.getTotalBenderPower() + ((this.getTotalBenderPower() / 100) * this.getTotalMonumentPower());
    }

    public void addBender(Bender bender){
        this.benders.add(bender);
    }

    public void addMonument(Monument monument){
        this.monuments.add(monument);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getType()).append(" Nation").append(System.lineSeparator()).append("Benders:");
        if(this.getBenders().isEmpty()){
            sb.append(" None");
        } else {
            this.getBenders().forEach(x -> sb.append(System.lineSeparator()).append(x.toString()));
        }
        sb.append(System.lineSeparator()).append("Monuments:");
        if(this.getMonuments().isEmpty()){
            sb.append(" None");
        } else {
            this.getMonuments().forEach(x -> sb.append(System.lineSeparator()).append(x.toString()));
        }
        return sb.toString();
    }

    public void erase(){
        this.setBenders(new ArrayList<>());
        this.setMonuments(new ArrayList<>());
    }
}
