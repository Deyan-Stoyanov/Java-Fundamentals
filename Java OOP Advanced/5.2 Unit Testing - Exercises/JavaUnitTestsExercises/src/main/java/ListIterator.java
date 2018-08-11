import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListIterator  implements Iterator{
    private List<String> list;
    private int index;

    public ListIterator(String... list) throws OperationNotSupportedException {
        this.setList(list);
        index = 0;
    }

    private void setList(String[] list) throws OperationNotSupportedException {
        if(Arrays.stream(list).anyMatch(Objects::isNull)){
            throw new OperationNotSupportedException("No object should be null.");
        }
        this.list = Arrays.stream(list).collect(Collectors.toList());
    }

    @Override
    public boolean hasNext() {
        return index + 1 < this.list.size();
    }

    @Override
    public Object next() {
        if(this.hasNext()) {
            return this.list.get(++this.index);
        }
        return null;
    }

    public boolean move(){
        if(this.hasNext()){
            index++;
        }
        return this.hasNext();
    }

    public void print() throws OperationNotSupportedException {
        if(this.list.isEmpty()){
            throw new OperationNotSupportedException("Invalid operation!");
        }
        System.out.println(this.list.get(this.index));
    }
}