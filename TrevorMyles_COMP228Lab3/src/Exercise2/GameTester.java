package Exercise2;

public abstract class GameTester {
    String name;
    boolean status;

    public GameTester() {

    }

    public GameTester(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public String Name() {
        return name;
    }

    public void Name(String name) {
        this.name = name;
    }

    public boolean status() {
        return status;
    }

    public void status(boolean status) {
        this.status = status;
    }

    public abstract double salary();
}
