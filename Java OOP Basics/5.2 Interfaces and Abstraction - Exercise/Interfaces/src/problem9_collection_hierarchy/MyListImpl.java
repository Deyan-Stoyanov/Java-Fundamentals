package problem9_collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl implements MyList {
    private List<String> list;
    private int used;

    public MyListImpl() {
        this.list = new ArrayList<>();
        this.used = this.list.size();
    }

    @Override
    public String remove() {
        return this.list.remove(0);
    }

    @Override
    public int add(String s) {
        this.list.add(0, s);
        return this.list.indexOf(s);
    }

    @Override
    public int getUsed() {
        this.setUsed();
        return this.used;
    }

    private void setUsed() {
        this.used = this.list.size();
    }
}
