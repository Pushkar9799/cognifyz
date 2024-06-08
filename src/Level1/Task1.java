/*codsoft.Task1: Temperature Converter
        Description: Create a program that converts
        temperatures between Celsius and
        Fahrenheit. Prompt the user to enter a
        temperature value and the unit of
        measurement, and then perform the
        conversion. Display the converted
        temperature.
        Skills: Basic input/output operations,
        arithmetic operations.   */



package Level1;


    import java.util.Scanner;

    public class Task1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the temperature value: ");
            double temperature = scanner.nextDouble();


            System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
            char unit = scanner.next().toUpperCase().charAt(0);


            if (unit == 'C') {
                double fahrenheit = celsiusToFahrenheit(temperature);
                System.out.printf("%.2f degrees Celsius is %.2f degrees Fahrenheit.%n", temperature, fahrenheit);
            } else if (unit == 'F') {
                double celsius = fahrenheitToCelsius(temperature);
                System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Celsius.%n", temperature, celsius);
            } else {
                System.out.println("Invalid unit of measurement. Please enter C for Celsius or F for Fahrenheit.");
            }


        }

        // Method to convert Celsius to Fahrenheit
        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * 9/5) + 32;
        }

        // Method to convert Fahrenheit to Celsius
        public static double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5/9;
        }

    }
