package exam_preparation_1.factories;

import exam_preparation_1.entities.Cluster;

public final class ClusterFactory {

    private ClusterFactory(){ }

    public static Cluster createCluster(String clusterId, int rows, int cols){
        return new Cluster(clusterId ,rows, cols);
    }
}
