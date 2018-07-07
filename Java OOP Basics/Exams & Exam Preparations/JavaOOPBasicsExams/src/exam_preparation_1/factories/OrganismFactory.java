package exam_preparation_1.factories;

import exam_preparation_1.entities.Organism;

public final class OrganismFactory {
    private OrganismFactory(){}

    public static Organism createOrganism(String name){
        return new Organism(name);
    }
}
