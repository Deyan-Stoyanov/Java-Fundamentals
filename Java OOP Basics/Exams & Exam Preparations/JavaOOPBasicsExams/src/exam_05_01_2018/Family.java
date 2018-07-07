package exam_05_01_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Family {
    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.setId(id);
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public List<Colonist> getColonists() {
        return Collections.unmodifiableList(this.colonists);
    }

    private void setColonists(List<Colonist> colonists) {
        this.colonists = colonists;
    }

    public void addColonist(Colonist colonist) {
        this.colonists.add(colonist);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId()).append(":");
        this.getColonists().stream().sorted(Comparator.comparing(Colonist::getId)).forEach(z -> sb.append(System.lineSeparator()).append(z.toString()));
        return sb.toString();
    }

    public void removeColonist(String id) {
        this.colonists.removeIf(x -> x.getId().equals(id));
    }
}
