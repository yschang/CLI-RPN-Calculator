import java.util.*;

public class CLIRPNCalculator {
	// stores operands or evaluated results to stack
	static Stack<Double> evalStack = new Stack<Double>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String lineInput;

		while (true) {
			try {
				// user input in a line
				System.out.print("> ");
				lineInput = scanner.nextLine();

				// exit loop when user inputs "q"
				if (lineInput.equals("q")) {
					break;
				}

				boolean validInput = false; 

				if (lineInput.contains(" ")) { // case for list of inputs that are separated by space
					String[] inputArray = lineInput.split(" ");

					// iterate through list of inputs that are separated by space
					for (int i = 0; i < inputArray.length; i++) {
						String input = inputArray[i];

						validInput = pushToEvalStack(input);

						if (!validInput) {
							break;
						}
					}
				} else { // case for a single input
					validInput = pushToEvalStack(lineInput);
				}

				if (validInput) {
					System.out.println(evalStack.peek());
				} else {
					System.out.println("Error: Not a valid Input");
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

		scanner.close();
	}

	public static boolean isDouble(String s) {
	    try { 
	        Double.parseDouble(s); 
	    } catch (NumberFormatException e) { 
	        return false; 
	    } catch (NullPointerException e) {
	        return false;
	    }

	    return true;
	}

	public static boolean isOperator(String s) {
	    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
	    	return true;
	    }

	    return false;
	}

	public static boolean pushToEvalStack(String input) {
		if (isDouble(input)) {
			evalStack.push(Double.parseDouble(input));
		} else if (isOperator(input) && evalStack.size() >= 2) { 
			evalStack.push(evaluateTopTwo(input));
		} else {
			return false;
		}

		return true;
	}

	public static Double evaluateTopTwo(String operator) {
		double operand2 = evalStack.pop();
		double operand1 = evalStack.pop();

		switch (operator) {
			case "+":
				return operand1 + operand2;
			case "-":
				return operand1 - operand2;
			case "*":
				return operand1 * operand2;
			case "/":
				return operand1 / operand2;
		}

		return null;
	}
}