import com.github.javafaker.Faker;

public class User {
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    private Faker faker;

    private Generate generate;

    private String email;

    private String firstName;
    private String lastName;
    private String password;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;

    public User() {
        faker = new Faker();
        generate = new Generate();
        email = generate.email();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = faker.internet().password();
        city = faker.address().city();
        postalCode = "12-345";
        street = faker.address().streetName();
        houseNumber = faker.address().buildingNumber();
        printUser();
    }

    public void printUser() {
        System.out.println("User data used in test:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("e-mail: " + email);
        System.out.println("Password: " + password);
        System.out.println("City: " + city);
        System.out.println("Postal Code: " + postalCode);
        System.out.println("Street: " + street);
        System.out.println("House Number: " + houseNumber);
    }
}
