package problem8_military_elite.units;

public class Mission {
    private String code;
    private String state;


    public Mission() {
    }

    public Mission(String code, String state) {
        this.code = code;
        this.setState(state);
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }

    public void completeMission(){
        this.state = "Finished";
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setState(String state) {
        if(!(state.equals("inProgress")) && !(state.equals("Finished"))){
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCode(), this.getState());
    }
}
