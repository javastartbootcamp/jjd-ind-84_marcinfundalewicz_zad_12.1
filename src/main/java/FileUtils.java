import java.io.*;
import java.util.Scanner;

public class FileUtils {

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

    public static void displayAndSaveResults(String[] mathOperations, double[] results, String resultFileName) throws IOException {
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
