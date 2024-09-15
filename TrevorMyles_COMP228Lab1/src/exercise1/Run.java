package exercise1;

public class Run {
    public static void Main(String[] args) {

        Singer singer1 = new Singer();

        // Set the values
        singer1.setId(1234);
        singer1.setName("John Doe");
        singer1.setAddress("123 Main St, Toronto");
        singer1.setDateOfBirth("23/5/1995");
        singer1.setNumberOfAlbums(5);

        // Display values
        System.out.println("ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums: " + singer1.getNumberOfAlbums());
    }
}
