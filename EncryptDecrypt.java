//created by Karel Cassandra Cruz (CITCS 1L)
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
public class EncryptDecrypt{
	public static StringBuffer encrypt (String str, int s){
		StringBuffer result= new StringBuffer();
		/*string buffer allows the creation of modifiable String objects such as:
		 * append, reverse, replace, concatenate, and manipulating sequences of characters and Strings*/
        for (int i=0; i<str.length(); i++) {
        /*starts at i=0 or the starting letter and increments until the end of the word
       	* for example, if str input is hello, h would be 0; str.length() would be 4. */	 
            if (Character.isUpperCase(str.charAt(i))) { 
                char char_curr = (char)(((int)str.charAt(i) +  s - 65+26) % 26 + 65); 
                result.append(char_curr);
                /* if current character is in UPPERCASE, this block of code is executed
                * 65 is the start of uppercase A, 26 is the alphabet size
                * "65+26" limits the range of elements to be shifted--26 items from the 65th character in the ASCII table */
            } else if (Character.isLowerCase(str.charAt(i))){ 
                char char_curr = (char)(((int)str.charAt(i) + s - 97+26) % 26 + 97); 
                result.append(char_curr); 
                /* if current character is in LOWERCASE
                 *97 is the start of uppercase A, 26 is the alphabet size
                 * "97+26" means only 26 characters are to be shifted starting from the 97th character in the ASCII table*/	
            } else {
            	char char_curr = (char)(((int)str.charAt(i) + s - 48+10) % 10 + 48); 
                result.append(char_curr); 
                /* if current character is a DIGIT
                 *48 is the start of 0, 10 is the size of numbers 
                 * "48+10" means only 10 characters are to be shifted starting from the 48th character in the ASCII table*/
            }
        } 
        return result; 
    }
    
	public static void main (String [] args){
		String str="";
		String mode="";
		int i=0;
		Scanner sc = new Scanner (System.in);
		
		char preans, answer;
		do{ 
			System.out.println ("Enter a word: ");
			str=sc.nextLine();
			Pattern p = Pattern.compile("[^A-Za-z0-9]");
			Matcher m = p.matcher(str);
			/*pattern object allows to create a matcher object for a given string.
			 *matcher object allows regex operations on a string 
			 *boolean confirms if string is within the conditions provided by matcher */
			boolean b = m.find();
			if (b==true){
				System.out.println ("Invalid input");
				System.exit(0);
				//exits the program if a special character is detected within the string
			}	
			System.out.println("Encrypt or Decrypt:");
			mode=sc.nextLine().toLowerCase();
			//any input is translated to lowercase
			
			switch (mode){
				case "encrypt": 
					int s=3;
					//shifts the alphabet 3 places to the right
					System.out.println("Original word: "+str);
					System.out.println("Encrypted word: "+encrypt(str,s));
					//str and s are inputted into the method encrypt ()
					break;
				case "decrypt":
					s=-3;
					//shifts the alphabet 3 places to the right
					System.out.println("Original word: "+str);
					System.out.println("Decrypted word:"+encrypt(str,s));
					break;
				default: 
					System.out.println ("ERROR. Please choose between encrypt and decrypt only.");
			}
			
			System.out.println ("\nDo you want to try again? [Y/N]");
			preans = sc.nextLine().charAt(0);
			answer =Character.toUpperCase(preans);
			if (answer=='Y'){
				System.out.println ("\nRestarting program...\n-------------------------------------------\n");
			} else {
				System.out.println ("\nThank you.");
				System.exit (0);
			}
		}while(answer=='Y');	
	}
}