package exam_05_01_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private List<Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.setMaxFamilyCount(maxFamilyCount);
        this.setMaxFamilyCapacity(maxFamilyCapacity);
        this.families = new ArrayList<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    private void setMaxFamilyCount(int maxFamilyCount) {
        this.maxFamilyCount = maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }

    private void setMaxFamilyCapacity(int maxFamilyCapacity) {
        this.maxFamilyCapacity = maxFamilyCapacity;
    }

    public void addFamily(Family family) {
        this.families.add(family);
    }

    public List<Family> getFamilies() {
        return Collections.unmodifiableList(this.families);
    }

    private void setFamilies(List<Family> families) {
        this.families = families;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        for (Family family : families) {
            if (family.getId().equals(familyId)) {
                return family.getColonists().stream().sorted(Comparator.comparing(Colonist::getId)).collect(Collectors.toCollection(ArrayList::new));
            }
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addColonist(Colonist colonist) {
        if (this.families.stream().noneMatch(x -> x.getId().equals(colonist.getFamilyId()))) {
            if (this.maxFamilyCount == this.families.size()) {
                throw new IllegalArgumentException("colony is full");
            }
            Family family = new Family(colonist.getFamilyId());
            family.addColonist(colonist);
            this.addFamily(family);
        } else if (this.families.stream().filter(x -> x.getId().equals(colonist.getFamilyId())).findFirst().get().getColonists().size() < this.getMaxFamilyCapacity()) {
            this.families.stream().filter(x -> x.getId().equals(colonist.getFamilyId())).findFirst().get().addColonist(colonist);
        } else {
            throw new IllegalArgumentException("family is full");
        }
    }

    public void removeColonist(String familyId, String memberId) {
        if (this.families.stream().anyMatch(x -> x.getId().equals(familyId))) {
            this.families.stream().filter(x -> x.getId().equals(familyId)).findFirst().get().removeColonist(memberId);
            if (this.families.stream().filter(x -> x.getId().equals(familyId)).findFirst().get().getColonists().isEmpty()) {
                this.removeFamily(familyId);
            }
        }
    }

    public void removeFamily(String id) {
        this.families.removeIf(x -> x.getId().equals(id));
    }

    public void grow(int years) {
        this.families.forEach(x -> x.getColonists().forEach(y -> y.age(years)));
    }

    public int getPotential() {
        return this.families
                .stream()
                .mapToInt(y -> y.getColonists()
                        .stream()
                        .mapToInt(Colonist::getPotential)
                        .sum())
                .sum();
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount));
        this.families.stream().sorted(Comparator.comparing(Family::getId)).forEach(x -> sb.append(String.format("%n-%s: %d/%d", x.getId(), x.getColonists().size(), this.maxFamilyCapacity)));
        return sb.toString();
    }

    public String getFamily(String familyId) {
        if(this.families.stream().noneMatch(x -> x.getId().equals(familyId))){
            return "family does not exist";
        }
        return this.families.stream().filter(x -> x.getId().equals(familyId)).findFirst().get().toString();
    }
}
