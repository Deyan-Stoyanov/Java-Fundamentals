import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Database<T> {
    private T[] objects;

    public Database(T... t) throws OperationNotSupportedException {
        this.setObjects(t);
    }

    private void setObjects(T... objects) throws OperationNotSupportedException {
        if(objects.length != 16){
            throw new OperationNotSupportedException("Capacity must be 16");
        }
        this.objects = objects;
    }

    public void add(T i) throws OperationNotSupportedException {
        if(i == null){
            throw new OperationNotSupportedException("Element should not be null");
        } else if(Arrays.stream(this.objects).noneMatch(Objects::isNull)){
            throw new OperationNotSupportedException("Database is full");
        }
        for (int j = 0; j < objects.length; j++) {
            if(objects[j] == null){
                objects[j] = i;
                break;
            }
        }
    }

    public void remove() throws OperationNotSupportedException {
        if(Arrays.stream(objects).noneMatch(Objects::nonNull)){
            throw new OperationNotSupportedException("Database is empty");
        }
        for (int j = this.objects.length - 1; j >= 0; j--) {
            if(this.objects[j] != null){
                this.objects[j] = null;
                break;
            }
        }
    }

    public T[] fetch(){
        return (T[]) Arrays.stream(this.objects).filter(Objects::nonNull).toArray();
    }

    public T findById(Long id) throws OperationNotSupportedException {
        if(id == null){
            throw new OperationNotSupportedException("Id must not be null.");
        }
        Optional<Person> person = Arrays.stream(this.objects).map(x -> (Person)x).filter(x -> x.getId().equals(id)).findFirst();
        if(!person.isPresent()){
            throw new OperationNotSupportedException("Person with id " + id + " not found.");
        }
        return (T) person.get();
    }

    public T findByUsername(String username) throws OperationNotSupportedException {
        if(username == null){
            throw new OperationNotSupportedException("Username must not be null.");
        }
        Optional<Person> person = Arrays.stream(this.objects).map(x -> (Person)x).filter(x -> x.getUsername().equals(username)).findFirst();
        if(!person.isPresent()){
            throw new OperationNotSupportedException("Person with username " + username + " not found.");
        }
        return (T) person.get();
    }
}
