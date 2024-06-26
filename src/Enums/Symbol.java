
/**
 * Enumeration representing different mathematical symbols present in the calculator.
 * These symbols are used to denote mathematical operations.
 * Each symbol is assigned a description that can be retrieved by the {@link #toString()} method.
 *
 * @author Saee Pujari
 */
public enum Symbol {
  LEFT_BRACKET("left-bracket"), RIGHT_BRACKET("right-bracket"), TIME("time"), DIVIDE("divide"), 
  PLUS("plus"), MINUS("minus"), INVALID("invalid");

  private String desc;

  /**
   * Creates a new Symbol and assigns it the description given.
   *
   * @param desc The description of the Symbol
   */
  Symbol(String desc) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return desc;
  }
}
