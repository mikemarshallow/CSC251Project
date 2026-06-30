public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // Standard Constructor
    public PolicyHolder(String fName, String lName, int age, String smoke, double height, double weight) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.smokingStatus = smoke;
        this.height = height;
        this.weight = weight;
    }

    // Copy Constructor for Defensive Copying (Security)
    public PolicyHolder(PolicyHolder objectToCopy) {
        this.firstName = objectToCopy.firstName;
        this.lastName = objectToCopy.lastName;
        this.age = objectToCopy.age;
        this.smokingStatus = objectToCopy.smokingStatus;
        this.height = objectToCopy.height;
        this.weight = objectToCopy.weight;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    @Override
    public String toString() {
        return "Policyholder's First Name: " + firstName +
               "\nPolicyholder's Last Name: " + lastName +
               "\nPolicyholder's Age: " + age +
               "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus +
               "\nPolicyholder's Height: " + height + " inches" +
               "\nPolicyholder's Weight: " + weight + " pounds";
    }
}