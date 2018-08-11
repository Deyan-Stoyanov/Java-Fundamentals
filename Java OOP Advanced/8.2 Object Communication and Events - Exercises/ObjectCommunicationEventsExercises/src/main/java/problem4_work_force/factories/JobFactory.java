package problem4_work_force.factories;

import problem4_work_force.abstractions.Employee;
import problem4_work_force.models.Job;

import java.lang.reflect.InvocationTargetException;

public class JobFactory {
    public static Job createJob(String name, int hours, Employee employee) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Job) Class.forName("problem4_work_force.models.Job").getConstructor(String.class, int.class, Employee.class).newInstance(name, hours, employee);
    }
}
