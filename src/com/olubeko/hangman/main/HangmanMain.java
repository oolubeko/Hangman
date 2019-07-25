package com.olubeko.hangman.main;

import java.util.Random;
import java.util.Scanner;


public class HangmanMain {
	
	//Helper method to check if the user's guessed letter is part of the word 
	private static boolean checkLetter(String word, char letter) {
		boolean isLetter = false;
		for(int i = 0; i < word.length(); i++) {
			if(Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(letter)) {
				return true;
			}
		}
		return isLetter;
	}
	
	//Helper method to update the current state of the user's guesses
	private static StringBuilder addLetter(String wordToGuess, StringBuilder finalWord, char g) {
		
		for(int i = 0; i < wordToGuess.length(); i++) {
			if(Character.toUpperCase(wordToGuess.charAt(i)) == Character.toUpperCase(g)) {
				finalWord.replace(i, i + 1, Character.toString(g));
			}
		}
		return finalWord;
	}
	
	//Helper method that checks if the word has been guessed
	private static boolean checkSolved(StringBuilder fWord) {
		for(int i = 0; i < fWord.length(); i++) {
			if(fWord.charAt(i) == '-') {
				return false;
			}
		}
		return true;
	}
	
	//Helper method that checks whether a string is a number
	private static boolean isNumeric(String strNum) {
	    try {
	        @SuppressWarnings("unused")
			int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	    	return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		
		boolean atPlay = true;		//Flag to set game state
		Scanner sc = new Scanner(System.in);
		HangmanLexicon hl = new HangmanLexicon();		//Hangman Lexicon stub
		Random r = new Random();
		
		while(atPlay) {		//This is playing the game
			int seed = r.nextInt(10);		//Get a random number between 0 and 9
			String wordToGuess = "";
			try {
				wordToGuess = hl.getWord(seed);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int wordLen = wordToGuess.length();
			System.out.println("Welcome to Hangman!");
			System.out.print("The word now looks like this: ");
		
			//let a StringBuilder object represent the user's progress
			StringBuilder finalWord = new StringBuilder();
			
			//Populate finalWord with dashes
			while(wordLen > 0) {
				finalWord.append("-");
				wordLen--;
			}
			
			//Print out the current game state
			System.out.println(finalWord);
			
			int numGuesses = 8;		//set number of guesses to 8
			boolean solved = false;		//set solved game state to false
			
			while(numGuesses > 0 && !solved) {
				System.out.println("You have " + numGuesses + " left");
				System.out.print("Enter your guess: ");
				String userGuess = sc.next(); //get user's guess
				while(userGuess.length() != 1 ||isNumeric(userGuess)) {
					System.out.println("Invalid value entered. Please enter a letter.");
					System.out.print("Enter your guess: ");
					userGuess = sc.next();
				}
				char g = userGuess.charAt(0); //.next() method returns a String, so convert it to a char first
				
				boolean isLetter = checkLetter(wordToGuess, g); //check if the users guess is correct
				
				if(isLetter) {
					finalWord = addLetter(wordToGuess, finalWord, g);
					System.out.println("Right answer! Your word is now " + finalWord);
					solved = checkSolved(finalWord);	
				}
				else {
					System.out.println("Wrong answer! Your word is now " + finalWord);
				}
				numGuesses--;
			}
			
			if(solved){
				System.out.println("Congratulations! The word is " + finalWord);
			}
			else {
				System.out.println("Better Luck Next Time! The word is " + wordToGuess);
			}
			
			System.out.print("Would you like to play again (Y/N)?:  ");
			String cont = sc.next();
			
			if(cont.toLowerCase().equals("n")) {
				atPlay = false;
				System.out.println("Thanks for playing! Goodbye!");
			}
		}
		sc.close();	
	}

}
