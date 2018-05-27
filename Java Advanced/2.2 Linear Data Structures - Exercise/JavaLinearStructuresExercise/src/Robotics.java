import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class Robotics {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputData = reader.readLine().split(";");
        List<Robot> robots = new ArrayList<>();
        for (String s : inputData) {
            String[] robotData = s.split("-");
            Robot robot = new Robot(robotData[0], Integer.parseInt(robotData[1]));
            robots.add(robot);
        }
        int[] timeData = Arrays.stream(reader.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int hours = timeData[0];
        int minutes = timeData[1];
        int seconds = timeData[2] + 1;
        String command;
        Queue<String> items = new ArrayDeque<>();
        Deque<String> itemsLeft = new ArrayDeque<>();
        while (!"END".equalsIgnoreCase(command = reader.readLine())) {
            items.add(command);
        }
        while (true) {
            while (seconds >= 60) {
                minutes++;
                seconds -= 60;
            }
            while (minutes >= 60) {
                hours++;
                minutes -= 60;
            }
            if (items.isEmpty() && itemsLeft.isEmpty()) {
                break;
            }
            for (Robot r : robots) {
                if (Math.abs(((hours * 3600) + (minutes * 60) + seconds) - r.getStartTime()) == r.getWorkTime()) {
                    r.setProduct(null);
                    r.setStartTime(0);
                }
                if (r.getProduct() == null) {
                    if (!items.isEmpty()) {
                        String currentItem = items.remove();
                        r.setProduct(currentItem);
                        r.setStartTime((hours * 3600) + (minutes * 60) + seconds);
                        System.out.printf("%s - %s [%02d:%02d:%02d]%n", r.getName(), r.getProduct(), hours, minutes, seconds);

                        break;
                    } else if (!itemsLeft.isEmpty()) {
                        String currentItem = itemsLeft.pop();
                        r.setProduct(currentItem);
                        r.setStartTime((hours * 3600) + (minutes * 60) + seconds);
                        System.out.printf("%s - %s [%02d:%02d:%02d]%n", r.getName(), r.getProduct(), hours, minutes, seconds);
                        break;
                    }
                }
            }
            if (robots.stream().noneMatch(x -> x.getProduct() == null) && !items.isEmpty()) {
                itemsLeft.push(items.remove());
            }
            if (robots.stream().allMatch(x -> x.getProduct() == null)) {
                break;
            }
            seconds++;
        }
    }

    static class Robot {
        private String name;
        private long workTime;
        private String product;
        private int startTime;

        public Robot(String name, long workTime) {
            this.name = name;
            this.workTime = workTime;
        }

        public Robot() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getWorkTime() {
            return workTime;
        }

        public void setWorkTime(long workTime) {
            this.workTime = workTime;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }
    }
}

