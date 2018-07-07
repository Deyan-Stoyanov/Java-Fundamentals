package exam_05_01_2018;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int bonus = 0;
        if(this.getAge() > 15){
            bonus += 1;
        }
        if(this.getSign().equals("caring")){
            bonus += 1;
        } else if(this.getSign().equals("careless")){
            bonus -= 2;
        }
        return super.getPotential() + bonus;
    }
}
