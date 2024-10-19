package Exercise2;

class PartTimeGameTester extends GameTester{
    public int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double salary() {
        return hoursWorked * 20;
    }
}