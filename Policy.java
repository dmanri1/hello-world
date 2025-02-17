import java.util.Scanner;

public class Policy {
    private int policyNumber, age;
    private String providerName, firstName, lastName, smokingStatus;
    private double height, weight;

    public Policy() { this(0, "Unknown", "Unknown", "Unknown", 0, "non-smoker", 0.0, 0.0); }
    public Policy(int policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber; this.providerName = providerName; this.firstName = firstName;
        this.lastName = lastName; this.age = age; this.smokingStatus = smokingStatus; this.height = height; this.weight = weight;
    }

    public double calculateBMI() { return (weight * 703) / (height * height); }
    public double calculatePolicyPrice() {
        double price = 600 + (age > 50 ? 75 : 0) + (smokingStatus.equalsIgnoreCase("smoker") ? 100 : 0);
        return price + (Math.max(0, calculateBMI() - 35) * 20);
    }

    public void displayPolicyDetails() {
        System.out.printf("Policy Number: %d\nProvider Name: %s\nPolicyholder’s Name: %s %s\nAge: %d\nSmoking Status: %s\nHeight: %.1f inches\nWeight: %.1f pounds\nBMI: %.2f\nPolicy Price: $%.2f\n",
                policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight, calculateBMI(), calculatePolicyPrice());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Policy Number: "); int policyNumber = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Provider Name: "); String providerName = scanner.nextLine();
        System.out.print("Enter First Name: "); String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: "); String lastName = scanner.nextLine();
        System.out.print("Enter Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Smoking Status (smoker/non-smoker): "); String smokingStatus = scanner.nextLine();
        System.out.print("Enter Height (in inches): "); double height = scanner.nextDouble();
        System.out.print("Enter Weight (in pounds): "); double weight = scanner.nextDouble();
        
        new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight).displayPolicyDetails();
        scanner.close();
    }
}
