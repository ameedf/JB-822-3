package ameedf.jb8223.lectures.sorting;

public class MyNumber implements Sortable {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public void add(int otherNumber) {
        this.number += otherNumber;
    }

    @Override
    public int getOrder() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
