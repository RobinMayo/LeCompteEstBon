
public class Main {
	private static final int NUMBER_TO_FIND_MAX_VALUE = 1000;
	private static final int NUMBER_TO_FIND_MIN_VALUE = 101;
	private static final int GIVEN_NUMBERS_NUMBER = 6;
	private static final int GIVEN_NUMBERS_MAX_VALUE = 100;

	private static String printArray(int [] array) {
		StringBuilder str = new StringBuilder((array.length * 3) + 2);
		str.append("{");

		for (int i = 0; i < array.length; i++) {
			str.append(array[i]);

			if (i < array.length - 1) {
				str.append(", ");
			}
		}
		str.append("}\n");
		return str.toString();
	}
	
	private static void randomlyFillArray(int [] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * GIVEN_NUMBERS_MAX_VALUE);
		}
	}
	
	private static void operationsFillArray(Operations [] array, int iterationNumber) {
		String numberBase = Integer.toString(iterationNumber, Operations.values().length);
		
		for (int i = array.length - 1; i >= 0; i--) {
			if (numberBase.length() <= i) {
				array[i] = Operations.Plus;
			} else {
				array[i] = Operations.values()[Integer.parseInt(numberBase.substring(i, i + 1))];
			}
		}
	}
	
	private static void operationsFillArrays(Operations [][] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			operationsFillArray(arrays[i], i);
		}
	}

	public static void main(String[] args) throws InvalidOperation {
		int numberToFind = (int) (Math.random() *
				(NUMBER_TO_FIND_MAX_VALUE - NUMBER_TO_FIND_MIN_VALUE)) + NUMBER_TO_FIND_MIN_VALUE;
		int [] inputNumbersArray = new int[GIVEN_NUMBERS_NUMBER];
		int nOps = Operations.getNumberOfOperation();
		Operations [][] operationsArray = new Operations[(int) Math.pow(GIVEN_NUMBERS_NUMBER - 1, nOps)]
				[GIVEN_NUMBERS_NUMBER - 1];
		
		randomlyFillArray(inputNumbersArray);
		System.out.println("Number to find : " + numberToFind + " with a composition of the numbers : "
				+ printArray(inputNumbersArray));
		
		operationsFillArrays(operationsArray);
		//System.out.println(Operations.printArray2D(operationsArray));
		
		int nearestNumber = 0;
		String operationsToDo = new String();
		
		for (int i = 0; i < operationsArray.length; i++) {
			double number = inputNumbersArray[0];
			StringBuilder tmpOperationsToDo = new StringBuilder();
			tmpOperationsToDo.append((int) number);
			
			for (int j = 1; j < inputNumbersArray.length; j++) {
				number = Operations.operate(number, inputNumbersArray[j], operationsArray[i][j - 1],
						tmpOperationsToDo);
				tmpOperationsToDo.append(inputNumbersArray[j]);
				
				// If we have the good result without using all the allowed numbers :
				if ((numberToFind - nearestNumber) == 0) {
					operationsToDo = tmpOperationsToDo.toString();
					nearestNumber = (int) number;
					break;
				}
			}
			if (Math.abs(numberToFind - nearestNumber) > Math.abs(numberToFind - number)) {
				operationsToDo = tmpOperationsToDo.toString();
				nearestNumber = (int) number;
				
				if ((numberToFind - nearestNumber) == 0) {
					break;
				}
			}
		}
		System.out.println("Nearest number : " + nearestNumber + " = " + operationsToDo + ".");
	}
}
