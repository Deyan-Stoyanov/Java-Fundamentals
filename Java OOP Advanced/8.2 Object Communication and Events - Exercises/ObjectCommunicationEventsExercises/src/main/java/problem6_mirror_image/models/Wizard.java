package problem6_mirror_image.models;

import problem6_mirror_image.util.Const;

public class Wizard {
    private  int id;
    private String name;
    private int magicalPower;

    public Wizard(String name, int magicalPower) {
        this.id = Const.WIZARD_ID++;
        this.name = name;
        this.magicalPower = magicalPower;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagicalPower() {
        return this.magicalPower;
    }

    public void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }
}
