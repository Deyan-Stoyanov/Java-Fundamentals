package problem4_work_force.factories;

import problem4_work_force.abstractions.Employee;

import java.lang.reflect.InvocationTargetException;

public class EmployeeFactory {
    public static Employee createEmployee(String type, String name) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Employee) Class.forName("problem4_work_force.models." + type).getConstructor(String.class).newInstance(name);
    }
}
