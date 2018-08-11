package P04_DetailPrinter;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employee employee : employees) {
            print(employee);
        }
    }

    private void print(Employee employee){
        System.out.println(employee.toString());
    }
}
