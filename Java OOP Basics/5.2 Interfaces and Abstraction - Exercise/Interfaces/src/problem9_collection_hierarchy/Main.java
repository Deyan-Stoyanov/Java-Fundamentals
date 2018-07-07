package problem9_collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddCollection addCollection = new AddCollectionsImpl();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImpl();
        MyList myList = new MyListImpl();
        List<AddCollection> addCollections = new ArrayList<>() {{
            add(addCollection);
            add(addRemoveCollection);
            add(myList);
        }};
        String[] input = reader.readLine().split("\\s+");
        int removeCount = Integer.parseInt(reader.readLine());
        for (AddCollection collection : addCollections) {
            StringBuilder sb = new StringBuilder();
            for (String s : input) {
                sb.append(collection.add(s)).append(" ");
            }
            System.out.println(sb.toString());
        }
        StringBuilder addRemoveCollectionRemoveResult = new StringBuilder();
        for (int i = 0; i < removeCount; i++) {
            addRemoveCollectionRemoveResult.append(addRemoveCollection.remove()).append(" ");
        }
        System.out.println(addRemoveCollectionRemoveResult.toString());

        StringBuilder myListRemoveResult = new StringBuilder();
        for (int i = 0; i < removeCount; i++) {
            if(myList.getUsed() >= 1){
                myListRemoveResult.append(myList.remove()).append(" ");
            }
        }
        System.out.println(myListRemoveResult.toString());
    }
}
