public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder holder; // Aggregation
    private static int policyCount = 0; // Static field

    // Constructor
    public Policy(int pNum, String pName, PolicyHolder holder) {
        this.policyNumber = pNum;
        this.providerName = pName;
        this.holder = new PolicyHolder(holder); // Create defensive copy
        policyCount++; // Increment count on creation
    }

    // Security: Returning a COPY of the object
    public PolicyHolder getHolder() {
        return new PolicyHolder(holder);
    }

    // Static Getter
    public static int getPolicyCount() {
        return policyCount;
    }

    // Calculations using data from the aggregated object
    public double calculateBMI() {
        return (holder.getWeight() * 703) / (holder.getHeight() * holder.getHeight());
    }

    public double calculatePrice() {
        double price = 600.0;
        if (holder.getAge() > 50) {
            price += 75.0;
        }
        if (holder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += ((bmi - 35) * 20);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + holder.toString() +
               "\nPolicyholder's BMI: " + String.format("%.2f", calculateBMI()) +
               "\nPolicy Price: $" + String.format("%.2f", calculatePrice());
    }
}