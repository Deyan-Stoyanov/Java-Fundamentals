package app.Lab;

import app.Config;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        String path = Config.RESOURCES + "\\exercises\\save.txt";
        Cube cube = new Cube();
        cube.setColour("green");
        cube.setWidth(15.3D);
        cube.setHeight(12.4D);
        cube.setDepth(3D);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))){
            outputStream.writeObject(cube);
            Cube newCube = (Cube) inputStream.readObject();
            System.out.println(newCube.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Cube implements Serializable {
        private String colour;
        private double width;
        private double height;
        private double depth;

        public Cube(String colour, double width, double height, double depth) {
            this.colour = colour;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public Cube() {
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getDepth() {
            return depth;
        }

        public void setDepth(double depth) {
            this.depth = depth;
        }

        @Override
        public String toString() {
            return String.format("Colour: %s, Width: %.2f, Height: %.2f, Depth: %.2f.", this.getColour(), this.getWidth(), this.getHeight(), this.getDepth());
        }
    }
}
