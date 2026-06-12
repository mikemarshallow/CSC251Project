public class Policy {
    
    // Fields
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * No-arg constructor that initializes all fields to default values.
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that initializes all fields in the Policy object.
     * * @param pNumber The policy number
     * @param pName The provider name
     * @param fName The policyholder's first name
     * @param lName The policyholder's last name
     * @param a The policyholder's age
     * @param sStatus The policyholder's smoking status (smoker/non-smoker)
     * @param h The policyholder's height in inches
     * @param w The policyholder's weight in pounds
     */
    public Policy(int pNumber, String pName, String fName, String lName, int a, String sStatus, double h, double w) {
        policyNumber = pNumber;
        providerName = pName;
        firstName = fName;
        lastName = lName;
        age = a;
        smokingStatus = sStatus;
        height = h;
        weight = w;
    }

    // --- Setters ---

    /**
     * Sets the policy number.
     * @param pNumber The policy number
     */
    public void setPolicyNumber(int pNumber) {
        policyNumber = pNumber;
    }

    /**
     * Sets the provider name.
     * @param pName The provider name
     */
    public void setProviderName(String pName) {
        providerName = pName;
    }

    /**
     * Sets the policyholder's first name.
     * @param fName The first name
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * Sets the policyholder's last name.
     * @param lName The last name
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * Sets the policyholder's age.
     * @param a The age
     */
    public void setAge(int a) {
        age = a;
    }

    /**
     * Sets the policyholder's smoking status.
     * @param sStatus The smoking status
     */
    public void setSmokingStatus(String sStatus) {
        smokingStatus = sStatus;
    }

    /**
     * Sets the policyholder's height.
     * @param h The height in inches
     */
    public void setHeight(double h) {
        height = h;
    }

    /**
     * Sets the policyholder's weight.
     * @param w The weight in pounds
     */
    public void setWeight(double w) {
        weight = w;
    }

    // --- Getters ---

    /**
     * Gets the policy number.
     * @return The policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Gets the provider name.
     * @return The provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Gets the policyholder's first name.
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the policyholder's last name.
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the policyholder's age.
     * @return The age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the policyholder's smoking status.
     * @return The smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Gets the policyholder's height.
     * @return The height in inches
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the policyholder's weight.
     * @return The weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    // --- Calculations ---

    /**
     * Calculates the policyholder's BMI.
     * @return The calculated BMI
     */
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the total price of the insurance policy.
     * @return The calculated policy price
     */
    public double getPrice() {
        // Your specific calculations from Project 1 would go here
        double price = 600.0; 
        
        if (age > 50) {
            price += 75.0;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        
        double bmi = getBMI();
        if (bmi > 35) {
            price += ((bmi - 35) * 20);
        }
        
        return price;
    }
}