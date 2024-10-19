package Exercise2;

public class FullTimeGameTester extends GameTester{
    //full-time game testers getting a base salary of $3000
    public FullTimeGameTester(String name){

    }

    @Override
    public double salary() {
        return 3000; // Base salary for full-time testers
    }
}
