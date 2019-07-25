Project Owner: Tomi Olubeko
Project Start Date: 6/26/2019 3:30 PM PST
Project Name: Hangman

Description

This is my implementation of the hangman childrens game. I first came across this project from an old Stanford CS106A assignment(https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/handouts/200%20Assignment%204.pdf).
The basic idea is to make a hangman game. The user has 8 guesses to guess the correct word. If they don't guess the word in 8 guesses, then they lose the game.
The project is subdivided into three parts. For me, since I will be chronicling my progress and problems encountered at each step, and putting this all on GitHub, it will be four parts,
with the first part being creating and adding files from my local repository to my GitHub account.

********************************************************************************************************************************************************************************************************************************************************************************************
Part One: Adding from local repository to GitHub

Things to Do
-Create a local repository to contain the project
-Initialize a local git repository
-Create a gitignore file
-Add relevant files to git repository
-Push the repo to the global repository


Problems Encountered
-Didn't know how to create a .gitignore file locally in Windows
-Didn't know what files to add to the .gitignore files for an Eclipse project


Solution
-Use git bash and touch .gitignore to create the .gitignore file
-Helpful link for which files I should add to a .gitignore file for an Eclipse Project(https://www.jamescoyle.net/how-to/supporting-scripts/3027-gitignore-file-for-eclipse-projects)

********************************************************************************************************************************************************************************************************************************************************************************************
Part Two: Playing a console based game

Things to Do
-Implement a hangman game that is playable on the console
-Choose a random word to use as the secret word. That word is chosen from a word list, located in HangmanLexicon.java
-Keep track of the user’s partially guessed word, which begins as a series of dashes and then gets
 updated as correct letters are guessed.
-Implement the basic control structure and manage the details (ask the user to guess a letter, keep
 track of the number of guesses remaining, print out the various messages, detect the end of the game,
 and so forth).

More In-Depth Specifications
-At the beginning of your run method, need to create a new HangmanLexicon and store it in an
 instance variable. If you extend the program to allow the user to play multiple games, the creation
 of the HangmanLexicon should be performed outside the loop that plays the game repeatedly so that
 this operation is performed once rather than for every game.
-Should accept the user’s guesses in either lower or upper case, even though all letters in the
 secret words are written in upper case. 
-If the user guesses something other than a single letter, program should tell the user that the
 guess is illegal and accept a new guess.

