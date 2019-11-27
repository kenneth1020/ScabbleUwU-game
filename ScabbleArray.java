import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*****
 * 
 * kenneth tran
 * 10/23/19
 * Scabble UwU game
 * This program will give you ten words its the player job to used those ten words
 * To make a word to get a point.
 * -------------------------------------------------
 * Reading in the file of words into an arry of strings
 *randomly pick ten letters from the alphabet - at least 1 of them a vowel
 *tell these player ask for words
 *doing binary search and give them a point
 */


public class ScabbleArray {
	private static int SIZE = 9;//the num of letters given to user
	private static ArrayList<Scabbles> wordList = new ArrayList<Scabbles>();
	static char [] letters = {'A', 'E', 'I', 'O', 'U', 'Y', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'};
	public static void main(String[] args) {
		// Create scanner 
		//read in the data from the file and opening the file and connecting it to the Scanner object
		//that I called input
		Scanner input = null;

		//catch out exception
		try {
			input = new Scanner(new File("Collins Scrabble Words (2019).txt"));
		}//end try

		//if reading can't find or detect file
		catch(FileNotFoundException e)
		{
			System.out.println( "Error opening the file. Grades.csv. Why you no, READ my file!!!");
			e.printStackTrace();
		}//end exception

		input.nextLine();//Skips header in the file
		input.nextLine();//Skips blank
		//reading file 
		while(input.hasNext()) {
			String record = input.nextLine();
			wordList.add(new Scabbles(record));
		}//end of while

		/***
				//test
				for(int i= 0; i< wordList.size(); i++) {
					System.out.println(wordList.get(i));
				}//end for loop
		 */

		//Introducion uwu to the uwuser
		System.out.println("How do you do? My UUUmmmm, ?????");
		System.out.println("What is your name user?");
		//waiting for username 
		Scanner inputs = new Scanner(System.in);
		String user = inputs.nextLine();
		System.out.println("Welcome!!! To wUWUrld uwuf chauwus and fuwun. " + user);

		//creating variables
		int tries = 0;
		int count = 0;
		int point = 0;
		String[] index = new String[100];
		//do loops 
		do {	
			/*-Reading if user want play scabble -*/
			System.out.println("Wuwuld yuwu like tuwu play scabble uwu! yes || no");
			Scanner inputs1 = new Scanner(System.in);
			String response = inputs1.nextLine();
			response =response.toUpperCase();
			/*-Reading if user want play scabble IF yes will run through the game-*/
			if(response.equalsIgnoreCase("YES"))
			{
				char[] given = scabbleLetters();
				do {
					System.out.println("Type your words using these letters || If you want quit Please Type 'ImUwU' || "
							+ "Repeat of letters Please type in 'IFORGOTUWU'");
					System.out.println(" ");
					System.out.println("Current points: " + point);
					for(int i = 0; i < given.length;i++)
					{
						System.out.print(" " + given[i]);
					}
					System.out.println(" ");
					Scanner Userwords = new Scanner(System.in);
					String answer = Userwords.nextLine();
					/*-Reading if user want quit then game will end-*/
					if(answer.equalsIgnoreCase("ImUwU")) {
						System.out.println("OwO . . . OK guwudbye, " + user);
						System.out.println("You got: " + point + " points. Under this many tries: " + count);
						System.exit(0);
					}
					/*-Reading if user want the words back if they lost them*/
					if(answer.equalsIgnoreCase("IFORGOTUWU")){
						System.out.println("Letters are: ");
						for(int i = 0; i < given.length;i++)
						{
							System.out.print(" " + given[i]);
						}
					}
					/*-Reading if user doesn't used the word given -*/
					else if(detect(given, answer, point, index)== false)
					{
						count++;
						System.out.println( user + " tries left: " + (10-count)); 
					}
					/*-Reading if user enter the word false count will go up and system will response*/
					else if(WordSearch(answer) == false) {
						count++;
						System.out.println(" ");
						System.out.println(">w< oooowwwwooooo that hurt WRONG Answer!!!!" + user + " tries left: " + (10-count)); 
					}
					/*-Reading if user type word correctly will give them points -*/
					else if(WordSearch(answer) == true) {
						index[point] = answer;
						point++;
					}


				}while(count < 10);
				/*IF user doesn't get scabble word correct 10 time then game will end -*/
				if(count == 10)
				{
					System.out.println("You got: " + point + " points.");
					System.out.println("OwO . . . GAME UWUver guwudbye, " + user);
					System.exit(0);
				}

			}//end of the game playing

			/*-Reading if user doesn't want to play will end the game -*/
			else if(response.equalsIgnoreCase("NO"))
			{
				System.out.println("OwO . . . OK guwudbye, " + user);
				System.exit(0);
			}//end of NO

			/*-Reading if user type anything else than yes or no in response-*/
			else
			{
				tries++;
				System.out.println("Please Duwun't type Anything else uwur yUWU shall suffer an hUWUndred angry UWU, OWO " + user);
			}//end of anything else

		}while(tries < 10);//end of do while when tries reach 10

		/*-Reading if user still doesnt listen will trigger uwu hell -*/
		if(tries == 10)
		{
			System.out.println("UWU YOU ASK YOU IT, " + user);
			for(int i =0; i < 100 ; i++)
			{
				System.out.println("UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo UWU owo ");
			}
			for(int i =0; i < 100 ; i++)
			{
				System.out.println("OWO UWO UWU UwU OwU OwO owO owo uwo uwu owu owo Owo OWo OWO UWO UWU UwU OwU OwO owO owo uwo uwu owu owo Owo OWo");
			}
			for(int i =0; i < 100 ; i++)
			{
				System.out.println("RRRRRRRUWU RRRRRUWU RRRRRRROWOWO RRRRRRUWUW");
			}
			System.exit(0);
		}//end of tries

	}//end of main

	//dectection code to see if user using the right words given unless they want trigger OWO hell
	public static boolean detect(char[] given, String answer, int point, String[] index) {
		//remove blank
		answer.split(" ");
		//checking if answer length is exteding given letter 
		if(answer.length() > given.length)
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

		//checking if user doesn't cheat and used same words
		for(int a = 0; a < point; a++)
		{
			if(answer.equalsIgnoreCase(index[a]))
			{
				System.out.println(" ");
				System.out.println(">w< oooowwwwooooo that hurt!!!! NO CHEATING you already type that word (#0w0)");
				return false;
			}
		}
		//creating a array for testing and elimate value of certain variable
		char[] test = new char[given.length];
		for(int h = 0; h < given.length; h++)
		{
			test[h]=given[h];
		}
		
		//creating a array of char for the user answers
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
					//changing the user answer into blank so the system do not check it again
					charater[j] = '#';
					test[i] = '%';
					//test printing for errors
					//System.out.println(test[i] + " " +charater[j]);
					count++;
					j++;
					//test printing for errors
					//System.out.println("hi " +count+ " " + j + " " + i);
				}
			}
		}
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

	//binary searching for word in the list
	public static boolean WordSearch(String word) {
		//creating low and high
		word=word.toUpperCase();
		int lowIndex = 0, highIndex = wordList.size()-1;
		//creating mid
		int currentIndex;
		while (lowIndex <= highIndex) {
			currentIndex = (highIndex+ lowIndex)/2;
			String check = wordList.get(currentIndex).getWords();
			if(word.equalsIgnoreCase(check)) 
				return true;
			else if(word.compareTo(check) < 0)
				highIndex = currentIndex -1;
			else
				lowIndex = currentIndex+1;
		}//end of while
		return false;
	}//end of word searching


	//creating value for scrabble
	public static char[] scabbleLetters() {
		//array for character
		char[] given = new char[100];
		//random the value for character
		Random rand =new Random();
		rand.setSeed(System.currentTimeMillis());
		//making sure user get one vowel
		int indexOfVowel = rand.nextInt(5); //num between 0-5
		System.out.print("Letter: " + letters[indexOfVowel]);
		given[0]= letters[indexOfVowel];
		//then randomize the rest of the remaning letter
		for(int i=0; i<SIZE; i++) {
			int index = rand.nextInt(26);
			System.out.print(" " + letters[index]);
			given[i+1]=letters[index];
		}
		System.out.println(" ");
		//returning given array of letter
		return given;
	}//end or scabbleLetters


}//end of class















