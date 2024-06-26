
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EntryTest {
  private Entry newTest;
  private Float floatTest = 8.0f;
  private String stringTest = "hello";
  private Symbol signTest = Symbol.DIVIDE;
  private Symbol invalidSign = Symbol.INVALID;

  @Test
  void testFloatEntry() { //Test 1 - Tests if an instance of Entry is created using a float input
    assertDoesNotThrow(() -> new Entry(floatTest), "CstrFloat Test: constructor accepts float");
  } // Created a separate constructor for Float inputs

  @Test
  void testStringEntry() { //Test 2 - Tests if an instance of Entry is created using a string input
    assertDoesNotThrow(() -> new Entry(stringTest), "CstrString Test: constructor accepts string");
  } // Created a separate constructor for String inputs

  @Test
  void testSymbolEntry() { //Test 3 - Tests if an instance of Entry is created using a Symbol input
    assertDoesNotThrow(() -> new Entry(signTest), "CstrSymbol Test: constructor accepts Symbol");
  } // Created a separate constructor for Symbol inputs
  
  @Test
  void testGetValue() throws BadTypeException { //Test 4 - Tests if FloatEntry getter returns input
    newTest = new Entry(floatTest);
    assertEquals(newTest.getValue(), floatTest, "Get-Value Test: should return float input");
  } // Created a getter that returns the numerical value of the entry

  @Test
  void testInvalidGetValue() { //Test 8 - Tests for invalid getValue() calls
    newTest = new Entry(signTest);
    assertThrows(BadTypeException.class, () -> newTest.getValue(), "IvdSymbol Test: Bad Type");
    newTest = new Entry(stringTest);
    assertThrows(BadTypeException.class, () -> newTest.getValue(), "IvdString Test: Bad Type");
  } // Created a branch that throws an exception if an invalid type calls getValue()

  @Test
  void testGetInput() throws BadTypeException { //Test 5 - Tests if StringEntry getter returns input
    newTest = new Entry(stringTest);
    assertEquals(newTest.getInput(), stringTest, "Get-Input Test: should return string input");
  } // Created a getter that returns the string value of the entry

  @Test
  void testInvalidGetInput() { //Test 9 - Tests for invalid getInput() calls
    newTest = new Entry(signTest);
    assertThrows(BadTypeException.class, () -> newTest.getInput(), "IvdSymbol Test: exception");
    newTest = new Entry(floatTest);
    assertThrows(BadTypeException.class, () -> newTest.getInput(), "IvdFloat Test: exception");
  } // Created a branch that throws an exception if an invalid type calls getInput()

  @Test
  void testGetSign() throws BadTypeException { //Test 6 - Tests if Symbol entry getter returns input
    newTest = new Entry(signTest);
    assertEquals(newTest.getSign(), signTest, "Get-Sign Test: should return the Symbol input");
  } // Created a getter that returns the symbol value of the entry

  @Test
  void testInvalidGetSign() { //Test 10 - Tests for invalid getSign() calls
    newTest = new Entry(stringTest);
    assertThrows(BadTypeException.class, () -> newTest.getSign(), "IvdString Test: exception");
    newTest = new Entry(floatTest);
    assertThrows(BadTypeException.class, () -> newTest.getSign(), "IvdFloat Test: exception");
  } // Created a branch that throws an exception if an invalid type calls getSign()

  @Test
  void testGetType() { //Test 7 - Tests if getter for entry Type returns the correct Type
    newTest = new Entry(floatTest);
    assertEquals(newTest.getType(), Type.NUMBER, "GetType Test: should return the input type");
  } // Created a getter that returns the type of entry
 
  @Test
  void testEqualFalse() { //Test 11 - Tests if equals() returns false - tested with all types
    newTest = new Entry(stringTest);
    Entry equalEntryTest = new Entry(Symbol.MINUS);
    assertFalse(newTest.equals(equalEntryTest), "EqualFalse Test: returns false for diff values");
    newTest = new Entry(signTest);
    equalEntryTest = new Entry(30f);
    assertFalse(newTest.equals(equalEntryTest), "EqualFalse Test: returns false for diff values");
    newTest = new Entry(floatTest);
    equalEntryTest = new Entry("Saee");
    assertFalse(newTest.equals(equalEntryTest), "EqualFalse Test: returns false for diff values");
  } // Created an @Override equals() method that returned false
  
  @Test
  void testEqualTypeFalse() { //Test 12 - Tests entries with equal types but diff values
    newTest = new Entry(floatTest);
    Entry equalEntryTest = new Entry(12f);
    assertFalse(newTest.equals(equalEntryTest), "EqualType Test: returns false as diff valString");
    newTest = new Entry(signTest);
    equalEntryTest = new Entry(Symbol.MINUS);
    assertFalse(newTest.equals(equalEntryTest), "EqualType Test: returns false as diff valString");
    newTest = new Entry(stringTest);
    equalEntryTest = new Entry("world");
    assertFalse(newTest.equals(equalEntryTest), "EqualType Test: returns false as diff valString");
  } // Created a branch that checked if types were equal but returned false

  @Test
  void testEqualValueFalse() { //Test 13 - Tests entries with equal values but diff types
    newTest = new Entry("8.0f");
    Entry equalEntryTest = new Entry(floatTest);
    assertFalse(newTest.equals(equalEntryTest), "EqualValue Test: returns false as diff entryType");
    newTest = new Entry("DIVIDE");
    equalEntryTest = new Entry(signTest);
    assertFalse(newTest.equals(equalEntryTest), "EqualValue Test: returns false as diff entryType");
    newTest = new Entry(Symbol.PLUS);
    equalEntryTest = new Entry("Plus");
    assertFalse(newTest.equals(equalEntryTest), "EqualValue Test: returns false as diff entryType");
  } // Added code that checked if the values were the same within the same-type branch

  @Test
  void testEqualTrue() { //Test 14 - Tests if entries with same value and type return equal
    newTest = new Entry(floatTest);
    Entry equalEntryTest = new Entry(floatTest);
    assertTrue(newTest.equals(equalEntryTest), "EqualTrue Test: true iff all values are equal");
    newTest = new Entry(signTest);
    equalEntryTest = new Entry(signTest);
    assertTrue(newTest.equals(equalEntryTest), "EqualTrue Test: true iff all values are equal");
    newTest = new Entry(stringTest);
    equalEntryTest = new Entry(stringTest);
    assertTrue(newTest.equals(equalEntryTest), "EqualTrue Test: true iff all values are equal");
  } // Added a return statement that only returned true if the two strings were equal
  /* Modified code - changed the value of obj valueString in every branch, added return after outer
  if-block. Removes code that involves multiple 'returns' of same value in all branches */

  @Test
  void testHashCode() { //Test 15 - Tests if a hashcode can be generated
    newTest = new Entry(floatTest);
    newTest.hashCode();
  } // Created a basic @Override hashCode() method that returns 1

  @Test
  void testMixedFloatHashCode() { //Test 16 - Tests if hashcodes for diff floats are diff
    newTest = new Entry(floatTest);
    int hash1 = newTest.hashCode();
    Entry testEntry2 = new Entry(4f);
    int hash2 = testEntry2.hashCode();
    assertNotEquals(hash1, hash2, "MixedFloat hashCode Test: is not-equal for diff hashCode");
  } // Used .getValue() to retrieve float and used it with hashCode() to create a hashcode value
  // Created an int variable 'result', a constant 'prime' and used all values to return a value

  @Test
  void testMixedSymbolHashCode() { //Test 17 - Tests if hashcodes for diff symbols are diff
    newTest = new Entry(signTest);
    int hash1 = newTest.hashCode();
    Entry testEntry2 = new Entry(Symbol.TIME);
    int hash2 = testEntry2.hashCode();
    assertNotEquals(hash1, hash2, "MixedSymbol hashCode Test: is not-equal for diff hashCode");
  } /* Created a separate branches for Float, Symbol and String to use getters for entry values as
  getValue() throws exceptions for Symbol and String types calling it. Used appropriate getters.*/ 
  // Gave result a new value in each branch, returned result outside of the if-block at the end

  @Test
  void testMixedStringHashCode() { //Test 18 - Tests if hashcodes for diff strings are diff
    newTest = new Entry(stringTest);
    int hash1 = newTest.hashCode();
    Entry testEntry2 = new Entry("world");
    int hash2 = testEntry2.hashCode();
    assertNotEquals(hash1, hash2, "MixedString hashCode Test: is not-equal for diff hashCode");
  }

  @Test
  void testInvalidTypeHashCode() { //Test 19 - Tests if invalid type returns a valid integer value
    newTest = new Entry(invalidSign);    
    assertEquals(newTest.hashCode(), 0, "InvalidSymbolType Test: .hashCode() "
        + "should equal a BadTypeException");
  } // Added a branch that returns 0 if the type is invalid
  // Initialised result to 0 instead of 1, so if no conditions for if-block are met, returns 0
  
}
