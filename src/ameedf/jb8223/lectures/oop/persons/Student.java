package ameedf.jb8223.lectures.oop.persons;

public class Student extends Person {
    private String collegeName;
    private float average;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", collegeName='" + collegeName + '\'' +
                ", average=" + average;
    }
}
