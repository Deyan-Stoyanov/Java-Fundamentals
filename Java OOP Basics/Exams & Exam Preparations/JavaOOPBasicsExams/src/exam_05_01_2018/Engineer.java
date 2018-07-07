package exam_05_01_2018;

public abstract class Engineer extends Colonist{
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        if(this.getAge() > 30){
            return this.getTalent() + 5;
        }
        return this.getTalent() + 3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
