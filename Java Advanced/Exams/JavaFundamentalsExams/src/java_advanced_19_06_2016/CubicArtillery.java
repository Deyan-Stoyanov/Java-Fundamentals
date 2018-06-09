package java_advanced_19_06_2016;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Queue<Pair<String, Queue<Integer>>>
        Queue<Bunker> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int capacity = Integer.parseInt(reader.readLine());
        String command;
        while(!"Bunker Revision".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(" ");
            for (String s : input) {
                if(!s.matches("[0-9]+")){
                    Bunker bunker = new Bunker(s);
                    queue.offer(bunker);
                } else {
                    int w = Integer.parseInt(s);
                    if(!queue.isEmpty()){
                        Bunker bunker = queue.remove();
                        if(queue.isEmpty()){
                            while (!bunker.getWeapons().isEmpty() && bunker.getContaints() + w > capacity){
                                bunker.getWeapons().remove();
                            }
                            bunker.getWeapons().offer(w);
                            queue.offer(bunker);
                        }
                        else {
                            while (true){
                                if (bunker.getContaints() + w > capacity) {
                                    sb.append(bunker.getName()).append(" -> ");
                                    if(bunker.getWeapons().isEmpty()){
                                        sb.append("Empty");
                                    } else {
                                        while (!bunker.getWeapons().isEmpty()) {
                                            sb.append(bunker.getWeapons().remove()).append(", ");
                                        }
                                        sb.delete(sb.lastIndexOf(","), sb.length());
                                    }
                                    sb.append(System.lineSeparator());
                                    if(queue.isEmpty()){
                                        break;
                                    } else {
                                        bunker = queue.remove();
                                    }
                                } else {
                                    bunker.getWeapons().offer(w);
                                    ((ArrayDeque<Bunker>) queue).push(bunker);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static class Bunker{
        private String name;
        private Queue<Integer> weapons;

        public Bunker(String name) {
            this.name = name;
            this.weapons = new ArrayDeque<>();
        }

        public Bunker() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Queue<Integer> getWeapons() {
            return weapons;
        }

        public void setWeapons(Queue<Integer> weapons) {
            this.weapons = weapons;
        }

        public long getContaints(){
            return this.getWeapons().stream().mapToInt(Integer::valueOf).sum();
        }
    }
}
