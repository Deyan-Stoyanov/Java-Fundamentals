import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> students = new LinkedHashSet<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            List<Integer> grades = Arrays.stream(input).filter(x -> x.matches("[0-9]")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
            students.add(new Student(input[0], input[1], grades));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .filter(x -> x.getGrades().stream().anyMatch(grade -> grade == 6))
                .forEach(x -> sb.append(x.getFirstName()).append(" ").append(x.getLastName()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static class Student{
        private String firstName;
        private String lastName;
        private List<Integer> grades;

        public Student(String firstName, String lastName, List<Integer> grades) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grades = grades;
        }

        public Student() {
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public void setGrades(List<Integer> grades) {
            this.grades = grades;
        }
    }
}
