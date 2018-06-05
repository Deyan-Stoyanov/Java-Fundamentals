import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gems = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        Map<String, BiFunction<List<Integer>, Integer, Set<Integer>>> commands = new HashMap<>();
        Set<Integer> numbersToRemove = new HashSet<>();
        String command;
        while(!"Forge".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("[;]");
            BiFunction<List<Integer>, Integer, Set<Integer>> currentFunction;
            switch (input[0]){
                case "Exclude":
                    switch (input[1]){
                        case "Sum Left":
                            currentFunction = (list, integer) -> {
                                int leftSum = 0;
                                HashSet<Integer> nums = new HashSet<>();
                                for (int i = 0; i < list.size(); i++) {
                                    leftSum += list.get(i);
                                    if(i - 1 >= 0){
                                        leftSum += (list.get(i - 1));
                                    }
                                    if(leftSum == integer){
                                        nums.add(i);
                                    }
                                    leftSum = 0;
                                }
                                return nums;
                            };
                            commands.putIfAbsent(command.substring(command.indexOf(";")), currentFunction);
                            break;
                        case "Sum Right":
                            currentFunction = (list, integer) -> {
                                int rightSum = 0;
                                HashSet<Integer> nums = new HashSet<>();
                                for (int i = 0; i < list.size(); i++) {
                                    rightSum += list.get(i);
                                    if(i + 1 < list.size()){
                                        rightSum += list.get(i + 1);
                                    }
                                    if(rightSum == integer){
                                        nums.add(i);
                                    }
                                    rightSum = 0;
                                }
                                return nums;
                            };
                            commands.putIfAbsent(command.substring(command.indexOf(";")), currentFunction);
                            break;
                        case "Sum Left Right":
                            currentFunction = (list, integer) -> {
                                int leftRightSum = 0;
                                HashSet<Integer> nums = new HashSet<>();
                                for (int i = 0; i < list.size(); i++) {
                                    leftRightSum += list.get(i);
                                    if(i - 1 >= 0){
                                        leftRightSum += list.get(i - 1);
                                    }
                                    if(i + 1 < list.size()){
                                        leftRightSum += list.get(i + 1);
                                    }
                                    if(leftRightSum == integer){
                                        nums.add(i);
                                    }
                                    leftRightSum = 0;
                                }
                                return nums;
                            };
                            commands.putIfAbsent(command.substring(command.indexOf(";")), currentFunction);
                            break;
                    }
                    break;
                case "Reverse":
                    String finalCommand = command.substring(command.indexOf(";"));
                    commands.entrySet().removeIf(x -> x.getKey().equalsIgnoreCase(finalCommand));
                    break;
            }
        }
        for (Map.Entry<String, BiFunction<List<Integer>, Integer, Set<Integer>>> entry : commands.entrySet()) {
            numbersToRemove.addAll(entry.getValue().apply(gems, Integer.parseInt(entry.getKey().substring(entry.getKey().lastIndexOf(";") + 1))));
        }
        gems.removeIf(x -> numbersToRemove.contains(gems.indexOf(x)));
        StringBuilder sb = new StringBuilder();
        for (Integer gem : gems) {
            sb.append(gem).append(" ");
        }
        System.out.println(sb.toString());
    }
}
