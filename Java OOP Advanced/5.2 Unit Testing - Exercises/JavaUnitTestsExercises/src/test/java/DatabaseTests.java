import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    Database database;
    @Before
    public void init() throws OperationNotSupportedException {
        Person[] array = new Person[16];
        for (int i = 0; i < 16; i++) {
            Person mockPerson = Mockito.mock(Person.class);
            array[i] = mockPerson;
        }
        database = new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldHaveExactlySixteenIntegers() throws OperationNotSupportedException {
        database = new Database(Mockito.mock(Person.class), Mockito.mock(Person.class));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addThrowsExceptionWhenDatabaseFull() throws OperationNotSupportedException {
        this.database.add(Mockito.mock(Person.class));
    }

    @Test
    public void databaseRemove() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertEquals("Remove unsuccessful", this.database.fetch().length, 15);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElementThrowsException() throws OperationNotSupportedException {
        this.database.remove();
        this.database.add(null);
    }

    @Test
    public void databaseAdd() throws OperationNotSupportedException {
        this.database.remove();
        this.database.add(Mockito.mock(Person.class));
        Assert.assertEquals("Add unsuccessful", this.database.fetch().length, 16);
    }

    @Test
    public void fetchReturnsAllElements(){
        Assert.assertEquals("Fetch unsuccessful", this.database.fetch().length, 16);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByNonExistentIdThrowsException() throws OperationNotSupportedException {
        database.findById(1L);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByNullUsernameThrowsException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
}
