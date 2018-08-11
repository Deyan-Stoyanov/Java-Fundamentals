package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {
    public T min(){
        if(super.isEmpty()){
            throw new UnsupportedOperationException("List is empty.");
        }
        return super.stream().min(Comparator.comparingInt(Object::hashCode)).get();
    }

    public T max(){
        if(super.isEmpty()){
            throw new UnsupportedOperationException("List is empty.");
        }
        Iterator iterator = super.iterator();
        T startElement = (T) iterator.next();
        while(iterator.hasNext()) {
            T nextElement = (T) iterator.next();
            if(startElement.compareTo(nextElement) < 0){
                startElement = nextElement;
            }
        }
        return startElement;
    }
}
