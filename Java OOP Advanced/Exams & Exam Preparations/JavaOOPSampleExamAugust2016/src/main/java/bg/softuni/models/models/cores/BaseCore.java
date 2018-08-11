package bg.softuni.models.models.cores;

import bg.softuni.interfaces.Core;
import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.Stack;
import bg.softuni.models.collection.LStack;
import bg.softuni.models.enums.CoreStatus;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.util.Const;

public abstract class BaseCore implements Core {
    private String type;
    private String name;
    private Integer durability;
    private Stack<Fragment> fragments;

    public BaseCore(String type, Integer durability) {
        this.setType(type);
        this.name = String.valueOf(Const.CORE_ID++);
        this.setDurability(durability);
        this.fragments = new LStack<>();
    }

    @Override
    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    @Override
    public Integer getDurability() {
        if(this.getCurrentPressure() > 0){
            return this.durability - this.getCurrentPressure();
        }
        return this.durability;
    }

    private void setDurability(Integer durability) {
        if(durability < 0){
            throw new IllegalArgumentException(Const.ADD_CORE_ERROR_MESSAGE);
        }
        this.durability = durability;
    }

    @Override
    public Stack getFragments() {
        return this.fragments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CoreStatus getStatus(){
        int pressure = getCurrentPressure();
        if(pressure > 0){
            return CoreStatus.CRITICAL;
        }
        return CoreStatus.NORMAL;
    }

    private int getCurrentPressure() {
        int pressure = 0;
        for (Fragment fragment : this.fragments) {
            if(fragment.getType().equals(FragmentType.Cooling)){
                pressure -= fragment.getPressureAffection();
            } else {
                pressure += fragment.getPressureAffection();
            }
        }
        return pressure;
    }

    @Override
    public String toString() {
        return String.format("%nCore %s:%n" +
                "####Durability: %d%n" +
                "####Status: %s",
                this.getName(),
                this.getDurability(),
                this.getStatus().name());
    }
}
