
public class CalcModel {
  private StandardCalc baseStandard = new StandardCalc();

  public Float evaluate(String expr1, boolean infix) throws Exception {
    return baseStandard.evaluate(expr1);
  }
  
}
