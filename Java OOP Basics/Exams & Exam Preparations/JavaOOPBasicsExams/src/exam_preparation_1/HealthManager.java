package exam_preparation_1;

import exam_preparation_1.entities.*;
import exam_preparation_1.entities.cells.abstractions.Cell;
import exam_preparation_1.factories.CellFactory;
import exam_preparation_1.factories.ClusterFactory;
import exam_preparation_1.factories.OrganismFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return null;
    }

    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        }
        organisms.put(name, OrganismFactory.createOrganism(name));
        return "Created organism " + name;
    }


    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName)) {
            if (this.organisms.get(organismName).getClusters().stream().noneMatch(x -> x.getId().equals(id))) {
                this.organisms.get(organismName).addCluster(ClusterFactory.createCluster(id, rows, cols));
                return String.format("Organism %s: Created cluster %s", organismName, id);
            }
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (this.organisms.containsKey(organismName)) {
            for (Cluster c : organisms.get(organismName).getClusters()) {
                if (c.getId().equals(clusterId)) {
                    Cell cell = CellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
                    if (cell != null) {
                        try {
                            c.addCell(cell, positionRow, positionCol);
                            return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
        return null;
    }

    public String activateCluster(String organismName) {
        if (!organisms.containsKey(organismName)) {
            return null;
        }
        if (organisms.get(organismName).getClusters().isEmpty()) {
            return null;
        }
        Cluster cluster = this.organisms.get(organismName).getCurrentCluster();
        cluster.activate();
        this.organisms.get(organismName).addCluster(cluster);
        return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, cluster.getId(), cluster.getCellLeft());
    }
}
