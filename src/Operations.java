
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
	
	public static int operate(int leftOperand, int rightOperand, Operations operand)
			throws InvalidOperation {
		if (rightOperand == 0) {
			return leftOperand;
		} else if (leftOperand == 0) {
			return rightOperand;
		}
		switch(operand) {
			case Plus:
				return leftOperand + rightOperand;
			case Minus:
				return leftOperand - rightOperand;
			case Multi:
				return leftOperand * rightOperand;
			case Divid:
				return (int) leftOperand / rightOperand;
			default:
				throw new InvalidOperation("Unknown operation : " + operand);
		}
	}
	
	public static int getNumberOfOperation() {
		return Operations.values().length;
	}
}
