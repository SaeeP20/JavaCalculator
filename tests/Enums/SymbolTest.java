package uk.ac.rhul.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SymbolTest {

  private Symbol sign1;

  @BeforeEach
  void testSymbolConstructor() { // Test 1 - Ensures sign1 is initialised correctly before each test
    sign1 = Symbol.DIVIDE;
  }

  @Test
  void testSymbolGetDescription() { /* Test 2 - Checks if description can be retrieved for the 
                                       Symbol.
  Updated sign1.getDescription to sign1.toString as getDescription() deleted due to OAOO smell */
    assertEquals("divide", sign1.toString(), "SymGetDesc() Test: desc = sign1.desc if initialised");
  } // getDescription() method created, returning the description

  @Test
  void testSymbolToString() { // Test 4 - Tests if toString() and getDescription() return same value
    assertEquals("divide", sign1.toString(), "SymToString() Test: toString() = sign1");
  } // Deleted getDescription() method to avoid OAOO code smell

  @Test
  void testPrintSymbol() { // Test 3 - Checks if the Symbol constant is printable
    System.out.println(sign1);
  } // A toString() method was created returning the description as a string
}
