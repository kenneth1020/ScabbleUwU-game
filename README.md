# ScabbleUwU-game
A text base game in java. The game is scabble 

# Description
The game purpose is to ask the user his name. Then ask if user want to play. 
If they say yes then the game will start and give the user 10 letters in an array at least one is a vowel.
The user job is to put together using the word given. If the word is in the index they gain one point.

--Side note: When ask if you want to play. If user hit no then the program stops and say goodbye. 
If user type anything else program will response asking the user to read carefully. 
If user doesn't comply with warning. Program will inciate UwU hell 

User has ten lives. Losing all of them is game over.

-----How to lose a life.-------

1 type in a blank or null 

2 used letters that are not given to the user

3 the word is not in the index

4 using the same word that user used to get the point

# Files
File in my code used "Collins Srabble Words (2019).txt

# Usage
import java.io.File; # new file("[name of file]")

import java.io.FileNotFoundException; # catch(FileNotFoundException e){  
System.out.println("Error opening the file." + [file name]  +  "Why you no, READ my file!!!");
			e.printStackTrace();  
      }
      
import java.util.ArrayList; #	private static ArrayList<Scabbles> wordList = new ArrayList<Scabbles>();

import java.util.Random; # Random rand =new Random();
		rand.setSeed(System.currentTimeMillis());
    
import java.util.Scanner; # Scanner input = null;

# Authors and acknowledgment
Thanks to my Professor Kanemoto from Merced College. 
For showing my class the basic of the code. 
As an example in one of her lectures in class. 

