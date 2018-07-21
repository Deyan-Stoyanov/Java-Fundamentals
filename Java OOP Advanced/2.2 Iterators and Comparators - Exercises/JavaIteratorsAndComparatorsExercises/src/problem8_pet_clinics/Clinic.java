package problem8_pet_clinics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Clinic{
    private String name;
    private int numberOfRooms;
    private Pet[] rooms;

    public Clinic(String name, int numberOfRooms) {
        this.setName(name);
        this.setNumberOfRooms(numberOfRooms);
        this.rooms = new Pet[numberOfRooms];
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }

    private void setNumberOfRooms(int numberOfRooms) {
        if(numberOfRooms % 2 == 0){
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        this.numberOfRooms = numberOfRooms;
    }

    public boolean add(Pet pet){
        if(this.hasMoreRooms()){
            if(this.rooms[getNumberOfRooms() / 2] == null){
                this.rooms[getNumberOfRooms() / 2] = pet;
            } else {
                for (int i = 0; i < this.getNumberOfRooms() / 2; i++) {
                    if(this.rooms[getNumberOfRooms() / 2 - i - 1] == null) {
                        this.rooms[getNumberOfRooms() / 2 - i - 1] = pet;
                        break;
                    } else if(this.rooms[getNumberOfRooms() / 2 + i + 1] == null) {
                        this.rooms[getNumberOfRooms() / 2 + i + 1] = pet;
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean release(){
        for (int i = 0; i < this.getNumberOfRooms() / 2; i++) {
            if(this.rooms[getNumberOfRooms() / 2 - i] != null) {
                this.rooms[getNumberOfRooms() / 2 - i] = null;
                return true;
            } else if(this.rooms[getNumberOfRooms() / 2 + i + 1] != null) {
                this.rooms[getNumberOfRooms() / 2 + i + 1] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasMoreRooms(){
        if(Arrays.stream(this.rooms).noneMatch(Objects::isNull)){
            return false;
        }
        return true;
    }

    public void print(int index){
        if(this.rooms[index - 1] == null){
            System.out.println("Room empty");
        } else {
            System.out.println(this.rooms[index - 1].toString());
        }
    }
    
    public void print(){
        for (int i = 1; i <= this.getNumberOfRooms(); i++) {
            this.print(i);
        }
    }
}
