
public class Developer {
    private long id;
    private String firstName;
    private String lastName;
    private String specialty;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public Developer(long id, String firstName, String lastName, String specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return id + ", " + firstName + ", " + lastName + ", " + specialty;
    }
}

