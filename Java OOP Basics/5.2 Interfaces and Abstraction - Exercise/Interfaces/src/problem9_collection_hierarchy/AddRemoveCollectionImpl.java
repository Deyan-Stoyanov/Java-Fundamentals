package problem9_collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollectionImpl implements AddRemoveCollection{
    private List<String> list;

    public AddRemoveCollectionImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public String remove() {
        return this.list.remove(this.list.size() - 1);
    }

    @Override
    public int add(String s) {
        this.list.add(0, s);
        return this.list.indexOf(s);
    }
}
