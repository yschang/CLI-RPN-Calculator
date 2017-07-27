# CLI-RPN-Calculator
## High-level Description of the Solution
This Java program uses the Scanner class in the while loop to prompt the input from the user until "q" has been detected from the input. The user can choose to either input list of values and operators separated by space in one line, or input a single value or a single operator. If the user chooses to input list of values and operators separated by space in one line, then each value and operator will be iterated and evaluated at once in a single loop, and print out the result. If the user chooses to input a single value, then it will be stored in a stack, and when the user inputs a single operator, the top two values from the stack will be polled to be evaluated, and the evaluated value will be stored back to the stack. The program will print the value when the user inputs a value in decimal, and will print the evaluated value in decimal when the user inputs an operator. If the user inputs something other than a number or an operator, it will print out an error.


## Reasoning Behind Technical Choices
I chose Java as a programming language because it is what I am most comfortable with. Also, it is object-oriented, so it allows me to use reuseable code in my program, such as isDouble, isOperator, pushToEvalStack, and evaluateTopTwo functions.


## Trade-offs, or what I might do differently if I were to spend additional time on the project
If I were to spend additional time on the project, I would have definitely create a list of test cases and run those test cases to fix any bug that I haven't found.


## How to run the code
Simply open the command prompt and locate the CLIRPNCalculator.java file. Run "javac CLIRPNCalculator.java" to compile the program, and run "java CLIRPNCalculator" to run the program. 
