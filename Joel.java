import java.util.Arrays;
import java.util.Scanner;

public class StatisticsCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();

        // Input validation and array creation
        if (numElements < 1) {
            System.out.println("Error: Number of elements must be at least 1.");
            return;
        }
        int[] numbers = new int[numElements];

        //  Accept the user's input for each element
        System.out.println("Enter the numbers:");
        for (int i = 0; i < numElements; i++) {
            numbers[i] = scanner.nextInt();
        }

        //  Calculate and assign statistics
        double mean = calculateMean(numbers);
        double median = calculateMedian(numbers);
        double standardDeviation = calculateStandardDeviation(numbers);

        // Display results
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Standard Deviation: " + standardDeviation);
    }

    // Calculate the mean (average)
    public static double calculateMean(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    //  Calculate the median (middle value)
    public static double calculateMedian(int[] numbers) {
        Arrays.sort(numbers); 
        int middle = numbers.length / 2;
        if (numbers.length % 2 == 0) {
            return (double) (numbers[middle - 1] + numbers[middle]) / 2; 
        } else {
            return numbers[middle];
        }
    }

    // Calculate the standard deviation
    public static double calculateStandardDeviation(int[] numbers) {
        if (numbers.length < 2) {
            System.out.println("Error: At least 2 elements are required for standard deviation calculation.");
            return Double.NaN; // Return Not-a-Number
        }

        double mean = calculateMean(numbers);
        double variance = 0;
        for (int number : numbers) {
            variance += Math.pow(number - mean, 2);
        }
        return Math.sqrt(variance / (numbers.length - 1)); // Sample standard deviation
    }
}
