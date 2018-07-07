package problem8_military_elite.abstract_classes;

public abstract class SpecialisedSoldier extends Soldier{
    private String corps;
    protected SpecialisedSoldier(Integer id, String firstName, String lastName, String corps) {
        super(id, firstName, lastName);
        this.setCorps(corps);
    }

    public String getCorps() {
        if(!(corps.equals("Airforces")) && !(corps.equals("Marines"))){
            throw new IllegalArgumentException();
        }
        return corps;
    }

    private void setCorps(String corps) {
        this.corps = corps;
    }
}
