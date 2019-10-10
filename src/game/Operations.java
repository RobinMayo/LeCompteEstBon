package game;
import exception.InvalidOperation;

public enum Operations {
	Plus,
	Minus,
	Multi,
	Divid;
	
	static String printArray(Operations [] array) {
		StringBuilder str = new StringBuilder((array.length * 3) + 2);
		str.append("{");

		for (int i = 0; i < array.length; i++) {
			str.append(array[i]);

			if (i < array.length - 1) {
				str.append(",\t");
			}
		}
		str.append("}\n");
		return str.toString();
	}
	
	static String printArray2D(Operations [][] array) {
		StringBuilder str = new StringBuilder(((array.length * 3) + 2) * array.length);
		str.append("{\n");

		for (int i = 0; i < array.length; i++) {
			str.append(printArray(array[i]));
		}
		str.append("}\n");
		return str.toString();
	}
	
	public static double operate(double leftOperand, double rightOperand, Operations operand,
			StringBuilder str) throws InvalidOperation {
		if (rightOperand == 0) {
			return leftOperand;
		} else if (leftOperand == 0) {
			return rightOperand;
		}
		str.append(" ");
		
		switch(operand) {
			case Plus:
				str.append("+ ");
				return leftOperand + rightOperand;
			case Minus:
				str.append("- ");
				return leftOperand - rightOperand;
			case Multi:
				str.append("* ");
				return leftOperand * rightOperand;
			case Divid:
				str.append("/ ");
				return leftOperand / rightOperand;
			default:
				throw new InvalidOperation("Unknown operation : " + operand);
		}
	}
	
	public static int getNumberOfOperation() {
		return Operations.values().length;
	}
}
