import java.util.Random;
import java.util.Scanner;

/*****
 * 
 * kenneth tran
 * 10/23/19
 * Scabble game
 * This program will give you five words its the player job to used those five words
 * To make a word to get a point.
 * -------------------------------------------------
Checking if a certain part of the code
perifically the detect in checking if player using all types of array

 */
public class TESTCODE {
	static char [] letters = {'A', 'E', 'I', 'O', 'U', 'Y', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'};
	public static void main(String[] args) {
		char[] given = scabbleLetters();
		for(int i = 0; i < given.length;i++)
		{
			System.out.print(" " + given[i]);
		}
		System.out.println(" ");
		Scanner Userwords = new Scanner(System.in);
		String answer = Userwords.nextLine();
		System.out.println( detect(given,answer));
	}

	//dectection code to see if user using the right words given unless they want trigger OWO hell
		public static boolean detect(char[] given, String answer) {
			//remove blank
			answer.split(" ");
			//checking if answer length is exteding given letter 
			if(answer.length() > 10)
			{
				return false;
			}
			//return false if null
			if(answer.equalsIgnoreCase(null))
			{
				return false;
			}
			//return false if blank
			if(answer == " ")
			{
				return false;
			}
			//creating value
			int count = 0;
			//changing string to upper case
			answer = answer.toUpperCase();
			//creating a array for testing and elimate value of certain variable
			char[] test = new char[given.length];
			for(int h = 0; h < given.length; h++)
			{
			test[h]=given[h];
			}
			char[] charater = new char[answer.length()];
			for(int j = 0; j < answer.length(); j++)
			{
				charater[j] = answer.charAt(j);
			}
			
			//scanning to detect if words are given are used
			for(int i=0; i < given.length; i++) {
				for(int j = 0; j < answer.length(); j++)
				{
					if(test[i] == charater[j]) {
						charater[j] = ' ';
						System.out.println(test[i] + " " +charater[j]);
						count++;
						j++;
						System.out.println("hi " +count+ " " + j + " " + i);
					}
				}
			}                
			/*
			for(int j = 0; j < answer.length(); j++)
			{
			
				for(int i=0; i < given.length; i++) {
					if(test[i] == answer.charAt(j)) {
						System.out.println(test[i] + " " +answer.charAt(j));
						count++;
						test[i] = ' ';
						j++;
						System.out.println("hi " +count+ " " + j + " " + i);
					}
				}
			}
			*/
			
			//if user does used the word given then return true
			if(answer.length() == count)
			{
				return true;
			}
			System.out.println(" ");
			System.out.println(">w< oooowwwwooooo that hurt WRONG words!!!!");
			//if user doesnt used word given return false
			return false;
		}
	
	
	
	public static char[] scabbleLetters() {
		char[] given = { 'A', 'E', 'Q', 'F', 'T', 'L', 'V', 'E', 'A', 'W'};
		return given;
	}//end or scabbleLetters
}
