import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Project_Swayam_Tripathy {
    public static void main(String[] args) {
        
        try {
            // Open the file
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);

            // ArrayList to store policies
            ArrayList<Policy> policies = new ArrayList<>();

            int smokerCount = 0;
            int nonSmokerCount = 0;

            // Read file until empty
            while (inputFile.hasNext()) {
                
                int policyNumber = Integer.parseInt(inputFile.nextLine());
                String providerName = inputFile.nextLine();
                String firstName = inputFile.nextLine();
                String lastName = inputFile.nextLine();
                int age = Integer.parseInt(inputFile.nextLine());
                String smokingStatus = inputFile.nextLine();
                double height = Double.parseDouble(inputFile.nextLine());
                double weight = Double.parseDouble(inputFile.nextLine());

                // Consume the blank line separating policies
                if (inputFile.hasNext()) {
                    inputFile.nextLine(); 
                }

                // Create the independent PolicyHolder object
                PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                
                // Pass the holder to the Policy object
                Policy p = new Policy(policyNumber, providerName, holder);
                
                policies.add(p);
            }

            inputFile.close();

            // Iterate over policies to print and calculate
            for (Policy currentPolicy : policies) {
                
                // Implicit call to toString()
                System.out.println(currentPolicy);
                System.out.println(); // Adds the required blank line between outputs

                // Access the aggregated object to check smoking status
                if (currentPolicy.getHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            // Print final statistics using the static method
            System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (IOException ex) {
            System.out.println("Something went wrong reading the file: " + ex.getMessage());
        }
    }
}