package uk.ac.rhul.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTest {
  private Type type1;

  @BeforeEach 
  void testTypeConstructor() { //Test 1 - Ensures type1 is initialised correctly before each test
    type1 = Type.NUMBER;
  }

  @Test 
  void testSymbolGetDescription() { //Test 2 - Checks if description can be retrieved for the Type
    assertEquals("number", type1.toString(), "SymbolCstr Test: desc = sign1 if initialised");
  } //getDescription() method created, returning the description
  
  @Test 
  void testTypeToString() { //Test 4 - Tests if toString() and getDescription() return same value
    assertEquals("number", type1.toString(), "TypeToString() Test: toString() = type1");
  } //Deleted getDescription() method to avoid OAOO code smell

  @Test 
  void testPrintType() { //Test 3 - Checks if the Type constant is printable
    System.out.println(type1);
  } //A toString() method was created returning the description as a string
}
