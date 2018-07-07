package exam_05_01_2018;

public abstract class Colonist{
    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.setId(id);
        this.setFamilyId(familyId);
        this.setTalent(talent);
        this.setAge(age);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getFamilyId() {
        return familyId;
    }

    private void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public int getTalent() {
        return talent;
    }

    private void setTalent(int talent) {
        this.talent = talent;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public abstract int getPotential();

    @Override
    public String toString() {
        return String.format("-%s: %d", this.getId(), this.getPotential());
    }

    public void age(int years){
        this.setAge(this.getAge() + years);
    }
}
