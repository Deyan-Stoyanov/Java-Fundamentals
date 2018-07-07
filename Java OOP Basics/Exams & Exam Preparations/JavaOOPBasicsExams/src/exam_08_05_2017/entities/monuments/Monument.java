package exam_08_05_2017.entities.monuments;

public abstract class Monument {

    private String name;

    public Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public abstract int getAffinity();

    @Override
    public String toString() {
        return super.toString();
    }
}
