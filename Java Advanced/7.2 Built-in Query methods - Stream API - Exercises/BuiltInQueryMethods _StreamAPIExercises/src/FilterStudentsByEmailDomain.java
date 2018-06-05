import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> students = new LinkedHashSet<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            students.add(new Student(input[0], input[1], input[2]));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .filter(x -> x.email.endsWith("@gmail.com"))
                .forEach(x -> sb.append(x.getFirstName()).append(" ").append(x.getLastName()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static class Student{
        private String firstName;
        private String lastName;
        private String email;

        public Student(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
