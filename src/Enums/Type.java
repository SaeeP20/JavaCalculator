
/**
 * Enumeration representing the different input types for the {@link Entry} class.
 * These types are used to identify which methods and variables are subsequently called.
 * Each type is assigned a description which can be retrieved by the {@link #toString()} method.
 *
 * @author Saee Pujari
 */
public enum Type {
  STRING("string"), NUMBER("number"), SYMBOL("symbol"), INVALID("invalid");

  private final String desc;

  /**
   * Creates a new Type and assigns it the description given.
   *
   * @param desc The description of the Type
   */
  Type(String desc) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return desc;
  }
}
