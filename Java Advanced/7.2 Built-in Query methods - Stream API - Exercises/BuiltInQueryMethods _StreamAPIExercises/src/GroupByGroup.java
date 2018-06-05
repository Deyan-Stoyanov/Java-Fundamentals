import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> students = new LinkedHashSet<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            students.add(new Student(input[0], input[1], Integer.parseInt(input[2])));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup)).forEach((x, y) -> {
                    sb.append(x).append(" - ");
                    y.forEach(a -> sb.append(a.toString()).append(", "));
                    if(sb.length() != 0){
                        sb.delete(sb.length() - 2, sb.length());
                    }
                    sb.append(System.lineSeparator());
        });
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

        @Override
        public String toString() {
            return this.getFirstName() + " " + this.getLastName();
        }
    }
}
