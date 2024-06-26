
public class StandardCalc implements Calculator {
  private OpStack operators;
  private RevPolishCalc rpCalc = new RevPolishCalc();
  private String rpExpr = "";
  private int opCount = 0; // count for consecutive operators
  private int numCount = 0; // count for consecutive numbers

  public boolean isOperator(String op) {
    return op.matches("[+\\-*/]");
  }
  
  public boolean isNumeric(String num) {
    return num.matches("-?\\d+(\\.\\d+)?");
  }
  
  public Symbol convertSym(String sym) throws Exception {
    switch (sym) { // switch-case to improve readability
      case "+":
        return Symbol.PLUS;
      case "-":
        return Symbol.MINUS;
      case "*":
        return Symbol.TIMES;
      case "/":
        return Symbol.DIVIDE;
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      default:
        throw new BadTypeException("This is not a valid operator");
    }
  }
  
  public int precedence(String operand) {
    switch(operand) {
      case "+":
      case "-":
        return 1;
      case "*":
      case "/":
        return 2;
      default:
        return 0;
    }
  }
  
  @Override
  public Float evaluate(String expr) throws Exception {
    operators = new OpStack();
    for (String token : expr.split("\\s+")) {
      if (isNumeric(token)) {
        rpExpr += (token + " ");
        if (opCount != 0) {
          opCount--;
        }
        numCount++;
      } else if (isOperator(token)) {
        while (operators.size() != 0 && 
            (precedence(operators.top().toString()) >= precedence(token))) {
          rpExpr += (operators.pop().toString() + " ");
        }
        operators.push(convertSym(token));
        if (numCount != 0) {
          numCount--;
        }
        opCount++;
      } else if (token.equals("(")) { // Brackets aren't included in isOperator()
        operators.push(convertSym(token));
      } else if (token.equals(")")) { // Ensures expr inside () is arranged to be
        // performed first in RPN
        while (operators.size() != 0 && operators.top().toString() != "(") {
          rpExpr += (operators.pop().toString() + " ");
        }
        operators.pop();
      } 
      if (opCount >= 2 && numCount >= 2){
        throw new InvalidExpression("Enter an infix expression!");
      }
    }
    while (operators.size() != 0) {
      rpExpr += (operators.pop().toString() + " ");
    }
    return rpCalc.evaluate(rpExpr.trim());
  }
  
  
}
