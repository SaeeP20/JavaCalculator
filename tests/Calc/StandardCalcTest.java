
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {
  StandardCalc testCalc;

  @BeforeEach
  void successfulCalc() {
    testCalc = new StandardCalc();
  }
  
  @Test
  void isOperatorTest() {
    assertTrue(testCalc.isOperator("+"),
        "isOperator Test: should return true for operator '+'");
  }
  
  @Test
  void isOperatorFalseTest() {
    assertFalse(testCalc.isOperator("hello"),
        "isOperatorFalse Test: should return false for 'hello'");
  }
  
  @Test
  void isNumericTest() {
    assertTrue(testCalc.isNumeric("2"),
        "isNumeric Test: should return true for numeric '2'");
  }

  @Test
  void isNumericFalse() {
    assertFalse(testCalc.isNumeric("hello"),
        "isNumericFalse Test: should return false for 'hello'");
  }
  @Test
  void evalReturnTest() throws Exception {
    assertEquals(testCalc.evaluate("1 + 1"), 2,
        "Evaluate Test: should accept infix expression and return float 2");
  }
  
  @Test
  void evalPlusTest() throws Exception {
    assertEquals(testCalc.evaluate("3 + 3"), 6,
        "EvaluatePlus Test: using infix should return float 6");
  }
  
  @Test
  void evalMinusTest() throws Exception {
    assertEquals(testCalc.evaluate("4 - 3"), 1,
        "EvaluateMinus Test: using infix should return float 1");
  }
  
  @Test
  void evalMultiplyTest() throws Exception {
    assertEquals(testCalc.evaluate("3 * 3"), 9,
        "EvaluateMultiply Test: using infix should return float 9");
  }
  
  @Test
  void evalDivideTest() throws Exception {
    assertEquals(testCalc.evaluate("6 / 3"), 2,
        "EvaluateDivide Test: using infix should return float 2");
  }
  
  @Test
  void evalPrecedenceTest() throws Exception {
    assertEquals(testCalc.evaluate("5 - 4 * 2"), -3,
        "EvaluatePrecedence: should sort '4 * 2' first to return float -3");
  }
  
  @Test
  void evalPrecedence2Test() throws Exception {
    assertEquals(testCalc.evaluate("5 + 4 / 2"), 7,
        "EvaluatePrecedence2: should sort '4 / 2' first to return float 7");
  }

  @Test
  void evalBracketsTest() throws Exception {
    assertEquals(testCalc.evaluate("5 * ( 3 + 4 )"), 35,
        "Evaluate brackets: should position '3 4 +' at middle of postfix expr");
  }
  
  @Test
  void evalComplexTest() throws Exception {
    assertEquals(testCalc.evaluate("( 3 + 4 ) / ( 5 + 2 )"), 1,
        "Evaluate Complex: should compute brackets first to return float 1");
  }
  
  @Test
  void evalComplex2Test() throws Exception {
    assertEquals(testCalc.evaluate("( 3 - 4 ) * ( 5 - 2 )"), -3,
        "Evaluate Complex2: should compute brackets first to return float -3");
  }
}
