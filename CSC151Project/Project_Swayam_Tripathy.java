import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Project_Swayam_Tripathy {
    public static void main(String[] args) {
        
        // Step 2: Use a try-catch block to handle file reading
        try {
            // Open the file
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);

            // Create an ArrayList to store Policy objects
            ArrayList<Policy> policies = new ArrayList<Policy>();

            // Variables to keep track of smoking status counts
            int smokerCount = 0;
            int nonSmokerCount = 0;

            // Read the file until there is no more data
            while (inputFile.hasNext()) {
                
                // Read the lines and parse numbers to match the Policy constructor
                int policyNumber = Integer.parseInt(inputFile.nextLine());
                String providerName = inputFile.nextLine();
                String firstName = inputFile.nextLine();
                String lastName = inputFile.nextLine();
                int age = Integer.parseInt(inputFile.nextLine());
                String smokingStatus = inputFile.nextLine();
                double height = Double.parseDouble(inputFile.nextLine());
                double weight = Double.parseDouble(inputFile.nextLine());

                // Skip the blank line separating policies if we haven't reached the end of the file
                if (inputFile.hasNext()) {
                    inputFile.nextLine(); 
                }

                // Create a new Policy object with the data we just read
                Policy p = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                
                // Add the object to the ArrayList
                policies.add(p);
            }

            // Close the file
            inputFile.close();

            // Step 3 & 4: Iterate over the ArrayList to display the output and count smokers
            for (int i = 0; i < policies.size(); i++) {
                
                Policy currentPolicy = policies.get(i);
                
                System.out.println("Policy Number: " + currentPolicy.getPolicyNumber());
                System.out.println("Provider Name: " + currentPolicy.getProviderName());
                System.out.println("Policyholder's First Name: " + currentPolicy.getFirstName());
                System.out.println("Policyholder's Last Name: " + currentPolicy.getLastName());
                System.out.println("Policyholder's Age: " + currentPolicy.getAge());
                System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + currentPolicy.getSmokingStatus());
                System.out.printf("Policyholder's Height: %.1f inches\n", currentPolicy.getHeight());
                System.out.printf("Policyholder's Weight: %.1f pounds\n", currentPolicy.getWeight());
                System.out.printf("Policyholder's BMI: %.2f\n", currentPolicy.getBMI());
                System.out.printf("Policy Price: $%.2f\n", currentPolicy.getPrice());
                System.out.println(); 

                // Track smokers and non-smokers
                if (currentPolicy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            // Print the final counts
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } 
        catch (IOException ex) {
            // Handle any file reading errors gracefully
            System.out.println("Something went wrong reading the file: " + ex.getMessage());
        }
    }
}