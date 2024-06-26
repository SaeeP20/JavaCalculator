
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  RevPolishCalc testCalc;
  String op1 = "+";
  String num1 = "3";

  @BeforeEach
  void successfulCalc() {
    testCalc = new RevPolishCalc();
  }

  @Test
  void isOperatorTest() { // Test 1 - Tests if method returns correct value
    assertTrue(testCalc.isOperator(op1),
        "IsOperator Test: should return true for operator in the string");
  }

  @Test
  void isNumericTest() { // Test 2 - Tests if method returns correct value
    assertTrue(testCalc.isNumeric(num1),
        "IsNumeric Test: should return true for number in the string");
  }

  @Test
  void evalReturnTest() throws Exception { // Test 3 - Tests if method correctly
    // returns float
    assertEquals(testCalc.evaluate("1 1 +"), 2,
        "Evaluate Test: using RPN method should return float 2");
  }

  @Test
  void evalPlusTest() throws Exception { // Test 4 - Tests if method computes addition
    assertEquals(testCalc.evaluate("3 4 +"), 7,
        "Evaluate Plus: using RPN method should return float 7");
  }

  @Test
  void evalMinusTest() throws Exception { // Test 5 - Tests if method computes subtraction
    assertEquals(testCalc.evaluate("7 4 -"), 3,
        "Evaluate Minus: using RPN method should return float 3");
  }

  @Test
  void evalDivideTest() throws Exception { // Test 6 - Tests if method computes division
    assertEquals(testCalc.evaluate("10 2 /"), 5,
        "Evaluate Divide: using RPN method should return float 5");
  }

  @Test
  void evalMultiplyTest() throws Exception { // Test 7 - Tests if method computes multiplication
    assertEquals(testCalc.evaluate("3 4 *"), 12,
        "Evaluate Multiply: using RPN method should return float 12");
  }

  @Test
  void invEvaluateTest() throws Exception { // Test 8 - Tests if exception is thrown for
    // invalid input
    assertThrows(InvalidExpression.class, () -> testCalc.evaluate("hello"),
        "Broken Input: should throw exception for invalid inputs");
  }

  @Test
  void complexPlusTest() throws Exception { // Test 9 - Complex testing for addition
    assertEquals(testCalc.evaluate("3 4 5 + +"), 12,
        "Complex Plus: using RPN method should return float 12");
  }

  @Test
  void complexMinusTest() throws Exception { // Test 10 - Complex testing for subtraction
    assertEquals(testCalc.evaluate("9 5 2 - -"), 6,
        "Complex Minus: using RPN method should return float 6");
  }

  @Test
  void complexDivideTest() throws Exception { // Test 11 - Complex testing for division
    assertEquals(testCalc.evaluate("12 2 2 / /"), 12,
        "Complex Divide: using RPN method should return float 3");
  }

  @Test
  void complexMultiplyTest() throws Exception { // Test 12 - Complex testing for multiplication
    assertEquals(testCalc.evaluate("1 2 3 * *"), 6,
        "Complex Multiply: using RPN method should return float 6");
  }

  @Test
  void complexMixTest() throws Exception { // Test 13
    assertEquals(testCalc.evaluate("2 3 4 + *"), 14,
        "Complex Mix: using RPN method should return float 14");
  }

  @Test
  void complexMix2Test() throws Exception { // Test 14
    assertEquals(testCalc.evaluate("12 5 4 3 2 + - * /"), -2.4f,
        "Complex Mix: using RPN method should return float -2.4");
  }
}
