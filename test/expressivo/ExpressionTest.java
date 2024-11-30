package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 *
 * Testing Strategy:
 * - We are testing the core functionalities of the Expression ADT. 
 * - The tests verify that:
 *   1. Expressions are structurally equal when they represent the same mathematical meaning.
 *   2. The `toString()` method produces the correct string representation.
 *   3. The `equals()` and `hashCode()` methods work correctly for both simple and complex expressions.
 *   4. Edge cases, such as invalid expressions, are handled appropriately.
 *
 * Testing for various types of expressions:
 * 1. **Constant expressions** (e.g., `5.0`).
 * 2. **Variable expressions** (e.g., `x`).
 * 3. **Addition expressions** (e.g., `3.0 + x`).
 * 4. **Multiplication expressions** (e.g., `2.0 * y`).
 * 
 * We will ensure that equality and string representation follow the intended structural rules for each type of expression.
 */
public class ExpressionTest {

    /**
     * Test for equality of two constant expressions.
     * It checks that two constants with the same value are considered equal.
     */
    @Test
    public void testConstantEquals() {
        Expression e1 = new Constant(5.0);
        Expression e2 = new Constant(5.0);
        assertTrue(e1.equals(e2));  // e1 and e2 should be equal since their values are the same.
    }

    /**
     * Test for equality of two variable expressions.
     * It checks that two variables with the same name are considered equal.
     */
    @Test
    public void testVariableEquals() {
        Expression e1 = new Variable("x");
        Expression e2 = new Variable("x");
        assertTrue(e1.equals(e2));  // e1 and e2 should be equal because they are both "x".
    }

    /**
     * Test for equality of two addition expressions.
     * It checks that two addition expressions with the same operands are considered equal.
     */
    @Test
    public void testAdditionEquals() {
        Expression e1 = new Addition(new Constant(3), new Variable("x"));
        Expression e2 = new Addition(new Constant(3), new Variable("x"));
        assertTrue(e1.equals(e2));  // e1 and e2 should be equal because they both represent "3.0 + x".
    }

    /**
     * Test for equality of two multiplication expressions.
     * It checks that two multiplication expressions with the same operands are considered equal.
     */
    @Test
    public void testMultiplicationEquals() {
        Expression e1 = new Multiplication(new Constant(2), new Variable("y"));
        Expression e2 = new Multiplication(new Constant(2), new Variable("y"));
        assertTrue(e1.equals(e2));  // e1 and e2 should be equal because they both represent "2.0 * y".
    }

    /**
     * Test for equality of hash codes of two constant expressions.
     * This verifies that if two expressions are equal according to `equals()`, they should have the same hash code.
     */
    @Test
    public void testHashCode() {
        Expression e1 = new Constant(5.0);
        Expression e2 = new Constant(5.0);
        assertEquals(e1.hashCode(), e2.hashCode());  // e1 and e2 should have the same hash code because they are equal.
    }

    /**
     * Test for the `toString()` method.
     * This verifies that the string representation of an expression matches the expected format.
     */
    @Test
    public void testToString() {
        Expression e1 = new Addition(new Constant(3), new Variable("x"));
        assertEquals("3.0 + x", e1.toString());  // The string representation of the expression should be "3.0 + x".
    }

    /**
     * Test for inequality between two addition expressions with different values.
     * It checks that two expressions that are not structurally the same are considered not equal.
     */
    @Test
    public void testAdditionNotEquals() {
        Expression e1 = new Addition(new Constant(3), new Variable("x"));
        Expression e2 = new Addition(new Constant(4), new Variable("x"));
        assertFalse(e1.equals(e2));  // e1 and e2 should not be equal because the constants are different.
    }
}
