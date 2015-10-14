package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLinesBetweenNumbers() {
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

	@Test
	public void testNegativeNumbers() {
		try 
		{
			int sum = Calculator.add("-1,2");
		}

		catch (RuntimeException exeption)
		{
			assertEquals("Negatives not allowed: -1", exeption.getMessage());
		}
		
	}

	@Test
	public void testNegativeMultipleNumbers() {
		try 
		{
			int sum = Calculator.add("2,-4,3,-5");
		}

		catch (RuntimeException exeption)
		{
			assertEquals("Negatives not allowed: -4, -5", exeption.getMessage());
		}
	}	

	@Test
    public void testBiggerThanThousand(){
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testBiggerThanThousandMultipleNumbers(){
        assertEquals(0, Calculator.add("1001,1002,1003"));
    }   

}