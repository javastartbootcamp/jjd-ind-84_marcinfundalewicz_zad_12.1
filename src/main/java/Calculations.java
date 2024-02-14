public class Calculations {

    private static final String ADD = "+";
    private static final String SUBSTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

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
}
