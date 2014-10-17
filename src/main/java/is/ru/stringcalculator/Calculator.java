package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		}
		return sum(splitNumbers(text));
	
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if(numbers.startsWith("/"))
		{
			String delimiter = Character.toString(numbers.charAt(2));
			String theNumbers = numbers.substring(4);
			return theNumbers.split(delimiter);
		}
		else
		{
			return numbers.split(",|\n");			
		}
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}