package ameedf.jb8223.lectures.sorting;

public class SortingApplication {
    public static void main(String[] args) {
        SortedCollection collection = new SortedCollection(3);
        System.out.println("Collection size: " + collection.getSize());

        collection.add(new Employee("Daniel", 700));
        System.out.println("Collection size: " + collection.getSize());

        collection.add(new MyNumber(2));
        System.out.println("Collection size: " + collection.getSize());

        // collection.add(new User("Bob"));
        collection.add(new MyNumber(10));
        System.out.println("Collection size: " + collection.getSize());

        collection.add(new Employee("Won't enter", 103));
        System.out.println("Collection size: " + collection.getSize());

        final Sortable[] objects = collection.getObjects();
        for (Sortable object : objects) {
            System.out.println(object);
        }
    }
}
