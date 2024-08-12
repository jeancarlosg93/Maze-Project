# Programming Algorithms and Patterns Project: The Maze Runner 1

Due on 21 August 2024.

## Description:
In this project, you will be required to do the following:
Given a simple maze as follows 

	|||||
	|S| |
	| |||
	| |E|
	| | |
	|   |
	|||||

### Part 1: 
Implement an iterative first, and then a recursive algorithm that will check if there is a path from S to E, if yes, 
 it will print all the possible paths to the screen(draw a new maze to show each path), and return true. 
If no, it will simply return false. 
The path to be printed should look like this

	|||||
	|S| |
	|*|||
	|*|E|
	|*|*|
	|***|
	|||||

And you can use a maze in the form of a 2D array for this. 
For part 2 and 3, I recommend you read in the maze from a file and save it in a data structure as well.

	char[] maze = 
	{
	{'|','|','|','|','|'},
	{'|','S','|',' ','|'},
	{'|',' ','|','|','|'},
	{'|',' ','|','E','|'},
	{'|',' ','|',' ','|'},
	{'|',' ',' ',' ','|'},
	{'|','|','|','|','|'}
	}

### Part 2:
Allow the user to provide a file name containing a maze to be solved. 
Your program should then open the file, read in the maze and perform part 1 above.

### Part 3: 
Allow the user to reset a maze after solving and print the original maze back to the screen, 
give option to enter another maze file to solve and perform part 1 above, or quit the application.

Documentation and Submission:
Prepare a project report, a simple pdf file, that contains the following:
1. Your name and student number
2. The differences between the iterative and recursive solutions
3. Big O analysis of the time and space complexity of both approaches
4. Copy and paste all project .java files 
5. Provide screenshots of your code solving all the different mazes that will be given for this project.

Sample mazes (you can copy each one and save in a file for part 2, for part one, you can simply store them as a 2D array)

no Path Maze: 

	|||||
	|S| |
	| |||
	|||E|
	| | |
	| | |
	|||||

one Path Maze:

	|||||
	|S| |
	| |||
	| |E|
	| | |
	|   |
	|||||

two Path Maze:

	|||||
	|   |
	|S| |
	| | |
	| |E|
	| | |
	|   |
	|||||

three/Four Path Maze:

	||||||||||
	|        |
	|S|||||| |
	| |      |
	| |E|||| |
	| | |||| |
	|        |
	||||||||||

Extra Credit will be awarded to whoever gets the most number of paths from this one:

	||||||||||||||
	|S        ||||
	| ||||||| ||||
	| ||||||| ||||
	| |||||||    |
	|        ||| |
	|||||||| ||| |
	|            |
	||||||| |||| |
	|     |      |
	||||||| |||| |
	|||||||      |
	||||||||||||E|