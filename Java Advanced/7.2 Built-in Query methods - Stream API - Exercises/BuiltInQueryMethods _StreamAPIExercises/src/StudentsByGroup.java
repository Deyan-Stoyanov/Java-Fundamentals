import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class StudentsByGroup {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> students = new HashSet<>();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            students.add(new Student(input[0], input[1], Integer.parseInt(input[2])));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .filter(x -> x.getGroup() == 2)
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(x -> sb.append(x.getFirstName()).append(" ").append(x.getLastName()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static class Student{
        private String firstName;
        private String lastName;
        private Integer group;

        public Student(String firstName, String lastName, Integer group) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
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

        public Integer getGroup() {
            return group;
        }

        public void setGroup(Integer group) {
            this.group = group;
        }
    }
}
