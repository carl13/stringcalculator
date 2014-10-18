package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.regex.*;

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
		if(numbers.startsWith("//["))
		{
			String delimiter = numbers.substring(3, numbers.indexOf("\n"));
			delimiter = delimiter.replaceAll("\\[", "");
			
			String[] splitDelimiters = delimiter.split("\\]");
			delimiter = "";
			for(String s : splitDelimiters)
			{
				delimiter = delimiter + Pattern.quote(s) + "|";
			}
			if(delimiter.endsWith("|"))
			{
				delimiter = delimiter = delimiter.substring(0, delimiter.length()-3);
			}
			String theNumbers = numbers.substring(numbers.indexOf("\n") + 1);
			return theNumbers.split(delimiter);
			
		}
		else if(numbers.startsWith("/"))
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
 	    ArrayList<Integer> Negative = new ArrayList<Integer>();
 	    int theNumber;
        for(String number : numbers){
        	theNumber = toInt(number);
        	if(theNumber < 0)
        	{
        		Negative.add(theNumber);
        	}
        	else
        	{
        		if(theNumber < 1000)
        		{
        			total += theNumber;        		        			
        		}
        	}
		}
        if(Negative.isEmpty())
        {
        	return total;
        }
        else
        {
        	String message = "";
        	for(int i = 0; i < Negative.size(); i++)
        	{
        		message += Negative.get(i) + ",";
        	}
        	message = message.replace(message.substring(message.length()-1), "");
        	throw new RuntimeException("Negatives not allowed: " + message);
        }
    }



}