import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Student> students = new LinkedHashSet<>();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            students.add(new Student(input[0], input[1]));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .sorted((x, y) -> {
            if(x.getLastName().compareTo(y.getLastName()) == 0){
                return y.getFirstName().compareTo(x.getFirstName());
            }
            return x.getLastName().compareTo(y.getLastName());
        }).forEach(x -> sb.append(x.getFirstName()).append(" ").append(x.getLastName()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static class Student{
        private String firstName;
        private String lastName;

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
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
    }
}
