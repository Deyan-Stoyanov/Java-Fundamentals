package bg.softuni.models.models.fragments;


import bg.softuni.models.enums.FragmentType;

public class CoolingFragment extends BaseFragment {
    public CoolingFragment(String name, Integer pressureAffection) {
        super(name, pressureAffection);
        this.setType(FragmentType.Cooling);
    }

    @Override
    protected void setPressureAffection(Integer value) {
        super.setPressureAffection(value * 3);
    }
}
