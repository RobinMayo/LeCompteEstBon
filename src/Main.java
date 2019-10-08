
public class Main {
	private static final int NUMBER_TO_FIND_MAX_VALUE = 1000;
	private static final int GIVEN_NUMBERS_NUMBER = 5;
	private static final int GIVEN_NUMBERS_MAX_VALUE = 20;

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
		String numberBase = Integer.toString(iterationNumber, array.length);
		
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
		int numberToFind = (int) (Math.random() * NUMBER_TO_FIND_MAX_VALUE);
		int [] inputNumbersArray = new int[GIVEN_NUMBERS_NUMBER];
		int nOps = Operations.getNumberOfOperation();
		Operations [][] operationsArray = new Operations[(int) Math.pow(nOps, nOps)][nOps];
		
		randomlyFillArray(inputNumbersArray);
		System.out.println("Number to find : " + numberToFind + " with a composition of the numbers : "
				+ printArray(inputNumbersArray));
		
		operationsFillArrays(operationsArray);
		//System.out.println(Operations.printArray2D(operationsArray));
		
		int nearestNumber = 0;
		
		for (int i = 0; i < operationsArray.length; i++) {
			int number = inputNumbersArray[0];
			
			for (int j = 1; j < inputNumbersArray.length; j++) {
				number = Operations.operate(number, inputNumbersArray[j], operationsArray[i][j - 1]);
			}
			if (Math.abs(numberToFind - nearestNumber) > Math.abs(numberToFind - number)) {
				nearestNumber = number;
			}
		}
		System.out.println("Nearest number = " + nearestNumber);
	}
}
