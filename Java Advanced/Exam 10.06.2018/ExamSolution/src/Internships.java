import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Internships {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());
        Deque<String> problems = new ArrayDeque<>();
        Queue<String> candidates = new ArrayDeque<>();
        for (int i = 0; i < problemsCount; i++) {
            problems.push(reader.readLine());
        }
        for (int i = 0; i < candidatesCount; i++) {
            String currentCandidate = reader.readLine();
            if (currentCandidate.matches("[A-Z][a-z]+\\s[A-Z][a-z]+")) {
                candidates.offer(currentCandidate);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!problems.isEmpty() && !candidates.isEmpty()) {
            String problem = problems.poll();
            String candidate = candidates.remove();
            if (candidates.isEmpty()) {
                sb.append(candidate).append(" gets the job!").append(System.lineSeparator());
                break;
            }
            int problemCharSum = 0;
            int candidateCharSum = 0;
            for (int i = 0; i < problem.length(); i++) {
                problemCharSum += problem.charAt(i);
            }
            for (int i = 0; i < candidate.length(); i++) {
                candidateCharSum += candidate.charAt(i);
            }
            if (candidateCharSum > problemCharSum) {
                sb.append(candidate).append(" solved ").append(problem).append(".").append(System.lineSeparator());
                candidates.offer(candidate);
            } else {
                sb.append(candidate).append(" failed ").append(problem).append(".").append(System.lineSeparator());
                problems.offer(problem);
            }
        }
        while (!candidates.isEmpty()) {
            sb.append(candidates.remove()).append(", ");
        }
        if (sb.toString().contains(",")) {
            sb.delete(sb.lastIndexOf(","), sb.length());
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}