package ameedf.jb8223.lectures.oop.persons;

public class Employee extends Person {
    private String employerName;
    private double salary;

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", employerName='" + employerName + '\'' +
                ", salary=" + salary;
    }
}
