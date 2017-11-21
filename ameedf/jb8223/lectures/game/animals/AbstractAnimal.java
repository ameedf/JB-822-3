package ameedf.jb8223.lectures.game.animals;

public abstract class AbstractAnimal {
    private final String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public AnimalType getType();
}
