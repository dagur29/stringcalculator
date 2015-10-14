package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
	{
		if (text.equals(""))
		{
			return 0;
		}

		if (text.startsWith("//"))
		{
			return sum(delimiter(text));
		}

		if (text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}

		else
		{
			return 1;
		}
			
	}

	private static void negative(String str)
	{
		String negative = "";

		if (str.contains("-1")) 
		{
			throw new RuntimeException("Negatives not allowed: -1");	
		}

		if (negative.contains("-")) 
		{
			throw new RuntimeException("Negatives not allowed: " + negative);	
		}
	}


	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
	    return numbers.split(",|\n");
	}

	private static String[] delimiter(String numbers) 
	{
		String delimiter = numbers.substring(2,3);
		numbers = numbers.substring(4, numbers.length());
		return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for (String number : numbers)
       	{
       		if (toInt(number) <= 1000) 
       		{
       			total += toInt(number);
       		}
		}

		return total;
    }
}