
import java.util.Scanner;
import  java.util.Arrays;

public class Converter {

    public final int[] NUMBER_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 }; // array containing all of the values
    public final String[] NUMBER_LETTERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; // array containing all of the numerals
    public int toNumerical(String roman) {
        for (int i=0;i<13;i++) { // Loop through all the letters
            if(roman.startsWith(NUMBER_LETTERS[i])) // Check if the string starts with that letter
                return NUMBER_VALUES[i] + toNumerical(roman.replaceFirst(NUMBER_LETTERS[i], ""));
        }
        return 0; // If something went wrong, simply return 0
    }

    /**
     * Method used to convert an integer to a roman numeral
     * @param num number to be converted
     * @return roman numeral
     */
    public String toRoman(int num) {
        String roman = ""; // Declare a string to hold the numerals
        for (int i=0;i<13;i++) { // loop through all the values
            while (num >= NUMBER_VALUES[i]) { // Check if the number is greater than the current value
                roman += NUMBER_LETTERS[i]; // Add the letter to the String
                num -= NUMBER_VALUES[i]; // Subtract the amount from the value
            }
        }
        return roman; // Return the String
    }

    /**
     * Method used to check if a string is a roman
     * @param s string to be parsed
     * @return boolean
     */
    public static boolean isRoman(String s) {
        String[] roman_numbers = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
        boolean contains = Arrays.stream(roman_numbers).anyMatch(s::equals);
        return contains;
    }
    
    /**
     * Method used to check if a string is an integer
     * @param s string to be parsed
     * @return boolean
     */
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        }catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
        	int num1, num2=0;
        	double output=0;
        	String  x1, x2;
        	boolean flag=false,run=true;
        	boolean arab=false, roman=false;
        	Converter converter = new Converter();
            String[] roman_numbers = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
            String[] operators = { "+", "*", "-", "/" };
            String first="", second="", third="", line="";
            Scanner scanner = new Scanner(System.in);
    
    
            System.out.println("Hello Java Mentor ...");
            System.out.println("Tambi Kankush is here ...");
            System.out.println("Welcome to my new calculator ...");
            System.out.println("Hope it will be a good work ...");
            System.out.println("You can use the calculator for arabic or roman numbers");
            System.out.println("Here we go ..");
            while (run==true)
            {

            System.out.println("Please enter your numbers from 1 to 10 or from I to X");
            System.out.println("and make sure it will be like x operation y (ex. 5 + 6 or I * X) SEPARATED BY SPACES ");
                line=scanner.nextLine();
                String[] words=line.split(" ");
                int count=words.length;                
                if(count==3)
                {

                    first = words[0];
                    second = words[1];
                    third = words[2];
                    boolean contains = Arrays.stream(operators).anyMatch(second::equals);
                   if (isInt(first)==true && isInt(third)==true &&  contains==true)
                    {
                        num1=Integer.parseInt(first);
                        num2=Integer.parseInt(third);
                        if (num1>10 || num2>10)
                        {
                            System.out.println("Please make sure your numbers are from 1 to 10");
                        }
                        else
                        {
                             switch(second)
                            {
                                case "+":
                                	output = num1 + num2;
                                    break;
                    
                                case "-":
                                	output = num1 - num2;
                                    break;
                    
                                case "*":
                                	output = num1 * num2;
                                    break;
                    
                                case "/":
                                	output = num1 / num2;
                                    break;
                                
                            }   
                            System.out.println(output);
                            run=false;
                        }
                    }
                    // Roman Processing
                   if (isRoman(first)==true && isRoman(third)==true &&  contains==true )
                    {
                        num1= converter.toNumerical(first); 
                        num2= converter.toNumerical(third); 
                      if (num1>10 || num1 <1 || num2>10 || num2 < 1)
                        {
                            System.out.println("Please make sure your numbers are from I to X");
                        }
                        else
                        {
                             switch(second)
                            {
                                case "+":
                                	output = num1 + num2;
                                    break;
                    
                                case "-":
                                	output = num1 - num2;
                                    break;
                    
                                case "*":
                                	output = num1 * num2;
                                    break;
                    
                                case "/":
                                	output = num1 / num2;
                                    break;
                    
                            }    
                            
                            System.out.println(converter.toRoman((int)output));
                            run=false;
                        }
                        
                    }
                    if(contains==false)
                    {
                        System.out.println("Please reenter a right operator (+,*,/,-)");
                        run=true;
                    }
                    if((contains==true) && ((isRoman(first)==true && isInt(third)==true) || (isInt(first)==true && isRoman(third)==true)) )
                    {
                        System.out.println("Please modify your numbers to be both integers or romans");
                        run=true;
                    }
                    if(contains==true && isRoman(first)==false && isInt(first)==false && isRoman(third)==true )
                    {
                        System.out.println("Please check your first number");
                        run=true;
                    }   
                    if(contains==true && isRoman(first)==false && isInt(first)==false && isInt(third)==true )
                    {
                        System.out.println("Please check your first number");
                        run=true;
                    }   
                    if(contains==true && isInt(first)==true && isInt(third)==false && isRoman(third)==false )
                    {
                        System.out.println("Please check your second number");
                        run=true;
                    }  
                    if(contains==true && isRoman(first)==true && isInt(third)==false && isRoman(third)==false )
                    {
                        System.out.println("Please check your second number");
                        run=true;
                    }
                    if(contains==true && isRoman(first)==false && isInt(first)==false && isInt(third)==false && isRoman(third)==false )
                    {
                        System.out.println("Please check your numbers");
                        run=true;
                    }
            
                }
                else
                {
                    System.out.println("Please enter your calculation in the form X operator Y");
                }
            }

    }
}