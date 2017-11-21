package ameedf.jb8223.lectures.sorting;

public class SortedCollection {
    private Sortable[] objects;
    private int size;

    public SortedCollection(int maxSize) {
        this.objects = new Sortable[maxSize];
    }

    public boolean add(Sortable newObject) {
        if (newObject == null || objects.length == size) {
            return false;
        }

        objects[size] = newObject;
        size++;
        return true;
    }

    public Sortable[] getObjects() {
        sort();
        return objects;
    }

    public int getSize() {
        return size;
    }

    private void sort() {
        for (int i = 0; i < size - 1; i++) {
            int indexOfMin = findMinIndex(i + 1);
            if (objects[i].getOrder() > objects[indexOfMin].getOrder()) {
                Sortable tmp = objects[i];
                objects[i] = objects[indexOfMin];
                objects[indexOfMin] = tmp;
            }
        }
    }

    private int findMinIndex(int fromIndex) {
        int minIndex = fromIndex;
        for (int j = fromIndex + 1; j < size; j++) {
            if (objects[j].getOrder() < objects[minIndex].getOrder()) {
                minIndex = j;
            }
        }
        return minIndex;
    }
}
