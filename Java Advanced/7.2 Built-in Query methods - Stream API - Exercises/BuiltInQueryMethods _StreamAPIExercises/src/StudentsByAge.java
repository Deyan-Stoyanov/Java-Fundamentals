import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class StudentsByAge {
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
                .filter(x -> x.getAge() <= 24 && x.getAge() >= 18)
                .forEach(x -> sb.append(x.getFirstName()).append(" ").append(x.getLastName()).append(" ").append(x.getAge()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static class Student{
        private String firstName;
        private String lastName;
        private Integer age;

        public Student(String firstName, String lastName, Integer age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
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

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
