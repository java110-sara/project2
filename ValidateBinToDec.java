//name: Sara Russert
//date: 1/7/24
//file: ValidateBinToDec.java

import javax.swing.JOptionPane;

public class ValidateBinToDec {
   public static void main(String[] args) {
      // Declare constant for the required binary length
      final int BINARY_CHAR_LENGTH = 4;
      
      // Declare all the variables needed by the program
      String inputString;
      int inputStringLength;
      boolean binaryStringIsValid = true;
      int decimalValue;
      char char0, char1, char2, char3;
      byte byte3, byte2, byte1, byte0;
      
      // Collect user input for the inputString
      inputString = JOptionPane.showInputDialog("Enter a 4 digit binary number (with no spaces):  ");
      System.out.println("You entered: " + inputString);
      
      // Determine the length of the string; if not correct, exit program
      inputStringLength = inputString.length();
      
      if (inputStringLength != BINARY_CHAR_LENGTH) {
         System.out.println("You did not enter a 4 character string.");
         System.out.println("Instead, you entered a " + inputStringLength + " character string");
         System.out.println("Therefore, the program is terminating.");
         System.exit(0);
      } else {
         System.out.println("The input is the correct length.");
         System.out.println("Each character will be examined to determine if it is a valid binary char.");
         System.out.println("Binary characters must be 0 or 1.");
      }
      
      // Examine each char of the inputString
      //decompose inputString into its individual chars
      char0 = inputString.charAt(3);
      char1 = inputString.charAt(2);
      char2 = inputString.charAt(1);
      char3 = inputString.charAt(0);
      
      // If any char is not valid, flip boolean flag to false
      if (char0 != '1' && char0 != '0')
         binaryStringIsValid = false;
      if (char1 != '1' && char1 != '0')
         binaryStringIsValid = false;
      if (char2 != '1' && char2 != '0')
         binaryStringIsValid = false;
      if (char3 != '1' && char3 != '0')
         binaryStringIsValid = false;
         
      // else, exit the program
      if (!binaryStringIsValid) {
         System.out.println("There was at least one invalid binary char.");
         System.out.println("The program is terminating.");
         System.exit(0);
      }
      
      // If the boolean flag contains true, compute the base ten representation of the binary number
      //cast each char to a string and then to a byte  
      byte0 = Byte.parseByte(Character.toString(char0));
      byte1 = Byte.parseByte(Character.toString(char1));
      byte2 = Byte.parseByte(Character.toString(char2));    
      byte3 = Byte.parseByte(Character.toString(char3));
      
      System.out.println("A valid binary number was entered; the base ten representation will be computed.");
      
      //Display the byte version of each char          
      System.out.println("byte3: " + byte3 + "; byte2: " + byte2 
                         + "; byte1: " + byte1 + "; byte0: " + byte0);
      
      //compute the base ten representation
      //note that Math.pow( ) returns a double, so this must be cast to an int 
      //to permit storing result in an int
      //initialize decimalValue with the value of the left most digit
      decimalValue = byte3 * (int)Math.pow(2, 3);
      //use combined assignment operator to increment decimalValue by value next digit
      decimalValue += byte2 * (int)Math.pow(2, 2);
      //use combined assignment operator to increment decimalValue by value next digit
      decimalValue += byte1 * (int)Math.pow(2, 1);
      //use combined assignment operator to increment decimalValue by value next digit
      decimalValue += byte0 * (int)Math.pow(2, 0);

      //display results to the user
      System.out.print("The base ten representation of " + inputString + " is:  ");
      System.out.println(decimalValue);  
      
      System.exit(0); 
   }
}