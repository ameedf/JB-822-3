package ameedf.jb8223.lectures.oop.persons;

public class PersonsApplication {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId("1");
        person.setName("Person Person");
        person.setAge(33);
        // person.setSalary(123f); -- ERROR

        Employee employee = new Employee();
        employee.setId("2"); // from Person
        employee.setName("Employee Employee"); // from Person
        employee.setAge(44); // from Person
        employee.setEmployerName("My Bad Boss");
        employee.setSalary(3233.8);

        Student student = new Student();
        student.setId("3"); // from Person
        student.setName("Student Student"); // from Person
        student.setAge(22); // from Person
        student.setCollegeName("John Bryce");
        student.setAverage(78.3f);
    }
}
