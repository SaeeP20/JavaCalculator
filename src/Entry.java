/**
 * This class is a wrapper to hide the type of the contained value. It is immutable.
 * @author dave
 *
 */

package uk.ac.rhul.cs2800;

/**
 * Class representing the different input types for the {@link Stack} class.
 * Each input type is a constant in the {@link Type} class. This is used for methods within the
 * class.
 * The class creates instances from arguments of type: Float, String, {@link Symbol}.
 *
 * @author Saee Pujari
 */
public class Entry {

  private Float value;
  private Symbol sign;
  private String input;
  private String valueString; // Variable used to compare string of entries in equals()
  private Type entryType; // Default value of entryType before any conditions

  /**
   * Creates an Entry instance using a Float input.
   *
   * @param value Float input value.
   */
  public Entry(float value) {
    this.value = value;
    entryType = Type.NUMBER; // entryType assigned other value if certain conditions are met
    valueString = Float.toString(value);
  }

  /**
   * Creates an Entry instance using a Symbol input.
   *
   * @param sign Symbol input value.
   */
  public Entry(Symbol sign) {
    this.sign = sign;
    if (sign != Symbol.INVALID) { // Symbol.INVALID would not logically be a valid type
      entryType = Type.SYMBOL;
    }
    valueString = sign.toString();
  }

  /**
   * Creates an Entry instance using a String input.
   *
   * @param input String input value.
   */
  public Entry(String input) {
    this.input = input;
    entryType = Type.STRING;
    valueString = input;
  }
  
  /**
   * Retrieves the type of Entry.
   *
   * @return the type of Entry
   */
  public Type getType() {
    return entryType;
  }

  /**
   * Retrieves numeric value of the entry.
   *
   * @return The value of the entry.
   * @throws BadTypeException if entryType is not of type NUMBER.
   */
  public Float getValue() throws BadTypeException {
    if (entryType != Type.NUMBER) { // Using the wrong getter would not return anything
      throw new BadTypeException("Bad Type: The 'Float' value doesn't exist for this item");
    }
    return value;
  }

  /**
   * Retrieves the Symbol sign of the entry.
   *
   * @return The sign of the entry.
   * @throws BadTypeException if entryType is not of type SYMBOL.
   */
  public Symbol getSign() throws BadTypeException {
    if (entryType != Type.SYMBOL) {
      throw new BadTypeException("Bad Type: The 'Sign' value doesn't exist for this item");
    }
    return sign;
  }

  /**
   * Retrieves the String input of the entry.
   *
   * @return The input of the entry.
   * @throws BadTypeException if entryType is not of type STRING.
   */
  public String getInput() throws BadTypeException {
    if (entryType != Type.STRING) {
      throw new BadTypeException("Bad Type: The 'String' value doesn't exist for this item");
    }
    return input;
  }

  /**
   * Boolean method that determines if two objects of type Entry are equal.
   *
   * @param obj The object the current Entry is being compared to.
   * @return The boolean value determining if the two Entry's are equal.
   */
  @Override
  public boolean equals(Object obj) {
    String equalValueString = ""; // Local variable is only used to compare obj with entries
    Entry equalEntry = (Entry) obj; // Parsing obj as Entry so comparison can be made
    if (this.entryType == equalEntry.entryType) { // If types not equal, returns false by default
      if (equalEntry.entryType == Type.NUMBER) {
        equalValueString = Float.toString(equalEntry.value);
      } else if (equalEntry.entryType == Type.SYMBOL) {
        equalValueString = equalEntry.sign.toString();
      } else if (equalEntry.entryType == Type.STRING) {
        equalValueString = equalEntry.input;
      }
    }
    return valueString.equals(equalValueString);
  }

  /**
   * Creates a unique number for each object.
   *
   * @return an integer hashCode.
   */
  @Override
  public int hashCode() {
    final int prime = 31; // Final variable is used to create unique hashcodes for each object
    int result = 0;
    if (entryType == Type.NUMBER) {
      result = prime + (value.hashCode());
    } else if (entryType == Type.SYMBOL) {
      result = prime + (sign.hashCode());
    } else if (entryType == Type.STRING) {
      result = prime + (input.hashCode());
    }
    return result; // Only returns 0 if entryType == Type.INVALID
  }
}