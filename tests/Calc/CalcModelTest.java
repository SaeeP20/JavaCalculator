
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {
  private CalcModel testModel;
  private String expr1 = "( 4 * ( 5 + 2 ) ) - 3";
  private String expr2 = "-3 4 5 2 + * +";

  @BeforeEach
  void successfulCalcTest() {
    testModel = new CalcModel();
  }
  
  @Test
  void evalStandardTest() throws Exception {
    assertEquals(testModel.evaluate(expr1, true), 25f,
        "Eval Standard: should call StandardCalc.evaluate() to retrieve answer");
  }
  
  @Test
  void evalRpInvTest() throws Exception {
    assertThrows(InvalidExpression.class, () -> testModel.evaluate(expr1, false),
        "Eval RevPolish: should call RevPolishCalc.evaluate() and throw exception");
  }
  
  @Test
  void evalStndInvTest() throws Exception {
    assertThrows(InvalidExpression.class, () -> testModel.evaluate(expr2, true),
        "Eval StandardInv: should call StandardCalc.evaluate() and throw exception");
  }
}
