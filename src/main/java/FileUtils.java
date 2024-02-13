import java.io.*;
import java.util.Scanner;

public class FileUtils {

    private static final String ADD = "+";
    private static final String SUBSTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public static String[] readFile(String fileName) throws FileNotFoundException {

        int linesCount = calculateFileLength(fileName);

        String[] mathOperationsArray = new String[linesCount];
        int index = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                mathOperationsArray[index++] = scanner.nextLine();
            }
        }
        return mathOperationsArray;
    }

    public static double[] calculateResult(String[] mathOperations) {
        double[] results = new double[mathOperations.length];
        for (int i = 0; i < mathOperations.length; i++) {
            String[] operationsParts = mathOperations[i].split(" ");
            double num1 = Double.parseDouble(operationsParts[0]);
            String operator = operationsParts[1];
            double num2 = Double.parseDouble(operationsParts[2]);
            switch (operator) {
                case ADD -> results[i] = num1 + num2;
                case SUBSTRACT -> results[i] = num1 - num2;
                case MULTIPLY -> results[i] = num1 * num2;
                case DIVIDE -> results[i] = num1 / num2;
                default -> throw new IllegalArgumentException("Niewłaściwy znak");
            }
        }
        return results;
    }

    public static void displayAndSaveResults(String[] mathOperations, double[] results,
                                             String resultFileName) throws IOException {

        try (FileWriter fileWriter = new FileWriter(resultFileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for (int i = 0; i < mathOperations.length; i++) {
                System.out.printf("%s = %.1f%n", mathOperations[i], results[i]);
                bufferedWriter.write(mathOperations[i] + " = " + results[i]);
                bufferedWriter.newLine();
            }
        }

    }

    private static int calculateFileLength(String fileName) throws FileNotFoundException {
        int linesCounter = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                linesCounter++;
                scanner.nextLine();

            }
        }
        return linesCounter;
    }
}
