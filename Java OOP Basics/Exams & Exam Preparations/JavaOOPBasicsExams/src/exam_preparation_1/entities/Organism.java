package exam_preparation_1.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.setName(name);
        this.setClusters(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    private void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    public Cluster getCurrentCluster() {
        return this.clusters.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ").append(this.getName()).append(System.lineSeparator());
        sb.append("--Clusters: ").append(this.getClusters().size()).append(System.lineSeparator());
        int cellsCount = 0;
        for (Cluster cluster : this.clusters) {
            for (int i = 0; i < cluster.getRows(); i++) {
                for (int j = 0; j < cluster.getCols(); j++) {
                    if(cluster.getCells()[i][j] != null){
                        cellsCount++;
                    }
                }
            }
        }
        sb.append("--Cells: ").append(cellsCount);
        for (Cluster cluster : this.clusters) {
            sb.append(cluster.toString());
        }
        return sb.toString();
    }
}
