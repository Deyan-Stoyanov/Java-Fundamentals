package java_advanced_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Vlogger> vloggers = new HashSet<>();
        String command;
        while(!"Statistics".equalsIgnoreCase(command = reader.readLine())) {
            if(command.contains("joined The V-Logger")){
                String name = command.substring(0, command.indexOf(" "));
                Vlogger vlogger = new Vlogger(name);
                if(vloggers.stream().noneMatch(x -> x.getName().equals(name))){
                    vloggers.add(vlogger);
                }
            } else if(command.contains("followed")){
                String follower = command.substring(0, command.indexOf(" "));
                String followed = command.substring(command.lastIndexOf(" ") + 1);
                if(vloggers.stream().anyMatch(x -> x.getName().equals(followed)) && vloggers.stream().anyMatch(x -> x.getName().equals(follower))){
                    for (Vlogger vlogger : vloggers) {
                        if(vlogger.getName().equals(followed) && !vlogger.getName().equals(follower)){
                            vlogger.getFollowers().add(vloggers.stream().filter(x -> x.getName().equals(follower)).findFirst().get());
                        }
                        if(vlogger.getName().equals(follower) && !vlogger.getName().equals(followed)){
                            vlogger.getIsFollowing().add(vloggers.stream().filter(x -> x.getName().equals(followed)).findFirst().get());
                        }
                    }
                }
            }
        }
        LinkedHashSet<Vlogger> sortedVloggers = vloggers.stream()
                .sorted((x, y) -> {
                    if(Integer.compare(y.getFollowers().size(), x.getFollowers().size()) == 0){
                        return Integer.compare(x.getIsFollowing().size(), y.getIsFollowing().size());
                    }
                    return Integer.compare(y.getFollowers().size(), x.getFollowers().size());
                }).collect(Collectors.toCollection(LinkedHashSet::new));
        int i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The V-Logger has a total of %d vloggers in its logs.%n", vloggers.size()));
        for (Vlogger sv : sortedVloggers) {
            sb.append(String.format("%d. %s : %d followers, %d following%n", ++i, sv.getName(), sv.getFollowers().size(), sv.getIsFollowing().size()));
            if(i == 1 && !sv.getFollowers().isEmpty()){
                sv.getFollowers().stream()
                        .sorted(Comparator.comparing(Vlogger::getName))
                        .forEach(x -> sb.append(String.format("*  %s%n", x.getName())));
            }
        }
        System.out.println(sb.toString());
    }

    private static class Vlogger{
        private String name;
        private Set<Vlogger> followers;
        private Set<Vlogger> isFollowing;

        public Vlogger(String name) {
            this.name = name;
            this.followers = new HashSet<>();
            this.isFollowing = new HashSet<>();
        }

        public Vlogger() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Vlogger> getFollowers() {
            return followers;
        }

        public void setFollowers(Set<Vlogger> followers) {
            this.followers = followers;
        }

        public Set<Vlogger> getIsFollowing() {
            return isFollowing;
        }

        public void setIsFollowing(Set<Vlogger> isFollowing) {
            this.isFollowing = isFollowing;
        }
    }
}
