package exam_08_03_2017;

public abstract class Animal {
    private static final String DEFAULT_INITIAL_CLEANSING_STATUS = "UNCLEANSED";
    private String name;
    private int age;
    private String cleansingStatus;
    private String adoptionCenterName;
    private boolean castrated;

    protected Animal(String name, int age, String adoptionCenterName) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = DEFAULT_INITIAL_CLEANSING_STATUS;
        this.adoptionCenterName = adoptionCenterName;
        castrated = false;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    private void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public void changeStatus(){
        this.cleansingStatus = "CLEANSED";
    }

    public String getAdoptionCenterName() {
        return adoptionCenterName;
    }

    private void setAdoptionCenterName(String adoptionCenterName) {
        this.adoptionCenterName = adoptionCenterName;
    }

    public boolean isCastrated() {
        return castrated;
    }

    private void setCastrated(boolean castrated) {
        this.castrated = castrated;
    }

    public void castrate(){
        this.castrated = true;
    }
}
