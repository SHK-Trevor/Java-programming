//package exercise_1;

public class Singers {
    private int id;
    private String name;
    private String address;
    private String dateOfBirth;
    private int numberOfAlbums;

    // Constructor 1
    public Singers() {
    }

    // Constructor 2
    public Singers(int id) {
        this.id = id;
    }

    // Constructor 3
    public Singers(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor 4
    public Singers(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Constructor 5
    public Singers(int id, String name, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    // Constructor 6
    public Singers(int id, String name, String address, String dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfAlbums(int numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }
}
