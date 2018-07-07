package problem9_collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionsImpl implements AddCollection {
    private List<String> list;
    public AddCollectionsImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add(String s) {
        this.list.add(s);
        return this.list.indexOf(s);
    }
}
