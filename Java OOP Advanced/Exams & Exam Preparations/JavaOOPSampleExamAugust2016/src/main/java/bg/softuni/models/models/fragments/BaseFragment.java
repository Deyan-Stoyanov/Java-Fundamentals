package bg.softuni.models.models.fragments;

import bg.softuni.interfaces.Fragment;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.util.Const;

public abstract class BaseFragment implements Fragment {

    private String name;
    private FragmentType type;
    private Integer pressureAffection;

    protected BaseFragment(String name, Integer pressureAffection) {
        this.setName(name);
        this.setPressureAffection(pressureAffection);
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setName(String value) {
        this.name = value;
    }

    @Override
    public FragmentType getType() {
        return this.type;
    }

    protected void setType(FragmentType value) {
        this.type = value;
    }

    @Override
    public Integer getPressureAffection () {
        return this.pressureAffection;
    }

    protected void setPressureAffection (Integer pressureAffection) {
        if(pressureAffection < 0){
            throw new IllegalArgumentException(Const.ATTACH_FRAGMENT_ERROR_MESSAGE);
        }
        this.pressureAffection = pressureAffection;
    }
}
