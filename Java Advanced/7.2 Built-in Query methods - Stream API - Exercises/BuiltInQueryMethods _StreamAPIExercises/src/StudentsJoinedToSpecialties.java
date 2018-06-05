import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> students = new LinkedHashSet<>();
        Set<Specialty> specialties = new LinkedHashSet<>();
        String command;
        while(!"Students:".equalsIgnoreCase(command = reader.readLine())) {
            String[] input  = command.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String s : input) {
                if(!s.matches("[0-9]+")){
                    sb.append(s).append(" ");
                }
            }
            sb.delete(sb.length() - 1, sb.length());
            specialties.add(new Specialty(sb.toString(), input[input.length - 1]));
        }
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] input  = command.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < input.length; i++) {
                sb.append(input[i]).append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            students.add(new Student(sb.toString(), input[0]));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .filter(x -> specialties.stream().anyMatch(y -> y.getFacultyNumber().equalsIgnoreCase(x.getFacultyNumber())))
                .sorted(Comparator.comparing(Student::getName))
                .forEach(x -> {
                    List<String> specialtiesOfStudent =  specialties.stream()
                            .filter(y -> y.getFacultyNumber().equalsIgnoreCase(x.getFacultyNumber()))
                            .map(y -> y.name)
                            .collect(Collectors.toCollection(ArrayList::new));
                    for (String s : specialtiesOfStudent) {
                        sb.append(x.getName()).append(" ").append(x.getFacultyNumber()).append(" ").append(s).append(System.lineSeparator());
                    }
                });
        System.out.println(sb.toString());
    }

    private static class Student{
        private String name;
        private String facultyNumber;

        public Student(String name, String facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }

        public Student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }

        public void setFacultyNumber(String facultyNumber) {
            this.facultyNumber = facultyNumber;
        }
    }

    private static class Specialty{
        private String name;
        private String facultyNumber;

        public Specialty(String name, String facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }

        public Specialty() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFacultyNumber() {
            return facultyNumber;
        }

        public void setFacultyNumber(String facultyNumber) {
            this.facultyNumber = facultyNumber;
        }

    }
}

