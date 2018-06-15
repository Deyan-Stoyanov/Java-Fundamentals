package family_tree;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name;
    private String birthDate;
    private Set<Person> parents;
    private Set<Person> children;

    public Person() {
        this.name = "";
        this.birthDate = "";
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
    }

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
    }

    public Person(String name, String birthDate, Set<Person> parents, Set<Person> children) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = parents;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Person> getParents() {
        return parents;
    }

    public void setParents(Set<Person> parents) {
        this.parents = parents;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public void setChildren(Set<Person> children) {
        this.children = children;
    }
}
