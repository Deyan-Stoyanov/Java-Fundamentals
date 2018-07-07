package exam_08_03_2017;

public class Cat extends Animal {
    private int intelligenceCoeficient;

    public Cat(String name, int age, int intelligenceCoeficient, String adoptionCenterName) {
        super(name, age, adoptionCenterName);
        this.intelligenceCoeficient = intelligenceCoeficient;
    }

    public int getIntelligenceCoeficient() {
        return intelligenceCoeficient;
    }

    private void setIntelligenceCoeficient(int intelligenceCoeficient) {
        this.intelligenceCoeficient = intelligenceCoeficient;
    }
}
