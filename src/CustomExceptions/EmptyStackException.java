package uk.ac.rhul.cs;

/**
 * A custom Exception created for methods within the {@link Stack} class.
 * A serializable class that is a subset of the Java class Exception.
 */
public class EmptyStackException extends Exception {

  /**
   * A unique identifier associated with a serializable class.
   */
  private static final long serialVersionUID = 2L;

  public EmptyStackException() {
    super("You cannot perform this on an empty stack");
  }
}
