
/**
 * Class computing user input in the Reverse Polish Notation (RPN). Using an instance of
 * the {@link Stack} class, expressions using numbers of type float are computed with
 * mathematical operators in {@link Symbol}.
 * 
 * @author Saee Pujari
 */
public class RevPolishCalc {

  Stack baseStack = new Stack();
  Entry newToken;

  /**
   * Boolean method that determines if a string is an operator.
   * 
   * @param op The string that is tested for an operator.
   * @return The boolean value determining if 'op' is an operator.
   */
  public static boolean isOperator(String op) {
    return op.matches("[+\\-*/]"); // Stands for all operators(excluding brackets)
  }

  /**
   * Boolean method that determines if a string is a number.
   * 
   * @param num The string that is tested for a number of any type.
   * @return The boolean value determining if 'num' is a number.
   */
  public static boolean isNumeric(String num) {
    return num.matches("-?\\d+(\\.\\d+)?"); // Stands for all types of nums
  }

  /**
   * Method that computes the float result of the string expression, utilising 
   * {@link Stack}.
   * 
   * @param expr The mathematical expression as a string in reverse polish notation.
   * @return a float result
   * @throws Exception if expression includes letters or other special characters.
   */
  public Float evaluate(String expr) throws Exception {
    String[] tokens = expr.split("\\s+"); // Splits expr at every whitespace
    for (String token : tokens) {
      if (isNumeric(token)) {
        newToken = new Entry(Float.valueOf(token));
        baseStack.push(newToken);
      } else if (isOperator(token) && baseStack.size() != 0) {
        Float num2 = baseStack.pop().getValue();
        Float num1 = baseStack.pop().getValue();
        switch (token) {
          case "+":
            newToken = new Entry(num1 + num2); // Initialised for each operation
            baseStack.push(newToken);
            break;
          case "-":
            newToken = new Entry(num1 - num2);
            baseStack.push(newToken);
            break;
          case "/":
            newToken = new Entry(num1 / num2);
            baseStack.push(newToken);
            break;
          case "*":
            newToken = new Entry(num1 * num2);
            baseStack.push(newToken);
            break;
          default: // Custom exception message for invalid operators
            throw new InvalidExpression("Not a valid operator");
        }
      } else {
        throw new InvalidExpression();
      }
    }
    return baseStack.pop().getValue(); // Removed need for unnecessary variables
  }
}
