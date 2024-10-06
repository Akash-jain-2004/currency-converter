package convertor;

import java.util.Scanner;

// Base class for currency conversion
class CurrencyConverter {
    protected double rate; // Exchange rate for conversion
    
    // Method to set exchange rate
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    // Method to convert currency
    public double convert(double amount) {
        return amount * rate;
    }
}

// Class for converting USD to INR
class USDToINRConverter extends CurrencyConverter {
    public USDToINRConverter() {
        // Set exchange rate for USD to INR (example rate)
        setRate(82.0);
    }
}

// Class for converting EUR to INR
class EURToINRConverter extends CurrencyConverter {
    public EURToINRConverter() {
        // Set exchange rate for EUR to INR (example rate)
        setRate(90.0);
    }
}

// Class for converting GBP to INR
class GBPToINRConverter extends CurrencyConverter {
    public GBPToINRConverter() {
        // Set exchange rate for GBP to INR (example rate)
        setRate(100.0);
    }
}

// Main class to test the currency converter
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true; // Flag to control the loop
        
        while (continueConversion) {
            // Display menu
            System.out.println("Currency Converter");
            System.out.println("1. USD to INR");
            System.out.println("2. EUR to INR");
            System.out.println("3. GBP to INR");
            System.out.println("4. Exit");
            System.out.print("Choose conversion option (1/2/3/4): ");
            int choice = scanner.nextInt();
            
            // Exit option
            if (choice == 4) {
                System.out.println("Exiting the Currency Converter. Goodbye!");
                break;
            }
            
            // Create an object for the appropriate currency converter
            CurrencyConverter converter = null;
            switch(choice) {
                case 1:
                    converter = new USDToINRConverter();
                    break;
                case 2:
                    converter = new EURToINRConverter();
                    break;
                case 3:
                    converter = new GBPToINRConverter();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Go back to the start of the loop
            }
            
            // Get amount to convert
            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();
            
            // Convert and display result
            double convertedAmount = converter.convert(amount);
            System.out.println("Converted Amount: " + convertedAmount + " INR");
            
            // Ask if the user wants to perform another conversion
            System.out.print("Do you want to perform another conversion? (yes/no): ");
            String continueResponse = scanner.next().toLowerCase();
            if (!continueResponse.equals("yes")) {
                continueConversion = false; // End the loop if the user says no
                System.out.println("Exiting the Currency Converter. Goodbye!");
            }
        }
        
        scanner.close();
    }
}
