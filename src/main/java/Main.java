import java.io.FileNotFoundException;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        // uzupełnij rozwiązanie

        String inputFileName = "operations.txt";
        String outputFileName = "results.txt";

        try {
            String[] mathOperations = FileUtils.readFile(inputFileName);
            double[] mathOperationsResults = FileUtils.calculateResult(mathOperations);
            FileUtils.displayAndSaveResults(mathOperations, mathOperationsResults, outputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się wczytać pliku");
        } catch (IOException e) {
            System.out.println("Nie udało się zapisać pliku");
        }
    }
}
