package ameedf.jb8223.lectures.sorting;

public class Employee extends Person implements Sortable {
    private int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public int getOrder() {
        return salary;
    }
}
