
/**
 * A custom Exception created for getters that are called using incorrect Entry types.
 * A serializable class that is a subset of the Java class Exception.
 *
 * @author Saee Pujari
 */
public class BadTypeException extends Exception {
  
  /**
   * A unique identifier associated with a serializable class.
   */
  private static final long serialVersionUID = 1L;

  public BadTypeException(String message) {
    super(message);
  }
}
